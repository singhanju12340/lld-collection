package com.machineCode.splitwise.repository;

import com.machineCode.splitwise.models.UserGroup;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author anju
 * @created on 05/05/25 and 3:26 PM
 */
public class UserGroupRepository {
    private Map<String, UserGroup> userGroups = new HashMap<>();

    public Set<UserGroup> getAllGroupOfUser(String userId){
        return this.userGroups.values().stream()
                .filter(stringUserGroup -> stringUserGroup.getUser().contains(userId))
                .collect(Collectors.toSet());
    }

    public UserGroup getGroupOfUser(String userId){
        return userGroups.get(userId);
    }

    public void addGroup(UserGroup group){
        this.userGroups.put(group.getId(), group);
    }
}
