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

import dao.CategoryDao;
import dao.QaDao;
import model.Category;
import model.Qaall;
import model.Qaplus;


/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		List<Qaplus> cardList = qDao.selectsave3(new Qaall(question_id,null, "", 0, "", "",0,"",""));
		// 全項目をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);

		//カテゴリーidの取得
				String category_item=request.getParameter("CATEGORY_ITEM");
				CategoryDao cDao=new CategoryDao();
				List<Category> tangen=cDao.select1(new Category(0,0,0,category_item));
				request.setAttribute("tangen", tangen);



		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/SaveEdit.jsp");
		dispatcher.forward(request, response);
	}
}