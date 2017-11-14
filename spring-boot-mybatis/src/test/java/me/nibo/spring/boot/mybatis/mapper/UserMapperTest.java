package me.nibo.spring.boot.mybatis.mapper;

import me.nibo.spring.boot.mybatis.common.AbstractTestCaseSupport;
import me.nibo.spring.boot.mybatis.domain.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * @author NiBo
 */
public class UserMapperTest extends AbstractTestCaseSupport {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
//        initData(23);

//        logger.debug(userMapper.selectAll().toString());
        User user = new User(UUID.randomUUID().toString().replace("-", ""),
                "小明ssssss", "abc", 20);
        int result = userMapper.insert(user);
        logger.debug("处理结果：{}", result);
        logger.debug("用户 id：{}", user.getId());

//        logger.debug(userMapper.findUsers("小明").toString());
//        MapperHelper mapperHelper = new MapperHelper();
//        Config config = new Config();
//        config.setUUID();
//        config.setIDENTITY("");
//        config.setBEFORE(true);
//        config.setOrder("BEFORE");
//
//
//
//        mapperHelper.setConfig(config);

//        logger.debug(userMapper.selectAll().toString());
//        userMapper.updateByPrimaryKey()
//        User user = new User("张三", "abc", 20);
//        logger.debug("处理结果：{}", userMapper.insert(user));
//        logger.debug("用户 id：{}", user.getId());
    }

    private void initData(int record) {
        for (int i = 0; i < record; i++) {
            userMapper.insert(
                    new User(UUID.randomUUID().toString().replace("-", ""),
                            "小明" + i, "abc" + i, 10 + i));
        }
    }

}
