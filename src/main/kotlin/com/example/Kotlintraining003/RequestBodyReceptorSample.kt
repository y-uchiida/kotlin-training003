package com.example.Kotlintraining003

// リクエストボディに含まれるデータを受け取るためのクラスの例
// data class と宣言するのがポイント
// 今回はひとつの文字列としてリクエストボディの中身をすべて受け取っている
// このクラスを使って、SampleController@requestBodyAsClassTest を実装する
data class RequestBodyReceptorSample (val data: String)