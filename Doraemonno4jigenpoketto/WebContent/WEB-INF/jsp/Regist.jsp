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
				<th>質問文</th><td><textarea name="question"></textarea></td>
			</tr>
			<tr>
				<th>回答文</th><td><textarea name="answer"></textarea></td>
			</tr>

			<tr>
				<td>
					<select name="unit" id="unit">
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
						<option value="26">その他</option>
					</optgroup>
					</select>
				</td>
			</tr>

			<tr>
				<td>
					<select name="category" id="category">
						<option value="">単元項目を選択してください</option>
						<!--パーソナルコース-->
						<optgroup label="ビジネスマナー・コミュニケーション">
							<option value="0101001">敬語</option>
							<option value="0101002">ビジネスマナー</option>
							<option value="0101003">挨拶</option>
							<option value="0101004">電話対応</option>
							<option value="0101005">名刺交換</option>
							<option value="0101006">顧客先への訪問時と顧客の来社時のマナー</option>
							<option value="0101007">その他</option>
						</optgroup>
						<optgroup label="ビジネスメール・ビジネス文章">
							<option value="0102001">ビジネス文書とは</option>
							<option value="0102002">文書の書き方</option>
							<option value="0102003">Wordの起動～文書の作成</option>
							<option value="0102004">報告書を書く時の注意点</option>
							<option value="0102005">その他</option>
						</optgroup>
						<optgroup label="Word">
							<option value="0103001">Word</option>
						</optgroup>
						<optgroup label="Excel">
							<option value="0104001">Excel</option>
						</optgroup>
						<!--IT基礎コース-->
						<optgroup label="プログラミング">
							<option value="0201001">プログラミングの世界</option>
							<option value="0201002">コンピューターの仕組みと役割</option>
							<option value="0201003">OSの仕組みと役割</option>
							<option value="0201004">プログラミング言語の基礎知識</option>
							<option value="0201005">論理演算とプログラミング</option>
							<option value="0201006">その他</option>
						</optgroup>
						<optgroup label="アルゴリズム">
							<option value="0202001">アルゴリズム</option>
							<option value="0202002">データ構造</option>
							<option value="0202003">その他</option>
						</optgroup>
						<optgroup label="ネットワーク">
							<option value="0203001">IPアドレス</option>
							<option value="0203002">DNSサーバー</option>
							<option value="0203003">ポート番号</option>
							<option value="0203004">ルータ</option>
							<option value="0203005">WebページのソースとCookie</option>
							<option value="0203006">MacアドレスとARPテーブル</option>
							<option value="0203007">Windowsとファイアウォール</option>
							<option value="0203008">その他</option>
						</optgroup>
						<optgroup label="HTML">
							<option value="0204001">製作の準備と基本的なHTMＬ</option>
							<option value="0204002">見出し・段落・リスト</option>
							<option value="0204003">リンクと画像の挿入</option>
							<option value="0204004">2ページ目意向を効率的に作成する</option>
							<option value="0204005">その他</option>
						</optgroup>
						<optgroup label="CSS">
							<option value="0205001">CSSでページのスタイルを調整</option>
							<option value="0205002">フロートとテーブルのスタイル</option>
							<option value="0205003">フォームの作成</option>
							<option value="0205004">その他</option>
						</optgroup>
						<optgroup label="JavaScript">
							<option value="0206001">アウトプットの基本</option>
							<option value="0206002">文法と基本的な機能</option>
							<option value="0206003">インプットとデータの加工</option>
							<option value="0206004">一歩進んだテクニック</option>
							<option value="0206005">WebページにJavascriptを追加</option>
							<option value="0206006">その他</option>
						</optgroup>
						<optgroup label="データベース（SQL）">
							<option value="0207001">用途と役割</option>
							<option value="0207002">リレーショナルデータベース</option>
							<option value="0207003">データベースとアーキテクチャ構成</option>
							<option value="0207004">DBMSを操作する際の基礎知識</option>
							<option value="0207005">SQL文の基本</option>
							<option value="0207006">トランザクションと同時実行制御</option>
							<option value="0207007">テーブル</option>
							<option value="0207008">バックアップとリカバリー</option>
							<option value="0207009">その他</option>
						</optgroup>
						<!--Java基礎コース-->
						<optgroup label="Javaプログラミング">
							<option value="0301001">Javaプログラムの書き方</option>
							<option value="0301002">式と演算子</option>
							<option value="0301003">条件分岐と繰り返し</option>
							<option value="0301004">配列</option>
							<option value="0301005">メソッド</option>
							<option value="0301006">複数クラスを用いた開発</option>
							<option value="0301007">クラスとインスタンス</option>
							<option value="0301008">カプセル化</option>
							<option value="0301009">継承</option>
							<option value="0301010">多態性</option>
							<option value="0301011">例外処理</option>
							<option value="0301012">文字列を操作するAPI</option>
							<option value="0301013">コレクションを提供するAPI</option>
							<option value="0301014">その他</option>
						</optgroup>
						<optgroup label="サーバサイドJava">
							<option value="0302001">サーブレットの基礎</option>
							<option value="0302002">JSPの基礎</option>
							<option value="0302003">リクエストパラメータの取得</option>
							<option value="0302004">MVCモデル</option>
							<option value="0302005">JavaBeans</option>
							<option value="0302006">リクエストスコープ</option>
							<option value="0302007">セッションスコープ</option>
							<option value="0302008">アプリケーションスコープ</option>
							<option value="0302009">Webアプリケーションの画面と機能</option>
							<option value="0302010">フィルタ</option>
							<option value="0302011">アクションタグとEL</option>
							<option value="0302012">JDBCとDAOのパターン</option>
							<option value="0302013">Webアプリケーションの設計</option>
							<option value="0302014">JSTL</option>
							<option value="0302015">その他</option>
						</optgroup>
						<optgroup label="品質管理">
							<option value="0303001">品質管理の基礎知識</option>
							<option value="0303002">ホワイトボックス・ブラックボックス・オートテスト</option>
							<option value="0303003">品質管理</option>
							<option value="0303004">単体テスト・結合テスト・システムテスト</option>
							<option value="0303005">その他</option>
						</optgroup>
						<optgroup label="セキュリティ">
							<option value="0304001">脅威の存在を知る</option>
							<option value="0304002">暗号化とディジタル署名</option>
							<option value="0304003">Webアプリの脆弱性と対策</option>
							<option value="0304004">その他</option>
						</optgroup>
						<!--Web開発演習コース-->
						<optgroup label="導入">
							<option value="0401001">webアプリケーションの構成要素</option>
							<option value="0401002">webアプリケーションフレームワーク</option>
							<option value="0401003">構成管理</option>
							<option value="0401004">進め方について</option>
							<option value="0401005">その他</option>
						</optgroup>
						<optgroup label="要件定義">
							<option value="0402001">プロジェクトについて</option>
							<option value="0402002">ヒアリング</option>
							<option value="0402003">業務分析・業務知識</option>
							<option value="0402004">要件の種類（機能/非機能要件）</option>
							<option value="0402005">見積もり手法</option>
							<option value="0402006">スケジュール策定</option>
							<option value="0402007">その他</option>
						</optgroup>
						<optgroup label="外部設計">
							<option value="0403001">外部設計書</option>
						</optgroup>
						<optgroup label="内部設計">
							<option value="0404001">内部設計書</option>
						</optgroup>
						<optgroup label="実装">
							<option value="0405001">コーディング規約</option>
							<option value="0405002">命名規則</option>
							<option value="0405003">その他</option>
						</optgroup>
						<optgroup label="テスト">
							<option value="0406001">テストの工程</option>
							<option value="0406002">テストの種類と方法</option>
							<option value="0406003">影響範囲と修正方法</option>
							<option value="0406004">テスト仕様書</option>
							<option value="0406005">その他</option>
						</optgroup>
						<optgroup label="プレゼン作成">
							<option value="0407001">プレゼンの基礎</option>
							<option value="0407002">パワーポイント基礎</option>
							<option value="0407003">その他</option>
						</optgroup>
						<optgroup label="発表">
							<option value="0408001">発表</option>
						</optgroup>
						<!--ドリル-->
						<optgroup label="アルゴリズムドリル">
							<option value="0501001">アルゴリズムドリル</option>
						</optgroup>
						<optgroup label="SQLドリル">
							<option value="0502001">SQLドリル</option>
						</optgroup>
						<!--Javaドリル-->
						<optgroup label="Javaドリル">
							<option value="0503001">Javaドリル</option>
						</optgroup>
						<!--その他-->
						<optgroup label="その他">
							<option value="0601001">その他</option>
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
			    <input type="text" name="answerer" id="answerer">
			</tr>
			<tr>
			    <input type="text" name="registant" id="registant">
			</tr>
			<input type="submit" name="regist" value="登録"><br>
		</table>
		</form>
	</nav>
</body>
</html>