package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Qa;
import model.Qaall;
import model.Qacount;
import model.Qaplus;
import model.Qas;
import model.Qasplus;

public class QaDao {
	//今回は使わない予定
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Qa> select(Qas param) {
		Connection conn = null;
		List<Qa> cardList = new ArrayList<Qa>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

			// SQL文を準備する
			String sql = "select Q.QUESTION_ID, Q.DATE, Q.ANSWERER,  Q.CATEGORY_ID, CO.COURSE, U.UNIT, CA.CATEGORY_ITEM,"
					+ " U.TEXTBOOK, Q.QUESTION, Q.ANSWER, Q.PAGEVIEW, Q.REGISTRANT from\r\n"
					+ " ((QA as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
					+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
					+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
					+ "WHERE CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END)) LIKE ?"
					+ "AND CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END)) LIKE ?"
					+ "AND CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END)) LIKE ?"
					+ "ORDER BY Q.PAGEVIEW";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			/*if (param.getNumber() != 0) {
				pStmt.setInt(1,  param.getNumber() );
			}
			else {
				pStmt.setString(1, "%");
			}*/
			if (param.getQuestion1() != null && param.getQuestion1() != "") {
				pStmt.setString(1, "%" + param.getQuestion1() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getQuestion2() != null && param.getQuestion2() != "") {
				pStmt.setString(2, "%" + param.getQuestion2() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getQuestion3() != null && param.getQuestion3() != "") {
				pStmt.setString(3, "%" + param.getQuestion3() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Qa card = new Qa(
				rs.getInt("QUESTION_ID"),
				rs.getDate("DATE"),
				rs.getString("ANSWERER"),
				rs.getInt("CATEGORY_ID"),
				rs.getString("QUESTION"),
				rs.getString("ANSWER"),
				rs.getInt("PAGEVIEW"),
				rs.getString("REGISTRANT")
				);
				cardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}

	//研修生用検索ANDAND
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Qaplus> select1_1(Qas param) {
		Connection conn = null;
		List<Qaplus> cardListplus = new ArrayList<Qaplus>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

			// SQL文を準備する
			String sql = "select Q.QUESTION_ID, Q.DATE, Q.ANSWERER,  Q.CATEGORY_ID, CO.COURSE, U.UNIT, CA.CATEGORY_ITEM,"
					+ " U.TEXTBOOK, Q.QUESTION, Q.ANSWER, Q.PAGEVIEW, Q.FILENAME, Q.REGISTRANT from\r\n"
					+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
					+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
					+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
					+ "WHERE UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "ORDER BY Q.PAGEVIEW DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getQuestion1() != null && param.getQuestion1() != "") {
				pStmt.setString(1, "%" + param.getQuestion1() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getQuestion2() != null && param.getQuestion2() != "") {
				pStmt.setString(2, "%" + param.getQuestion2() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getQuestion3() != null && param.getQuestion3() != "") {
				pStmt.setString(3, "%" + param.getQuestion3() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Qaplus card = new Qaplus(
				rs.getInt("QUESTION_ID"),
				rs.getDate("DATE"),
				rs.getString("ANSWERER"),
				rs.getString("COURSE"),
				rs.getString("UNIT"),
				rs.getString("CATEGORY_ITEM"),
				rs.getString("textbook"),
				rs.getString("QUESTION"),
				rs.getString("ANSWER"),
				rs.getInt("PAGEVIEW"),
				rs.getString("FILENAME"),
				rs.getString("REGISTRANT")
				);
				cardListplus.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardListplus = null;
				}
			}
		}

		// 結果を返す
		return cardListplus;
	}


	//研修生用検索ANDOR
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Qaplus> select1_2(Qas param) {
		Connection conn = null;
		List<Qaplus> cardListplus = new ArrayList<Qaplus>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

			// SQL文を準備する
			String sql = "select Q.QUESTION_ID, Q.DATE, Q.ANSWERER,  Q.CATEGORY_ID, CO.COURSE, U.UNIT, CA.CATEGORY_ITEM,"
					+ " U.TEXTBOOK, Q.QUESTION, Q.ANSWER, Q.PAGEVIEW, Q.FILENAME, Q.REGISTRANT from\r\n"
					+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
					+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
					+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
					+ "WHERE UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "ORDER BY Q.PAGEVIEW DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getQuestion1() != null && param.getQuestion1() != "") {
				pStmt.setString(1, "%" + param.getQuestion1() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getQuestion2() != null && param.getQuestion2() != "") {
				pStmt.setString(2, "%" + param.getQuestion2() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getQuestion3() != null && param.getQuestion3() != "") {
				pStmt.setString(3, "%" + param.getQuestion3() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Qaplus card = new Qaplus(
				rs.getInt("QUESTION_ID"),
				rs.getDate("DATE"),
				rs.getString("ANSWERER"),
				rs.getString("COURSE"),
				rs.getString("UNIT"),
				rs.getString("CATEGORY_ITEM"),
				rs.getString("textbook"),
				rs.getString("QUESTION"),
				rs.getString("ANSWER"),
				rs.getInt("PAGEVIEW"),
				rs.getString("FILENAME"),
				rs.getString("REGISTRANT")
				);
				cardListplus.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardListplus = null;
				}
			}
		}

		// 結果を返す
		return cardListplus;
	}


	//研修生用検索ORAND
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Qaplus> select1_3(Qas param) {
		Connection conn = null;
		List<Qaplus> cardListplus = new ArrayList<Qaplus>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

			// SQL文を準備する
			String sql = "select Q.QUESTION_ID, Q.DATE, Q.ANSWERER,  Q.CATEGORY_ID, CO.COURSE, U.UNIT, CA.CATEGORY_ITEM,"
					+ " U.TEXTBOOK, Q.QUESTION, Q.ANSWER, Q.PAGEVIEW, Q.FILENAME, Q.REGISTRANT from\r\n"
					+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
					+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
					+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
					+ "WHERE UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "ORDER BY Q.PAGEVIEW DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getQuestion1() != null && param.getQuestion1() != "") {
				pStmt.setString(1, "%" + param.getQuestion1() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getQuestion2() != null && param.getQuestion2() != "") {
				pStmt.setString(2, "%" + param.getQuestion2() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getQuestion3() != null && param.getQuestion3() != "") {
				pStmt.setString(3, "%" + param.getQuestion3() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Qaplus card = new Qaplus(
				rs.getInt("QUESTION_ID"),
				rs.getDate("DATE"),
				rs.getString("ANSWERER"),
				rs.getString("COURSE"),
				rs.getString("UNIT"),
				rs.getString("CATEGORY_ITEM"),
				rs.getString("textbook"),
				rs.getString("QUESTION"),
				rs.getString("ANSWER"),
				rs.getInt("PAGEVIEW"),
				rs.getString("FILENAME"),
				rs.getString("REGISTRANT")
				);
					cardListplus.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardListplus = null;
				}
			}
		}

		// 結果を返す
		return cardListplus;
	}


	//研修生用検索OROR
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Qaplus> select1_4(Qas param) {
		Connection conn = null;
		List<Qaplus> cardListplus = new ArrayList<Qaplus>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

			// SQL文を準備する
			String sql = "select Q.QUESTION_ID, Q.DATE, Q.ANSWERER,  Q.CATEGORY_ID, CO.COURSE, U.UNIT, CA.CATEGORY_ITEM,"
					+ " U.TEXTBOOK, Q.QUESTION, Q.ANSWER, Q.PAGEVIEW, Q.FILENAME, Q.REGISTRANT from\r\n"
					+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
					+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
					+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
					+ "WHERE UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "ORDER BY Q.PAGEVIEW DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			if (param.getQuestion1() != null && param.getQuestion1() != "") {
				pStmt.setString(1, "%" + param.getQuestion1() + "%");
				}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getQuestion2() != null && param.getQuestion2() != "") {
				pStmt.setString(2, "%" + param.getQuestion2() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getQuestion3() != null && param.getQuestion3() != "") {
				pStmt.setString(3, "%" + param.getQuestion3() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Qaplus card = new Qaplus(
				rs.getInt("QUESTION_ID"),
				rs.getDate("DATE"),
				rs.getString("ANSWERER"),
				rs.getString("COURSE"),
				rs.getString("UNIT"),
				rs.getString("CATEGORY_ITEM"),
				rs.getString("textbook"),
				rs.getString("QUESTION"),
				rs.getString("ANSWER"),
				rs.getInt("PAGEVIEW"),
				rs.getString("FILENAME"),
				rs.getString("REGISTRANT")
				);
					cardListplus.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardListplus = null;
				}
			}
		}

		// 結果を返す
		return cardListplus;
	}




	//研修生用検索ANDAND(単元項目付き)
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Qaplus> selectcategory1_1(Qasplus param) {
			Connection conn = null;
			List<Qaplus> cardListplus = new ArrayList<Qaplus>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

				// SQL文を準備する
				String sql = "select Q.QUESTION_ID, Q.DATE, Q.ANSWERER,  Q.CATEGORY_ID, CO.COURSE, U.UNIT, CA.CATEGORY_ITEM,"
						+ " U.TEXTBOOK, Q.QUESTION, Q.ANSWER, Q.PAGEVIEW, Q.FILENAME, Q.REGISTRANT from\r\n"
						+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
						+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
						+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
						+ "WHERE (UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
						+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
						+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
						+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
						+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
						+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
						+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
						+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
						+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
						+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
						+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
						+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
						+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
						+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
						+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
						+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
						+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
						+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
						+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
						+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
						+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
						+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
						+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
						+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)) "
						+ "AND CA.CATEGORY_ITEM = ?"
						+ "ORDER BY Q.PAGEVIEW DESC";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getQuestion1() != null && param.getQuestion1() != "") {
					pStmt.setString(1, "%" + param.getQuestion1() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}
				if (param.getQuestion2() != null && param.getQuestion2() != "") {
					pStmt.setString(2, "%" + param.getQuestion2() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}
				if (param.getQuestion3() != null && param.getQuestion3() != "") {
					pStmt.setString(3, "%" + param.getQuestion3() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}
				if (param.getCategory_item() != null && param.getCategory_item() != "") {
					pStmt.setString(4, param.getCategory_item());
				}
				else {
					pStmt.setString(4, "%");
				}
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Qaplus card = new Qaplus(
					rs.getInt("QUESTION_ID"),
					rs.getDate("DATE"),
					rs.getString("ANSWERER"),
					rs.getString("COURSE"),
					rs.getString("UNIT"),
					rs.getString("CATEGORY_ITEM"),
					rs.getString("textbook"),
					rs.getString("QUESTION"),
					rs.getString("ANSWER"),
					rs.getInt("PAGEVIEW"),
					rs.getString("FILENAME"),
					rs.getString("REGISTRANT")
					);
					cardListplus.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardListplus = null;
					}
				}
			}

			// 結果を返す
			return cardListplus;
		}

