package com.example.Kotlintraining003.Repositories

import com.example.Kotlintraining003.Entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

// User エンティティを操作するためのリポジトリ層(データアクセス層)として、
// UserRepository インターフェースを作成
// JpaRepository インターフェースを拡張することで、データベースとの連携機能が利用できるようになる
// JpaRepository が @Repository アノテーションの機能を実装しているので、
// UserRepository 自体には @Repository アノテーションはつけなくてよい
// JpaRepository<操作するエンティティクラス名, ID(プライマリキーとして扱うカラム)の型>
interface UserRepository: JpaRepository<User, Long> {

    /**
     * name と email でuser を検索する
     */
    // @Query アノテーション：
    // JPA から提供されるアノテーションで、JPQL（Java Persistence Query Language）やネイティブSQLクエリをメソッドに直接関連付けるために使用される
    // ここでは、与えたSQLクエリを実行させるメソッドを定義する際に利用する
    // SQLクエリ内の名前付きプレースホルダは、同名のメソッドの引数にバインドされる
    // パラメータが渡されなかった場合は、そのカラムでの絞り込みは行われない
    @Query(
            "SELECT " +
                "u " +
            "FROM " +
                "User u " +
            "WHERE " +
                "(:name is null or u.name LIKE %:name%) " +
            "and " +
                "(:email is null or u.email LIKE %:email%)"
    )
    fun findByNameAndEmail(
        @Param("name") name: String?,
        @Param("email") email: String?
    ): List<User>
}
