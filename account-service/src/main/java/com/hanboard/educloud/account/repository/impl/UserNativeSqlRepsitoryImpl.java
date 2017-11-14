package com.hanboard.educloud.account.repository.impl;

import com.hanboard.educloud.account.repository.UserNativeSqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class UserNativeSqlRepsitoryImpl implements UserNativeSqlRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public List findUserDetails(String username) {
        return null;
//        return jdbcTemplate.queryForList("select " +
//                        "    u.id as userId," +
//                        "    u.username as username," +
//                        "    u.age as age," +
//                        "    r.id as roleId," +
//                        "    r.name as roleName " +
//                        "from " +
//                        "    `user` u left join user_role ur on " +
//                        "    u.id = ur.user_id left join `role` r on " +
//                        "    ur.role_id = r.id " +
//                        "where u.username = ?"
//                , UserDetailsView.class, username);

    }

    @Override
    public List sqlObjectList(String sql, Object obj, String username) {
        EntityManager em = emf.createEntityManager();
        return null;
//        Query query = em.createNativeQuery("select " +
//                "    u.id as userId," +
//                "    u.username as username," +
//                "    u.age as age," +
//                "    r.id as roleId," +
//                "    r.name as roleName " +
//                "from " +
//                "    `user` u left join user_role ur on " +
//                "    u.id = ur.user_id left join `role` r on " +
//                "    ur.role_id = r.id " +
//                "where u.username = ?", UserDetailsView.class);
//        query.setParameter(1, username);
//        List list = query.getResultList();
//        em.close();
//        return list;
    }
}
