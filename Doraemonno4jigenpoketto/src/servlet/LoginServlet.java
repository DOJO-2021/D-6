package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.Result;
//

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String id = request.getParameter("ID");
				String pass = request.getParameter("PW");

		//ログイン処理を行う
		UserDao iDao =new UserDao() ;
		if (iDao.isLoginOK(id,pass)) { //ログイン成功
			String result="success";
			//セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id", new Result(result));

			// 編集サーブレットにリダイレクトする
			response.sendRedirect("/Doraemonno4jigenpoketto/EditServlet");
		}
		else {// ログイン失敗
			String result="false";
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result",new Result(result));


			// ログイン画面にフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
			dispatcher.forward(request, response);
		}

	}
}
