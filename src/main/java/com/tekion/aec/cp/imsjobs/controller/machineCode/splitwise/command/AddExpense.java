package com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.command;

import com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.ExpenseDataManager;
import com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.models.*;
import com.tekion.aec.cp.imsjobs.controller.machineCode.splitwise.services.SplitServiceFactory;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 01/08/24 and 4:48 PM
 */
public class AddExpense extends SplitCommand {
    private static AddExpense addExpense;

    public static synchronized AddExpense getInstance(){
        if(addExpense == null)
        {
            addExpense = new AddExpense();
        }
        return addExpense;
    }

    public void execute(ExpenseDataManager manager, String[] inputs){
        try {
            String expenseName = inputs[1];
            double amountExpend = Double.parseDouble(inputs[2]);
            String paidBy = inputs[2];
            String createdBy = inputs[3];
            int totalUser = Integer.getInteger(inputs[4]);
            String expenseType = inputs[5];

            Expense expense = new Expense();
            expense.setDate(Instant.now().getEpochSecond());
            expense.setLabel(expenseName);
            expense.setPayId(paidBy);

            expense.setTotalAmount(amountExpend);
            expense.setType(SplitType.valueOf(expenseType));
            // get user list from index 6 to 6+totalUser-1;
            List<Split> splitList = new ArrayList<>();
            List<String> userToShare = new ArrayList<>();

            for (int i = 6; i < 6 + totalUser - 1; i++) {
                userToShare.add(inputs[i]);
            }

            // decide type of split
            // create splitList

            expense.setSplitList(SplitServiceFactory.getInstance().execute(SplitType.valueOf(expenseType), expense));
        }catch (Exception e){
            System.out.println("Failed to execute task :"+ inputs[0]);
            System.out.println(e);
        }
    }

    @Override
    public boolean validate(String[] inputs) {
        // validate each index as string and int or double value based on the definition
        //Add_Expense Cable 100 1 1 3 Exact 1 2 3 40 50 10
        return true;
    }


}
