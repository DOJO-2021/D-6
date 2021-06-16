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

		if(request.getParameter("andor1").equals("and1") && request.getParameter("andor2").equals("and2")) {
			// 検索処理を行う
			List<Qaplus> cardList = qDao.select1_1(new Qas(question1,question2,question3));
			// 全項目をリクエストスコープに格納する
			request.setAttribute("cardList", cardList);
		}else if(request.getParameter("andor1").equals("and1") && request.getParameter("andor2").equals("or2")) {
			// 検索処理を行う
			List<Qaplus> cardList = qDao.select1_2(new Qas(question1,question2,question3));
			// 全項目をリクエストスコープに格納する
			request.setAttribute("cardList", cardList);
		}else if(request.getParameter("andor1").equals("or1") && request.getParameter("andor2").equals("and2")) {
			// 検索処理を行う
			List<Qaplus> cardList = qDao.select1_3(new Qas(question1,question2,question3));
			// 全項目をリクエストスコープに格納する
			request.setAttribute("cardList", cardList);
		}else {
		// 検索処理を行う
		List<Qaplus> cardList = qDao.select1_4(new Qas(question1,question2,question3));
		// 全項目をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);
		}



		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Result.jsp");
		dispatcher.forward(request, response);
	}

}
