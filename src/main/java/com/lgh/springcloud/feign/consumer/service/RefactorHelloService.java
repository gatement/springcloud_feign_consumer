package com.lgh.springcloud.feign.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService extends com.lgh.springcloud.hello.service.api.service.HelloService {

}
