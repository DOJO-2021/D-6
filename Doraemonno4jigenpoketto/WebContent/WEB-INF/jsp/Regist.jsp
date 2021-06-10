<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>DOJO Q&amp;A集</h1>
		<p><a href="Login.jsp">ログアウト</a></p>

	<h2>登録</h2>

	<nav>
		<form method="POST" action="RegistServlet.java">
		<table>
			<tr>
				<th>質問文</th><td><textarea name="question"></textarea></td><br>
			</tr>
			<tr>
				<th>回答文</th><td><textarea name="answer"></textarea></td><br>
			</tr>

			<tr>
				<td>
					<select name="Unit" id="Unit"><br>
					<option value="">単元を選択してください</option>
					<optgroup label="パーソナルスキルコース">
						<option value="0">ビジネス・コミュニケーション</option>
						<option value="1">ビジネスメール・ビジネス文章</option>
						<option value="2">Word</option>
						<option value="3">Excel</option>
					</optgroup>
					<optgroup label="IT基礎コース">
						<option value="4">プログラミング</option>
						<option value="5">アルゴリズム</option>
						<option value="6">ネットワーク</option>
						<option value="7">HTML</option>
						<option value="8">CSS</option>
						<option value="9">JavaScript</option>
						<option value="10">データベース(SQL)</option>
					</optgroup>
					<optgroup label="Java基礎コース">
						<option value="11">Javaプログラミング</option>
						<option value="12">サーバーサイドJava</option>
						<option value="13">品質管理</option>
						<option value="14">セキュリティ</option>
					</optgroup>
						<optgroup label="Web開発演習コース">
						<option value="15">導入</option>
						<option value="16">要件定義</option>
						<option value="17">外部設計</option>
						<option value="18">内部設計</option>
						<option value="19">実装</option>
						<option value="20">テスト</option>
						<option value="21">プレゼン作成</option>
						<option value="22">発表</option>
					</optgroup>
					<optgroup label="ドリル">
						<option value="23">アルゴリズムドリル</option>
						<option value="24">SQLドリル</option>
						<option value="25">Javaドリル</option>
					</optgroup>
					<optgroup label="その他">
						<option value="27">その他</option>
					</optgroup>
					</select>
				</td>
			</tr>

			<tr>
				<td>
					<select name="category" id="category"><br>
						<option value="">単元項目を選択してください</option>
						<!--パーソナルコース-->
						<optgroup label="ビジネスマナー・コミュニケーション">
							<option value="0">敬語</option>
							<option value="1">ビジネスマナー</option>
							<option value="2">挨拶</option>
							<option value="3">電話対応</option>
							<option value="4">名刺交換</option>
							<option value="5">顧客先への訪問時と顧客の来社時のマナー</option>
							<option value="6">その他</option>
						</optgroup>
						<optgroup label="ビジネスメール・ビジネス文章">
							<option value="7">ビジネス文書とは</option>
							<option value="8">文書の書き方</option>
							<option value="9">Wordの起動～文書の作成</option>
							<option value="10">報告書を書く時の注意点</option>
							<option value="11">その他</option>
						</optgroup>
						<optgroup label="Word">
							<option value="12">Word</option>
						</optgroup>
						<optgroup label="Excel">
							<option value="13">Excel</option>
						</optgroup>
						<!--IT基礎コース-->
						<optgroup label="プログラミング">
							<option value="14">プログラミングの世界</option>
							<option value="15">コンピューターの仕組みと役割</option>
							<option value="16">OSの仕組みと役割</option>
							<option value="17">プログラミング言語の基礎知識</option>
							<option value="18">論理演算とプログラミング</option>
							<option value="19">その他</option>
						</optgroup>
						<optgroup label="アルゴリズム">
							<option value="20">アルゴリズム</option>
							<option value="21">データ構造</option>
							<option value="22">その他</option>
						</optgroup>
						<optgroup label="ネットワーク">
							<option value="23">IPアドレス</option>
							<option value="24">DNSサーバー</option>
							<option value="25">ポート番号</option>
							<option value="26">ルータ</option>
							<option value="27">WebページのソースとCookie</option>
							<option value="28">MacアドレスとARPテーブル</option>
							<option value="29">Windowsとファイアウォール</option>
							<option value="30">その他</option>
						</optgroup>
						<optgroup label="HTML">
							<option value="31">2ページ目意向を効率的に作成する</option>
							<option value="32">その他</option>
						</optgroup>
						<optgroup label="CSS">
							<option value="33">フォームの作成</option>
							<option value="34">その他</option>
						</optgroup>
						<optgroup label="JavaScript">
							<option value="35">アウトプットの基本</option>
							<option value="36">文法と基本的な機能</option>
							<option value="37">インプットとデータの加工</option>
							<option value="38">一歩進んだテクニック</option>
							<option value="39">WebページにJavascriptを追加</option>
							<option value="40">その他</option>
						</optgroup>
						<optgroup label="データベース（SQL）">
							<option value="41">用途と役割</option>
							<option value="42">リレーショナルデータベース</option>
							<option value="43">データベースとアーキテクチャ構成</option>
							<option value="44">DBMSを操作する際の基礎知識</option>
							<option value="45">SQL文の基本</option>
							<option value="46">トランザクションと同時実行制御</option>
							<option value="47">テーブル</option>
							<option value="48">バックアップとリカバリー</option>
							<option value="49">その他</option>
						</optgroup>
						<!--Java基礎コース-->
						<optgroup label="Javaプログラミング">
							<option value="50">Javaプログラムの書き方</option>
							<option value="51">式と演算子</option>
							<option value="52">条件分岐と繰り返し</option>
							<option value="53">配列</option>
							<option value="54">メソッド</option>
							<option value="55">複数クラスを用いた開発</option>
							<option value="56">クラスとインスタンス</option>
							<option value="57">カプセル化</option>
							<option value="58">継承</option>
							<option value="59">多態性</option>
							<option value="60">例外処理</option>
							<option value="61">文字列を操作するAPI</option>
							<option value="62">コレクションを提供するAPI</option>
							<option value="63">その他</option>
						</optgroup>
						<optgroup label="サーバサイドJava">
							<option value="64">サーブレットの基礎</option>
							<option value="65">JSPの基礎</option>
							<option value="66">リクエストパラメータの取得</option>
							<option value="67">MVCモデル</option>
							<option value="68">JavaBeans</option>
							<option value="69">リクエストスコープ</option>
							<option value="70">セッションスコープ</option>
							<option value="71">アプリケーションスコープ</option>
							<option value="72">Webアプリケーションの画面と機能</option>
							<option value="73">フィルタ</option>
							<option value="74">アクションタグとEL</option>
							<option value="75">JDBCとDAOのパターン</option>
							<option value="76">Webアプリケーションの設計</option>
							<option value="77">JSTL</option>
							<option value="78">その他</option>
						</optgroup>
						<optgroup label="品質管理">
							<option value="79">品質管理の基礎知識</option>
							<option value="80">ホワイトボックス・ブラックボックス・オートテスト</option>
							<option value="81">品質管理</option>
							<option value="82">単体テスト・結合テスト・システムテスト</option>
							<option value="83">その他</option>
						<optgroup label="セキュリティ">
							<option value="84">脅威の存在を知る</option>
							<option value="85">暗号化とディジタル署名</option>
							<option value="86">Webアプリの脆弱性と対策</option>
							<option value="87">その他</option>
						</optgroup>
						<!--Web開発演習コース-->
						<optgroup label="導入">
							<option value="88">webアプリケーションの構成要素</option>
							<option value="89">webアプリケーションフレームワーク</option>
							<option value="90">構成管理</option>
							<option value="91">進め方について</option>
							<option value="92">その他</option>
						</optgroup>
						<optgroup label="要件定義">
							<option value="93">プロジェクトについて</option>
							<option value="94">ヒアリング</option>
							<option value="95">業務分析・業務知識</option>
							<option value="96">要件の種類（機能/非機能要件）</option>
							<option value="97">見積もり手法</option>
							<option value="98">スケジュール策定</option>
							<option value="99">その他</option>
						</optgroup>
						<optgroup label="外部設計">
							<option value="100">外部設計書</option>
						</optgroup>
						<optgroup label="内部設計">
							<option value="101">内部設計書</option>
						</optgroup>
						<optgroup label="実装">
							<option value="102">コーディング規約</option>
							<option value="103">命名規則</option>
							<option value="104">その他</option>
						</optgroup>
						<optgroup label="テスト">
							<option value="105">テストの工程</option>
							<option value="106">テストの種類と方法</option>
							<option value="107">影響範囲と修正方法</option>
							<option value="108">影響範囲と修正方法</option>
							<option value="109">テスト仕様書</option>
							<option value="110">その他</option>
						</optgroup>
						<optgroup label="プレゼン作成">
							<option value="111">プレゼンの基礎</option>
							<option value="112">パワーポイント基礎</option>
							<option value="113">その他</option>
						</optgroup>
						<optgroup label="発表">
							<option value="114">発表</option>
						</optgroup>
						<!--ドリル-->
						<optgroup label="アルゴリズムドリル">
							<option value="115">アルゴリズムドリル</option>
						</optgroup>
						<optgroup label="SQLドリル">
							<option value="116">SQLドリル</option>
						</optgroup>
						<!--Javaドリル-->
						<optgroup label="Javaドリル">
							<option value="117">Javaドリル</option>
						</optgroup>
						<!--その他-->
						<optgroup label="その他">
							<option value="118">その他</option>
						</optgroup>
				</td>
			</tr>
			<!--
				<div>
					テキスト<select name="text"><br>
				</div>
			-->
			<tr>
				<td><input type="date" name="calendar" max="9999-12-31"></td>
			</tr>
			<tr>
				<select name="answerer" id="answerer">
					<option value="">回答者を選択してください</option>
						<option value="0">向後海</option>
						<option value="1">小林茉乃</option>
						<option value="2">奥戸楓</option>
						<option value="3">山嵜佳昭</option>
						<option value="4">森下佳亮</option>
				</select>
			</tr>
			<tr>
				<select name="regestant" id="regestant">
					<option value="">登録者を選択してください</option>
						<option value="0">向後海</option>
						<option value="1">小林茉乃</option>
						<option value="2">奥戸楓</option>
						<option value="3">山嵜佳昭</option>
						<option value="4">森下佳亮</option>
				</select>
			</tr>
			<input type="submit" name="regist" value="登録"><br>
		</table>
		</form>
	</nav>
</body>
</html>