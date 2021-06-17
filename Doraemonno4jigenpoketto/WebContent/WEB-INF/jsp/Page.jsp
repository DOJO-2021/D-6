<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="css/contents.css"><!-- 後で -->
  <link rel="stylesheet" href="css/pagination.css"><!-- 後で -->
</head>
<body>
  <ul>
    <div id="diary-all-contents"></div><!-- コンテンツの埋め込み先をid指定 -->
  </ul>
  <div class="pager" id="diary-all-pager"></div><!-- ページャーの埋め込み先をid指定 -->
  <script src="./jquery-3.6.0.min.js"></script>
  <script src="./pagination.js"></script>
  <script>
    // [1] 配列のデータを用意


    var diary = [
 	<c:forEach var="e" items="${cardList}">
      {
        ${e.question},
        ${e.pageview}
      }
   </c:forEach>
      // ...以下略
    ]

    // [2] pagination.jsの設定
    $(function() {
      $('#diary-all-pager').pagination({ // diary-all-pagerにページャーを埋め込む
        dataSource: diary,
        pageSize: 20, // 1ページあたりの表示数
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
        return '<li class="list"><a href="' + data.link + '">'
        + '<p class="category category-' + data.class + '">' + data.category + '</p>'
        + '<p class="title">' + data.title + '</p>'
        + '<p class="date">' + data.date + '</p></a></li>'
      })
    }
  </script>
</body>