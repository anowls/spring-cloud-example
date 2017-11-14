package me.nibo.spring.boot.mybatis.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author NiBo
 */
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    private String name;

    private Boolean enable;

    public Role() {
    }

    public Role(String name, Boolean enable) {
        this.name = name;
        this.enable = enable;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
