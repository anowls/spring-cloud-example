package com.hanboard.educloud.account.web.api;

import com.hanboard.educloud.account.service.UserService;
import com.hanboard.educloud.framework.web.controller.BaseController;
import com.hanboard.educloud.account.domain.User;
import com.hanboard.educloud.account.repository.UserRepository;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/users")
public class UserApiController extends BaseController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "{username}", method = RequestMethod.GET)
    public ResponseEntity getUserByUsername(@PathVariable String username) {
        logger.info("GET /api/users/{}", username);
        return ResponseEntity.ok(userService.findByName(username));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> users() {
        logger.info("GET /api/users");
        logger.info("用户 ip：{}", getUserIp());
        User user = new User();
        user.setId("aaaaaaaa");
        user.setPassword("Richard");
        user.setPassword("abc123");
        user.setAge(28);
        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }

    @RequestMapping(value = "param", method = RequestMethod.GET)
    public User getUserById(@RequestParam String id) {
        logger.info("GET /api/users, id: {}", id);
        User user = new User();
        user.setId(id);
        user.setPassword("Richard");
        user.setPassword("password123");
        user.setAge(11);
        return user;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> delete(@PathVariable String id) {
        logger.info("DELETE /api/users/{}", id);

        userService.delete(id);

        Map<String, Object> result = new HashMap<>();
        result.put("message", "删除成功，id：" + id);
        result.put("status", "success");
        return ResponseEntity.ok(result);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> batchDelete(@RequestBody List<String> ids) {
        logger.info("DELETE /api/users, ids: {}", ids);

        Map<String, Object> result = new HashMap<>();
        result.put("message", "删除成功，ids：" + ids.toString());
        result.put("status", "success");
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody User user) {
        logger.info("PUT /api/users/{}", id);
        if (user != null) {
            logger.info(user.toString());
            user.setId(id);
        } else {
            logger.info("User 对象为 Null");
        }
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public ResponseEntity<User> update2(@PathVariable String id, @RequestBody User user) {
        logger.info("PATCH /api/users/{}", id);
        if (user != null) {
            logger.info(user.toString());
            user.setId(id);
        } else {
            logger.info("User 对象为 Null");
        }
        return ResponseEntity.ok(user);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody User user) throws InterruptedException {

        // region 测试 Hystrix 调用服务超时的断路保护
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:{}", sleepTime);
        Thread.sleep(sleepTime);
        // endregion

        logger.info("POST /api/users");
        if (user == null) {
            logger.info("User 对象为 Null");
            return ResponseEntity.ok(new User());
        }
//        User result = userService.save(user);
        User result = new User("test", "aaa", 32);
        return ResponseEntity.ok(result);
    }
}
