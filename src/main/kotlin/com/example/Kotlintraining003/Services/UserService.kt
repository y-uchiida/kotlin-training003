package com.example.Kotlintraining003.Services

import com.example.Kotlintraining003.Entities.User
import com.example.Kotlintraining003.Exceptions.ResourceNotFoundException
import com.example.Kotlintraining003.Repositories.UserRepository
import org.springframework.stereotype.Service

/**
 * UserRepository を用いて、User エンティティを操作するサービス
 * UserのCRUDなどの機能を提供する
 * Controller クラスは、基本的にこのクラスの実装にのみ依存させる
 */
@Service
class UserService(
    val repository: UserRepository
) {

    /**
     * ユーザーの一覧を取得する
     */
    fun getUsers(): List<User> {
        return repository.findAll()
    }

    /**
     * ユーザーをIDで指定して取得する
     */
    fun findUser(id: Long): User {
        val user = repository.findById(id)
            .orElseThrow{
                // 指定したIDでユーザーが見つからない場合、
                // ResourceNotFoundException が発生し、この例外から 404 レスポンスが返される
                ResourceNotFoundException("User not found with id $id")
            }
        return user
    }

    /**
     * ユーザーを新規追加する
     */
    fun storeUser(
        name: String,
        email: String,
        password: String
    ) {
        val newUser = User(name, email, password)
        repository.save(newUser)
    }

    /**
     * ユーザーの情報を更新する
     * 今回はサンプルとしてname のみ更新できる仕様として実装
     */
    fun updateUser(id: Long, name: String) {
        val user = findUser(id)
        user.name = name
        repository.save(user)
    }

    /**
     * ユーザーを削除する
     */
    fun deleteUser(id: Long) {
        val user = findUser(id)
        repository.delete(user)
    }

    /**
     * name と email でユーザーを検索する
     * 検索処理はUserRepository で JPQL を利用して実装
     */
    fun searchUser(name: String?, email: String?): List<User> {
        return repository.findByNameAndEmail(name, email)
    }
}