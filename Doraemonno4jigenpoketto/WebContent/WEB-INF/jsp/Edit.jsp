<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><!--Edit.jsp-->
<html>

<head>
<meta charset="UTF-8">
<title>DOJO Q &nbsp; A集</title>
</head>


<body>

<hr><!--リンク先注意-->

<p>DOJO Q &nbsp; A集  <!--タイトルをクリックしても、メニュー画面に遷移しない-->
   <a href="Menu.jsp">ログアウト</a> </p>

<h1>編集</h1>

<!--リンク先注意！ 登録画面と更新・削除検索画面に遷移-->
<form method="GET" action="Regist.jsp" id="form"> </form>
<form method="GET" action="Udsearch.jsp" id="form"> </form>

<!--name="regist" name="ud" -->
<input type="submit" name="regist" value="登録"> <br><br>
<input type="submit" name="ud" value="更新・削除">

</body>
</html>