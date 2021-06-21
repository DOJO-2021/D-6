<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<link href='/Doraemonno4jigenpoketto/css/common.css' rel='stylesheet'>
	<head>
		<meta charset="UTF-8">
		<title>DOJO Q&amp;A集</title>
		<script src="script.js"></script>
	</head>
	<body>

		<img src="/Doraemonno4jigenpoketto/image/帯.png" class="titlebar">
		<!-- <h1><a href="/Doraemonno4jigenpoketto/MenuServlet"><img src="/Doraemonno4jigenpoketto/image/ロゴ.png" alt="DOJO Q&A集" class="logo"></a></h1>-->
		<a href="/Doraemonno4jigenpoketto/LoginServlet" class="edit">編集</a>
		<a href="/Doraemonno4jigenpoketto/SearchServlet" class="search">検索</a>


		<h2><img src="/Doraemonno4jigenpoketto/image/詳細画面.png" alt="詳細画面" class="h2"></h2>
		<c:forEach var="e" items="${cardList}">

			<input type="text" name="pageview" value="閲覧数：${e.pageview}" class="d_pageview" readonly>

			<div style="text-align:center;">
			<input type="text" name="question" value="${e.question}" class="d_question" readonly>
				<img src="/Doraemonno4jigenpoketto/image/質問文の枠.png" class="d_qb"><!--d_qb=DerailQuestionBox-->
			</div>

			<div>
			<input type="text" name="date" value="質問日：${e.date}" class="d_date" readonly>
			</div>


			<div style="text-align:center;">
			<input type="text" name="answer" value="${e.answer}" class="d_answer" readonly>
				<img src="/Doraemonno4jigenpoketto/image/回答文の枠.png" class="d_ab"><!--d_ab=DerailAnswerBox-->
			</div>

			<input type="text" name="answerer" value="回答者：${e.answerer}" class="d_answerer" readonly>
		</c:forEach>
	</body>
</html>
