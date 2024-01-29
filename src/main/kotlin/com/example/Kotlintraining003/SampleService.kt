package com.example.Kotlintraining003

import org.springframework.stereotype.Service

// @Service: Spring Bootで、サービス層として扱われるクラス
@Service
class SampleService {
    fun getSample(): String{
        return "GET response"
    }
    fun postSample(): String{
        return "POST response"
    }
    fun putSample(): String{
        return "PUT response"
    }
    fun deleteSample(): String{
        return "DELETE response"
    }
}