package com.example.Kotlintraining003

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

// @SpringBootApplication アノテーション
// SpringBootの実行時に最初に呼び出されるクラスを示すためのアノテーション
@SpringBootApplication
class KotlinTraining003Application

fun main(args: Array<String>) {
	// @SpringBootApplication アノテーションがついたクラスの
	// runApplication() メソッドが、アプリケーションの起点になる
	runApplication<KotlinTraining003Application>(*args)
}
