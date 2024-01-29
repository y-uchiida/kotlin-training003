package com.example.Kotlintraining003

// レスポンスボディに含めるデータを定義するクラスの例
// data class と宣言するのがポイント
// 今回はname と age を持つクラスをJSONに変換してレスポンスボディにする
// このクラスを使って、SampleController@responseBodyAsClassTest を実装する
data class ResponseBodySample(
    var name: String,
    var age: Int,
)