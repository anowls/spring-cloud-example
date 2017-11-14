package com.hanboard.educloud.account.domain.view;


public interface UserDetailsView {
    String getUserId();

    String getUsername();

    int getAge();

    long getRoleId();

    String getRoleName();

    default String getAgeRange() {
        if (getAge() > 0 && getAge() < 6) {
            return "小孩";
        } else if (getAge() > 6 && getAge() < 16) {
            return "少年";
        } else {
            return "青年";
        }
    }

}
