package com.hanboard.educloud.account.repository;

import java.util.List;

public interface UserNativeSqlRepository {

    List findUserDetails(String username);

    List sqlObjectList(String sql, Object obj, String username);

}
