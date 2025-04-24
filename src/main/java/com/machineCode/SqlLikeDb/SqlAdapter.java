package com.machineCode.SqlLikeDb;

import com.machineCode.SqlLikeDb.model.Database;
import com.machineCode.SqlLikeDb.model.Schema;
import com.machineCode.SqlLikeDb.model.Table;
import com.machineCode.SqlLikeDb.service.*;

/**
 * @author anju
 * @created on 19/04/25 and 7:58 PM
 */


public class SqlAdapter {







    public static void main(String[] args) throws Exception {
        SqlService sqlService = SqlService.getInstance();
        sqlService.addDatabase(new Database("myDb"));
        sqlService.addTable("myDb",  new Table(new Schema(), "payment"));



        try {





        }catch (Exception e){
            System.out.println(e);
        }
    }
}
