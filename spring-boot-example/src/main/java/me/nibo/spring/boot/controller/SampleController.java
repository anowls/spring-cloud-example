package me.nibo.spring.boot.controller;

import me.nibo.spring.boot.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Value("${param}")
    private String param;

    @Autowired
    private SampleService service;

    @Qualifier("counterService")
    @Autowired
    private CounterService counterService;

    @RequestMapping("/")
    String home() {
        return "Home";
    }

    @RequestMapping("/hello")
    String hello() {
        counterService.increment("didispace.hello.count");
        System.out.println(param);
        service.test();
        return "Hello World";
    }


}