package me.nibo.spring.boot.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.nibo.spring.boot.mybatis.domain.User;
import me.nibo.spring.boot.mybatis.mapper.UserMapper;
import me.nibo.spring.boot.mybatis.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author NiBo
 */
@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll(Map<String, Object> filter, int page, int size) {
        if (page > 0 && size > 0) {
            PageHelper.startPage(page, size);
        }
        List<User> list = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(list);

        logger.debug("记录总数：{}", pageInfo.getTotal());
        logger.debug("总页数：{}", pageInfo.getPages());
        logger.debug("当前页数：{}", pageInfo.getPageNum());
        logger.debug("下一页：{}", pageInfo.getNextPage());
        logger.debug("每页记录数：{}", pageInfo.getPageSize());
        return null;
    }

    @Override
    public int save(User user) {
        int result = userMapper.insert(user);

        logger.debug("用户 id：{}", user.getId());
        return result;
    }

}
