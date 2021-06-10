package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Qa;


public class QaDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Qa> select(Qa param) {
		Connection conn = null;
		List<Qa> cardList = new ArrayList<Qa>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "select NUMBER, NAME, NAMEFURIGANA, ENGLISHNAME, COMPANY, SECTION, POST, ZIPCODE, ADDRESS, MOBILENUMBER, TELEPHONENUMBER, FAX, MAILADDRESS, REMARKS from BC "
					+ "WHERE NAME LIKE ? AND  (CASE WHEN NAMEFURIGANA IS NULL THEN '' ELSE NAMEFURIGANA END) LIKE ? AND (CASE WHEN ENGLISHNAME IS NULL THEN '' ELSE ENGLISHNAME END) LIKE ? AND "
					+ "(CASE WHEN COMPANY IS NULL THEN '' ELSE COMPANY END) LIKE ? AND (CASE WHEN SECTION IS NULL THEN '' ELSE SECTION END) LIKE ? AND (CASE WHEN POST IS NULL THEN '' ELSE POST END) LIKE ? AND "
					+ "(CASE WHEN ZIPCODE IS NULL THEN '' ELSE ZIPCODE END) LIKE ? AND (CASE WHEN ADDRESS IS NULL THEN '' ELSE ADDRESS END) LIKE ? AND(CASE WHEN MOBILENUMBER IS NULL THEN '' ELSE MOBILENUMBER END) LIKE ? AND (CASE WHEN TELEPHONENUMBER IS NULL THEN '' ELSE TELEPHONENUMBER END) LIKE ? AND"
					+ "(CASE WHEN FAX IS NULL THEN '' ELSE FAX END) LIKE ? AND (CASE WHEN MAILADDRESS IS NULL THEN '' ELSE MAILADDRESS END) LIKE ? AND (CASE WHEN REMARKS IS NULL THEN '' ELSE REMARKS END) LIKE ? "
					+ "ORDER BY NUMBER";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			/*if (param.getNumber() != 0) {
				pStmt.setInt(1,  param.getNumber() );
			}
			else {
				pStmt.setString(1, "%");
			}*/
			if (param.getName() != null && param.getName() != "") {
				pStmt.setString(1, "%" + param.getName() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getNamefurigana() != null && param.getNamefurigana() != "") {
				pStmt.setString(2, "%" + param.getNamefurigana() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getEnglishname() != null && param.getEnglishname() != "") {
				pStmt.setString(3, "%" + param.getEnglishname() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if ( param.getCompany() !=null &&param.getCompany() != "") {
				pStmt.setString(4, "%" + param.getCompany() + "%");
			}
			else {
				pStmt.setString(4,"%");
			}
			if (param.getSection() != null && param.getSection() != "") {
				pStmt.setString(5, "%" + param.getSection() + "%");
			}
			else {
				pStmt.setString(5, "%");
			}
			if (param.getPost() != null && param.getPost() != "") {
				pStmt.setString(6, "%" + param.getPost() + "%");
			}
			else {
				pStmt.setString(6,"%");
			}
			if (param.getZipcode() != null && param.getZipcode() != "") {
				pStmt.setString(7, "%"+param.getZipcode()+"%");
			}
			else {
				pStmt.setString(7,"%");
			}
			if (param.getAddress() != null && param.getAddress() != "") {
				pStmt.setString(8, "%" + param.getAddress() + "%");
			}
			else {
				pStmt.setString(8, "%");
			}
			if (param.getMobilenumber() != null && param.getMobilenumber() != "") {
				pStmt.setString(9, "%"+param.getMobilenumber()+"%");
			}
			else {
				pStmt.setString(9, "%");
			}
			if (param.getTelephonenumber() != null && param.getTelephonenumber() != "") {
				pStmt.setString(10, "%"+param.getTelephonenumber()+"%");
			}
			else {
				pStmt.setString(10,"%");
			}
			if (param.getFax() != null && param.getFax() != "") {
				pStmt.setString(11, "%"+param.getFax()+"%");
			}
			else {
				pStmt.setString(11,"%");
			}
			if (param.getMailaddress() != null && param.getMailaddress() != "") {
				pStmt.setString(12, "%" + param.getMailaddress() + "%");
			}
			else {
				pStmt.setString(12,"%");
			}
			if (param.getRemarks() != null && param.getRemarks() != "") {
				pStmt.setString(13, "%" + param.getRemarks() + "%");
			}
			else {
				pStmt.setString(13,"%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Qa card = new Qa(
				rs.getInt("NUMBER"),
				rs.getString("NAME"),
				rs.getString("NAMEFURIGANA"),
				rs.getString("ENGLISHNAME"),
				rs.getString("COMPANY"),
				rs.getString("SECTION"),
				rs.getString("POST"),
				rs.getString("ZIPCODE"),
				rs.getString("ADDRESS"),
				rs.getString("MOBILENUMBER"),
				rs.getString("TELEPHONENUMBER"),
				rs.getString("FAX"),
				rs.getString("MAILADDRESS"),
				rs.getString("REMARKS")
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



	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Qa card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "insert into BC (NUMBER, NAME, NAMEFURIGANA, ENGLISHNAME, COMPANY, SECTION, POST, ZIPCODE, ADDRESS, MOBILENUMBER, TELEPHONENUMBER, FAX, MAILADDRESS, REMARKS)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			pStmt.setString(1, null);
			if (card.getName() != null) {
				pStmt.setString(2, card.getName());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getNamefurigana() != null) {
				pStmt.setString(3, card.getNamefurigana());
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getEnglishname() != null) {
				pStmt.setString(4, card.getEnglishname());
			}
			else {
				pStmt.setString(4, null);
			}
			if (card.getCompany() != null) {
				pStmt.setString(5, card.getCompany());
			}
			else {
				pStmt.setString(5, null);
			}
			if (card.getSection() != null) {
				pStmt.setString(6, card.getSection());
			}
			else {
				pStmt.setString(6, null);
			}
			if (card.getPost() != null) {
				pStmt.setString(7, card.getPost());
			}
			else {
				pStmt.setString(7, null);
			}
			if (card.getZipcode() != null) {
				pStmt.setString(8, card.getZipcode());
			}
			else {
				pStmt.setString(8, null);
			}
			if (card.getAddress() != null) {
				pStmt.setString(9, card.getAddress());
			}
			else {
				pStmt.setString(9, null);
			}
			if (card.getMobilenumber() != null) {
				pStmt.setString(10,card.getMobilenumber());
			}
			else {
				pStmt.setString(10, null);
			}
			if (card.getTelephonenumber() != null) {
				pStmt.setString(11, card.getTelephonenumber());
			}
			else {
				pStmt.setString(11, null);
			}
			if (card.getFax() != null) {
				pStmt.setString(12, card.getFax());
			}
			else {
				pStmt.setString(12, null);
			}
			if (card.getMailaddress() != null) {
				pStmt.setString(13, card.getMailaddress());
			}
			else {
				pStmt.setString(13, null);
			}
			if (card.getRemarks() != null) {
				pStmt.setString(14, card.getRemarks());
			}
			else {
				pStmt.setString(14, null);
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



	//初期の更新sql
	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Qa card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

			// SQL文を準備する
			String sql = "update BC set NAME=?, NAMEFURIGANA=?, ENGLISHNAME=?, COMPANY=?, SECTION=?, POST=?, ZIPCODE=?, ADDRESS=?, MOBILENUMBER=?, TELEPHONENUMBER=?, FAX=?, MAILADDRESS=?, REMARKS=? where NUMBER=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getName() != null) {
				pStmt.setString(1, card.getName());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getNamefurigana() != null) {
				pStmt.setString(2, card.getNamefurigana());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getEnglishname() != null) {
				pStmt.setString(3, card.getEnglishname());
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getCompany() != null) {
				pStmt.setString(4, card.getCompany());
			}
			else {
				pStmt.setString(4, null);
			}
			if (card.getSection() != null) {
				pStmt.setString(5, card.getSection());
			}
			else {
				pStmt.setString(5, null);
			}
			if (card.getPost() != null) {
				pStmt.setString(6, card.getPost());
			}
			else {
				pStmt.setString(6, null);
			}
			if (card.getZipcode() != null) {
				pStmt.setString(7, card.getZipcode());
			}
			else {
				pStmt.setString(7, null);
			}
			if (card.getAddress() != null) {
				pStmt.setString(8, card.getAddress());
			}
			else {
				pStmt.setString(8, null);
			}
			if (card.getMobilenumber() != null) {
				pStmt.setString(9, card.getMobilenumber());
			}
			else {
				pStmt.setString(9, null);
			}
			if (card.getTelephonenumber() !=null) {
				pStmt.setString(10, card.getTelephonenumber());
			}
			else {
				pStmt.setString(10, null);
			}
			if (card.getFax() != null) {
				pStmt.setString(11, card.getFax());
			}
			else {
				pStmt.setString(11, null);
			}
			if (card.getMailaddress() != null) {
				pStmt.setString(12, card.getMailaddress());
			}
			else {
				pStmt.setString(12, null);
			}
			if (card.getRemarks() != null) {
				pStmt.setString(13, card.getRemarks());
			}
			else {
				pStmt.setString(13, null);
			}
			pStmt.setInt(14, card.getNumber());

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
		public boolean delete(int number) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する
				String sql = "delete from BC where NUMBER=?; ALTER TABLE BC drop column NUMBER; ALTER TABLE BC ADD NUMBER int primary key auto_increment first;";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setInt(1, number);

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