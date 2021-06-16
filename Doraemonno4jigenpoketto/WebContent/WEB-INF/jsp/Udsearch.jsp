<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DOJO Q&amp;A集</title>
		<script src="Udedit.js"></script>
	</head>
	<body>
									<!--h1は左より-->
		<h1><a href="/Doraemonno4jigenpoketto/MenuServlet">DOJO Q&amp;A集</a></h1>
													<!--h2は中央揃え-->
			<p><a href="/Doraemonno4jigenpoketto/LoginServlet">ログアウト</a> </p>

			<h2>編集内容検索</h2>
			<!--カテゴリ選択・回答者・質問した年月日・登録者についての登録-->
			<form method="POST" action="/Doraemonno4jigenpoketto/UdsearchServlet">
				<table>
					<tr>
						<td><!--単元選択-->
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
							<optgroup label="Web開発演習コース">
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
						<td>
						<select name="category_item" id="category_item">
						</select>
						</td>
						<td><!--回答者選択-- input typeに変更-->
						回答者<input type="text" name="ANSWERER">
						</td>
					</tr>
					<tr>
						<td><!--年月日選択-->
						<input type="date" name="CALENDAR" max="9999-12-31">
						</td>
						<td><!--登録者選択--input typeに変更-->
						登録者<input type="text" name="REGISTRANT">
						</td>
					</tr>
					<tr>
						<td>
						質問文<textarea name="QUESTION"></textarea>
						</td>
						<td>
						回答文<textarea name="ANSWER"></textarea>
						</td>
					</tr>
				</table>
				<input type="submit" name="SUBMIT" value="検索">
			</form>
	</body>
</html>