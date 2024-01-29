package com.example.Kotlintraining003

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

// SpringBoot で、RESTfull APIのエンドポイントとして扱われるようにする
// @SpringBootApplication: SpringBoot でリクエストを処理するクラスであることの宣言
// @TestController: RESTfull なAPIを提供するための機能を実装することの宣言
@SpringBootApplication
@RestController
class SampleController(
    // @RestController を付けたクラスでは、コンストラクタに@Service をつけたクラスを渡すとDI してくれる
    val sampleService: SampleService
) {
    @GetMapping("/hello") // GET /hello へのアクセスを処理する
    fun getHello(): String {
        return "Spring Boot on Kotlin!!"
    }

    @GetMapping("/sample") // GET /sample へのアクセスを処理する
    fun getSample(): String {
        return sampleService.getSample()
    }

    @PostMapping("/sample") // POST /sample
    fun postSample(): String {
        return sampleService.postSample()
    }

    @PutMapping("/sample") // PUT /sample
    fun putSample(): String {
        return sampleService.putSample()
    }

    @DeleteMapping("/sample") // DELETE /sample
    fun deleteSample(): String {
        return sampleService.deleteSample()
    }
}