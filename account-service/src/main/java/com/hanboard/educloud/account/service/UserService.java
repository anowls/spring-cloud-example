package com.hanboard.educloud.account.service;

import com.hanboard.educloud.account.domain.Role;
import com.hanboard.educloud.account.domain.User;
import com.hanboard.educloud.account.domain.view.UserDetailsView;
import com.hanboard.educloud.framework.web.domain.PageQuery;
import com.hanboard.educloud.framework.web.domain.SimplePage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    /**
     * 根据名称查询用户信息
     *
     * @param name 名称
     * @return 用户对象
     */
    User findByName(String name);

    /**
     * 按名称分页查询
     *
     * @param name     名称
     * @param pageable 分页对象
     * @return 分页用户对象
     */
    Page<User> findByNameLike(String name, Pageable pageable);

    /**
     * 根据名称和年龄查询用户信息
     *
     * @param name 名称
     * @param age  年龄
     * @return 用户对象
     */
    User findByNameAndAge(String name, Integer age);

    /**
     * 根据名称或年龄查询用户信息
     *
     * @param name 名称
     * @param age  年龄
     * @return 用户对象
     */
    List<User> findUser(String name, int age);

    /**
     * 保存用户信息
     *
     * @param user 用户对象
     * @return 用户对象
     */
    User save(User user);

    /**
     * 更新用户信息
     *
     * @param user 用户对象
     * @return 用户对象
     */
    User update(User user);

    void delete(String id);

    /**
     * 创建用户
     *
     * @param user 用户对象
     * @param role 角色对象
     */
    void createUser(User user, Role role);

    void updateUser(User user, Role role);

    int deleteUser(String username);

    long deleteByUsername(String username);

    int updateByUsername(String username, String newUsername);

    SimplePage<UserDetailsView> findUserDetails(PageQuery pageQuery);

    Page<UserDetailsView> findUserDetailsNativeSql(String username, String roleName, Pageable pageable);
}
