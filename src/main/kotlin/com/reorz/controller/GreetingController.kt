package com.reorz.controller

import com.reorz.service.GreetingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


/**
 * Created by acris on 3/31/17.
 */
@RestController
class GreetingController @Autowired constructor(val greetingService: GreetingService) {
    @GetMapping("/hello")
    fun greeting(@RequestParam("name", defaultValue = "World") name: String): String {
        return greetingService.greeting(name)
    }
}