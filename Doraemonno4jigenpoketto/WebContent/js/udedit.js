window.onload = function() {

  // 単元項目の選択肢

  category_item = document.getElementById("category_item");

  // ジャンルの選択肢が変更された際の動作

  unit = document.getElementById("unit");

  unit.onchange = changeUnit;

}

// ジャンルの選択肢が変更された際の動作

function changeUnit() {

  // 変更後のカテゴリを取得

  var changedUnit = unit.value;

  if (changedUnit == "0") {

    // カテゴリにビジネス・コミュニケーションが選択された場合

     setBCommuUnits();

  } else if (changedUnit == "1") {

    // カテゴリにビジネスメール・ビジネス文章が選択された場合

     setBMailUnits();

  } else if (changedUnit == "2") {

    // カテゴリにWordが選択された場合

    setWordUnits();
   }else if (changedUnit == "3") {

    // カテゴリにExcelが選択された場合

    setExcelUnits();


  } else if (changedUnit == "4") {

    // カテゴリにプログラミング(Programing)が選択された場合

    setProUnits();


  } else if (changedUnit == "5") {

    // カテゴリにアルゴリズムが選択された場合

    setAlgorithmUnits();


  } else if (changedUnit == "6") {

    // カテゴリにネットワークが選択された場合

    setNetworkUnits();


  } else if (changedUnit == "7") {

    // カテゴリにHTMLが選択された場合

    setHtmlUnits();


  }else if (changedUnit == "8") {

    // カテゴリにCSSが選択された場合

    setCssUnits();


  } else if (changedUnit == "9") {

    // カテゴリにJavaScriptが選択された場合

    setJSUnits();


  } else if (changedUnit == "10") {

    // カテゴリにデータベース（SQL）(DataBase)が選択された場合

    setDBUnits();


  } else if (changedUnit == "11") {

    // カテゴリにJavaプログラミング(JavaPrograming)が選択された場合

    setJavaProUnits();


  } else if (changedUnit == "12") {

    // カテゴリにサーバサイドJava(ServersideJava)が選択された場合

    setSSJavaUnits();


  } else if (changedUnit == "13") {

    // カテゴリに品質管理が選択された場合

    setQualityUnits();


  } else if (changedUnit== "14") {

    // カテゴリにセキュリティが選択された場合

    setSecurityUnits();


  } else if (changedUnit == "15") {

    // カテゴリに導入(Introduction)が選択された場合

    setIntroUnits();


  } else if (changedUnit == "16") {

    // カテゴリに要件定義（requirement definition）が選択された場合

    setRDUnits();


  } else if (changedUnit == "17") {

    // カテゴリに外部設計（External design）が選択された場合

    setEDUnits();


  } else if (changedUnit == "18") {

    // カテゴリに内部設計（Internal design）が選択された場合

    setIDUnits();


  } else if (changedUnit == "19") {

    // カテゴリに実装（implementation）が選択された場合

    setImpleUnits();


  } else if (changedUnit== "20") {

    // カテゴリにテスト（test）が選択された場合

    setTestUnits();


  } else if (changedUnit == "21") {

    // カテゴリにプレゼン作成（）が選択された場合

    setPresentationUnits();


  } else if (changedUnit == "22") {

    // カテゴリに発表（announcement）が選択された場合

    setAnnnounceUnits();


  } else if (changedUnit == "23") {

    // カテゴリにアルゴリズムドリルが選択された場合

    setAlgorithmDUnits();


  } else if (changedUnit == "24") {

    // カテゴリにSQLドリルが選択された場合

    setSqlDUnits();


  } else if (changedUnit == "25") {

    // カテゴリにJavadドリルが選択された場合

    setJavaDUnits();


  } else if (changedUnit == "26") {

    // カテゴリにその他が選択された場合

    setOthersUnits();
  }

}

// ビジネス・コミュニケーションの選択肢を設定する

function setBCommuUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // 和食の選択肢

  var BCommuUnits = [


    {cd:"", label:"選択して下さい"},

    {cd:"101001", label:"敬語"},

    {cd:"101002", label:"ビジネスマナー"},

    {cd:"101003", label:"挨拶"},

    {cd:"101004", label:"電話対応"},

    {cd:"101005", label:"名刺交換"},

    {cd:"101006", label:"顧客先への訪問時と顧客の来社時のマナー"},

    {cd:"101007", label:"その他"}

  ];

  BCommuUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    category_item.appendChild(op);

  });

}

// ビジネスメール・ビジネス文章の選択肢を設定する

function setBMailUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // ビジネスメール・ビジネス文章の選択肢

  var BMailUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"102001", label:"ビジネス文書とは"},

    {cd:"102002", label:"文書の書き方"},

    {cd:"102003", label:"Wordの起動～文書の作成"},

    {cd:"102004", label:"報告書を書く時の注意点"},

    {cd:"102005", label:"その他"}

  ];

  BMailUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
// Wordの選択肢を設定する

function setWordUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // ビジネスメール・ビジネス文章の選択肢

  var WordUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"103001", label:"Word"}

  ];

   WordUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
// Excelの選択肢を設定する

function setExcelUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // ビジネスメール・ビジネス文章の選択肢

  var ExcelUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"104001", label:"Excel"}

  ];

   ExcelUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
// プログラミングの選択肢を設定する

function setProUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // ビジネスメール・ビジネス文章の選択肢

  var  ProUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"201001", label:"プログラミングの世界"},

    {cd:"201002", label:"コンピューターの仕組みと役割"},

    {cd:"201003", label:"OSの仕組みと役割"},

    {cd:"201004", label:"プログラミング言語の基礎知識"},

    {cd:"201005", label:"論理演算とプログラミング"},

    {cd:"201006", label:"その他"}

  ];

   ProUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
// アルゴリズムの選択肢を設定する

function setAlgorithmUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // ビジネスメール・ビジネス文章の選択肢

  var  AlgorithmUnits = [

   {cd:"", label:"選択して下さい"},

    {cd:"202001", label:"アルゴリズム"},

    {cd:"202002", label:"データ構造"},

    {cd:"202003", label:"その他"}

  ];

  AlgorithmUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}

// ネットワークの選択肢を設定する

function setNetworkUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // ビジネスメール・ビジネス文章の選択肢

  var  NetworkUnits= [

    {cd:"", label:"選択して下さい"},

    {cd:"203001", label:"IPアドレス"},

    {cd:"203002", label:"DNSサーバー"},

    {cd:"203003", label:"ポート番号"},

    {cd:"203004", label:"ルータ"},

    {cd:"203005", label:"WebページのソースとCookie"},

    {cd:"203006", label:"MacアドレスとARPテーブル"},

    {cd:"203007", label:"Windowsとファイアウォール"},

    {cd:"203008", label:"その他"}
  ];

  NetworkUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}

// HTMLの選択肢を設定する

function setHtmlUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // ビジネスメール・ビジネス文章の選択肢

  var  HtmlUnits = [

    {cd:"", label:"選択して下さい"},

	{cd:"204001", label:"製作の準備と基本的なHTML"},

	{cd:"204002", label:"見出し・段落・リスト"},

	{cd:"204003", label:"リンクと画像の挿入"},

    {cd:"204004", label:"2ページ目意向を効率的に作成する"},

    {cd:"204005", label:"その他"}

  ];

    HtmlUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
// CSSの選択肢を設定する

function setCssUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // ビジネスメール・ビジネス文章の選択肢

  var  CssUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"205001", label:"CSSでページのスタイルを調整"},

    {cd:"205002", label:"フロートとテーブルのスタイル"},

    {cd:"205003", label:"フォームの作成"},

    {cd:"205004", label:"その他"}

  ];

    CssUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
//JavaScriptの選択肢を設定する

function setJSUnits(){

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // ビジネスメール・ビジネス文章の選択肢

  var  JSUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"206001", label:"アウトプットの基本"},

    {cd:"206002", label:"文法と基本的な機能"},

    {cd:"206003", label:"インプットとデータの加工"},

    {cd:"206004", label:"一歩進んだテクニック"},

    {cd:"206005", label:"WebページにJavascriptを追加"},

    {cd:"206006", label:"その他"}

  ];

   JSUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
