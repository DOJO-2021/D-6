/**
 *
 */


window.onload = function() {

  //

  unit = document.getElementById("unit");

  // ジャンルの選択肢が変更された際の動作

  unit = document.getElementById("unit");

  unit.onchange = changeUnit;

}



// ジャンルの選択肢が変更された際の動作 course→unit→category

function changeUnit() {

  // 変更後のカテゴリを取得

  var changedUnit = unit.value;

  if (changedunit == "0") {

    // カテゴリにビジネス・コミュニケーションが選択された場合

    setBCommuUnits();


  } else if (changedCategory == "1") {

    // カテゴリにビジネスメール・ビジネス文章が選択された場合

    setBMailUnits();


  } else if (changedCategory == "2") {

    // カテゴリにWordが選択された場合

    setWordUnits();


  } else if (changedCategory == "3") {

    // カテゴリにExcelが選択された場合

    setExcelUnits();


  } else if (changedCategory == "4") {

    // カテゴリにプログラミング(Programing)が選択された場合

    setProUnits();


  } else if (changedCategory == "5") {

    // カテゴリにアルゴリズムが選択された場合

    setAlgorithmUnits();


  } else if (changedCategory == "6") {

    // カテゴリにネットワークが選択された場合

    setNetworkUnits();


  } else if (changedCategory == "7") {

    // カテゴリにHTMLが選択された場合

    setHtmlUnits();


  } else if (changedCategory == "8") {

    // カテゴリにCSSが選択された場合

    setCssUnits();


  } else if (changedCategory == "9") {

    // カテゴリにJavaScriptが選択された場合

    setJSUnits();


  } else if (changedCategory == "10") {

    // カテゴリにデータベース（SQL）(DataBase)が選択された場合

    setDBUnits();


  } else if (changedCategory == "11") {

    // カテゴリにJavaプログラミング(JavaPrograming)が選択された場合

    setJavaProUnits();


  } else if (changedCategory == "12") {

    // カテゴリにサーバサイドJava(ServersideJava)が選択された場合

    setSSJavaUnits();


  } else if (changedCategory == "13") {

    // カテゴリに品質管理が選択された場合

    setQualityUnits();


  } else if (changedCategory == "14") {

    // カテゴリにセキュリティが選択された場合

    setSecurityUnits();


  } else if (changedCategory == "15") {

    // カテゴリに導入(Introduction)が選択された場合

    setIntroUnits();


  } else if (changedCategory == "16") {

    // カテゴリに要件定義（requirement definition）が選択された場合

    setRDUnits();


  } else if (changedCategory == "17") {

    // カテゴリに外部設計（External design）が選択された場合

    setEDUnits();


  } else if (changedCategory == "18") {

    // カテゴリに内部設計（Internal design）が選択された場合

    setIDUnits();


  } else if (changedCategory == "19") {

    // カテゴリに実装（implementation）が選択された場合

    setImpleUnits();


  } else if (changedCategory == "20") {

    // カテゴリにテスト（test）が選択された場合

    setTestUnits();


  } else if (changedCategory == "21") {

    // カテゴリにプレゼン作成（）が選択された場合

    setPresentationUnits();


  } else if (changedCategory == "22") {

    // カテゴリに発表（announcement）が選択された場合

    setAnnnounceUnits();


  } else if (changedCategory == "23") {

    // カテゴリにアルゴリズムドリルが選択された場合

    setAlgorithmDUnits();


  } else if (changedCategory == "24") {

    // カテゴリにSQLドリルが選択された場合

    setSqlDUnits();


  } else if (changedCategory == "25") {

    // カテゴリにJavadドリルが選択された場合

    setJavaDUnits();


  } else /*(changedCategory == "26")*/ {

    // カテゴリにその他が選択された場合

    setOthersUnits();


  }

}

// ビジネスマナー・コミュニケーションの選択肢を設定する

function setBCommuUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // ビジネスマナー・コミュニケーションの選択肢

  var BCommuUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"0", label:"敬語"},

    {cd:"1", label:"ビジネスマナー"},

    {cd:"2", label:"挨拶"},

    {cd:"3", label:"電話対応"},

    {cd:"4", label:"名刺交換"},

    {cd:"5", label:"顧客先への訪問時と顧客の来社時のマナー"},

    {cd:"6", label:"その他"}
  ];

  BCommuUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// ビジネスメール・ビジネス文章の選択肢を設定する
function setBMailUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // ビジネスメール・ビジネス文章の選択肢

  var BMailUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"7", label:"ビジネス文書とは"},

    {cd:"8", label:"文書の書き方"},

    {cd:"9", label:"Wordの起動～文書の作成"},

    {cd:"10", label:"報告書を書く時の注意点"},

    {cd:"11", label:"その他"},
  ];

  BMailUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// Wordの選択肢を設定する
function setWordUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // Wordの選択肢

  var WordUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"12", label:"Word"},
  ];

  WordUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// Excelの選択肢を設定する
function setExcelUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // Excelの選択肢

  var ExcelUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"13", label:"Excel"},
  ];

  ExcelUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// プログラミングの選択肢を設定する
function setProUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // プログラミングの選択肢

  var ProUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"14", label:"プログラミングの世界"},

    {cd:"15", label:"コンピューターの仕組みと役割"},

    {cd:"16", label:"OSの仕組みと役割"},

    {cd:"17", label:"プログラミング言語の基礎知識"},

    {cd:"18", label:"論理演算とプログラミング"},

    {cd:"19", label:"その他"},

  ];

  ProUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// アルゴリズムの選択肢を設定する
function setAlgorithmUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // アルゴリズムの選択肢

  var AlgorithmUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"20", label:"アルゴリズム"},

    {cd:"21", label:"データ構造"},

    {cd:"22", label:"その他"},

  ];

  AlgorithmUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// ネットワークの選択肢を設定する
function setNetworkUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // ネットワークの選択肢

  var NetworkUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"23", label:"IPアドレス"},

    {cd:"24", label:"DNSサーバー"},

    {cd:"25", label:"ポート番号"},

    {cd:"26", label:"ルータ"},

    {cd:"27", label:"WebページのソースとCookie"},

    {cd:"28", label:"MacアドレスとARPテーブル"},

    {cd:"29", label:"Windowsとファイアウォール"},

    {cd:"30", label:"その他"},

  ];

  NetworkUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// HTMLの選択肢を設定する
function setHtmlUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // HTMLの選択肢

  var HtmlUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"31", label:"2ページ目意向を効率的に作成する"},

    {cd:"32", label:"その他"},

  ];

  HtmlUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// CSSの選択肢を設定する
function setCssUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // CSSの選択肢

  var CssUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"33", label:"フォームの作成"},

    {cd:"34", label:"その他"},

  ];

  CssUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// JavaScriptの選択肢を設定する
function setJSUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // JavaScriptの選択肢

  var JSUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"35", label:"アウトプットの基本"},

    {cd:"36", label:"文法と基本的な機能"},

    {cd:"37", label:"インプットとデータの加工"},

    {cd:"38", label:"一歩進んだテクニック"},

    {cd:"39", label:"WebページにJavascriptを追加"},

    {cd:"40", label:"その他"},

  ];

  JSUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// データベース（SQL）の選択肢を設定する
function setDBUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // データベース（SQL）の選択肢

  var DBUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"41", label:"用途と役割"},

    {cd:"42", label:"リレーショナルデータベース"},

    {cd:"43", label:"データベースとアーキテクチャ構成"},

    {cd:"44", label:"DBMSを操作する際の基礎知識"},

    {cd:"45", label:"SQL文の基本"},

    {cd:"46", label:"トランザクションと同時実行制御"},

    {cd:"47", label:"テーブル"},

    {cd:"48", label:"バックアップとリカバリー"},

    {cd:"49", label:"その他"},

  ];

  DBUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// Javaプログラミングの選択肢を設定する
function setJavaProUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // Javaプログラミングの選択肢

  var JavaProUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"50", label:"Javaプログラムの書き方"},

    {cd:"51", label:"式と演算子"},

    {cd:"52", label:"条件分岐と繰り返し"},

    {cd:"53", label:"配列"},

    {cd:"54", label:"メソッド"},

    {cd:"55", label:"複数クラスを用いた開発"},

    {cd:"56", label:"クラスとインスタンス"},

    {cd:"57", label:"カプセル化"},

    {cd:"58", label:"継承"},

    {cd:"59", label:"多態性"},

    {cd:"60", label:"例外処理"},

    {cd:"61", label:"文字列を操作するAPI"},

    {cd:"62", label:"コレクションを提供するAPI"},

    {cd:"63", label:"その他"},

  ];

  JavaProUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// サーバサイドJavaの選択肢を設定する
function setSSJavaUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // サーバサイドJavaの選択肢

  var SSJavaUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"64", label:"サーブレットの基礎"},

    {cd:"65", label:"JSPの基礎"},

    {cd:"66", label:"リクエストパラメータの取得"},

    {cd:"67", label:"MVCモデル"},

    {cd:"68", label:"JavaBeans"},

    {cd:"69", label:"リクエストスコープ"},

    {cd:"70", label:"セッションスコープ"},

    {cd:"71", label:"アプリケーションスコープ"},

    {cd:"72", label:"Webアプリケーションの画面と機能"},

    {cd:"73", label:"フィルタ"},

    {cd:"74", label:"アクションタグとEL"},

    {cd:"75", label:"JDBCとDAOのパターン"},

    {cd:"76", label:"Webアプリケーションの設計"},

    {cd:"77", label:"JSTL"},

    {cd:"78", label:"その他"},

  ];

  SSJavaUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// 品質管理の選択肢を設定する
function setQualityUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // 品質管理の選択肢

  var QualityUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"79", label:"品質管理の基礎知識"},

    {cd:"80", label:"ホワイトボックス・ブラックボックス・オートテスト"},

    {cd:"81", label:"品質管理"},

    {cd:"82", label:"単体テスト・結合テスト・システムテスト"},

    {cd:"83", label:"その他"},

  ];

  QualityUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// セキュリティの選択肢を設定する
function setSecurityUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // セキュリティの選択肢

  var SecurityUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"84", label:"脅威の存在を知る"},

    {cd:"85", label:"暗号化とディジタル署名"},

    {cd:"86", label:"Webアプリの脆弱性と対策"},

    {cd:"87", label:"その他"},

  ];

  SecurityUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// 導入の選択肢を設定する
function setIntroUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // 導入の選択肢

  var IntroUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"88", label:"Webアプリケーションの構成要素"},

    {cd:"89", label:"Webアプリケーションフレームワーク"},

    {cd:"90", label:"構成管理"},

    {cd:"91", label:"進め方について"},

    {cd:"92", label:"その他"},

  ];

  IntroUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// 要件定義の選択肢を設定する
function setRDUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // 要件定義の選択肢

  var RDUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"93", label:"プロジェクトについて"},

    {cd:"94", label:"ヒアリング"},

    {cd:"95", label:"業務分析・業務知識"},

    {cd:"96", label:"要件の種類（機能/非機能要件）"},

    {cd:"97", label:"見積もり手法"},

    {cd:"98", label:"スケジュール策定"},

    {cd:"99", label:"その他"},

  ];

  RDUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// 外部設計の選択肢を設定する
function setEDUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // 外部設計の選択肢

  var EDUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"100", label:"外部設計書"},

  ];

  EDUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// 内部設計の選択肢を設定する
function setIDUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // 内部設計の選択肢

  var IDUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"101", label:"内部設計書"},

  ];

  IDUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// 実装の選択肢を設定する
function setImpleUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // 実装の選択肢

  var ImpleUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"102", label:"コーディング規約"},

    {cd:"103", label:"命名規則"},

    {cd:"104", label:"その他"},
  ];

  ImpleUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// テストの選択肢を設定する
function setTestUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // テストの選択肢

  var TestUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"105", label:"テストの工程"},

    {cd:"106", label:"テストの種類と方法"},

    {cd:"107", label:"影響範囲と修正方法"},

    {cd:"108", label:"影響範囲と修正方法"},

    {cd:"109", label:"テスト仕様書"},

    {cd:"110", label:"その他"},
  ];

  ImpleUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// プレゼン作成の選択肢を設定する
function setPresentationUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // プレゼン作成の選択肢

  var PresentationUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"111", label:"プレゼンの基礎"},

    {cd:"112", label:"パワーポイント基礎"},

    {cd:"113", label:"その他"},
  ];

  PresentationUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// 発表の選択肢を設定する
function setAnnnounceUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // 発表の選択肢

  var AnnnounceUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"114", label:"発表"},
  ];

  AnnnounceUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// アルゴリズムドリルの選択肢を設定する
function setAlgorithmDUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // アルゴリズムドリルの選択肢

  var AlgorithmDUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"115", label:"アルゴリズムドリル"},
  ];

  AlgorithmDUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// SOLドリルの選択肢を設定する
function setSqlDUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // SOLドリルの選択肢

  var SqlDUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"116", label:"SQLドリル"},
  ];

  SqlDUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// Javaドリルの選択肢を設定する
function setJavaDUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // Javaドリルの選択肢

  var JavaDUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"117", label:"Javaドリル"},
  ];

  JavaDUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


// その他の選択肢を設定する
function setOtherUnits() {

  // 単元項目の選択肢を空にする

  category.textContent = null;

  // その他の選択肢

  var OtherUnits = [

    {cd:"", label:"選択して下さい"},

    {cd:"118", label:"その他"},
  ];

  OtherUnits.forEach(function(value) {

    var op = document.createElement("option");

    op.value = value.cd;

    op.text = value.label;

    units.appendChild(op);

  });

}


