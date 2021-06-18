<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link href='/Doraemonno4jigenpoketto/css/common.css' rel='stylesheet'>
<head>
<meta charset="UTF-8">
<title>DOJO Q&amp;A集</title>
</head>
<body>

<img src="/Doraemonno4jigenpoketto/image/帯.png" class="titlebar">
<h1><a href="/Doraemonno4jigenpoketto/MenuServlet"><img src="/Doraemonno4jigenpoketto/image/ロゴ.png" alt="DOJO Q&A集" class="logo"></a></h1>

         <div class="logoutbutton">
           <a href="/Doraemonno4jigenpoketto/MenuServlet"><img src="/Doraemonno4jigenpoketto/image/ログアウトボタン.png" alt="ログアウト" class="logoutbutton"></a>
         </div>

<h2><img src="/Doraemonno4jigenpoketto/image/更新・削除用検索結果画面.png" alt="更新・削除用検索結果画面" class="h2"></h2>

<!--ヒット数表示-->
<p class="hitnumber"><b><c:out value="${counter.count}"/>件ヒットしました。</b></p>

<!--質問文-->
	<c:forEach var="e" items="${cardList}">
		<form method="POST" action="/Doraemonno4jigenpoketto/UdresultServlet">
		<div class="searchresult">
				<input type="image" src="/Doraemonno4jigenpoketto/image/検索結果の枠.png" class="Udresult_qb">
				<input type="text" name="QUESTION" value="${e.question}" class="Udresult_question" readonly>
				<input type="text" name="PAGEVIEW" value="閲覧数：${e.pageview}" class="Udresult_pageview" readonly>
				<input type="hidden" name="QUESTION_ID" value="${e.question_id}">
				<input type="hidden" name="CATEGORY_ITEM" value="${e.category_item}">
		</div>
		</form>
	</c:forEach>

</body>
</html>
