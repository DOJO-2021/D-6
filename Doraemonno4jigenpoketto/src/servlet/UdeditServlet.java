package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QaDao;
import model.Qa;
import model.Result;

									//更新と削除用の編集画面用
/**
 * Servlet implementation class UdeditServlet
 */
@WebServlet("/UdeditServlet")
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
		String question=request.getParameter("QUESTION");//質問内容
		String answer=request.getParameter("ANSWER");//回答内容
		int pageview=Integer.parseInt(request.getParameter("PAGEVIEW"));//閲覧数
		String regestant=request.getParameter("REGESTRANT");//登録者

		//更新を行う
		QaDao QaDao=new QaDao();
		if(request.getParameter("SUBMIT").equals("更新")) {
			if (QaDao.update(new Qa(question_id, date,answerer , category_id,question ,answer , pageview,regestant ))) {	// 更新成功
				String result="updatesuccess";
				request.setAttribute("result", new Result(result));
			}
			else {			// 更新失敗
				String result="updatefault";
				request.setAttribute("result",new Result(result) );
			}
		}
		//削除を行う
		else {
			if (QaDao.delete(question_id)) {	// 削除成功
				String result="deletesuccess";
				request.setAttribute("result",new Result(result) );
			}
			else {						// 削除失敗
				String result="deletefault";
				request.setAttribute("result", new Result(result));
			}
		}
		//フォワード
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/Udedit.jsp");
		dispatcher.forward(request, response);
	}

}
