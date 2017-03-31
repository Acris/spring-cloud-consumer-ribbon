package com.reorz

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableEurekaClient
class SpringCloudConsumerRibbonApplication {
    @Bean
    @LoadBalanced
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(SpringCloudConsumerRibbonApplication::class.java, *args)
}
