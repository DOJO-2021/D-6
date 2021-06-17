<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link href='../../css/common.css' rel='stylesheet'>
<head>
<meta charset="UTF-8">
<title>DOJO Q&amp;A集</title>
</head>
<body>

<img src="">
<img src="../../image/帯.png" class="titlebar">
<h1><a href="../../src/servlet/Doraemonno4jigenpoketto/MenuServlet"><img src="../../image/ロゴ.png" alt="DOJO Q&A集" class="logo"></a></h1>
<a href="../../src/servlet/Doraemonno4jigenpoketto/LoginServlet" class="edit">編集</a>
<a href="../../src/servlet/Doraemonno4jigenpoketto/SearchServlet" class="search">検索</a>



<h2><img src="../../image/検索結果画面.png" alt="検索結果画面" class="h2"></h2>

<!--ヒット数表示-->
<p class="hitnumber"><b>"e"件ヒットしました。</b></p>

<!--質問文-->
	<c:forEach var="e" items="${quastion}">
		<form method="POST" action="DetailServlet.java">

			<div class="searchresult">
				<input type="image" src="../../image/検索結果の枠.png" class="r_qb"><!--r_qb=ResultQuestionBox-->
				<input type="text" name="question" value=${e.question} class="r_question" readonly>
				<input type="text" name="pageview" value="閲覧数："+${e.pageview}; class="r_pageview" readonly>


			</div>


		</form>
	</c:forEach>


</body>
</html>
