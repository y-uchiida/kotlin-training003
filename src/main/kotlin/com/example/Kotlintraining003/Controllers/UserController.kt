package com.example.Kotlintraining003.Controllers

import com.example.Kotlintraining003.Entities.User
import com.example.Kotlintraining003.Exceptions.ResourceNotFoundException
import com.example.Kotlintraining003.Repositories.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.Optional

// @RequestMapping アノテーションで、
// 指定したパス以降のURLをすべて取り扱うクラスを宣言できる
@RestController
@RequestMapping("/users")
class UserController (
    val repository: UserRepository
) {
    @GetMapping("/") // GET /users
    // User エンティティをリポジトリを通じて取得し、
    // JSON に変換してレスポンスする
    fun getUsers(): List<User> {
        val users = repository.findAll()

        return users
    }

    @GetMapping("/{id}") // GET /users/:id
    fun getUser(
        @PathVariable id: Long
    ): ResponseEntity<User> {
        val user = repository.findById(id)
            .orElseThrow { ResourceNotFoundException("User not found with id $id") }
        return ResponseEntity.ok(user)
    }

    /**
     * name と email でユーザーを検索する
     */
    @GetMapping("/search") // GET /users/search
    fun searchUser(
        @RequestParam("name") name: String?,
        @RequestParam("email") email: String?,
    ): List<User> {
        val result = repository.findByNameAndEmail(name, email)
        return result
    }
}
