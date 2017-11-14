package me.nibo.spring.cloud.ribbon.controller;

import me.nibo.spring.cloud.ribbon.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class ConsumerController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RestTemplate restTemplate;



    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers() {
        String result = restTemplate.getForEntity("http://ACCOUNT-SERVICE/users", String.class)
                .getBody();
        logger.info(result);
        return result;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable String id) {
        Map result = restTemplate.getForEntity("http://ACCOUNT-SERVICE/users/{1}",
                Map.class, id).getBody();
        logger.info(result.toString());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Account> saveUser(@RequestBody Account account) {
        Account result = restTemplate
                .postForEntity("http://ACCOUNT-SERVICE/users", account, Account.class).getBody();
        logger.info(result.toString());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/users2", method = RequestMethod.POST)
    public ResponseEntity<Account> saveUser2(@RequestBody Account account) {
        Account result = restTemplate
                .postForObject("http://ACCOUNT-SERVICE/users", account, Account.class);
        logger.info(result.toString());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@PathVariable String id, @RequestBody Account account) {
        restTemplate.put("http://ACCOUNT-SERVICE/users/{1}", account, id);
        logger.info("更新用户信息");
        return ResponseEntity.ok("用户信息更新成功");
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable String id) {
        restTemplate.delete("http://ACCOUNT-SERVICE/users/{1}", id);
        logger.info("删除用户信息");
        return ResponseEntity.ok("用户信息删除成功");
    }
}
