package com.hanboard.educloud.account.web;

import com.hanboard.educloud.account.service.UserService;
import com.hanboard.educloud.framework.web.controller.BaseController;
import com.hanboard.educloud.framework.web.domain.PageQuery;
import com.hanboard.educloud.framework.web.message.SimpleMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Value("${custom.param1}")
    private String param1;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<SimpleMessage> findUser(PageQuery pageQuery) {
        logger.info("custom.param1: {}", param1);
        return ResponseEntity.ok(SimpleMessage.info(userService.findUserDetails(pageQuery)));
    }

}
