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
<div><img src="/Doraemonno4jigenpoketto/image/帯.png" class="titlebar"></div>
<div><img src="/Doraemonno4jigenpoketto/image/ロゴ.png" alt="DOJO Q&A集" class="logo"></div>
<div><a href="/Doraemonno4jigenpoketto/EditServlet" class="edit">編集</a></div>


   		<div class="logoutbutton">
			<a href="/Doraemonno4jigenpoketto/LoginServlet"><img src="/Doraemonno4jigenpoketto/image/ログアウトボタン.png" alt="ログアウト" class="buttonsize"></a>
		</div>


<h2><img src="/Doraemonno4jigenpoketto/image/保存一覧画面.png" alt="保存一覧画面" class="h2"></h2>


<div class="pager" id="diary-all-pager" style="text-align:center; margin-bottom:50px;"></div>
		<!--ヒット数表示-->
		<p class="hitnumber"><b><c:out value="${counter.count}"/>件ヒットしました。</b></p>

<div id="diary-all-contents"></div>

<div class="pager" id="diary-all-pager" style="text-align:center; margin-top:50px;"></div>




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
{title:0,
	  link:0,
  	  category:0}

      // ...以下略
    ]

    // [2] pagination.jsの設定
    $(function() {
      $('.pager').pagination({ // diary-all-pagerにページャーを埋め込む
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
        return         '<form method="GET" action="/Doraemonno4jigenpoketto/SaveServlet"><div class="searchresult"><input type="image" src="/Doraemonno4jigenpoketto/image/検索結果の枠.png" class="r_qb"><div class="searchresult"><p class="r_question" style="color:black;">' + data.title + '</p>'
		+'<p class="r_pageview"> 閲覧数：' + data.link + '</p>'
		+'<input type="hidden" name="QUESTION_ID" value="' + data.category + '"></form>'
      })
    }
  </script>	</body>
</html>