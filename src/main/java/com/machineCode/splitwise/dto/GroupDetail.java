package com.machineCode.splitwise.dto;

import com.machineCode.splitwise.models.UserGroup;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author anju
 * @created on 05/05/25 and 9:40 PM
 */

@Data
public class GroupDetail {
    UserGroup UserGroup;
    List<TransactionRecord> recordList;
}
