package com.hanboard.educloud.account.repository;

import com.hanboard.educloud.account.domain.User;
import com.hanboard.educloud.account.domain.view.UserDetailsView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * 根据名称查询用户信息
     *
     * @param name 名称
     * @return 用户对象
     */
    User findByUsername(String name);

    /**
     * 按名称模糊分页查询
     *
     * @param name     名称
     * @param pageable 分页对象
     * @return 分页用户对象
     */
    Page<User> findByUsernameLike(String name, Pageable pageable);

    /**
     * 根据名称和年龄查询用户信息
     *
     * @param name 名称
     * @param age  年龄
     * @return 用户对象
     */
    User findByUsernameAndAge(String name, Integer age);


    String findUserSql = "select u from User u where u.username = :name or u.age = :age";

    /**
     * 根据名称或年龄查询用户信息
     *
     * @param name 名称
     * @param age  年龄
     * @return 用户对象
     */
    @Query(value = findUserSql)
    List<User> findUser(@Param("name") String name, @Param("age") int age);

    @Modifying
    long deleteByUsername(String username);

    @Modifying
    @Query("update User u set u.username = :newUsername where u.username = :username")
    int updateByUsername(@Param("username") String username,
                         @Param("newUsername") String newUsername);

    @Modifying
    @Query("delete from User u where u.username = ?1")
    int deleteUser(String username);

    // JPQL 语句
    String baseSql = "select u.id as userId, u.username as username, u.age as age, r.id as roleId, r.name as roleName from " +
            "User u, UserRole ur, Role r " +
            "where u.id = ur.userId and ur.roleId = r.id";

    // 原生 SQl
    String baseNativeSql = "select u.id as userId, u.username as username, u.age as age, r.id as roleId, r.name as roleName from `user` u " +
            "left join user_role ur on u.id = ur.user_id " +
            "left join `role` r on ur.role_id = r.id ";

    @Query(baseSql + " and u.username = ?1 and r.name = ?2")
    Page<UserDetailsView> findUserDetails(String username, String roleName, Pageable pageable);


    @Query(value = baseNativeSql + " where u.username = ?1 and r.name = ?2 ORDER BY ?#{#pageable}",
            countQuery = "SELECT count(*) FROM `user` u WHERE u.username = ?1 ORDER BY ?#{#pageable}",
            nativeQuery = true)
    Page<UserDetailsView> findUserDetailsNativeSql(String username, String roleName,
                                                   Pageable pageable);

}
