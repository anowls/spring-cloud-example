package com.hanboard.educloud.account.repository;

import com.hanboard.educloud.account.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Modifying
    @Query("update Role r set r.name = ?2 where r.name = ?1")
    int updateRole(String oldName, String newName);
}
