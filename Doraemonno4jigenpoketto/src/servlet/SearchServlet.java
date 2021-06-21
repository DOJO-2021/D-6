package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QaDao;
import model.Qacount;
import model.Qaplus;
import model.Qas;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 検索ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Search.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String question1 = request.getParameter("QUESTION1");
		String question2= request.getParameter("QUESTION2");
		String question3=request.getParameter("QUESTION3");
		QaDao qDao = new QaDao();
	/*	String course=request.getParameter("COURSE");
		String unit=request.getParameter("UNIT");*/
		String category_item=request.getParameter("Q_category");

		if(category_item=="") {
			if(request.getParameter("andor1").equals("and1") && request.getParameter("andor2").equals("and2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_1(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_1(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else if(request.getParameter("andor1").equals("and1") && request.getParameter("andor2").equals("or2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_2(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_2(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else if(request.getParameter("andor1").equals("or1") && request.getParameter("andor2").equals("and2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_3(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_3(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_4(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_4(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}
		}else{
			if(request.getParameter("andor1").equals("and1") && request.getParameter("andor2").equals("and2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.selectcategory1_1(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcategorycount1_1(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else if(request.getParameter("andor1").equals("and1") && request.getParameter("andor2").equals("or2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.selectcategory1_2(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcategorycount1_2(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else if(request.getParameter("andor1").equals("or1") && request.getParameter("andor2").equals("and2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.selectcategory1_3(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcategorycount1_3(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.selectcategory1_4(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcategorycount1_4(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}
		}

		/*
		if(course=="") {
			if(request.getParameter("andor1").equals("and1") && request.getParameter("andor2").equals("and2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_1(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_1(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else if(request.getParameter("andor1").equals("and1") && request.getParameter("andor2").equals("or2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_2(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_2(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else if(request.getParameter("andor1").equals("or1") && request.getParameter("andor2").equals("and2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_3(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_3(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_4(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_4(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}
		}else if(unit=="") {
			if(request.getParameter("andor1").equals("and1") && request.getParameter("andor2").equals("and2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_1(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_1(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else if(request.getParameter("andor1").equals("and1") && request.getParameter("andor2").equals("or2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_2(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_2(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else if(request.getParameter("andor1").equals("or1") && request.getParameter("andor2").equals("and2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_3(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_3(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_4(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_4(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}
		}else if(category_item==""){
			if(request.getParameter("andor1").equals("and1") && request.getParameter("andor2").equals("and2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_1(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_1(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else if(request.getParameter("andor1").equals("and1") && request.getParameter("andor2").equals("or2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_2(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_2(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else if(request.getParameter("andor1").equals("or1") && request.getParameter("andor2").equals("and2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_3(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_3(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_4(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_4(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}
		}else {
			if(request.getParameter("andor1").equals("and1") && request.getParameter("andor2").equals("and2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_1(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_1(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else if(request.getParameter("andor1").equals("and1") && request.getParameter("andor2").equals("or2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_2(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_2(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else if(request.getParameter("andor1").equals("or1") && request.getParameter("andor2").equals("and2")) {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_3(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_3(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}else {
				// 検索処理を行う
				List<Qaplus> cardList = qDao.select1_4(new Qas(question1,question2,question3));
				// 全項目をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);
				//検索件数を数えます
				List<Qacount> counter =  qDao.selectcount1_4(new Qas(question1,question2,question3));
				// 検索件数をリクエストスコープに格納する
				request.setAttribute("counter", counter.get(0));
			}
		}
*/


		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
		dispatcher.forward(request, response);
	}

}
