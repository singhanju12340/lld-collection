package com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.models;

import lombok.Data;

/**
 * @author anju
 * @created on 01/08/24 and 11:57 AM
 */

@Data
public class User {
    String id;
    String name;
    String email;
    Long createdDate;

    public User(String id, String name, Long createDate){
        this.id = id;
        this.name = name;
        this.createdDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }
}
