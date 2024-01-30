package com.example.Kotlintraining003

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// @SpringBootApplication アノテーション
// SpringBootの実行時にエントリポイントとなるクラスをマーキングする
@SpringBootApplication
class KotlinTraining003Application

fun main(args: Array<String>) {
	// @SpringBootApplication アノテーションがついたクラスの
	// runApplication() メソッドが、アプリケーションの起点になる
	runApplication<KotlinTraining003Application>(*args)
}
