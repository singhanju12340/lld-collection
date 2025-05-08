package com.machineCode.splitwise.models;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author anju
 * @created on 01/08/24 and 2:04 PM
 */

@Data
public class UserGroup {
    private String id;
    private List<String> user;
    private String name;
    private Long createdDate;
    boolean isActive;

}
