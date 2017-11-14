package me.nibo.spring.boot.mybatis.service;

import me.nibo.spring.boot.mybatis.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author NiBo
 */
public interface UserService {
    List<User> findAll(Map<String, Object> filter, int page, int size);

    int save(User user);
}
