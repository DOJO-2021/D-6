<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link href='/Doraemonno4jigenpoketto/css/common.css' rel='stylesheet'>
<link rel="stylesheet" href="/Doraemonno4jigenpoketto/css/pagination.css">
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



<div id="diary-all-contents"></div>

	<div class="pager" id="diary-all-pager"></div>

  <script src="/Doraemonno4jigenpoketto/js/jquery-3.6.0.min.js"></script>
  <script src="/Doraemonno4jigenpoketto/js/pagination.js"></script>
  <script>
    // [1] 配列のデータを用意


    var diary = [

    	<c:forEach var="e" items="${cardList}">
        {
      	 title:" ${e.question}",
      	  link:"${e.pageview}",
      	  category:"${e.question_id}"
        },
     </c:forEach>


      // ...以下略
    ]

    // [2] pagination.jsの設定
    $(function() {
      $('#diary-all-pager').pagination({ // diary-all-pagerにページャーを埋め込む
        dataSource: diary,
        pageSize: 10, // 1ページあたりの表示数
        prevText: '&lt; 前へ',
        nextText: '次へ &gt;',
        // ページがめくられた時に呼ばれる
        callback: function(data, pagination) {
          // dataの中に次に表示すべきデータが入っているので、html要素に変換
          $('#diary-all-contents').html(template(data)); // diary-all-contentsにコンテンツを埋め込む
        }
      });
    });
    // [3] データ1つ1つをhtml要素に変換する
    function template(dataArray) {
      return dataArray.map(function(data) {
        return         '<form method="POST" action="/Doraemonno4jigenpoketto/UdresultServlet"><div class="searchresult"><input type="image" src="/Doraemonno4jigenpoketto/image/検索結果の枠.png" class="r_qb"><input type="text" name="QUESTION" value="' + data.title + '" class="r_question" readonly>'
		+'<input type="text" name="PAGEVIEW" value="閲覧数：' + data.link + '" class="r_pageview" readonly>'
		+'<input type="hidden" name="QUESTION_ID" value="' + data.category + '"></form>'
      })
    }
  </script>
</body>
</html>