// データベース（SQL）の選択肢を設定する

function setDBUnits(){

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // ビジネスメール・ビジネス文章の選択肢

  var  DBUnits = [


    {cd:"", label:"選択して下さい"},

    {cd:"207001", label:"用途と役割"},

    {cd:"207002", label:"リレーショナルデータベース"},

    {cd:"207003", label:"データベースとアーキテクチャ構成"},

    {cd:"207004", label:"DBMSを操作する際の基礎知識"},

    {cd:"207005", label:"SQL文の基本"},

    {cd:"207006", label:"トランザクションと同時実行制御"},

    {cd:"207007", label:"テーブル"},

    {cd:"207008", label:"バックアップとリカバリー"},

    {cd:"207009", label:"その他"}

  ];

    DBUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
// Javaプログラミングの選択肢を設定する

function setJavaProUnits(){

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // ビジネスメール・ビジネス文章の選択肢

  var JavaProUnits= [


 		{cd:"", label:"選択して下さい"},

    {cd:"301001", label:"Javaプログラムの書き方"},

    {cd:"301002", label:"式と演算子"},

    {cd:"301003", label:"条件分岐と繰り返し"},

    {cd:"301004", label:"配列"},

    {cd:"301005", label:"メソッド"},

    {cd:"301006", label:"複数クラスを用いた開発"},

    {cd:"301007", label:"クラスとインスタンス"},

    {cd:"301008", label:"カプセル化"},

    {cd:"301009", label:"継承"},

    {cd:"301010", label:"多態性"},

    {cd:"301011", label:"例外処理"},

    {cd:"301012", label:"文字列を操作するAPI"},

    {cd:"301013", label:"コレクションを提供するAPI"},

    {cd:"301014", label:"その他"}

  ];

    JavaProUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
//サーバサイドJavaの選択肢を設定する

function setSSJavaUnits(){

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // ビジネスメール・ビジネス文章の選択肢

  var   SSJavaUnits = [


    {cd:"", label:"選択して下さい"},

    {cd:"302001", label:"サーブレットの基礎"},

    {cd:"302002", label:"JSPの基礎"},

    {cd:"302003", label:"リクエストパラメータの取得"},

    {cd:"302004", label:"MVCモデル"},

    {cd:"302005", label:"JavaBeans"},

    {cd:"302006", label:"リクエストスコープ"},

    {cd:"302007", label:"セッションスコープ"},

    {cd:"302008", label:"アプリケーションスコープ"},

    {cd:"302009", label:"Webアプリケーションの画面と機能"},

    {cd:"302010", label:"フィルタ"},

    {cd:"302011", label:"アクションタグとEL"},

    {cd:"302012", label:"JDBCとDAOのパターン"},

    {cd:"302013", label:"Webアプリケーションの設計"},

    {cd:"302014", label:"JSTL"},

    {cd:"302015", label:"その他"}

  ];

  SSJavaUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
//品質管理の選択肢を設定する

function setQualityUnits(){

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // ビジネスメール・ビジネス文章の選択肢

  var  QualityUnits = [

   {cd:"", label:"選択して下さい"},

    {cd:"303001", label:"品質管理の基礎知識"},

    {cd:"303002", label:"ホワイトボックス・ブラックボックス・オートテスト"},

    {cd:"303003", label:"品質管理"},

    {cd:"303004", label:"単体テスト・結合テスト・システムテスト"},

    {cd:"303005", label:"その他"}

  ];

   QualityUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
//セキュリティの選択肢を設定する

function setQualityUnits(){

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // セキュリティの選択肢

  var   SecurityUnits = [

 		{cd:"", label:"選択して下さい"},

    {cd:"304001", label:"脅威の存在を知る"},

    {cd:"304002", label:"暗号化とディジタル署名"},

    {cd:"304003", label:"Webアプリの脆弱性と対策"},

    {cd:"304004", label:"その他"}
  ];

   SecurityUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
//導入の選択肢を設定する

function setIntroUnits(){

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // セキュリティの選択肢

  var  IntroUnits = [

 	  {cd:"", label:"選択して下さい"},

    {cd:"401001", label:"Webアプリケーションの構成要素"},

    {cd:"401002", label:"Webアプリケーションフレームワーク"},

    {cd:"401003", label:"構成管理"},

    {cd:"401004", label:"進め方について"},

    {cd:"401005", label:"その他"}
  ];

  IntroUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
//要件定義の選択肢を設定する

function  setRDUnits(){

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // セキュリティの選択肢

  var  RDUnits = [

 	 {cd:"", label:"選択して下さい"},

    {cd:"402001", label:"プロジェクトについて"},

    {cd:"402002", label:"ヒアリング"},

    {cd:"402003", label:"業務分析・業務知識"},

    {cd:"402004", label:"要件の種類（機能/非機能要件）"},

    {cd:"402005", label:"見積もり手法"},

    {cd:"402006", label:"スケジュール策定"},

    {cd:"402007", label:"その他"}
  ];

 RDUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
//外部設計の選択肢を設定する

function  setEDUnits(){

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // セキュリティの選択肢

  var EDUnits= [

 	 {cd:"", label:"選択して下さい"},

    {cd:"403001", label:"外部設計書"}
  ];

 EDUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
//内部設計の選択肢を設定する

function  setIDUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // セキュリティの選択肢

  var IDUnits = [


    {cd:"", label:"選択して下さい"},

    {cd:"404001", label:"内部設計書"}
  ];

IDUnits .forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
//実装の選択肢を設定する

function setImpleUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // セキュリティの選択肢

  var ImpleUnits= [


   {cd:"", label:"選択して下さい"},

    {cd:"405001", label:"コーディング規約"},

    {cd:"405002", label:"命名規則"},

    {cd:"405003", label:"その他"}
  ];

ImpleUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
//テストの選択肢を設定する

function setTestUnits(){

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // セキュリティの選択肢

  var TestUnits= [


     {cd:"", label:"選択して下さい"},

    {cd:"406001", label:"テストの工程"},

    {cd:"406002", label:"テストの種類と方法"},

    {cd:"406003", label:"影響範囲と修正方法"},,

    {cd:"406004", label:"テスト仕様書"},

    {cd:"406005", label:"その他"}
  ];

TestUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}

//プレゼン作成の選択肢を設定する

function setPresentationUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // セキュリティの選択肢

  var  PresentationUnits= [


   {cd:"", label:"選択して下さい"},

    {cd:"407001", label:"プレゼンの基礎"},

    {cd:"407002", label:"パワーポイント基礎"},

    {cd:"407003", label:"その他"}
  ];

 PresentationUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
//発表の選択肢を設定する

function  setAnnnounceUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // セキュリティの選択肢

  var  AnnnounceUnits= [


   {cd:"", label:"選択して下さい"},

    {cd:"408001", label:"発表"}
  ];

  AnnnounceUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
//アルゴリズムドリルの選択肢を設定する

function   setAlgorithmDUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // セキュリティの選択肢

  var  AlgorithmDUnits= [


  {cd:"", label:"選択して下さい"},

    {cd:"501001", label:"アルゴリズムドリル"}
  ];

  AlgorithmDUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
//SOLドリルの選択肢を設定する

function   setSqlDUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // セキュリティの選択肢

  var   SqlDUnits= [


   {cd:"", label:"選択して下さい"},

       {cd:"502001", label:"SQLドリル"}
  ];

  SqlDUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
// Javaドリルの選択肢を設定する

function   setJavaDUnits() {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // セキュリティの選択肢

  var  JavaDUnits= [


   {cd:"", label:"選択して下さい"},

   {cd:"503001", label:"Javaドリル"}
  ];

  JavaDUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
// その他の選択肢を設定する

function  setOtherUnits()  {

  // 単元項目の選択肢を空にする

  category_item.textContent = null;

  // セキュリティの選択肢

  var  OtherUnits= [


   {cd:"", label:"選択して下さい"},

   {cd:"601001", label:"その他"}
  ];

  OtherUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

   category_item.appendChild(op);

  });

}
