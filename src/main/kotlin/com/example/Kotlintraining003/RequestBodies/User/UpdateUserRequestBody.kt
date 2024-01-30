package com.example.Kotlintraining003.RequestBodies.User

/**
 * ユーザーの情報を更新するエンドポイント (PUT /users/:id) が
 * 受け取るリクエストボディを定義する
 * ここではメールアドレスとパスワードは更新できないものとし、
 * name のみ受け取れるようにする
 */
data class UpdateUserRequestBody(
    var name: String
)