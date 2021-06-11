<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOJO Q&amp;A集</title>
<script src="script.js"></script>
<script src="udedit.js"></script>
</head>
<body>
											<!--h1は左より-->
<h1><a href="/Doraemonno4jigenpoketto/MenuServlet">DOJO Q&amp;A集</a></h1>
<p><a href="Login.jsp">ログアウト</a></p>	<!--ログアウト右上-->
<h2>更新・削除</h2>  	                    <!--h2は中央-->
<!--閲覧数・回答者・質問した年月日・登録者についての更新・削除-->

<c:forEach var="e" items="${qa}">
	  <form method="POST" action="DetailServlet.java">
	  質問文<input type="text" name="question" value="${e.question}"><br>    <!--質問文-->
	  回答<input type="text" name="answer" value="${e.answer}"><br>    <!--回答-->

 	<table>
    <tr>
      <td>
       閲覧数<input type="text" name="pageview" value="${e.pageview}"><br>
     </td>
    </tr>

    <tr>
      <td>
      質問日<input type="text" name="date" value="${e.date}"><br>
     </td>
    </tr>

    <tr>
     <td>
	  回答者<input type="text" name="answerer" value="${e.answerer}">
      </td>
    </tr>

    <tr>
     <td>
        <input type="DATE" name="calendar" max="9999-12-31">
     </td>
    </tr>

    <tr>
     <td>
	  登録者<input type="text" name="registrant" value="${e.registrant}">
      </td>
     </tr>

 	</table>
        <input type="submit" name="submit" value="更新">
        <input type="submit" name="submit" value="削除">
    </form>
</c:forEach>

</body>
</html>