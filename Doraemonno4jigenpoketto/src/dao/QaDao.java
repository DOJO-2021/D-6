package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Qa;
import model.Qaplus;
import model.Qas;

public class QaDao {
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

		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Qaplus> select1(Qas param) {
			Connection conn = null;
			List<Qaplus> cardListplus = new ArrayList<Qaplus>();

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
	public boolean insert(Qa card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

			// SQL文を準備する
			String sql = "insert into QA (question_id, date, answerer, category_id, "
					+ " question, answer, pageview, registrant)"
					+ " values (?, ?, ?, ?, ?, ?, 0, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			pStmt.setInt(1, 0);
			if (card.getDate() != null) {
				pStmt.setDate(2, (Date) card.getDate());
			}
			else {
				pStmt.setDate(2, null);
			}
			if (card.getAnswerer() != null && card.getAnswerer() != "") {
				pStmt.setString(3, card.getAnswerer());
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getCategory_id() !=0) {
				pStmt.setInt(4, card.getCategory_id());
			}
			else {
				pStmt.setInt(4, 0601001);
			}
			if (card.getQuestion() != null && card.getQuestion() != "") {
				pStmt.setString(5, card.getQuestion());
			}
			else {
				pStmt.setString(5, null);
			}
			if (card.getAnswer() != null && card.getAnswer() != "") {
				pStmt.setString(6, card.getAnswer());
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


	//更新処理
	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Qa card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");
			// SQL文を準備する
			String sql = "update QA set DATE=?, ANSWERER=?, CATEGORY_ID=?, QUESTION=?, ANSWER=?, REGISTRANT=? where QUESTION_ID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getDate() != null) {
				pStmt.setDate(1, (Date) card.getDate());
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
	public boolean updatecount(Qa card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");
			// SQL文を準備する
			String sql = "update QA set PAGEVIEW=PAGEVIEW+1 where QUESTION_ID=?";
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
				String sql = "delete from QA where QUESTION_ID=?; ALTER TABLE QA drop column QUESTION_ID; ALTER TABLE QA ADD QUESTION_ID int primary key auto_increment first;";
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