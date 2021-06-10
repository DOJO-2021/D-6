package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;


public class CategoryDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Category> select(Category param) {
		Connection conn = null;
		List<Category> cardList = new ArrayList<Category>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/D-6/Doraemonno4jigenpoketto/database", "sa", "sa");

			// SQL文を準備する
			String sql = "select COURSE_ID, UNIT_ID, CATEGORY_ID, CATEGORY_ITEM from CATEGORY "
					+ "where COURSE_ID=? and UNIT_ID=?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			/*if (param.getNumber() != 0) {
				pStmt.setInt(1,  param.getNumber() );
			}
			else {
				pStmt.setString(1, "%");
			}*/
			if (param.getCourse_id() !=0) {
				pStmt.setInt(1,  param.getCourse_id());
			}
			else {
				pStmt.setInt(1, 6);
			}
			if (param.getQuestion2() != 0) {
				pStmt.setInt(2, param.getUnit_id());
			}
			else {
				pStmt.setInt(2, 1);
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Qa card = new Category(
				rs.getInt("COURSE_ID"),
				rs.getInt("UNIT_ID"),
				rs.getInt("CATEGORY_ID"),
				rs.getString("CATEGORY_ITEM")
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


