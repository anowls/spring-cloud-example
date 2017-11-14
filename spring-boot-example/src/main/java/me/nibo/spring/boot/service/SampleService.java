package me.nibo.spring.boot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SampleService {
    @Value("${param}")
    private String param;

    public void test() {
        System.out.println(param);
    }
}
