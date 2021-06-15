package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QaDao;
import model.Qa;
import model.Qaplus;

/**
 * Servlet implementation class UdresultServlet
 */
@WebServlet("/UdresultServlet")
public class UdresultServlet extends HttpServlet {
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

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		int question_id=Integer.parseInt(request.getParameter("QUESTION_ID"));
		QaDao qDao=new QaDao();
		List<Qaplus> cardList = qDao.select3(new Qa(question_id,null, "", 0, "", "",0,""));
		// 全項目をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Udedit.jsp");
		dispatcher.forward(request, response);
	}
}
