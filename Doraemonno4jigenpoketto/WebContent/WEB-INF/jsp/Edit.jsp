<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><!--Edit.jsp-->
<html>
	<link href="/Doraemonno4jigenpoketto/css/common.css" rel="stylesheet">
	<head>
		<meta charset="UTF-8">
		<title>DOJO Q&amp;A集</title>
	</head>

	<body>
		<img src="/Doraemonno4jigenpoketto/image/帯.png" class="titlebar">
		<!--  <h1><a href="/Doraemonno4jigenpoketto/MenuServlet"><img src="/Doraemonno4jigenpoketto/image/ロゴ.png" alt="DOJO Q&A集" class="logo"></a></h1>-->

		<div>
			<a href="/Doraemonno4jigenpoketto/LoginServlet"><img src="/Doraemonno4jigenpoketto/image/ログアウトボタン.png" alt="ログアウト" width="150" height="50" class="logoutbutton"></a>
		</div>

		<h2><img src="/Doraemonno4jigenpoketto/image/編集画面.png" alt="編集画面" class="h2"></h2>

		<!--name="regist" name="ud" -->

		<div class="registpage">
			<a href="/Doraemonno4jigenpoketto/RegistServlet"><input type="image" src="/Doraemonno4jigenpoketto/image/登録.png" alt="登録" width="300" height="280" name="regist"></a>
		</div>

		<div class="udsearchpage">
			<a href="/Doraemonno4jigenpoketto/UdsearchServlet"><input type="image" src="/Doraemonno4jigenpoketto/image/更新削除.png" alt="更新・削除" width="300" height="280" name="ud"></a>
		</div>

			<canvas class="background"></canvas>
		<script src="/Doraemonno4jigenpoketto/js/menu.js"></script>

		<script>
			'use strict';

			window.onload = function() {
			  Particles.init({
			    selector: '.background',
			    sizeVariations: 200,
			    color: [
			      '#FF0000', '#00BFFF', '#FFFF00',
			    ]
			  });
			};
		</script>
	</body>
</html>
