package me.nibo.spring.boot.mybatis.mapper;

import me.nibo.spring.boot.mybatis.domain.Role;
import me.nibo.spring.boot.mybatis.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author NiBo
 */
@Mapper
public interface RoleMapper extends MyMapper<Role> {
}
