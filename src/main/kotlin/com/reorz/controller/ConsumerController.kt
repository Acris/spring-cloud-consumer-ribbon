package com.reorz.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate


/**
 * Created by acris on 3/31/17.
 */
@RestController
class ConsumerController @Autowired constructor(val restTemplate: RestTemplate) {
    @GetMapping("/hello")
    fun greeting(@RequestParam("name", defaultValue = "World") name: String): String {
        return restTemplate.getForObject("http://spring-cloud-provider/greeting?name=$name", String::class.java)
    }
}