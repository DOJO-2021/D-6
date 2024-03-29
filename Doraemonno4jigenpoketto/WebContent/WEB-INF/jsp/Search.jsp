<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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



<h2><img src="/Doraemonno4jigenpoketto/image/検索画面.png" alt="検索画面" class="h2"></h2>


<script type="text/javascript">
    /* ブラウザ判別 */
    var ie=document.all ? 1 : 0;
    var ns6=document.getElementById&&!document.all ? 1 : 0;
    var opera=window.opera ? 1 : 0;

    /* 子メニューの表示・非表示切替 */
    function openchild(childObj, parentObj) {
        var parent="";
        var child="";
        var sw="/content/img/js/arrowinbox_on.gif"; /* 子メニューが開いてる時のアイコン */
        var hd="/content/img/js/arrowinbox.gif"; /* 子メニューが閉じている時のアイコン */
        if (ie || ns6 || opera) {
            child=ns6 ? document.getElementById(childObj).style : document.all(childObj).style;
            parent=ns6 ? document.getElementById(parentObj).style : document.all(parentObj).style;
            if (child.display=="none") {
                child.display="block";
                child.backgroundColor="";
                parent.backgroundColor="";
                parent.color="#00BFFF";
            } else {
                child.display="none";
                parent.backgroundColor="";
                parent.color="#00BFFF";
            }
        }
    }
</script>


<script src="/Doraemonno4jigenpoketto/js/search.js"></script>

