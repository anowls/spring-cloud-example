package com.hanboard.educloud.account.service.impl;

import com.hanboard.educloud.account.service.UserRoleService;
import com.hanboard.educloud.account.domain.UserRole;
import com.hanboard.educloud.account.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }


}
