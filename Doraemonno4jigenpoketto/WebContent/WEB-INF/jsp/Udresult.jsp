<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOJO Q&amp;A集</title>
</head>
<body>
	<h1>DOJO Q&amp;A集</h1>
		<p><a href="Login.jsp">ログアウト</a></p>

	<h2>更新・削除用検索結果画面</h2>

<!--ヒット数表示-->
"e"件ヒットしました。</p>

<!--質問文-->
	<c:forEach var="e" items="${qa}">
		<form method="POST" action="UdeditServlet.java">
		<ul>
			<li>
				<input type="submit" name="question" value=${e.question}"閲覧数："${e.pageview}>
			</li>

		</ul>
		</form>
	</c:forEach>

</body>
</html>