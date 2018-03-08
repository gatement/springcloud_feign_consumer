package com.lgh.springcloud.feign.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lgh.springcloud.feign.consumer.service.HelloService;
import com.lgh.springcloud.feign.consumer.service.RefactorHelloService;
import com.lgh.springcloud.hello.service.api.dto.User;

@RestController
public class ConsumerController {
	@Autowired
	HelloService helloService;
	@Autowired
	RefactorHelloService refactorHelloService;

	@RequestMapping(value = "feign-consumer", method = RequestMethod.GET)
	public String helloConsumer2() {
		StringBuilder sb = new StringBuilder();
		sb.append(helloService.hello()).append("\n");
		sb.append(helloService.hello("Johnson")).append("\n");
		sb.append(helloService.hello("Johnson", 30)).append("\n");
		sb.append(helloService.hello(new User("Johnson", 30))).append("\n");
		return sb.toString();
	}

	@RequestMapping(value = "feign-consumer2", method = RequestMethod.GET)
	public String helloConsumer3() {
		StringBuilder sb = new StringBuilder();
		sb.append(refactorHelloService.hello("JohnsonLau")).append("\n");
		sb.append(refactorHelloService.hello("JohnsonLau", 30)).append("\n");
		sb.append(refactorHelloService.hello(new com.lgh.springcloud.hello.service.api.dto.User("JohnsonLau", 30))).append("\n");
		return sb.toString();
	}
}
