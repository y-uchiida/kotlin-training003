package com.example.Kotlintraining003

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

// SpringBoot で、RESTfull APIのエンドポイントとして扱われるようにする
// @SpringBootApplication: SpringBoot でリクエストを処理するクラスであることの宣言
// @TestController: RESTfull なAPIを提供するための機能を実装することの宣言
@SpringBootApplication
@RestController
class SampleController {
    @GetMapping("/hello") // ディレクトリルート
    fun getHello(): String {
        return "Spring Boot on Kotlin!!"
    }
}