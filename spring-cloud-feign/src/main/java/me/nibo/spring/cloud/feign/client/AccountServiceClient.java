package me.nibo.spring.cloud.feign.client;

import feign.hystrix.FallbackFactory;
import me.nibo.spring.cloud.feign.domain.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "account-service", fallbackFactory = AccountServiceClientFallbackFactory.class)
public interface AccountServiceClient {
    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    List<Account> findUsers();

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    Account getUserById(@PathVariable("id") String id);

    @RequestMapping(value = "/api/users/param", method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Account getUserByIdParam(@RequestParam("id") String id);

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.DELETE)
    Map deleteUser(@PathVariable("id") String id);

    @RequestMapping(value = "/api/users", method = RequestMethod.DELETE)
    Map batchDeleteUser(@RequestBody List<String> ids);

    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Account updateUser(@PathVariable("id") String id, @RequestBody Account account);

//    @RequestMapping(value = "/users/{id}", method = RequestMethod.PATCH,
//            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    Account updateUser2(@PathVariable("id") String id, @RequestBody Account account);

    @RequestMapping(value = "/api/users", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Account createUser(@RequestBody Account account);

}

@Component
class AccountServiceClientFallbackFactory implements FallbackFactory<AccountServiceClient> {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public AccountServiceClient create(Throwable e) {
        return new AccountServiceClient() {
            @Override
            public List<Account> findUsers() {
                return null;
            }

            @Override
            public Account getUserById(String id) {
                return null;
            }

            @Override
            public Account getUserByIdParam(String id) {
                return null;
            }

            @Override
            public Map deleteUser(String id) {
                return null;
            }

            @Override
            public Map batchDeleteUser(List<String> ids) {
                return null;
            }

            @Override
            public Account updateUser(String id, Account account) {
                return null;
            }

            @Override
            public Account createUser(Account account) {
                logger.info(account.toString());
                logger.error("调用创建用户服务异常", e);
                return new Account();
            }
        };
    }
}


