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


/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	String result;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/Doraemonno4jigenpoketto/LoginServlet");
					return;
				}

				// 登録ページにフォワードする
				result="start";
				request.setAttribute("result",new Result(result));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Regist.jsp");
				dispatcher.forward(request, response);
			}
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
				SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
	            Date date;
	            if(request.getParameter("CALENDAR")=="") {
	            	date=null;
	            }
	            else {
	    			try {date = sdFormat.parse(request.getParameter("CALENDAR"));
	    			} catch (ParseException e) {
	    				e.printStackTrace();
	    				date=null;
	    			}
	            }
	    		String answerer= request.getParameter("ANSWERER");
	    		int category_id=0;
	    		if(request.getParameter("CATEGORY_ITEM")==null) {
	    		category_id=0;
	    		}else {
	    		category_id=Integer.parseInt(request.getParameter("CATEGORY_ITEM"));
	    		}


				String question=request.getParameter("QUESTION");
				String answer=request.getParameter("ANSWER");
				String registrant=request.getParameter("REGISTRANT");

				QaDao qDao=new QaDao();

				if(qDao.insert(new Qa(0, date, answerer,  category_id, question, answer, 0, registrant))) {
					result="success";
					request.setAttribute("result",new Result(result));}
					else {
						// 登録失敗
						result="false";
						request.setAttribute("result",
						new Result(result));
					}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Regist.jsp");
				dispatcher.forward(request, response);
			}

}
