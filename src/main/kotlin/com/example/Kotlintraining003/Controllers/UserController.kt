package com.example.Kotlintraining003.Controllers

import com.example.Kotlintraining003.Entities.User
import com.example.Kotlintraining003.Exceptions.ResourceNotFoundException
import com.example.Kotlintraining003.Repositories.UserRepository
import com.example.Kotlintraining003.RequestBodies.User.CreateUserRequestBody
import com.example.Kotlintraining003.RequestBodies.User.UpdateUserRequestBody
import com.example.Kotlintraining003.Services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.Optional

// @RequestMapping アノテーションで、
// 指定したパス以降のURLをすべて取り扱うクラスを宣言できる
@RestController
@RequestMapping("/users")
class UserController (
    // Service 層のクラスを用いてCRUD操作を行う
    // Controller 層は、repository 層に依存しないようにする
    val service: UserService
) {
    @GetMapping("") // GET /users
    // User エンティティをリポジトリを通じて取得し、
    // JSON に変換してレスポンスする
    fun getUsers(): List<User> {
        return service.getUsers()
    }

    /**
     * リクエストボディで受け取った値を用いてuser テーブルに値を保存する
     * レスポンスボディは無し、ステータスコードは204 No Content
     */
    // ResponseEntityのメソッドは、HTTPステータスコードにそれぞれ対応するものが用意されているので、それを利用する
    // 今回はResponseEntity.noContent()
    // レスポンスボディは空なので、返り値の型定義はResponseEntity<Void>
    @PostMapping("") // POST /users
    fun createUser(
        @RequestBody request: CreateUserRequestBody
    ): ResponseEntity<Void> {
        service.storeUser(request.name, request.email, request.password)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{id}") // GET /users/:id
    fun getUser(
        @PathVariable id: Long
    ): ResponseEntity<User> {
        val user = service.findUser(id)
        return ResponseEntity.ok(user)
    }

    /**
     * リクエストボディで受け取った値を用いてuser テーブルの値を更新する
     * 今回はサンプルとして、name のみ更新できる実装とした
     * email などをリクエストボディに含めて送信しても何も起こらない仕様になっている
     * レスポンスボディは無し、ステータスコードは204 No Content
     */
    // ResponseEntityのメソッドは、HTTPステータスコードにそれぞれ対応するものが用意されているので、それを利用する
    // 今回はResponseEntity.noContent()
    // レスポンスボディは空なので、返り値の型定義はResponseEntity<Void>
    @PutMapping("/{id}") // PUT /users/:id
    fun updateUser(
        @PathVariable id: Long,
        @RequestBody request: UpdateUserRequestBody
    ): ResponseEntity<Void> {
        service.updateUser(id, request.name)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping("/{id}") // DELETE /users/:id
    fun deleteUser(
        @PathVariable id: Long
    ): ResponseEntity<Void> {
        service.deleteUser(id)
        return ResponseEntity.noContent().build()
    }

    /**
     * name と email でユーザーを検索する
     */
    @GetMapping("/search") // GET /users/search
    fun searchUser(
        @RequestParam("name") name: String?,
        @RequestParam("email") email: String?,
    ): List<User> {
        return service.searchUser(name, email)
    }
}
