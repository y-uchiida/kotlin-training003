package com.example.Kotlintraining003.RequestBodies.User

/**
 * ユーザーを作成するエンドポイント (POST /users) が
 * 受け取るリクエストボディを定義する
 */
data class CreateUserRequestBody(
    var name: String,
    var email: String,
    var password: String
)