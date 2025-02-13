package com.machineCode.splitwise.command;

import com.machineCode.splitwise.ExpenseDataManager;
import com.machineCode.splitwise.models.User;

import java.time.Instant;

/**
 * @author anju
 * @created on 01/08/24 and 4:52 PM
 */
public class AddUser extends SplitCommand {

    private static AddUser addUser;
    public static synchronized AddUser getInstance(){
        if(addUser == null)
            addUser = new AddUser();
        return addUser;
    }

    @Override
    public void execute(ExpenseDataManager manager, String[] inputs) {
        String name = inputs[1];
        String email = inputs[2];
        manager.addUser(new User(name, email, Instant.now().toEpochMilli()));

    }

    @Override
    public boolean validate(String[] inputs) {
        return inputs.length == 3;
    }
}
