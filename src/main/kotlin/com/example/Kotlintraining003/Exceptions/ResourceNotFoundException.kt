package com.example.Kotlintraining003.Exceptions

/**
 * リソースが見つからなかった場合に発生する汎用の例外
 */
class ResourceNotFoundException(message: String): RuntimeException(message)
