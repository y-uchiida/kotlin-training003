package com.example.Kotlintraining003.Controllers
import com.example.Kotlintraining003.Exceptions.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

/**
 * アプリケーション全体で共通な例外処理を定義するクラス
 */
// @ControllerAdviceアノテーション:
// Spring MVCでの例外ハンドリングやバインディング結果の処理など、複数の@Controllerクラス間で共通の処理を提供するために使用される
@ControllerAdvice
class RestExceptionHandler {

    // @ExceptionHandler アノテーション:
    // 指定された例外が発生したときの共通処理を定義する
    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(ex: ResourceNotFoundException): ResponseEntity<String> {
        // レスポンスデータに例外のメッセージを、ステータスに404 を設定する
        return ResponseEntity(ex.message, HttpStatus.NOT_FOUND)
    }
}