<form name="form1" id="form1" method="POST" action="/Doraemonno4jigenpoketto/SearchServlet">
<div class="blockA">
  <div id="menuA">

    <dl>
        <!-- menu1 -->
        <dt>
            <a href="javascript:void(0)" id="closer_1" onclick="openchild('opener_1', 'closer_1')"><img src="/Doraemonno4jigenpoketto/image/パーソナルスキルコース.png" alt="パーソナルスキルコース" class="navigation"></a>

        </dt>
        <ul id="opener_1" style="display:none;">
         <li><a href="#" class="line1" id="closer_101" onclick="openchild('opener_101', 'closer_101')">ビジネスマナー・コミュニケーション</a>
           <ul id="opener_101" style="display:none;" >
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">敬語</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">ビジネスマナー</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">挨拶</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">電話対応</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">名刺交換</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">顧客先への訪問時と顧客の来社時のマナー</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
           </ul>
         </li>


         <li> <a href="#" class="line1" id="closer_102" onclick="openchild('opener_102', 'closer_102')">ビジネスメール・ビジネス文章</a>
            <ul id="opener_102" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">ビジネス文書とは</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">文書の書き方</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">Wordの起動～文書の作成</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">報告書を書く時の注意点</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_103" onclick="openchild('opener_103', 'closer_103')">Word</a>
            <ul id="opener_103" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">Word</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_104" onclick="openchild('opener_104', 'closer_104')">Excel</a>
            <ul id="opener_104" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">Excel</a></li>
            </ul>
         </li>
       </ul>


        <!-- menu2 -->
        <dt>
            <a href="javascript:void(0)" id="closer_2" onclick="openchild('opener_2', 'closer_2')"><img src="/Doraemonno4jigenpoketto/image/IT基礎コース.png" alt="IT基礎コース" class="navigation"></a>
        </dt>
        <ul id="opener_2" style="display:none;">
         <li><a href="javascript:void(0)" class="line1" id="closer_201" onclick="openchild('opener_201', 'closer_201')">プログラミング</a>
           <ul id="opener_201" style="display:none;">
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">プログラミングの世界</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">コンピューターの仕組みと役割</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">OSの仕組みと役割</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">プログラミング言語の基礎知識</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">論理演算とプログラミング</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
           </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_202" onclick="openchild('opener_202', 'closer_202')">アルゴリズム</a>
            <ul id="opener_202" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">アルゴリズム</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">データ構造</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_203" onclick="openchild('opener_203', 'closer_203')">ネットワーク</a>
            <ul id="opener_203" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">IPアドレス</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">DNSサーバー</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">ポート番号</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">ルータ</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">WebページのソースとCookie</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">MacアドレスとARPテーブル</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">Windowsとファイアウォール</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_204" onclick="openchild('opener_204', 'closer_204')">HTML</a>
            <ul id="opener_204" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">製作の準備と基本的なHTMＬ</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">見出し・段落・リスト</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">リンクと画像の挿入</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">2ページ目意向を効率的に作成する</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_205" onclick="openchild('opener_205', 'closer_205')">CSS</a>
            <ul id="opener_205" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">CSSでページのスタイルを調整</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">フロートとテーブルのスタイル</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">フォームの作成</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_206" onclick="openchild('opener_206', 'closer_206')">JavaScript</a>
            <ul id="opener_206" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">アウトプットの基本</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">文法と基本的な機能</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">インプットとデータの加工</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">一歩進んだテクニック</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">WebページにJavaScriptを追加</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_207" onclick="openchild('opener_207', 'closer_207')">データベース(SQL)</a>
            <ul id="opener_207" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">用途と役割</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">リレーショナルデータベース</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">データベースとアーキテクチャ構成</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">DBMSを操作する際の基礎知識</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">SQL文の基本</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">トランザクションと同時実行制御</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">テーブル</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">バックアップとリカバリー</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
            </ul>
         </li>
       </ul>


        <!-- menu3 -->
        <dt>
            <a href="javascript:void(0)" id="closer_3" onclick="openchild('opener_3', 'closer_3')"><img src="/Doraemonno4jigenpoketto/image/Java基礎コース.png" alt="Java基礎コース" class="navigation"></a>
        </dt>
        <ul id="opener_3" style="display:none;">
         <li><a href="javascript:void(0)" class="line1" id="closer_301" onclick="openchild('opener_301', 'closer_301')">Javaプログラミング</a>
           <ul id="opener_301" style="display:none;">
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">Javaプログラムの書き方</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">式と演算子</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">条件分岐と繰り返し</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">配列</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">メソッド</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">複数クラスを用いた開発</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">クラスとインスタンス</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">カプセル化</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">継承</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">多態性</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">例外処理</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">文字列を操作するAPI</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">コレクションを提供するAPI</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
           </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_302" onclick="openchild('opener_302', 'closer_302')">サーバサイドJava</a>
            <ul id="opener_302" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">サーブレットの基礎</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">JSPの基礎</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">リクエストパラメータの取得</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">MVCモデル</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">JavaBeans</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">リクエストスコープ</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">セッションスコープ</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">アプリケーションスコープ</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">Webアプリケーションの画面と機能</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">フィルタ</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">アクションタグとEL</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">JDBCとDAOのパターン</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">Webアプリケーションの設計</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">JSTL</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_303" onclick="openchild('opener_303', 'closer_303')">品質管理</a>
            <ul id="opener_303" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">品質管理の基礎知識</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">ホワイトボックス・ブラックボックス・オートテスト</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">品質管理</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">単体テスト・結合テスト・システムテスト</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_304" onclick="openchild('opener_304', 'closer_304')">セキュリティ</a>
            <ul id="opener_304" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">脅威の存在を知る</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">暗号化とディジタル署名</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">Webアプリの脆弱性と対策</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
            </ul>
         </li>
       </ul>


        <!-- menu4 -->
        <dt>
            <a href="javascript:void(0)" id="closer_4" onclick="openchild('opener_4', 'closer_4')"><img src="/Doraemonno4jigenpoketto/image/Webアプリ開発演習コース.png" alt="Webアプリ開発演習コース" class="navigation"></a>
        </dt>
        <ul id="opener_4" style="display:none;">
         <li><a href="javascript:void(0)" class="line1" id="closer_401" onclick="openchild('opener_401', 'closer_401')">導入</a>
           <ul id="opener_401" style="display:none;">
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">Webアプリケーションの構成要素</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">Webアプリケーションフレームワーク</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">構成管理</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">進め方について</a></li>
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
           </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_402" onclick="openchild('opener_402', 'closer_402')">要件定義</a>
            <ul id="opener_402" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">プロジェクトについて</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">ヒアリング</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">業務分析・業務知識</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">要件の種類（機能/非機能要件）</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">見積もり手法</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">スケジュール策定</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_403" onclick="openchild('opener_403', 'closer_403')">外部設計</a>
            <ul id="opener_403" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">外部設計書</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_404" onclick="openchild('opener_404', 'closer_404')">内部設計</a>
            <ul id="opener_404" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">内部設計書</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_405" onclick="openchild('opener_405', 'closer_405')">実装</a>
            <ul id="opener_405" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">コーディング規約</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">命名規則</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_406" onclick="openchild('opener_406', 'closer_406')">テスト</a>
            <ul id="opener_406" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">テストの工程</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">テストの種類と方法</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">影響範囲と修正方法</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">テスト仕様書</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_407" onclick="openchild('opener_407', 'closer_407')">プレゼン作成</a>
            <ul id="opener_407" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">プレゼンの基礎</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">パワーポイント基礎</a></li>
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_408" onclick="openchild('opener_408', 'closer_408')">発表</a>
            <ul id="opener_408" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">発表</a></li>
            </ul>
         </li>
       </ul>


        <!-- menu5 -->
        <dt>
            <a href="javascript:void(0)" id="closer_5" onclick="openchild('opener_5', 'closer_5')"><img src="/Doraemonno4jigenpoketto/image/ドリル.png" alt="ドリル" class="navigation"></a>
        </dt>
        <ul id="opener_5" style="display:none;">
         <li><a href="javascript:void(0)" class="line1" id="closer_501" onclick="openchild('opener_501', 'closer_501')">アルゴリズムドリル</a>
           <ul id="opener_501" style="display:none;">
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">アルゴリズムドリル</a></li>
           </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_502" onclick="openchild('opener_502', 'closer_502')">SQLドリル</a>
            <ul id="opener_502" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">SQLドリル</a></li>
            </ul>
         </li>

         <li> <a href="#" class="line1" id="closer_503" onclick="openchild('opener_503', 'closer_503')">Javaドリル</a>
            <ul id="opener_503" style="display:none;">
             <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">Javaドリル</a></li>
            </ul>
         </li>
       </ul>


        <!-- menu6 -->
        <dt>
            <a href="javascript:void(0)" id="closer_6" onclick="openchild('opener_6', 'closer_6')"><img src="/Doraemonno4jigenpoketto/image/その他.png" alt="その他" class="navigation"></a>
        </dt>
        <ul id="opener_6" style="display:none;">
         <li><a href="javascript:void(0)" class="line1" id="closer_601" onclick="openchild('opener_601', 'closer_601')">その他</a>
           <ul id="opener_601" style="display:none;">
            <li><a href="javascript:void(0)" onclick="add(this.innerHTML);" class="line">その他</a></li>
           </ul>
         </li>
       </ul>

    </dl>
  </div>
</div>



<div class="blockB">
	<input type="text" placeholder="検索したいカテゴリー項目" name="Q_category" class="wordsearch" ><br>
    <input type="text"placeholder="検索したいワード" name="QUESTION1" class="wordsearch"> <br>
    <input type="text"placeholder="検索したいワード" name="QUESTION2" class="wordsearch"> <br>
    <input type="text"placeholder="検索したいワード" name="QUESTION3" class="wordsearch"> <br>

</div>


<div class="blockC">
<!--プルダウンメニュー name= "andor" "and1" "or1" -->
 <select name= "andor1" class="andor">
  <option value="and1">AND</option>
  <option value="or1">OR</option>
 </select>

<br>

 <select name= "andor2" class="andor">
  <option value="and2">AND</option>
  <option value="or2">OR</option>
 </select>
</div>


<br>
<br>
<div class="button">
  <input type="image" src="/Doraemonno4jigenpoketto/image/検索ボタン.png" name="search" alt="検索" class="buttonsize" style="margin-left:-550px;">
</div>
</form>

</body>
</html>
