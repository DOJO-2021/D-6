package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.CategoryDao;
import dao.QaDao;
import model.Category;
import model.Qaall;
import model.Qaplus;
import model.Result;

									//更新と削除用の編集画面用
/**
 * Servlet implementation class UdeditServlet
 */
@WebServlet("/UdeditServlet")
@MultipartConfig
public class UdeditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/Doraemonno4jigenpoketto/LoginServlet");
					return;
				}

		// リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		int question_id=Integer.parseInt(request.getParameter("QUESTION_ID"));//質問ID
		//質問日（49行まで）
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		if(request.getParameter("DATE")=="" || request.getParameter("DATE")==null) {
			date=null;
		}
		else {
	    	try {date = sdFormat.parse(request.getParameter("DATE"));
	   		}
	    	catch (ParseException e) {
	    		e.printStackTrace();
	    		date=null;
	    	}
	    }
		String answerer=request.getParameter("ANSWERER");//回答者
		int category_id=Integer.parseInt(request.getParameter("CATEGORY_ITEM"));//単元項目ID
		String question=request.getParameter("QUESTION");//質問内容int category_id=0;
	    if(request.getParameter("CATEGORY_ITEM")==null || request.getParameter("CATEGORY_ITEM")=="" || request.getParameter("CATEGORY_ITEM")=="0") {
	    	category_id=601001;
		}else {
			try {category_id=Integer.parseInt(request.getParameter("CATEGORY_ITEM"));
			if(category_id==0) {
				category_id=601001;
			}
	   		}
	    	catch (NumberFormatException e) {
	    		category_id=601001;
	    	}
	   	}
		String answer=request.getParameter("ANSWER");//回答内容
		int pageview=Integer.parseInt(request.getParameter("PAGEVIEW"));//閲覧数
		String registrant=request.getParameter("REGISTRANT");//登録者

		Part part=request.getPart("photo");
		//filename作成
		String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		//アップロードするフォルダの確認
		System.out.println(filename);

		if (part.getSize()!=0) {
			String path="C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/WebContent/upload";
			//実際にファイルが保存されている場所の確認、ターミナルから確認
			System.out.println(path);
			//写真の登録処理
			try{part.write(path+File.separator+filename);
				//request.setAttribute("filename", filename);

				//更新を行う
				QaDao qDao=new QaDao();
				CategoryDao cDao=new CategoryDao();
				if(request.getParameter("clickAction").equals("更新")) {
					if (qDao.update(new Qaall(question_id, date,answerer , category_id,question ,answer , pageview,filename,registrant ))) {	// 更新成功
						String result="updatesuccess";
						request.setAttribute("result", new Result(result));
						List<Qaplus> cardList1 = qDao.select3(new Qaall(question_id,null, "", 0, "", "",0,"",""));
						// 全項目をリクエストスコープに格納する
						request.setAttribute("cardList", cardList1);
						List<Category> tangen1=cDao.select1(new Category(0,0,category_id,""));
						request.setAttribute("tangen", tangen1);
					}
					else {			// 更新失敗
						String result="updatefault";
						request.setAttribute("result",new Result(result));
						List<Qaplus> cardList1 = qDao.select3(new Qaall(question_id,null, "", 0, "", "",0,"",""));
						// 全項目をリクエストスコープに格納する
						request.setAttribute("cardList", cardList1);
						List<Category> tangen1=cDao.select1(new Category(0,0,category_id,""));
						request.setAttribute("tangen", tangen1);
					}
					//フォワード
					RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/Udedit.jsp");
					dispatcher.forward(request, response);
				}
				//削除を行う
				else {
					if (qDao.delete(question_id)) {	// 削除成功
						String result="deletesuccess";
						request.setAttribute("result",new Result(result));
						//フォワード
						RequestDispatcher dispatcher =
						request.getRequestDispatcher("/WEB-INF/jsp/Udsearch.jsp");
						dispatcher.forward(request, response);
					}
					else {						// 削除失敗
						String result="deletefault";
						request.setAttribute("result", new Result(result));
						//フォワード
						RequestDispatcher dispatcher =
						request.getRequestDispatcher("/WEB-INF/jsp/Udedit.jsp");
						dispatcher.forward(request, response);
					}
				}
			}catch(Exception e) {
				//更新を行う
				QaDao qDao=new QaDao();
				CategoryDao cDao=new CategoryDao();
				if(request.getParameter("clickAction").equals("更新")) {
					if (qDao.update(new Qaall(question_id, date,answerer , category_id,question ,answer , pageview,filename,registrant ))) {	// 更新成功
						String result="updatesuccess";
						request.setAttribute("result", new Result(result));
						List<Qaplus> cardList1 = qDao.select3(new Qaall(question_id,null, "", 0, "", "",0,"",""));
						// 全項目をリクエストスコープに格納する
						request.setAttribute("cardList", cardList1);
						List<Category> tangen1=cDao.select1(new Category(0,0,category_id,""));
						request.setAttribute("tangen", tangen1);
					}
					else {			// 更新失敗
						String result="updatefault";
						request.setAttribute("result",new Result(result));
						List<Qaplus> cardList1 = qDao.select3(new Qaall(question_id,null, "", 0, "", "",0,"",""));
						// 全項目をリクエストスコープに格納する
						request.setAttribute("cardList", cardList1);
						List<Category> tangen1=cDao.select1(new Category(0,0,category_id,""));
						request.setAttribute("tangen", tangen1);
					}
					//フォワード
					RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/Udedit.jsp");
					dispatcher.forward(request, response);
				}
				//削除を行う
				else {
					if (qDao.delete(question_id)) {	// 削除成功
						String result="deletesuccess";
						request.setAttribute("result",new Result(result));
						//フォワード
						RequestDispatcher dispatcher =
						request.getRequestDispatcher("/WEB-INF/jsp/Udsearch.jsp");
						dispatcher.forward(request, response);
					}
					else {						// 削除失敗
						String result="deletefault";
						request.setAttribute("result", new Result(result));
						//フォワード
						RequestDispatcher dispatcher =
						request.getRequestDispatcher("/WEB-INF/jsp/Udedit.jsp");
						dispatcher.forward(request, response);
					}
				}
			}
		}else {
			//更新を行う
			QaDao qDao=new QaDao();
			CategoryDao cDao=new CategoryDao();
			if(request.getParameter("clickAction").equals("更新")) {
				if (qDao.updatenophoto(new Qaall(question_id, date,answerer , category_id,question ,answer , pageview,filename,registrant ))) {	// 更新成功
					String result="updatesuccess";
					request.setAttribute("result", new Result(result));
					List<Qaplus> cardList1 = qDao.select3(new Qaall(question_id,null, "", 0, "", "",0,"",""));
					// 全項目をリクエストスコープに格納する
					request.setAttribute("cardList", cardList1);
					List<Category> tangen1=cDao.select1(new Category(0,0,category_id,""));
					request.setAttribute("tangen", tangen1);
				}
				else {			// 更新失敗
					String result="updatefault";
					request.setAttribute("result",new Result(result));
					List<Qaplus> cardList1 = qDao.select3(new Qaall(question_id,null, "", 0, "", "",0,"",""));
					// 全項目をリクエストスコープに格納する
					request.setAttribute("cardList", cardList1);
					List<Category> tangen1=cDao.select1(new Category(0,0,category_id,""));
					request.setAttribute("tangen", tangen1);
				}
				//フォワード
				RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/Udedit.jsp");
				dispatcher.forward(request, response);
			}
			//削除を行う
			else {
				if (qDao.delete(question_id)) {	// 削除成功
					String result="deletesuccess";
					request.setAttribute("result",new Result(result));
					//フォワード
					RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/Udsearch.jsp");
					dispatcher.forward(request, response);
				}
				else {						// 削除失敗
					String result="deletefault";
					request.setAttribute("result", new Result(result));
					//フォワード
					RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/Udedit.jsp");
					dispatcher.forward(request, response);
				}
			}
		}
	}
}
