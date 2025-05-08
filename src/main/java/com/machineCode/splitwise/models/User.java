package com.machineCode.splitwise.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.Instant;

/**
 * @author anju
 * @created on 01/08/24 and 11:57 AM
 */

@Data
@JsonIgnoreProperties
public class User {
    private String id;
    private String name;
    private String email;
    private Long createdDate;
    private double overallBalance;

    public User(String id, String name){
        this.id = id;
        this.name = name;
        this.createdDate = Instant.now().getEpochSecond();
    }

    public User(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.createdDate = Instant.now().getEpochSecond();
    }

    public User(String id, String name, Long email){
        this.id = id;
        this.name = name;
        this.createdDate = Instant.now().getEpochSecond();
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
