<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOJO Q&amp;A集</title>
<script src="script.js"></script>
</head>
<body>
											<!--h1は左より-->
<h1>DOJO Q&amp;A集</h1>
<p><a href="Login.jsp">ログアウト</a></p>	<!--ログアウト右上-->
<h2>更新・削除</h2>  	                    <!--h2は中央-->
<!--閲覧数・回答者・質問した年月日・登録者についての更新・削除-->
<c:forEach var="e" items="${qa}">
	  <form method="POST" action="DetailServlet.java">
	  質問文<input type="text" name="QUESTION" value="${e.question}"><br>    <!--質問文-->
	  回答<input type="text" name="ANSWER" value="${e.answer}"><br>    <!--回答-->

 	<table>
    <tr>
      <td>
       閲覧数<input type="text" name="PAGEVIEW" value="${e.pageview}"><br>
     </td>
    </tr>

    <tr>
      <td>
      質問日<input type="text" name="DATE" value="${e.date}"><br>
     </td>
    </tr>

    <tr>
     <td>
	<select name="ANSWER" id="answerer">
        <option value="">回答者を選択してください</option>
        <option value="0">向後海</option>
		    <option value="1">小林茉乃</option>
        <option value="2">奥戸楓</option>
        <option value="3">山嵜佳昭</option>
		    <option value="4">森下佳亮</option>
     </select>
      </td>
    </tr>

    <tr>
     <td>
        <input type="DATE" name="calendar" max="9999-12-31">
     </td>
    </tr>

    <tr>
     <td>
	<select name="REGESTANT" id="regestant">
        <option value="">登録者を選択してください</option>
		    <option value="0">向後海</option>
		    <option value="1">小林茉乃</option>
        <option value="2">奥戸楓</option>
        <option value="3">山嵜佳昭</option>
		    <option value="4">森下佳亮</option>
     </select>
      </td>
     </tr>

 	</table>
        <input type="submit" name="UPDATE" value="更新">
        <input type="submit" name="DELETE" value="削除">
    </form>
</c:forEach>

<script>
'use strict'


document.getElementById('form'). onsubmit = function(event) {
   /*　回答者以外が未入力なら、デフォルトの動作を行わず、
　　WEB上にエラーと表示する */
    const guestion = document.getElementById('form').QUESTION.value;
    const answer = document.getElementById('form').ANSWER.value;
    const pageview = document.getElementById('form').PAGEVIEW.value;
    const date = document.getElementById('form').DATE.value;
    const ragestant = document.getElementById('form').RAGESTANT.value;

    if (question === "" || answer === "" || pageview === "" || date === "" || ragestant === "") {
    event.preventDefault();
    /* 「エラー」をWEBページ上に表示する */
    document.getElementById('output').textContent =('エラー');
    }
};

  /*　更新ボタンを押すと更新しますかという表示*/
document.myform.btn.addEventListener('UPDATE', function()) {
    if (window.confirm('更新しますか？')){
        console.log('はい')//「true」の処理
        window.confirm('更新しました。')
    }

    else {

    	console.log('いいえ') //「false」の処理

    }
}

/*　削除ボタンを押すと更新しますかという表示*/
document.myform.btn.addEventListener('DELETE', function()) {
    if (window.confirm('削除しますか？')){
        console.log('はい')//「true」の処理
        window.confirm('削除しました。')
    }

    else {

    	console.log('いいえ') //「false」の処理

    }
}

</script>
</body>
</html>