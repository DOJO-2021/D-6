<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><!--Login.jsp-->
<html>
<link href='/Doraemonno4jigenpoketto/css/common.css' rel='stylesheet'>
<head>
<meta charset="UTF-8">
<title>DOJO Q&amp;A集</title>


</head>


<body>

<div><img src="/Doraemonno4jigenpoketto/image/帯.png" class="titlebar"></div>
<div><a href="/Doraemonno4jigenpoketto/MenuServlet"><img src="/Doraemonno4jigenpoketto/image/ロゴ.png" alt="DOJO Q&A集" class="logo"></a></div>
<div><a href="/Doraemonno4jigenpoketto/LoginServlet" class="edit">編集</a></div>
<div><a href="/Doraemonno4jigenpoketto/SearchServlet" class="search">検索</a></div>




<h2><img src="/Doraemonno4jigenpoketto/image/ログイン画面.png" alt="ログイン" class="h2" style="margin-bottom:20px;"></h2>


<!--リンク先注意-->
<form method="POST" action="/Doraemonno4jigenpoketto/LoginServlet" id="form">

<p ID="output" class="loginerror">
  <div class="logintext">
   <input type="text"placeholder="ID"  name="ID"> <br>
   <input type="password"placeholder="Password" name="PW"> <br><br>
  </div>

<!--name="LOGIN"-->
  <div class=button>
   <input type="image" src="/Doraemonno4jigenpoketto/image/ログインボタン.png" alt="ログイン" class="buttonsize" name="login">
  </div>
  </form>
<c:choose>
	<c:when test="${result.result != null}">
		<c:choose>
			<c:when test="${result.result == 'false'}">
				<script type="text/javascript">window.alert("PWかIDが違います。");
				</script>
			</c:when>
		</c:choose>
	</c:when>
</c:choose>
</body>
</html>
