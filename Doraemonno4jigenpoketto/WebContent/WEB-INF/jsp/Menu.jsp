<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><!--Menu.jsp-->
<html>
<link href='../../css/common.css' rel='stylesheet' type='text/css'>
<head>
<meta charset="UTF-8">
<title>DOJO Q&A集</title>

<!--リンク先注意-->


</head>

<body>


<hr><!--リンク先注意-->

  <div class="searchpage">
   <p><a href="/Doraemonno4jigenpoketto/MenuServlet"><img src="../../image/Menu/検索.png" alt="検索" width="300" height="280"></a></p>
  </div>

  <div class ="titlepage">
   <p><a href="/Doraemonno4jigenpoketto/LoginServlet"><img src="../../image/Menu/DOJOQ&A集.png" alt="DOJO Q&A集" width="400" height="380"></a></p>
  </div>

  <div class="editpage">
   <p><a href="/Doraemonno4jigenpoketto/SearchServlet"><img src="../../image/Menu/編集(事務局用).png" alt="編集(事務局用)" width="300" height="280"></a></p>
  </div>



<canvas class="background"></canvas>
<script src="../../js/menu.js"></script>

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