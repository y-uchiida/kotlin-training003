package com.example.Kotlintraining003

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

// @Component アノテーション
// Spring Framework のコンポーネントの単位であるBean として扱われるようになる
// CommandLineRunner インターフェースを実装するBeanは、Spring Boot アプリケーションが
// 起動するときに `run` メソッドが実行される
@Component
class SampleCommandLineRunner(): CommandLineRunner {
    override fun run(vararg args: String?) {
        // アプリケーションプロセスの実行ログにテキストを出力
        println("run SampleCommandLineRunner")
    }
}
