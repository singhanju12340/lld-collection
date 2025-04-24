package com.machineCode.threadsImpls;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anju
 * @created on 14/04/25 and 10:10 AM
 */
public class HeapMemoryTest {
    public static void main(String[] args) {
        createRecurringObjects();
    }

    private static void createRecurringObjects() {
        for (int i=0 ; i< 100; i++) {
            List<Double> list = new ArrayList<>(1000000);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
