 'use strict';
// 外部udresult.jsファイル


//質問を閲覧数(降順)で並び替え
qa.sort(function(a, b) {
   if (a.pageview > b.pageview) {
       return -1;
   } else {
       return 1;
   }
});
console.log(qa);

//複数選択削除
function Checkedel(){
  for (var i=0; i<document.form.question.length; i++){
    document.form.question[i].checked = check;
    const element = document.querySelector('check')
    element.remove()
  }
};