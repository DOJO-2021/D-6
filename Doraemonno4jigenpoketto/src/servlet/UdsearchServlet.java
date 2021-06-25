package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QaDao;
import model.Qaall;
import model.Qacount;
import model.Qaplus;

/**
 * Servlet implementation class UdsearchServlet
 */
@WebServlet("/UdsearchServlet")
public class UdsearchServlet extends HttpServlet {
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

		// 検索ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Udsearch.jsp");
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

		SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        /*DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        if (dtf.format(LocalDate.parse(request.getParameter("CALENDAR"), dtf)) == null) {
        	date=null;
        }
        */
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
		if(request.getParameter("CATEGORY_ITEM")==null || request.getParameter("CATEGORY_ITEM")=="") {
		category_id=0;
		}else {
		category_id=Integer.parseInt(request.getParameter("CATEGORY_ITEM"));
		}
		String question=request.getParameter("QUESTION");
		String answer=request.getParameter("ANSWER");
		String registrant=request.getParameter("REGISTRANT");
		QaDao qDao=new QaDao();

		// 検索処理を行う
		List<Qaplus> cardList = qDao.select2(new Qaall(0, date, answerer,  category_id, question, answer, 0, "",registrant));
		// 全項目をリクエストスコープに格納する
		session.setAttribute("cardList", cardList);

		//検索件数を数えます
		List<Qacount> counter = qDao.select4(new Qaall(0, date, answerer,  category_id, question, answer, 0,"", registrant));
		// 検索件数をリクエストスコープに格納する
		session.setAttribute("counter", counter.get(0));

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Doraemonno4jigenpoketto/UdresultServlet");
		dispatcher.forward(request, response);
	}
}
