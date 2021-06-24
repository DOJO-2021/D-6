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

<div><img src="/Doraemonno4jigenpoketto/image/帯.png" class="titlebar"></div>
<div><a href="/Doraemonno4jigenpoketto/MenuServlet"><img src="/Doraemonno4jigenpoketto/image/ロゴ.png" alt="DOJO Q&A集" class="logo"></a></div>
<div><a href="/Doraemonno4jigenpoketto/LoginServlet" class="edit">編集</a></div>
<div><a href="/Doraemonno4jigenpoketto/SearchServlet" class="search">検索</a></div>


		<h2><img src="/Doraemonno4jigenpoketto/image/詳細画面.png" alt="詳細画面" class="h2"></h2>


		<div >
			<a href="/Doraemonno4jigenpoketto/ResultServlet"><input type="image" src="/Doraemonno4jigenpoketto/image/戻るボタン.png" class="buttonsize" style="margin-top:-50px; margin-left:30px; margin-bottom:0px;"></a>
		</div>



		<c:forEach var="e" items="${cardList1}">


			<p name="pageview" class="d_pageview"> 閲覧数：${e.pageview} </p>

			<div style="text-align:center;">
				<p name="question"class="d_question" style="color:black;">${e.question} </p>
				<img src="/Doraemonno4jigenpoketto/image/質問文の枠.png" class="d_qb"><!--d_qb=DerailQuestionBox-->
			</div>

			<div>
			<p name="date" class="d_date"> 質問日：${e.date} </p>
			</div>


			<div style="text-align:center;">
				<p name="answer" class="d_answer" style="color:black;">${e.answer} </p>
				<img src="/Doraemonno4jigenpoketto/image/回答文の枠.png" class="d_ab"><!--d_ab=DerailAnswerBox-->
			</div>

			<p name="answerer" class="d_answerer">回答者：${e.answerer} </p>


			<p name="category_item" style="margin-top:-20px; margin-left:250px;"><b>単元項目：${e.category_item}</b></p>
			<p name="textbook" class="text" style="margin-top:0px; margin-left:250px;"><b>教科書：${e.textbook}</b></p><br><br>
			<c:set var="path" value="upload\\" />
			<img src="${path}${e.filename}" width=250px height=150px alt='NO IMAGES' name="FILENAME" class="pic">
		</c:forEach>


	</body>
</html>
