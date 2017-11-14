package com.hanboard.educloud.account.service;

import com.hanboard.educloud.account.common.AbstractTestCaseSupport;
import com.hanboard.educloud.account.domain.User;
import com.hanboard.educloud.account.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import static org.junit.Assert.assertEquals;

public class UserServiceImplTest extends AbstractTestCaseSupport {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        userRepository.deleteAllInBatch();
    }

    @Test
    public void testFindByName() {

        assertEquals(0, userRepository.count());
        userService.save(new User("小明", "aaaa", 20));
        userService.save(new User("小红", "ddddd", 18));
        assertEquals(2, userRepository.count());

        userService.findByName("小明");


        Page<User> page = userService.findByNameLike("", null);
//        page
    }
}
