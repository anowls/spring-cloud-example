package me.nibo.spring.cloud.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import me.nibo.spring.cloud.hystrix.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(
            commandKey = "addUser",
            fallbackMethod = "addUserFallback",
            commandProperties = {
                    // 配置具体实例的 HystrixCommand 命令执行超时时间，单位毫秒
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                            value = "3000")
            }
    )
    public Account addUser(Account account) {
        long startTime = System.currentTimeMillis();
        Account result = restTemplate
                .postForEntity("http://ACCOUNT-SERVICE/users", account, Account.class).getBody();
        long endTime = System.currentTimeMillis();
        logger.info("Spend time: {} ms", endTime - startTime);
        return result;
    }

    private Account addUserFallback(Account account, Throwable e) {
        logger.info(account != null ? account.toString() : "");
        logger.error("用户添加服务调用失败", e);
        return new Account();
    }

    @CacheResult
    @HystrixCommand(commandKey = "getUserById")
    public Account getUserById(String id) {
        return restTemplate.getForObject("http://ACCOUNT-SERVICE/users/{1}",
                Account.class, id);
    }
}
