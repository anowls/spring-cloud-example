package me.nibo.spring.boot.jpa.repository;

import me.nibo.spring.boot.jpa.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据名称查询用户信息
     *
     * @param name 名称
     * @return 用户对象
     */
    User findByName(String name);

    /**
     * 按名称模糊分页查询
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
    @Query(value = "select u from User u where u.name = :name or u.age = :age")
    List<User> findUser(@Param("name") String name, @Param("age") int age);

}
