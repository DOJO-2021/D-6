<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><!--Login.jsp-->
<html>
<link href='../../css/common.css' rel='stylesheet'>
<head>
<meta charset="UTF-8">
<title>DOJO Q&A集</title>


</head>


<body>

<img src="../../image/Detail/帯.png" class="titlebar">
<h1><a href="../../src/servlet/Doraemonno4jigenpoketto/MenuServlet"><img src="../../image/Detail/ロゴ.png" alt="DOJO Q&A集" class="logo"></a></h1>
<a href="../../src/servlet/Doraemonno4jigenpoketto/LoginServlet" class="edit">編集</a>
<a href="../../src/servlet/Doraemonno4jigenpoketto/SearchServlet" class="search">検索</a>




<h2><img src="../../image/Login/ログイン画面.png" alt="ログイン" class="h2"></h2>


<!--リンク先注意-->
<form method="GET" action="Edit.jsp" id="form">

  <div class=logintext>
   <input type="text"placeholder="ID" name="ID"> <br><br>
   <input type="password"placeholder="Password" name="PW"> <br><br>
  </div>

<!--name="LOGIN"-->
  <div class=button>
   <input type="image" src="../../image/Login/ログインボタン.png" alt="ログイン" width="160" height="50" name="login">
  </div>

</body>
</html>