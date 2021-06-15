<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOJO Q&amp;A集</title>
<script src="script.js"></script>
</head>
<body>

<h1><a href="/Doraemonno4jigenpoketto/MenuServlet">DOJO Q&amp;A集</a></h1> <!--h1は左より-->
<p><a href="/Doraemonno4jigenpoketto/LoginServlet">ログアウト</a></p>	<!--ログアウト右上-->
<h2>質問と回答</h2>  	                    <!--h2は中央-->

<a href="/Doraemonno4jigenpoketto/EditServlet">編集</a>
<a href="/Doraemonno4jigenpoketto/SearchServlet">検索</a>
	<c:forEach var="e" items="${qa}">
閲覧数<input type="text" name="pageview" value="${e.pageview}">
質問<input type="text" name="question" value="${e.question}"> 質問日<input type="text" name="date" value="${e.date}"><br>
回答<input type="text" name="answer" value="${e.answer}"> 回答者<input type="text" name="answerer" value="${e.answerer}"><br>
</c:forEach>
</body>
</html>