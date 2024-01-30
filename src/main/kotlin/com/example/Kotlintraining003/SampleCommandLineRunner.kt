package com.example.Kotlintraining003

import com.example.Kotlintraining003.Entities.User
import com.example.Kotlintraining003.Repositories.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDate

// @Component アノテーション
// Spring Framework のコンポーネントの単位であるBean として扱われるようになる
// CommandLineRunner インターフェースを実装するBeanは、Spring Boot アプリケーションが
// 起動するときに `run` メソッドが実行される
@Component
class SampleCommandLineRunner(
    // SpringBoot のDIを利用して、UserRepository のインスタンスを注入
    val repository: UserRepository
): CommandLineRunner {
    override fun run(vararg args: String?) {
        // アプリケーションプロセスの実行ログにテキストを出力
        println("run SampleCommandLineRunner")

        // UserRepository をつうじて、データベースのusers テーブルにレコードを追加
        val user001 = User("user001", "user001@example.com", "password001", LocalDate.now())
        val user002 = User("user002", "user002@example.com", "password002", LocalDate.now())
        val user003 = User("user003", "user003@example.com", "password003", LocalDate.now())

        // listOf() 関数で user001, user002, user003 のリスト(Iterable)を作成して、saveAll() にわたす
        repository.saveAll(listOf(user001, user002, user003))

        println("insert users record done.")
    }
}
