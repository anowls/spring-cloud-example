package me.nibo.spring.boot.mybatis.web;

import com.google.common.collect.Maps;
import me.nibo.spring.boot.mybatis.domain.User;
import me.nibo.spring.boot.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author NiBo
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity findUsers(@RequestParam(required = false) String username,
                                    @RequestParam(required = false) Integer age,
                                    @RequestParam(required = false) int page,
                                    @RequestParam(required = false) int size) {
        return ResponseEntity.ok(userService.findAll(Maps.newHashMap(), page, size));
//        if (Objects.isNull(age)) {
//            return ResponseEntity.ok(userMapper.findUsers(username));
//        } else {
//            return ResponseEntity.ok(userMapper.findUserByNameAndAge(username, age));
//        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveUser(@RequestBody User user) {
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        return ResponseEntity.ok(userService.save(user));
    }

}
