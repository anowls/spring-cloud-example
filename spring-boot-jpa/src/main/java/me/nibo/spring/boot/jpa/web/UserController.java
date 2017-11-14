package me.nibo.spring.boot.jpa.web;

import me.nibo.spring.boot.jpa.domain.User;
import me.nibo.spring.boot.jpa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public ResponseEntity findUserByName(@PathVariable String name) {
        User user = userService.findByName(name);
        logger.info(user.toString());
        return ResponseEntity.ok(user);
    }
}
