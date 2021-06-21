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

import dao.QaDao;
import model.Qa;
import model.Qaplus;
import model.Result;


/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
@MultipartConfig
public class RegistServlet extends HttpServlet {
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

				// 登録ページにフォワードする
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
	   		}
	    	catch (ParseException e) {
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
		String result;

		QaDao qDao=new QaDao();


		Part part=request.getPart("photo");

		System.out.println(part);

		String filename=Paths.get(part.getSubmittedFileName()).getFileName().toString();
		//アップロードするフォルダ
		String path="C:/pleiades/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/simpleBC/upload";
		//実際にファイルが保存されている場所の確認、ターミナルから確認
		System.out.println(path);
		//写真の登録処理
		try{part.write(path+File.separator+filename);
			//request.setAttribute("filename", filename);
			if(request.getParameter("SUBMIT").equals("登録")) {
				//登録処理
				if(qDao.insert(new Qa(0, date, answerer,  category_id, question, answer, 0, registrant))) {
					result="success";
					request.setAttribute("result",new Result(result));
				}
				else {
					// 登録失敗
					result="false";
					request.setAttribute("result",new Result(result));
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Regist.jsp");
				dispatcher.forward(request, response);
			}
			else if(request.getParameter("SUBMIT").equals("保存")){
				//保存処理
				if(qDao.insertsave(new Qa(0, date, answerer,  category_id, question, answer, 0, registrant))) {
					result="savesuccess";
					request.setAttribute("result",new Result(result));
				}
				else {
					// 保存失敗
					result="savefalse";
					request.setAttribute("result",new Result(result));
				}

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Regist.jsp");
			dispatcher.forward(request, response);
			}
			else {
			List<Qaplus> cardList = qDao.selectsave(new Qa(0, date, answerer,  category_id, question, answer, 0, registrant));
			// 全項目をリクエストスコープに格納する
			request.setAttribute("cardList", cardList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Save.jsp");
			dispatcher.forward(request, response);
			}
		}catch(Exception e) {
			if(request.getParameter("SUBMIT").equals("登録")) {
				//登録処理
				if(qDao.insert(new Qa(0, date, answerer,  category_id, question, answer, 0, registrant))) {
					result="success";
					request.setAttribute("result",new Result(result));
				}
				else {
					// 登録失敗
					result="false";
					request.setAttribute("result",new Result(result));
				}

				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Regist.jsp");
				dispatcher.forward(request, response);
			}
			else if(request.getParameter("SUBMIT").equals("保存")){
				//保存処理
				if(qDao.insertsave(new Qa(0, date, answerer,  category_id, question, answer, 0, registrant))) {
					result="savesuccess";
					request.setAttribute("result",new Result(result));
				}
				else {
					// 保存失敗
					result="savefalse";
					request.setAttribute("result",new Result(result));
				}

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Regist.jsp");
			dispatcher.forward(request, response);
			}
			else {
			List<Qaplus> cardList = qDao.selectsave(new Qa(0, date, answerer,  category_id, question, answer, 0, registrant));
			// 全項目をリクエストスコープに格納する
			request.setAttribute("cardList", cardList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Save.jsp");
			dispatcher.forward(request, response);
			}
		}
	}
}
