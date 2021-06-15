<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><!--Login.jsp-->
<html>

<head>
<meta charset="UTF-8">
<title>DOJO Q &nbsp; A集</title>
</head>


<body>

<hr><!--リンク先注意-->
<p><a href="/Doraemonno4jigenpoketto/MenuServlet">DOJO Q &nbsp; A集</a></p>
<p><a href="/Doraemonno4jigenpoketto/LoginServlet">編集(事務局用)</a></p>
<p><a href="/Doraemonno4jigenpoketto/SearchServlet">検索</a></p>

<h1>ログイン</h1>

<!--リンク先注意-->
<form method="POST" action="/Doraemonno4jigenpoketto/LoginServlet" id="form">
<input type="text"placeholder="ID" name="ID" required> <br>
<input type="password"placeholder="Password" name="PW" required> <br><br>
<!--name="LOGIN"-->
<input type="submit" name="LOGIN" value="ログイン">
</form>
</body>
</html>