package com.example.Kotlintraining003

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.*

// SpringBoot で、RESTfull APIのエンドポイントとして扱われるようにする
// @RestController: RESTfull SpringBoot でリクエストを処理するクラスであることの宣言
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

    @GetMapping("query-param-test") // GET /query-param-test?name=xxx
    fun queryParameterTest(
        // @RequestParam アノテーションをリクエストにマッピングしたメソッドの引数につけると、
        // アノテーションで指定した名前のクエリストリングの内容を引数で受け取れる
        // 今回の例では、/query-param-test?name=xxx が受け取れるようになる
        // デフォルトでは、@RequestParam で指定したクエリパラメータがない場合、
        // 400 BadRequest になる(required paramとして扱われる)
        @RequestParam("name") queryName: String
    ): String {
        return "query parameter `name` is: $queryName"
    }

    // URLマッピングのアノテーションの値に、{}で囲んだ文字列を与えると、
    // パスパラメータとしてメソッドの引数で受け取れる
    // 今回の例では、 /path-param-test/xxx が受け取れる
    @GetMapping("path-param-test/{name}") // GET /path-param-test/xxx
    fun pathParameterTest(
        // パスパラメータの値を受け取る引数には、@PathVariable をつける必要がある
        // デフォルトでは、パスパラメータを含めないURLへのアクセスは
        // 404 Not Found になる(required path として扱われる)
        @PathVariable("name") pathName: String
    ): String {
        return "path parameter `name` is: $pathName"
    }

    @GetMapping("/request-body-as-string") // GET /request-body-as-string
    fun requestBodyAsStringTest(
        // URLマッピングしたコントローラクラスのメソッドの引数に
        // @RequestBody アノテーションをつけると、リクエストボディの内容を受け取ることができる
        // @RequestBody アノテーションをつけているURLに、リクエストボディなしでリクエストすると、
        // デフォルトで400 Bad Request になる
        @RequestBody requestBody: String
    ): String {
        return "request body data is: $requestBody"
    }

    @GetMapping("/request-body-as-class")
    fun requestBodyAsClassTest(
        // @RequestBody アノテーションをつけた引数は、
        // クラス(型)を指定することでそのクラスのインスタンスとして扱えるようになる
        // 今回は data という プロパティを持つクラス requestBodyReceptorSample を利用しているので、
        // RequestBody に data というプロパティを持つJSONが送られなければならない
        @RequestBody requestBodyReceptor: RequestBodyReceptorSample
    ): String {
        return "request body data as class is: $requestBodyReceptor"
    }

    @GetMapping("/response-body-as-class")
    fun responseBodyAsClassTest():ResponseBodySample {
        val responseBody = ResponseBodySample("Jack", 20)
        return responseBody
    }
}
