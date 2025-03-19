package com.machineCode.stackOverflow;

import java.util.List;
import java.util.Map;

/**
 * @author anju
 * @created on 19/03/25 and 2:24 PM
 */
public class Entity {

    String entityId;
    Member creator;
    Map<VoteType, Integer> votes;
    List<Entity> comments;


}
