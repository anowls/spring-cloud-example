package me.nibo.spring.boot.mybatis.mapper;

import me.nibo.spring.boot.mybatis.common.AbstractTestCaseSupport;
import me.nibo.spring.boot.mybatis.domain.Role;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author NiBo
 */
public class RoleMapperTest extends AbstractTestCaseSupport {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void test() {
        batchSave();
//        roleMapper.selectByExample();
//        Role role = new Role("系统管理员", true);
//        int result = roleMapper.insert(role);
//        logger.debug("处理结果：{}", result);
//        logger.debug("角色 id：{}", role.getId());
    }

    private void batchSave() {
        for (int i = 0; i < 1; i++) {
            Role role = new Role("系统管理员" + i, true);
            int result = roleMapper.insert(role);
            logger.debug("处理结果：{}", result);
            logger.debug("角色 id：{}", role.getId());
        }
    }
}
