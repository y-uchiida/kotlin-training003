package com.example.Kotlintraining003.Repositories

import com.example.Kotlintraining003.Entities.User
import org.springframework.data.jpa.repository.JpaRepository

// User エンティティを操作するためのリポジトリ層(データアクセス層)として、
// UserRepository インターフェースを作成
// JpaRepository インターフェースを拡張することで、データベースとの連携機能が利用できるようになる
// JpaRepository が @Repository アノテーションの機能を実装しているので、
// UserRepository 自体には @Repository アノテーションはつけなくてよい
// JpaRepository<操作するエンティティクラス名, ID(プライマリキーとして扱うカラム)の型>
interface UserRepository: JpaRepository<User, Long> {
}
