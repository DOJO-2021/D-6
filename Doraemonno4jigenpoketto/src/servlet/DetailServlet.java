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
import model.Qa;
import model.Qaplus;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int question_id=Integer.parseInt(request.getParameter("QUESTION_ID"));
		QaDao qDao=new QaDao();
		List<Qaplus> cardList1 = qDao.select3(new Qa(question_id,null, "", 0, "", "",0,""));
		// 全項目をリクエストスコープに格納する
		request.setAttribute("cardList1", cardList1);

		//詳細画面にフォワードする
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/Detail.jsp");
			dispatcher.forward(request, response);

	}
}
