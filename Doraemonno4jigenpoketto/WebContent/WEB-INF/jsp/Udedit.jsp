<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DOJO Q&amp;A集</title>
		<script src="script.js"></script>
		<script src="udedit.js"></script>

		 <script type="text/javascript">

 <!-- 更新・削除時の確認をダイアログボックスで行う-->
function check(){

	if(window.confirm('実行してよろしいですか？')){ // 確認ダイアログを表示
		return true; // 「OK」時は送信を実行

	}
	else{ // 「キャンセル」時の処理

		window.alert('キャンセルされました'); // 警告ダイアログを表示
		return false; // 送信を中止

	}

}
</script>
	</head>
	<body>
												<!--h1は左より-->
		<h1><a href="/Doraemonno4jigenpoketto/MenuServlet">DOJO Q&amp;A集</a></h1>
			<p><a href="/Doraemonno4jigenpoketto/LoginServlet">ログアウト</a></p>	<!--ログアウト右上-->
		<h2>更新・削除</h2>  	                    <!--h2は中央-->
		<!--閲覧数・質問日・回答者・質問した年月日・登録者についての更新・削除-->

		<c:forEach var="e" items="${result}">
		<form method="POST" action="/Doraemonno4jigenpoketto/UdeditServlet" onSubmit="return check()">
			質問文<input type="text" name="QUESTION" value="${e.question}"><br>    <!--質問文-->
			回答<input type="text" name="ANSWER" value="${e.answer}"><br>    <!--回答-->
			<table>
				<tr>
				<td>
				閲覧数<input type="text" name="PAGEVIEW" value="${e.pageview}"><br>
				</td>
				</tr>
				<tr>
				<td>
				質問日<input type="date" name="DATE" value="${e.date}"><br>
				</td>
				</tr>
				<tr>
				<td>
				回答者<input type="text" name="ANSWERER" value="${e.answerer}">
				</td>
				</tr>
				<tr>
				<td>
				登録者<input type="text" name="REGISTRANT" value="${e.registrant}">
				</td>
				</tr>
			</table>
			<input type="submit" name="SUBMIT" value="更新">
			<input type="submit" name="SUBMIT" value="削除">
		</form>
		</c:forEach>
	</body>
</html>