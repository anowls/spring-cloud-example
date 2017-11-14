package me.nibo.spring.boot.mybatis.mapper;

import me.nibo.spring.boot.mybatis.domain.User;
import me.nibo.spring.boot.mybatis.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author NiBo
 */
@Mapper
public interface UserMapper extends MyMapper<User> {
    @Select({"SELECT t.id, t.username, t.age FROM user t WHERE t.username = #{username}"})
    List<User> findUsers(String username);

    List<User> findUserByNameAndAge(@Param("username") String username, @Param("age") Integer age);

    @Override
    int insert(User record);

    //    User save(User user);
//    @Insert("INSERT INTO user ()")
//    @SelectKey()
//    User insert(User user);

}
