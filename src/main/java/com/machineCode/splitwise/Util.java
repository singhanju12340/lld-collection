package com.machineCode.splitwise;

import com.machineCode.splitwise.dto.GroupDetail;
import com.machineCode.splitwise.dto.TransactionRecord;
import com.machineCode.splitwise.models.Expense;
import com.machineCode.splitwise.models.UserGroup;
import com.machineCode.splitwise.services.GroupTxnService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author anju
 * @created on 05/05/25 and 9:44 PM
 */

public class Util {
    private GroupTxnService groupTxnService;

    public Util(GroupTxnService groupTxnService) {
        this.groupTxnService = groupTxnService;
    }

    public Set<GroupDetail> createGroupDetails(String userId){
        Set<GroupDetail> result = new HashSet<>();
        Map<String, List<Expense>> allGroupExpences = groupTxnService.getUserGroupsTxn(userId);
        for (Map.Entry<String, List<Expense>> groupExpences:allGroupExpences.entrySet()) {
            String grouoId = groupExpences.getKey();

            List<Expense> expenses = groupExpences.getValue();

            UserGroup userGroup = groupTxnService.getUserGroup(grouoId);
            GroupDetail groupDetail = new GroupDetail();
            groupDetail.setUserGroup(userGroup);

            List<TransactionRecord> txns = createExpencesSheet(expenses);
            groupDetail.setRecordList(txns);
            result.add(groupDetail);
        }
        return result;
    }



    public List<TransactionRecord> createExpencesSheet(List<Expense> expenses) {
        return expenses.stream()
                .flatMap(expense ->
                        expense.getSplitList().stream()
                                .map(split -> {
                                    TransactionRecord record = new TransactionRecord();
                                    record.setPayer(expense.getPaidBy());
                                    record.setPayee(split.getUserId());
                                    record.setAmount(split.getAmount());
                                    record.setExpenseId(expense.getId());
                                    return record;
                                })
                )
                .collect(Collectors.toList());
    }



}
