package me.nibo.spring.cloud.feign.web;

import me.nibo.spring.cloud.feign.client.AccountServiceClient;
import me.nibo.spring.cloud.feign.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ConsumerController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AccountServiceClient accountServiceClient;

    @RequestMapping(value = "/feign/users", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getUsers() {
        List<Account> list = accountServiceClient.findUsers();
        logger.info(list.toString());
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "/feign/users/{id}", method = RequestMethod.GET)
    public ResponseEntity getUserById(@PathVariable String id) {
        Account account = accountServiceClient.getUserById(id);
        logger.info(account.toString());
        return ResponseEntity.ok(account);
    }

    @RequestMapping(value = "/feign/users/param", method = RequestMethod.GET)
    public ResponseEntity getUserByIdParam(@RequestParam String id) {
        Account account = accountServiceClient.getUserByIdParam(id);
        logger.info(account.toString());
        return ResponseEntity.ok(account);
    }

    @RequestMapping(value = "/feign/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable String id) {
        Map result = accountServiceClient.deleteUser(id);
        logger.info(result.toString());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/feign/users", method = RequestMethod.DELETE)
    public ResponseEntity batchDeleteUser(@RequestBody List<String> ids) {
        Map result = accountServiceClient.batchDeleteUser(ids);
        logger.info(result.toString());
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/feign/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@PathVariable String id, @RequestBody Account account) {
        Account result = accountServiceClient.updateUser(id, account);
        logger.info(result.toString());
        return ResponseEntity.ok(result);
    }

//    @RequestMapping(value = "/feign/users/{id}", method = RequestMethod.PATCH)
//    public ResponseEntity updateUser2(@PathVariable String id, @RequestBody Account account) {
//        Account result = accountServiceClient.updateUser2(id, account);
//        logger.info(result.toString());
//        return ResponseEntity.ok(result);
//    }

    @RequestMapping(value = "/feign/users", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody Account account) {
        Account result = accountServiceClient.createUser(account);
        logger.info(result.toString());
        return ResponseEntity.ok(result);
    }

}
