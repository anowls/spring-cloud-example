package com.hanboard.educloud.account.service.impl;

import com.hanboard.educloud.account.domain.Role;
import com.hanboard.educloud.account.domain.User;
import com.hanboard.educloud.account.domain.view.UserDetailsView;
import com.hanboard.educloud.account.repository.RoleRepository;
import com.hanboard.educloud.account.repository.UserRepository;
import com.hanboard.educloud.account.repository.UserRoleRepository;
import com.hanboard.educloud.account.service.UserService;
import com.hanboard.educloud.framework.web.domain.PageQuery;
import com.hanboard.educloud.framework.web.domain.SimplePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public User findByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public Page<User> findByNameLike(String name, Pageable pageable) {
        return userRepository.findByUsernameLike(name, pageable);
    }

    @Override
    public User findByNameAndAge(String name, Integer age) {
        return userRepository.findByUsernameAndAge(name, age);
    }

    @Override
    public List<User> findUser(String name, int age) {
        return userRepository.findUser(name, age);
    }


    @Transactional
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(String id) {
        userRepository.delete(id);
    }

    @Transactional
    @Override
    public void createUser(User user, Role role) {

    }

    @Transactional
    @Override
    public void updateUser(User user, Role role) {
    }

    @Transactional
    @Override
    public int updateByUsername(String username, String newUsername) {
        return userRepository.updateByUsername(username, newUsername);
    }

    @Transactional
    @Override
    public int deleteUser(String username) {
        return userRepository.deleteUser(username);
    }

    @Override
    public long deleteByUsername(String username) {
        return userRepository.deleteByUsername(username);
    }

    @Override
    public SimplePage<UserDetailsView> findUserDetails(PageQuery pageQuery) {
        Pageable pageable = pageQuery.convertToPageable();
        Map<String, String> filter = pageQuery.convertFilterToMap();
        Page<UserDetailsView> page = userRepository.findUserDetails(
                filter.get("username"), filter.get("roleName"), pageable);
        return new SimplePage<UserDetailsView>().convert(page);
    }

    @Override
    public Page<UserDetailsView> findUserDetailsNativeSql(String username, String roleName,
                                                          Pageable pageable) {
        return userRepository.findUserDetailsNativeSql(username, roleName, pageable);
    }
}
