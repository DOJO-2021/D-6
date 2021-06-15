<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="js/udedit.js"></script>
</head>
<body>
	<h1>DOJO Q&amp;A集</h1>
		<p><a href="/Doraemonno4jigenpoketto/LoginServlet">ログアウト</a></p>

	<h2>登録</h2>

	<nav>
		<form method="POST" action="/Doraemonno4jigenpoketto/RegistServlet">
		<table>
			<tr>
				<th>質問文</th><td><textarea name="QUESTION"></textarea></td>
			</tr>
			<tr>
				<th>回答文</th><td><textarea name="ANSWER"></textarea></td>
			</tr>

			<tr>
				<td>
					<select name="unit" id="unit">
					<option value="">単元を選択してください</option>
					<optgroup label="パーソナルスキルコース">
						<option value="0">ビジネス・コミュニケーション</option>
						<option value="1">ビジネスメール・ビジネス文章</option>
						<option value="2">Word</option>
						<option value="3">Excel</option>
					</optgroup>
					<optgroup label="IT基礎コース">
						<option value="4">プログラミング</option>
						<option value="5">アルゴリズム</option>
						<option value="6">ネットワーク</option>
						<option value="7">HTML</option>
						<option value="8">CSS</option>
						<option value="9">JavaScript</option>
						<option value="10">データベース(SQL)</option>
					</optgroup>
					<optgroup label="Java基礎コース">
						<option value="11">Javaプログラミング</option>
						<option value="12">サーバーサイドJava</option>
						<option value="13">品質管理</option>
						<option value="14">セキュリティ</option>
					</optgroup>
						<optgroup label="Webアプリ開発演習コース">
						<option value="15">導入</option>
						<option value="16">要件定義</option>
						<option value="17">外部設計</option>
						<option value="18">内部設計</option>
						<option value="19">実装</option>
						<option value="20">テスト</option>
						<option value="21">プレゼン作成</option>
						<option value="22">発表</option>
					</optgroup>
					<optgroup label="ドリル">
						<option value="23">アルゴリズムドリル</option>
						<option value="24">SQLドリル</option>
						<option value="25">Javaドリル</option>
					</optgroup>
					<optgroup label="その他">
						<option value="26">その他</option>
					</optgroup>
					</select>
				</td>
			</tr>

			<tr>
				<td>
					<select name="category_item" id="category_item">
					<option value="">選択してください</option>
					</select>

				</td>
			</tr>
			<!--
				<div>
					テキスト<select name="text"><br>
				</div>
			-->
			<tr>
				<td><input type="date" name="CALENDAR" max="9999-12-31"></td>
			</tr>
			<tr>
			    <input type="text" name="ANSWERER" id="answerer">
			</tr>
			<tr>
			    <input type="text" name="REGISTRANT" id="registant">
			</tr>
			<input type="submit" name="REGIST" value="登録"><br>
		</table>
		</form>
	</nav>
</body>
</html>