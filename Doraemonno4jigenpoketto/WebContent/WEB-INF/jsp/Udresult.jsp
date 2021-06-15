<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOJO Q&amp;A集</title>
</head>
<body>
	<h1>DOJO Q&amp;A集</h1>
		<p><a href="/Doraemonno4jigenpoketto/LoginServlet"">ログアウト</a></p>

	<h2>更新・削除用検索結果画面</h2>

<!--ヒット数表示-->
"e"件ヒットしました。</p>

<!--質問文-->
	<c:forEach var="e" items="${cardList}">
		<form method="POST" action="/Doraemonno4jigenpoketto/UdresultServlet">
		<ul>
			<li>
				<input type="hidden" name="QUESTION_ID" value="${e.question_id}">
				<input type="hidden" name="QUESTION" value="${e.question}">
				<div>
				質問文：value="${e.question}"
				閲覧数：value="${e.pageview}"
				</div>
				<input type="submit" name="SUBMIT" value=更新・削除>
			</li>

		</ul>
		</form>
	</c:forEach>

</body>
</html>