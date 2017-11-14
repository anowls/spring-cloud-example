package com.hanboard.educloud.account.service.impl;

import com.hanboard.educloud.account.domain.Role;
import com.hanboard.educloud.account.repository.RoleRepository;
import com.hanboard.educloud.account.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
}
