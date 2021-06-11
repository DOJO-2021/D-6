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
<p><a href="Menu.jsp">DOJO Q &nbsp; A集</a></p>
<p><a href="Edit.jsp">編集(事務局用)</a></p>
<p><a href="Search.jsp">検索</a></p>

<h1>ログイン</h1>

<!--リンク先注意-->
<form method="GET" action="//Doraemonno4jigenpoketto/LoginServlet" id="form">
<input type="text"placeholder="ID" name="ID" required> <br>
<input type="password"placeholder="Password" name="PW" required> <br><br>
<!--name="LOGIN"-->
<input type="submit" name="LOGIN" value="ログイン">
</form>
</body>
</html>