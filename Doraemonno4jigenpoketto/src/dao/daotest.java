package dao;
import java.util.List;

import model.Category;
import model.Qa;
import model.Qaplus;
import model.Qas;


public class daotest {
	public static void main(String[] args) {
		CategoryDao dao1 = new CategoryDao();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Category> cardList2_1 = dao1.select(new Category(1,1,103001,""));
		for (Category card : cardList2_1) {
			System.out.println("NUMBER：" + card.getCourse_id());
			System.out.println("名前：" + card.getUnit_id());
			System.out.println("フリガナ:"+card.getCategory_id());
			System.out.println("Name:"+card.getCategory_item());

			System.out.println();
		}




		QaDao dao = new QaDao();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Qa> cardList2 = dao.select(new Qas("講師","",""));
		for (Qa card : cardList2) {
			System.out.println("NUMBER：" + card.getQuestion_id());
			System.out.println("名前：" + card.getDate());
			System.out.println("フリガナ:"+card.getAnswerer());
			System.out.println("Name:"+card.getCategory_id());
			System.out.println("会社:"+card.getQuestion());
			System.out.println("部署:"+card.getAnswer());
			System.out.println("役職：" + card.getPageview());
			System.out.println("郵便番号:"+card.getRegistrant());
			System.out.println();
		}

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Qaplus> cardList3 = dao.select1(new Qas("講師","",""));
		for (Qaplus card : cardList3) {
			System.out.println("NUMBER：" + card.getQuestion_id());
			System.out.println("名前：" + card.getDate());
			System.out.println("フリガナ:"+card.getAnswerer());
			System.out.println(card.getCourse());
			System.out.println(card.getUnit());
			System.out.println("Name:"+card.getCategory_item());
			System.out.println(card.getTextbook());
			System.out.println("会社:"+card.getQuestion());
			System.out.println("部署:"+card.getAnswer());
			System.out.println("役職：" + card.getPageview());
			System.out.println("郵便番号:"+card.getRegistrant());
			System.out.println();
		}
		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Qa insRec = new Qa(8, null, "女性",103001,"あれは何","何だろう",0,"男性");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<Qaplus> cardList4= dao.select2(new Qa(8, null, "女性",103001,"あれは何","何だろう",0,"男性"));
			for (Qaplus card : cardList4) {
			System.out.println("NUMBER：" + card.getQuestion_id());
			System.out.println("名前：" + card.getDate());
			System.out.println("フリガナ:"+card.getAnswerer());
			System.out.println("Name:"+card.getCategory_item());
			System.out.println("会社:"+card.getQuestion());
			System.out.println("部署:"+card.getAnswer());
			System.out.println("役職：" + card.getPageview());
			System.out.println("郵便番号:"+card.getRegistrant());
			System.out.println();
		}
		}else {
			System.out.println("登録失敗！");
		}

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Qa upRec = new Qa(4, null, "講師講師",103001,"あの山は何？","富士山です",200,"事務局");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<Qaplus> cardList5 = dao.select2(upRec);
			for (Qaplus card : cardList5) {
				System.out.println("NUMBER：" + card.getQuestion_id());
				System.out.println("名前：" + card.getDate());
				System.out.println("フリガナ:"+card.getAnswerer());
				System.out.println("Name:"+card.getCategory_item());
				System.out.println("会社:"+card.getQuestion());
				System.out.println("部署:"+card.getAnswer());
				System.out.println("役職：" + card.getPageview());
				System.out.println("郵便番号:"+card.getRegistrant());
				System.out.println();
			}
		}
		else {
			System.out.println("更新失敗！");
		}

		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete(4)) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}
	}
}

