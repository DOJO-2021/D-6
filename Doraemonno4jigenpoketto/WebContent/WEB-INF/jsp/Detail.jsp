<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOJO Q&amp;A集</title>
<script src="script.js"></script>
</head>
<body>

<h1><a href="/Doraemonno4jigenpoketto/MenuServlet">DOJO Q&amp;A集</a></h1> <!--h1は左より-->
<p><a href="Login.jsp">ログアウト</a></p>	<!--ログアウト右上-->
<h2>質問と回答</h2>  	                    <!--h2は中央-->

<a href="/Doraemonno4jigenpoketto/EditServlet">編集</a>
<a href="/Doraemonno4jigenpoketto/SearchServlet">検索</a>

閲覧数<input type="text" name="PAGEVIEW" value="${e.pageview}">
質問<input type="text" name="QUESTION" value="${e.question}"> 質問日<input type="text" name="DATE" value="${e.date}"><br>
回答<input type="text" name="ANSWER" value="${e.answer}"> 回答者<input type="text" name="ANSWER" value="${e.answerer}"><br>

</body>
</html>