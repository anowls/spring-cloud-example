package me.nibo.spring.boot.jpa.repository;

import me.nibo.spring.boot.jpa.domain.User;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        userRepository.deleteAllInBatch();
    }

    @Test
    public void test() throws Exception {
        assertEquals(0, userRepository.count());
        userRepository.save(new User("小明", 20));
        userRepository.save(new User("张三", 30));
        userRepository.save(new User("李四", 25));
        userRepository.save(new User("小红", 20));
        assertEquals(4, userRepository.count());

        assertEquals(30, userRepository.findByName("张三").getAge());
        assertEquals("李四",
                userRepository.findByNameAndAge("李四", 25).getName());
        assertEquals(25,
                userRepository.findByNameAndAge("李四", 25).getAge());

        assertEquals(2, userRepository.findUser("小明", 20).size());

        userRepository.delete(userRepository.findByName("张三"));
        Long id = userRepository.findByName("小明").getId();
        userRepository.delete(id);
        assertEquals(2, userRepository.count());

        User user = userRepository.findByName("小红");
        user.setName("大红");
        user.setAge(22);
        userRepository.saveAndFlush(user);
        assertEquals(2, userRepository.count());
        assertEquals("大红", userRepository.findByName("大红").getName());
        assertEquals(22, userRepository.findByName("大红").getAge());
    }

    @Test
    public void testPage() {
        assertEquals(0, userRepository.count());
        initUserData(101);
        int page = 0;
        int size = 10;
        Pageable pageable = new PageRequest(page, size);
        Page<User> userPage = userRepository.findAll(pageable);
        logger.info(userPage.toString());
        logger.info(userPage.getContent().toString());
        assertEquals(10, userPage.getContent().size());
        assertEquals(101, userPage.getTotalElements());
        assertEquals(11, userPage.getTotalPages());
        assertEquals(size, userPage.getSize());
        logger.info("Number: {}", userPage.getNumber());
        logger.info("NumberOfElements: {}", userPage.getNumberOfElements());
        assertEquals(page, userPage.getNumber());
    }

    @Test
    public void testPageByName() {
        assertEquals(0, userRepository.count());
        initUserData(53);
        assertEquals(53, userRepository.count());
        int page = 1;
        int size = 10;
        Pageable pageable = new PageRequest(page, size);
        Page<User> userPage = userRepository.findByNameLike("小明%", pageable);
        assertEquals(10, userPage.getContent().size());
        assertEquals(53, userPage.getTotalElements());
    }

    @Ignore
    public void testDeleteAll() {
        userRepository.deleteAll();
        initUserData(100);
        userRepository.deleteAll();
    }

    @Ignore
    public void testDeleteBatch() {
        userRepository.deleteAllInBatch();
        initUserData(100);
        userRepository.deleteAllInBatch();
    }

    private void initUserData(int total) {
        User user;
        List<User> list = new ArrayList<>(total);
        for (int i = 0; i < total; i++) {
            user = new User("小明" + i, 20 + i);
            list.add(user);
        }
        userRepository.save(list);
    }

}