		//研修生用検索ANDOR(単元項目付き)
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Qaplus> selectcategory1_2(Qasplus param) {
			Connection conn = null;
			List<Qaplus> cardListplus = new ArrayList<Qaplus>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

				// SQL文を準備する
				String sql = "select Q.QUESTION_ID, Q.DATE, Q.ANSWERER,  Q.CATEGORY_ID, CO.COURSE, U.UNIT, CA.CATEGORY_ITEM,"
						+ " U.TEXTBOOK, Q.QUESTION, Q.ANSWER, Q.PAGEVIEW, Q.FILENAME, Q.REGISTRANT from\r\n"
						+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
						+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
						+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
						+ "WHERE (UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
						+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
						+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
						+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
						+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
						+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
						+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
						+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
						+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
						+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
						+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
						+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
						+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
						+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
						+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
						+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
						+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
						+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
						+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
						+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
						+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
						+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
						+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
						+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)) "
						+ "AND CA.CATEGORY_ITEM = ?"
						+ "ORDER BY Q.PAGEVIEW DESC";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getQuestion1() != null && param.getQuestion1() != "") {
					pStmt.setString(1, "%" + param.getQuestion1() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}
				if (param.getQuestion2() != null && param.getQuestion2() != "") {
					pStmt.setString(2, "%" + param.getQuestion2() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}
				if (param.getQuestion3() != null && param.getQuestion3() != "") {
					pStmt.setString(3, "%" + param.getQuestion3() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}
				if (param.getCategory_item() != null && param.getCategory_item() != "") {
					pStmt.setString(4, param.getCategory_item());
				}
				else {
					pStmt.setString(4, "%");
				}
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Qaplus card = new Qaplus(
					rs.getInt("QUESTION_ID"),
					rs.getDate("DATE"),
					rs.getString("ANSWERER"),
					rs.getString("COURSE"),
					rs.getString("UNIT"),
					rs.getString("CATEGORY_ITEM"),
					rs.getString("textbook"),
					rs.getString("QUESTION"),
					rs.getString("ANSWER"),
					rs.getInt("PAGEVIEW"),
					rs.getString("FILENAME"),
					rs.getString("REGISTRANT")
					);
					cardListplus.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardListplus = null;
					}
				}
			}

			// 結果を返す
			return cardListplus;
		}

		//研修生用検索ORAND(単元項目付き)
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Qaplus> selectcategory1_3(Qasplus param) {
			Connection conn = null;
			List<Qaplus> cardListplus = new ArrayList<Qaplus>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

				// SQL文を準備する
				String sql = "select Q.QUESTION_ID, Q.DATE, Q.ANSWERER,  Q.CATEGORY_ID, CO.COURSE, U.UNIT, CA.CATEGORY_ITEM,"
						+ " U.TEXTBOOK, Q.QUESTION, Q.ANSWER, Q.PAGEVIEW, Q.FILENAME, Q.REGISTRANT from\r\n"
						+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
						+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
						+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
						+ "WHERE (UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
						+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
						+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
						+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
						+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
						+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
						+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
						+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
						+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
						+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
						+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
						+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
						+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
						+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
						+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
						+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
						+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
						+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
						+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
						+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
						+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
						+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
						+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
						+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)) "
						+ "AND CA.CATEGORY_ITEM = ?"
						+ "ORDER BY Q.PAGEVIEW DESC";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getQuestion1() != null && param.getQuestion1() != "") {
					pStmt.setString(1, "%" + param.getQuestion1() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}
				if (param.getQuestion2() != null && param.getQuestion2() != "") {
					pStmt.setString(2, "%" + param.getQuestion2() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}
				if (param.getQuestion3() != null && param.getQuestion3() != "") {
					pStmt.setString(3, "%" + param.getQuestion3() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}
				if (param.getCategory_item() != null && param.getCategory_item() != "") {
					pStmt.setString(4, param.getCategory_item());
				}
				else {
					pStmt.setString(4, "%");
				}
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Qaplus card = new Qaplus(
					rs.getInt("QUESTION_ID"),
					rs.getDate("DATE"),
					rs.getString("ANSWERER"),
					rs.getString("COURSE"),
					rs.getString("UNIT"),
					rs.getString("CATEGORY_ITEM"),
					rs.getString("textbook"),
					rs.getString("QUESTION"),
					rs.getString("ANSWER"),
					rs.getInt("PAGEVIEW"),
					rs.getString("FILENAME"),
					rs.getString("REGISTRANT")
					);
					cardListplus.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardListplus = null;
					}
				}
			}

			// 結果を返す
			return cardListplus;
		}

		//研修生用検索OROR(単元項目付き)
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Qaplus> selectcategory1_4(Qasplus param) {
			Connection conn = null;
			List<Qaplus> cardListplus = new ArrayList<Qaplus>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

				// SQL文を準備する
				String sql = "select Q.QUESTION_ID, Q.DATE, Q.ANSWERER,  Q.CATEGORY_ID, CO.COURSE, U.UNIT, CA.CATEGORY_ITEM,"
						+ " U.TEXTBOOK, Q.QUESTION, Q.ANSWER, Q.PAGEVIEW, Q.FILENAME, Q.REGISTRANT from\r\n"
						+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
						+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
						+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
						+ "WHERE (UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
						+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
						+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
						+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
						+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
						+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
						+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
						+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
						+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
						+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
						+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
						+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
						+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
						+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
						+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
						+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
						+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
						+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
						+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
						+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
						+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
						+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
						+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
						+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)) "
						+ "AND CA.CATEGORY_ITEM = ?"
						+ "ORDER BY Q.PAGEVIEW DESC";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getQuestion1() != null && param.getQuestion1() != "") {
					pStmt.setString(1, "%" + param.getQuestion1() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}
				if (param.getQuestion2() != null && param.getQuestion2() != "") {
					pStmt.setString(2, "%" + param.getQuestion2() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}
				if (param.getQuestion3() != null && param.getQuestion3() != "") {
					pStmt.setString(3, "%" + param.getQuestion3() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}
				if (param.getCategory_item() != null && param.getCategory_item() != "") {
					pStmt.setString(4, param.getCategory_item());
				}
				else {
					pStmt.setString(4, "%");
				}
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Qaplus card = new Qaplus(
					rs.getInt("QUESTION_ID"),
					rs.getDate("DATE"),
					rs.getString("ANSWERER"),
					rs.getString("COURSE"),
					rs.getString("UNIT"),
					rs.getString("CATEGORY_ITEM"),
					rs.getString("textbook"),
					rs.getString("QUESTION"),
					rs.getString("ANSWER"),
					rs.getInt("PAGEVIEW"),
					rs.getString("FILENAME"),
					rs.getString("REGISTRANT")
					);
					cardListplus.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardListplus = null;
					}
				}
			}

			// 結果を返す
			return cardListplus;
		}



	//研修生用検索ANDANDカウント
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Qacount> selectcount1_1(Qas param) {
		Connection conn = null;
		List<Qacount> cardListplus = new ArrayList<Qacount>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

				// SQL文を準備する
				String sql = "select COUNT(Q.QUESTION_ID) AS COUNTER from\r\n"
						+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
						+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
						+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
						+ "WHERE UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
						+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
						+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
						+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
						+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
						+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
						+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
						+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
						+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
						+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
						+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
						+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
						+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
						+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
						+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
						+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
						+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
						+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
						+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
						+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
						+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
						+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
						+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
						+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getQuestion1() != null && param.getQuestion1() != "") {
					pStmt.setString(1, "%" + param.getQuestion1() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}
				if (param.getQuestion2() != null && param.getQuestion2() != "") {
					pStmt.setString(2, "%" + param.getQuestion2() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}
				if (param.getQuestion3() != null && param.getQuestion3() != "") {
					pStmt.setString(3, "%" + param.getQuestion3() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Qacount card = new Qacount(
					rs.getInt("COUNTER")
					);
					cardListplus.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardListplus = null;
					}
				}
			}

			// 結果を返す
			return cardListplus;
		}

				//研修生用検索ANDORカウント
				// 引数paramで検索項目を指定し、検索結果のリストを返す
				public List<Qacount> selectcount1_2(Qas param) {
					Connection conn = null;
					List<Qacount> cardListplus = new ArrayList<Qacount>();

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

						// SQL文を準備する
						String sql = "select COUNT(Q.QUESTION_ID) AS COUNTER from\r\n"
								+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
								+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
								+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
								+ "WHERE UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
								+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
								+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
								+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
								+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
								+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
								+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
								+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
								+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
								+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
								+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
								+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
								+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
								+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
								+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
								+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
								+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
								+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
								+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
								+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
								+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
								+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
								+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
								+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
						if (param.getQuestion1() != null && param.getQuestion1() != "") {
							pStmt.setString(1, "%" + param.getQuestion1() + "%");
						}
						else {
							pStmt.setString(1, "%");
						}
						if (param.getQuestion2() != null && param.getQuestion2() != "") {
							pStmt.setString(2, "%" + param.getQuestion2() + "%");
						}
						else {
							pStmt.setString(2, "%");
						}
						if (param.getQuestion3() != null && param.getQuestion3() != "") {
							pStmt.setString(3, "%" + param.getQuestion3() + "%");
						}
						else {
							pStmt.setString(3, "%");
						}
						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							Qacount card = new Qacount(
							rs.getInt("COUNTER")
							);
							cardListplus.add(card);
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardListplus = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						cardListplus = null;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								cardListplus = null;
							}
						}
					}

					// 結果を返す
					return cardListplus;
				}

				//研修生用検索ORANDカウント
				// 引数paramで検索項目を指定し、検索結果のリストを返す
				public List<Qacount> selectcount1_3(Qas param) {
					Connection conn = null;
					List<Qacount> cardListplus = new ArrayList<Qacount>();

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

						// SQL文を準備する
						String sql = "select COUNT(Q.QUESTION_ID) AS COUNTER from\r\n"
								+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
								+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
								+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
								+ "WHERE UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
								+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
								+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
								+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
								+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
								+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
								+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
								+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
								+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
								+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
								+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
								+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
								+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
								+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
								+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
								+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
								+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
								+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
								+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
								+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
								+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
								+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
								+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
								+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
						if (param.getQuestion1() != null && param.getQuestion1() != "") {
							pStmt.setString(1, "%" + param.getQuestion1() + "%");
						}
						else {
							pStmt.setString(1, "%");
						}
						if (param.getQuestion2() != null && param.getQuestion2() != "") {
							pStmt.setString(2, "%" + param.getQuestion2() + "%");
						}
						else {
							pStmt.setString(2, "%");
						}
						if (param.getQuestion3() != null && param.getQuestion3() != "") {
							pStmt.setString(3, "%" + param.getQuestion3() + "%");
						}
						else {
							pStmt.setString(3, "%");
						}
						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							Qacount card = new Qacount(
							rs.getInt("COUNTER")
							);
							cardListplus.add(card);
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardListplus = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						cardListplus = null;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								cardListplus = null;
							}
						}
					}

					// 結果を返す
					return cardListplus;
				}

	//研修生用検索ORORカウント
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Qacount> selectcount1_4(Qas param) {
		Connection conn = null;
		List<Qacount> cardListplus = new ArrayList<Qacount>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

			// SQL文を準備する
			String sql = "select COUNT(Q.QUESTION_ID) AS COUNTER from\r\n"
					+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
					+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
					+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
					+ "WHERE UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getQuestion1() != null && param.getQuestion1() != "") {
				pStmt.setString(1, "%" + param.getQuestion1() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getQuestion2() != null && param.getQuestion2() != "") {
				pStmt.setString(2, "%" + param.getQuestion2() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getQuestion3() != null && param.getQuestion3() != "") {
				pStmt.setString(3, "%" + param.getQuestion3() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Qacount card = new Qacount(
				rs.getInt("COUNTER")
				);
				cardListplus.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardListplus = null;
				}
			}
		}

		// 結果を返す
		return cardListplus;
	}


	//研修生用検索ANDANDカウント（単元項目付き）
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Qacount> selectcategorycount1_1(Qasplus param) {
		Connection conn = null;
		List<Qacount> cardListplus = new ArrayList<Qacount>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

			// SQL文を準備する
			String sql = "select COUNT(Q.QUESTION_ID) AS COUNTER from\r\n"
					+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
					+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
					+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
					+ "WHERE (UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)) "
					+ "AND CA.CATEGORY_ITEM= ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getQuestion1() != null && param.getQuestion1() != "") {
				pStmt.setString(1, "%" + param.getQuestion1() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getQuestion2() != null && param.getQuestion2() != "") {
				pStmt.setString(2, "%" + param.getQuestion2() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getQuestion3() != null && param.getQuestion3() != "") {
				pStmt.setString(3, "%" + param.getQuestion3() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getCategory_item() != null && param.getCategory_item() != "") {
				pStmt.setString(4, param.getCategory_item());
			}
			else {
				pStmt.setString(4, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Qacount card = new Qacount(
				rs.getInt("COUNTER")
				);
				cardListplus.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardListplus = null;
				}
			}
		}

		// 結果を返す
		return cardListplus;
	}

	//研修生用検索ANDORカウント（単元項目付き）
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Qacount> selectcategorycount1_2(Qasplus param) {
		Connection conn = null;
		List<Qacount> cardListplus = new ArrayList<Qacount>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

			// SQL文を準備する
			String sql = "select COUNT(Q.QUESTION_ID) AS COUNTER from\r\n"
					+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
					+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
					+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
					+ "WHERE (UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)) "
					+ "AND CA.CATEGORY_ITEM= ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getQuestion1() != null && param.getQuestion1() != "") {
				pStmt.setString(1, "%" + param.getQuestion1() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getQuestion2() != null && param.getQuestion2() != "") {
				pStmt.setString(2, "%" + param.getQuestion2() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getQuestion3() != null && param.getQuestion3() != "") {
				pStmt.setString(3, "%" + param.getQuestion3() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getCategory_item() != null && param.getCategory_item() != "") {
				pStmt.setString(4, param.getCategory_item());
			}
			else {
				pStmt.setString(4, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Qacount card = new Qacount(
				rs.getInt("COUNTER")
				);
				cardListplus.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardListplus = null;
				}
			}
		}

		// 結果を返す
		return cardListplus;
	}

	//研修生用検索ORANDカウント（単元項目付き）
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Qacount> selectcategorycount1_3(Qasplus param) {
		Connection conn = null;
		List<Qacount> cardListplus = new ArrayList<Qacount>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

			// SQL文を準備する
			String sql = "select COUNT(Q.QUESTION_ID) AS COUNTER from\r\n"
					+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
					+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
					+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
					+ "WHERE (UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "AND UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)) "
					+ "AND CA.CATEGORY_ITEM= ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getQuestion1() != null && param.getQuestion1() != "") {
				pStmt.setString(1, "%" + param.getQuestion1() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getQuestion2() != null && param.getQuestion2() != "") {
				pStmt.setString(2, "%" + param.getQuestion2() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getQuestion3() != null && param.getQuestion3() != "") {
				pStmt.setString(3, "%" + param.getQuestion3() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getCategory_item() != null && param.getCategory_item() != "") {
				pStmt.setString(4, param.getCategory_item());
			}
			else {
				pStmt.setString(4, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Qacount card = new Qacount(
				rs.getInt("COUNTER")
				);
				cardListplus.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardListplus = null;
				}
			}
		}

		// 結果を返す
		return cardListplus;
	}

	//研修生用検索ORORカウント（単元項目付き）
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Qacount> selectcategorycount1_4(Qasplus param) {
		Connection conn = null;
		List<Qacount> cardListplus = new ArrayList<Qacount>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

			// SQL文を準備する
			String sql = "select COUNT(Q.QUESTION_ID) AS COUNTER from\r\n"
					+ " ((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
					+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
					+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
					+ "WHERE (UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)"
					+ "OR UPPER(CONCAT((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END),  "
					+ "(CASE WHEN CO.COURSE IS NULL THEN '' ELSE CO.COURSE END), "
					+ "(CASE WHEN U.UNIT IS NULL THEN '' ELSE U.UNIT END), "
					+ "(CASE WHEN CA.CATEGORY_ITEM IS NULL THEN '' ELSE CA.CATEGORY_ITEM END), "
					+ "(CASE WHEN U.TEXTBOOK IS NULL THEN '' ELSE U.TEXTBOOK END), "
					+ "(CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END), "
					+ "(CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END), "
					+ "(CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END))) LIKE UPPER(?)) "
					+ "AND CA.CATEGORY_ITEM= ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getQuestion1() != null && param.getQuestion1() != "") {
				pStmt.setString(1, "%" + param.getQuestion1() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getQuestion2() != null && param.getQuestion2() != "") {
				pStmt.setString(2, "%" + param.getQuestion2() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getQuestion3() != null && param.getQuestion3() != "") {
				pStmt.setString(3, "%" + param.getQuestion3() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getCategory_item() != null && param.getCategory_item() != "") {
				pStmt.setString(4, param.getCategory_item());
			}
			else {
				pStmt.setString(4, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Qacount card = new Qacount(
				rs.getInt("COUNTER")
				);
				cardListplus.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardListplus = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardListplus = null;
				}
			}
		}

		// 結果を返す
		return cardListplus;
	}



		//事務局用検索カウント
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Qacount> select4(Qaall param) {
			Connection conn = null;
			List<Qacount> cardListplus = new ArrayList<Qacount>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

				// SQL文を準備する
				String sql = "select COUNT(Q.QUESTION_ID) AS COUNTER from "
						+ "((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) "
						+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) "
						+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
						+ "WHERE UPPER((CASE WHEN Q.DATE IS NULL THEN 10001010 ELSE Q.DATE END)) LIKE UPPER(?) AND "
						+ "      UPPER((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END)) LIKE UPPER(?) AND "
						+ "      UPPER(CAST((CASE WHEN Q.CATEGORY_ID IS NULL THEN '' ELSE Q.CATEGORY_ID END) AS VARCHAR)) LIKE UPPER(?) AND "
						+ "      UPPER((CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END)) LIKE UPPER(?) AND "
						+ "      UPPER((CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END)) LIKE UPPER(?) AND "
						+ "      UPPER((CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END)) LIKE UPPER(?) ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getDate() != null) {
					long timeInMilliSeconds = param.getDate().getTime();
			        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
					pStmt.setDate(1,date1);
				}
				else {
					pStmt.setString(1, "%");
				}
				if (param.getAnswerer() != null && param.getAnswerer() != "") {
					pStmt.setString(2, "%" + param.getAnswerer() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}
				if (param.getCategory_id() != 0) {
					pStmt.setString(3, Integer.toString(param.getCategory_id()));
				}
				else {
					pStmt.setString(3, "%");
				}
				if (param.getQuestion() != null && param.getQuestion() != "") {
					pStmt.setString(4, "%" + param.getQuestion() + "%");
				}
				else {
					pStmt.setString(4, "%");
				}
				if (param.getAnswer() != null && param.getAnswer() != "") {
					pStmt.setString(5, "%" + param.getAnswer() + "%");
				}
				else {
					pStmt.setString(5, "%");
				}
				if (param.getRegistrant() != null && param.getRegistrant() != "") {
					pStmt.setString(6, "%" + param.getRegistrant() + "%");
				}
				else {
					pStmt.setString(6, "%");
				}
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Qacount card = new Qacount(
					rs.getInt("COUNTER")
					);
					cardListplus.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardListplus = null;
					}
				}
			}

			// 結果を返す
			return cardListplus;
		}

		//事務局用検索
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Qaplus> select2(Qaall param) {
					Connection conn = null;
					List<Qaplus> cardListplus = new ArrayList<Qaplus>();

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

						// SQL文を準備する
						String sql = "select Q.QUESTION_ID, Q.DATE, Q.ANSWERER,  Q.CATEGORY_ID, CO.COURSE, U.UNIT, "
								+ "CA.CATEGORY_ITEM, U.TEXTBOOK, Q.QUESTION, Q.ANSWER, Q.PAGEVIEW, Q.FILENAME, Q.REGISTRANT from "
								+ "((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) "
								+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) "
								+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID "
								+ "WHERE UPPER((CASE WHEN Q.DATE IS NULL THEN 10001010 ELSE Q.DATE END)) LIKE UPPER(?) AND "
								+ "      UPPER((CASE WHEN Q.ANSWERER IS NULL THEN '' ELSE Q.ANSWERER END)) LIKE UPPER(?) AND "
								+ "      UPPER(CAST((CASE WHEN Q.CATEGORY_ID IS NULL THEN '' ELSE Q.CATEGORY_ID END) AS VARCHAR)) LIKE UPPER(?) AND "
								+ "      UPPER((CASE WHEN Q.QUESTION IS NULL THEN '' ELSE Q.QUESTION END)) LIKE UPPER(?) AND "
								+ "      UPPER((CASE WHEN Q.ANSWER IS NULL THEN '' ELSE Q.ANSWER END)) LIKE UPPER(?) AND "
								+ "      UPPER((CASE WHEN Q.REGISTRANT IS NULL THEN '' ELSE Q.REGISTRANT END)) LIKE UPPER(?) "
								+ "      ORDER BY Q.PAGEVIEW DESC";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
						if (param.getDate() != null) {
							long timeInMilliSeconds = param.getDate().getTime();
					        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
							pStmt.setDate(1,date1);
						}
						else {
							pStmt.setString(1, "%");
						}
						if (param.getAnswerer() != null && param.getAnswerer() != "") {
							pStmt.setString(2, "%" + param.getAnswerer() + "%");
						}
						else {
							pStmt.setString(2, "%");
						}
						if (param.getCategory_id() != 0) {
							pStmt.setString(3, Integer.toString(param.getCategory_id()));
						}
						else {
							pStmt.setString(3, "%");
						}
						if (param.getQuestion() != null && param.getQuestion() != "") {
							pStmt.setString(4, "%" + param.getQuestion() + "%");
						}
						else {
							pStmt.setString(4, "%");
						}
						if (param.getAnswer() != null && param.getAnswer() != "") {
							pStmt.setString(5, "%" + param.getAnswer() + "%");
						}
						else {
							pStmt.setString(5, "%");
						}
						if (param.getRegistrant() != null && param.getRegistrant() != "") {
							pStmt.setString(6, "%" + param.getRegistrant() + "%");
						}
						else {
							pStmt.setString(6, "%");
						}
						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							Qaplus card = new Qaplus(
							rs.getInt("QUESTION_ID"),
							rs.getDate("DATE"),
							rs.getString("ANSWERER"),
							rs.getString("COURSE"),
							rs.getString("UNIT"),
							rs.getString("CATEGORY_ITEM"),
							rs.getString("TEXTBOOK"),
							rs.getString("QUESTION"),
							rs.getString("ANSWER"),
							rs.getInt("PAGEVIEW"),
							rs.getString("FILENAME"),
							rs.getString("REGISTRANT")
							);
							cardListplus.add(card);
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardListplus = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						cardListplus = null;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								cardListplus = null;
							}
						}
					}

					// 結果を返す
					return cardListplus;
				}



		//遷移用検索
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Qaplus> select3(Qaall param) {
			Connection conn = null;
			List<Qaplus> cardListplus = new ArrayList<Qaplus>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

				// SQL文を準備する
				String sql = "select Q.QUESTION_ID, Q.DATE, Q.ANSWERER,  Q.CATEGORY_ID, CO.COURSE, U.UNIT, \r\n"
						+ "CA.CATEGORY_ITEM, U.TEXTBOOK, Q.QUESTION, Q.ANSWER, Q.PAGEVIEW,Q.FILENAME, Q.REGISTRANT from \r\n"
						+ "((QA1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
						+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
						+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID \r\n"
						+ "WHERE Q.QUESTION_ID = ? ORDER BY Q.PAGEVIEW DESC;\r\n";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
					pStmt.setInt(1, param.getQuestion_id());
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Qaplus card = new Qaplus(
					rs.getInt("QUESTION_ID"),
					rs.getDate("DATE"),
					rs.getString("ANSWERER"),
					rs.getString("COURSE"),
					rs.getString("UNIT"),
					rs.getString("CATEGORY_ITEM"),
					rs.getString("textbook"),
					rs.getString("QUESTION"),
					rs.getString("ANSWER"),
					rs.getInt("PAGEVIEW"),
					rs.getString("FILENAME"),
					rs.getString("REGISTRANT")
					);
					cardListplus.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardListplus = null;
					}
				}
			}

			// 結果を返す
			return cardListplus;
		}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Qaall card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

			// SQL文を準備する
			String sql = "insert into QA1 values (null, ?, ?, ?, ?, ?, 0, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getDate() != null) {
		        long timeInMilliSeconds = card.getDate().getTime();
		        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
				pStmt.setDate(1,date1);
			}
			else {
				pStmt.setDate(1, null);
			}
			if (!card.getAnswerer().equals(null) && !card.getAnswerer().equals("")) {
				pStmt.setString(2, card.getAnswerer());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getCategory_id() !=0) {
				pStmt.setInt(3, card.getCategory_id());
			}
			else {
				pStmt.setInt(3, 0601001);
			}
			if (card.getQuestion() != null && card.getQuestion() != "") {
				pStmt.setString(4, card.getQuestion());
			}
			else {
				pStmt.setString(4, null);
			}
			if (card.getAnswer() != null && card.getAnswer() != "") {
				pStmt.setString(5, card.getAnswer());
			}
			else {
				pStmt.setString(5, null);
			}
			if (card.getFilename() != null && card.getFilename() != "") {
				pStmt.setString(6, card.getFilename());
			}
			else {
				pStmt.setString(6, null);
			}

			if (card.getRegistrant() != null && card.getRegistrant() != "") {
				pStmt.setString(7, card.getRegistrant());
			}
			else {
				pStmt.setString(7, null);
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	//保存用sql
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insertsave(Qaall card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

				// SQL文を準備する
				String sql = "insert into QASAVE1 values (null, ?, ?, ?, ?, ?, 0,?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getDate() != null) {
			        long timeInMilliSeconds = card.getDate().getTime();
			        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
					pStmt.setDate(1,date1);
				}
				else {
					pStmt.setDate(1, null);
				}
				if (!card.getAnswerer().equals(null) && !card.getAnswerer().equals("")) {
					pStmt.setString(2, card.getAnswerer());
				}
				else {
					pStmt.setString(2, null);
				}
				if (card.getCategory_id() !=0) {
					pStmt.setInt(3, card.getCategory_id());
				}
				else {
					pStmt.setInt(3, 0601001);
				}
				if (!card.getQuestion().equals(null) && !card.getQuestion().equals("")) {
					pStmt.setString(4, card.getQuestion());
				}
				else {
					pStmt.setString(4, null);
				}
				if (!card.getAnswer().equals(null) && !card.getAnswer().equals("")) {
					pStmt.setString(5, card.getAnswer());
				}
				else {
					pStmt.setString(5, null);
				}
				if (card.getFilename()!=null && card.getFilename()!="") {
					pStmt.setString(6, card.getFilename());
				}
				else {
					pStmt.setString(6, null);
				}
				if (!card.getRegistrant().equals(null) && !card.getRegistrant().equals("")) {
					pStmt.setString(7, card.getRegistrant());
				}
				else {
					pStmt.setString(7, null);
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}


		//保存遷移用検索
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Qaplus> selectsave(Qaall param) {
			Connection conn = null;
			List<Qaplus> cardListplus = new ArrayList<Qaplus>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

				// SQL文を準備する
				String sql = "select Q.QUESTION_ID, Q.DATE, Q.ANSWERER,  Q.CATEGORY_ID, CO.COURSE, U.UNIT, \r\n"
						+ "CA.CATEGORY_ITEM, U.TEXTBOOK, Q.QUESTION, Q.ANSWER, Q.PAGEVIEW, Q.FILENAME, Q.REGISTRANT from \r\n"
						+ "((QASAVE1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
						+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
						+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID \r\n"
						+ " ORDER BY Q.PAGEVIEW DESC;\r\n";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Qaplus card = new Qaplus(
					rs.getInt("QUESTION_ID"),
					rs.getDate("DATE"),
					rs.getString("ANSWERER"),
					rs.getString("COURSE"),
					rs.getString("UNIT"),
					rs.getString("CATEGORY_ITEM"),
					rs.getString("textbook"),
					rs.getString("QUESTION"),
					rs.getString("ANSWER"),
					rs.getInt("PAGEVIEW"),
					rs.getString("FILENAME"),
					rs.getString("REGISTRANT")
					);
					cardListplus.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardListplus = null;
					}
				}
			}

			// 結果を返す
			return cardListplus;
		}

		//保存編集遷移用検索
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Qaplus> selectsave3(Qaall param) {
			Connection conn = null;
			List<Qaplus> cardListplus = new ArrayList<Qaplus>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

				// SQL文を準備する
				String sql = "select Q.QUESTION_ID, Q.DATE, Q.ANSWERER,  Q.CATEGORY_ID, CO.COURSE, U.UNIT, \r\n"
						+ "CA.CATEGORY_ITEM, U.TEXTBOOK, Q.QUESTION, Q.ANSWER, Q.PAGEVIEW, Q.FILENAME, Q.REGISTRANT from \r\n"
						+ "((QASAVE1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) \r\n"
						+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) \r\n"
						+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID \r\n"
						+ " WHERE Q.QUESTION_ID = ? ORDER BY Q.PAGEVIEW DESC;\r\n";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setInt(1, param.getQuestion_id());
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Qaplus card = new Qaplus(
					rs.getInt("QUESTION_ID"),
					rs.getDate("DATE"),
					rs.getString("ANSWERER"),
					rs.getString("COURSE"),
					rs.getString("UNIT"),
					rs.getString("CATEGORY_ITEM"),
					rs.getString("textbook"),
					rs.getString("QUESTION"),
					rs.getString("ANSWER"),
					rs.getInt("PAGEVIEW"),
					rs.getString("FILENAME"),
					rs.getString("REGISTRANT")
					);
					cardListplus.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardListplus = null;
					}
				}
			}

			// 結果を返す
			return cardListplus;
		}




		//保存編集用カウント
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Qacount> selectsavecount(Qaall param) {
			Connection conn = null;
			List<Qacount> cardListplus = new ArrayList<Qacount>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

				// SQL文を準備する
				String sql = "select COUNT(Q.QUESTION_ID) AS COUNTER from "
						+ "((QASAVE1 as Q inner join CATEGORY as CA on Q.CATEGORY_ID=CA.CATEGORY_ID) "
						+ "inner join UNIT as U on CA.COURSE_ID=U.COURSE_ID and CA.UNIT_ID=U.UNIT_ID) "
						+ "inner join COURSE as CO on CA.COURSE_ID=CO.COURSE_ID ";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Qacount card = new Qacount(
					rs.getInt("COUNTER")
					);
					cardListplus.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardListplus = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardListplus = null;
					}
				}
			}

			// 結果を返す
			return cardListplus;
		}



	//更新処理
	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Qaall card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");
			// SQL文を準備する
			String sql = "update QA1 set DATE=?, ANSWERER=?, CATEGORY_ID=?, QUESTION=?, ANSWER=?, FILENAME=?, REGISTRANT=? where QUESTION_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getDate() != null) {
				long timeInMilliSeconds = card.getDate().getTime();
		        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
				pStmt.setDate(1,date1);
			}
			else {
				pStmt.setDate(1, null);
			}
			if (card.getAnswerer() != null) {
				pStmt.setString(2, card.getAnswerer());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getCategory_id() != 0) {
				pStmt.setInt(3, card.getCategory_id());
			}
			else {
				pStmt.setInt(3, 0601001);
			}
			if (card.getQuestion() != null) {
				pStmt.setString(4, card.getQuestion());
			}
			else {
				pStmt.setString(4, null);
			}
			if (card.getAnswer() != null) {
				pStmt.setString(5, card.getAnswer());
			}
			else {
				pStmt.setString(5, null);
			}
			if (card.getFilename() != null) {
				pStmt.setString(6, card.getFilename());
			}
			else {
				pStmt.setString(6, null);
			}
			if (card.getRegistrant() != null) {
				pStmt.setString(7, card.getRegistrant());
			}
			else {
				pStmt.setString(7, null);
			}
			pStmt.setInt(8, card.getQuestion_id());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	//保存更新処理
		// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean updatesave(Qaall card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");
				// SQL文を準備する
				String sql = "update QASAVE1 set DATE=?, ANSWERER=?, CATEGORY_ID=?, QUESTION=?, ANSWER=?, FILENAME=?, REGISTRANT=? where QUESTION_ID=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getDate() != null) {
					long timeInMilliSeconds = card.getDate().getTime();
			        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
					pStmt.setDate(1,date1);
				}
				else {
					pStmt.setDate(1, null);
				}
				if (card.getAnswerer() != null) {
					pStmt.setString(2, card.getAnswerer());
				}
				else {
					pStmt.setString(2, null);
				}
				if (card.getCategory_id() != 0) {
					pStmt.setInt(3, card.getCategory_id());
				}
				else {
					pStmt.setInt(3, 0601001);
				}
				if (card.getQuestion() != null) {
					pStmt.setString(4, card.getQuestion());
				}
				else {
					pStmt.setString(4, null);
				}
				if (card.getAnswer() != null) {
					pStmt.setString(5, card.getAnswer());
				}
				else {
					pStmt.setString(5, null);
				}
				if (card.getFilename() != null) {
					pStmt.setString(6, card.getFilename());
				}
				else {
					pStmt.setString(6, null);
				}
				if (card.getRegistrant() != null) {
					pStmt.setString(7, card.getRegistrant());
				}
				else {
					pStmt.setString(7, null);
				}
				pStmt.setInt(8, card.getQuestion_id());

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}

		//更新処理
		// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean updatenophoto(Qaall card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");
				// SQL文を準備する
				String sql = "update QA1 set DATE=?, ANSWERER=?, CATEGORY_ID=?, QUESTION=?, ANSWER=?, REGISTRANT=? where QUESTION_ID=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getDate() != null) {
					long timeInMilliSeconds = card.getDate().getTime();
			        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
					pStmt.setDate(1,date1);
				}
				else {
					pStmt.setDate(1, null);
				}
				if (card.getAnswerer() != null) {
					pStmt.setString(2, card.getAnswerer());
				}
				else {
					pStmt.setString(2, null);
				}
				if (card.getCategory_id() != 0) {
					pStmt.setInt(3, card.getCategory_id());
				}
				else {
					pStmt.setInt(3, 0601001);
				}
				if (card.getQuestion() != null) {
					pStmt.setString(4, card.getQuestion());
				}
				else {
					pStmt.setString(4, null);
				}
				if (card.getAnswer() != null) {
					pStmt.setString(5, card.getAnswer());
				}
				else {
					pStmt.setString(5, null);
				}
				if (card.getRegistrant() != null) {
					pStmt.setString(6, card.getRegistrant());
				}
				else {
					pStmt.setString(6, null);
				}
				pStmt.setInt(7, card.getQuestion_id());

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}

		//保存更新処理
			// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
			public boolean updatesavenophoto(Qaall card) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");
					// SQL文を準備する
					String sql = "update QASAVE1 set DATE=?, ANSWERER=?, CATEGORY_ID=?, QUESTION=?, ANSWER=?, REGISTRANT=? where QUESTION_ID=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					if (card.getDate() != null) {
						long timeInMilliSeconds = card.getDate().getTime();
				        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
						pStmt.setDate(1,date1);
					}
					else {
						pStmt.setDate(1, null);
					}
					if (card.getAnswerer() != null) {
						pStmt.setString(2, card.getAnswerer());
					}
					else {
						pStmt.setString(2, null);
					}
					if (card.getCategory_id() != 0) {
						pStmt.setInt(3, card.getCategory_id());
					}
					else {
						pStmt.setInt(3, 0601001);
					}
					if (card.getQuestion() != null) {
						pStmt.setString(4, card.getQuestion());
					}
					else {
						pStmt.setString(4, null);
					}
					if (card.getAnswer() != null) {
						pStmt.setString(5, card.getAnswer());
					}
					else {
						pStmt.setString(5, null);
					}
					if (card.getRegistrant() != null) {
						pStmt.setString(6, card.getRegistrant());
					}
					else {
						pStmt.setString(6, null);
					}
					pStmt.setInt(7, card.getQuestion_id());

					// SQL文を実行する
					if (pStmt.executeUpdate() == 1) {
						result = true;
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}

				// 結果を返す
				return result;
			}


	//閲覧数を増やす
	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean updatecount(Qaall card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");
			// SQL文を準備する
			String sql = "update QA1 set PAGEVIEW=PAGEVIEW+1 where QUESTION_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setInt(1, card.getQuestion_id());;

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}



	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
		public boolean delete(int question_id) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

				// SQL文を準備する
				String sql = "delete from QA1 where QUESTION_ID=?; ALTER TABLE QA1 drop column QUESTION_ID; ALTER TABLE QA1 ADD QUESTION_ID int primary key auto_increment first;";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setInt(1, question_id);

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}


		//保存削除
		// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
				public boolean deletesave(int question_id) {
					Connection conn = null;
					boolean result = false;

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

						// SQL文を準備する
						String sql = "delete from QASAVE1 where QUESTION_ID=?; ALTER TABLE QASAVE1 drop column QUESTION_ID; ALTER TABLE QASAVE1 ADD QUESTION_ID int primary key auto_increment first;";
						PreparedStatement pStmt = conn.prepareStatement(sql);

						// SQL文を完成させる
						pStmt.setInt(1, question_id);

						// SQL文を実行する
						if (pStmt.executeUpdate() == 1) {
							result = true;
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}

					// 結果を返す
					return result;
				}
	}

