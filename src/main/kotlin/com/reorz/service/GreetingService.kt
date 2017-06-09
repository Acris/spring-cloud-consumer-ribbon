package com.reorz.service

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

/**
 * Created by Acris on 2017/6/9.
 */
@Service
class GreetingService @Autowired constructor(val restTemplate: RestTemplate) {

    @HystrixCommand(fallbackMethod = "greetingFallback")
    fun greeting(name: String): String {
        return restTemplate.getForObject("http://spring-cloud-provider/greeting?name=$name", String::class.java)
    }

    fun greetingFallback(name: String): String {
        return "Service is Offline. Request parameter name = $name"
    }
}