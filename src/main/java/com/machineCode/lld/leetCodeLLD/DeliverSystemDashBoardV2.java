package com.machineCode.lld.leetCodeLLD;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Ripling
// level  1 question
/**
create driver dashboard to record total due amount of driver the company has to pay.
each driver has their rate.
every time driver deliver product, calls recordDriver method to update dashboard.

driver rate are hour basis.

addDriver(Integer driverId, double rate)

recordDelivery(Integer driverId, long startTime, long endTime)
*/


//2nd follow up question.

/**
The analytics team uses the live dashboard reporting function you built to see how much money is owed in total to all drivers.

Add the following functions:

* `payUpTo (payTime [integer, Unix time from epoch])`
    - Pay all drivers for recorded deliveries which ended up to and including the given time

* `getTotalCostUnpaid()`
    - Return the total, aggregated cost of all drivers' deliveries which have not been paid

The solution does not need to be thread-safe or handle concurrency.
*/

public class DeliverSystemDashBoardV2 {





    @Data
    public class Delivery {
        private final long startTime;
        private final long endTime;
        private final BigDecimal price;
        private boolean isPaid;

        public Delivery(long startTime, long endTime, BigDecimal price, boolean isPaid) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.price = price;
            this.isPaid = isPaid;
        }


    }


    public class Driver {
        private Integer id;
        private final List<Delivery> deliveries = new ArrayList<>();
        private BigDecimal rate;


        Driver(Integer id, BigDecimal rate) {
            this.id = id;
            this.rate = rate;
        }

        public BigDecimal calculatePay(long startTimeMillis, long endTimeMillis) {
            BigDecimal millisDiff = BigDecimal.valueOf(endTimeMillis - startTimeMillis);
            BigDecimal hours = millisDiff.divide(BigDecimal.valueOf(1000.0 * 60 * 60));
            return  rate.multiply(hours);
        }


        public void addDelivery(long startTime, long endTime) {
            BigDecimal cost = calculatePay(startTime, endTime);
            deliveries.add(new Delivery(startTime, endTime, cost, false));
            // for static variables
            totalUnpaid = totalUnpaid.add(cost);
        }

        public BigDecimal payUpTo(long payTime) {
            BigDecimal totalPaid = new BigDecimal(0);
            for (Delivery delivery: deliveries) {
                if (!delivery.isPaid && delivery.getEndTime() <= payTime) {
                    delivery.isPaid = true;
                    totalPaid = totalPaid.add(delivery.getPrice());
                }
            }
            return totalPaid;
        }

        public BigDecimal getUnpaidAmount() {
            BigDecimal unpaid = new BigDecimal(0);

            for (Delivery delivery: deliveries) {
                if (!delivery.isPaid) {
                    unpaid = unpaid.add(delivery.getPrice());
                }
            }
            return unpaid;
        }


    }


    private final Map<Integer, Driver> drivers = new HashMap<>();
    private static BigDecimal totalUnpaid = new BigDecimal(0);

    public void addDriver(Integer driverId, BigDecimal hourlyRate) {
        Driver driver = new Driver(driverId,hourlyRate );
        drivers.put(driverId, driver);
    }


    public void recordDelivery(Integer driverId, long startTime, long endTime) {
        if (!drivers.containsKey(driverId)) {
            throw new IllegalArgumentException("Driver not found: " + driverId);
        }
        drivers.get(driverId).addDelivery(startTime, endTime);
    }


    public void payUpTo(long payTime) {
        BigDecimal totalPaid = new BigDecimal(0);
        for (Driver driver: drivers.values()) {
            totalPaid = totalPaid.add(driver.payUpTo(payTime));
        }
        totalUnpaid = totalUnpaid.subtract(totalPaid);
    }



    public BigDecimal getTotalCostUnpaid() {
        BigDecimal total = new BigDecimal(0);
        for (Driver driver: drivers.values()) {
            total = total.add(driver.getUnpaidAmount());
        }
        return total;
    }

    public void printDashboard() {
        for (Map.Entry<Integer, Driver> entry : drivers.entrySet()) {
            BigDecimal due = entry.getValue().getUnpaidAmount();
            System.out.printf("Driver %d: $%.2f due%n", entry.getKey(), due);
        }
    }

    public static void main(String[] args) {
        DeliverSystemDashBoardV2 dashboard = new DeliverSystemDashBoardV2();
        dashboard.addDriver(1, new BigDecimal(20.0));
        dashboard.addDriver(2, new BigDecimal(25.0));

        long now = System.currentTimeMillis();
        long oneHourLater = now + 60 * 60 * 1000;
        long twoHoursLater = now + 2 * 60 * 60 * 1000;

        // Record deliveries
        dashboard.recordDelivery(1, now, oneHourLater);        // unpaid
        dashboard.recordDelivery(2, now, twoHoursLater);       // unpaid

        System.out.println("Unpaid total: $" + dashboard.getTotalCostUnpaid());

        // Pay up to 1.5 hours
        long payTime = now + 90 * 60 * 1000;  // 1.5 hours later
        dashboard.payUpTo(payTime);

        System.out.println("After payUpTo: $");
        System.out.println(dashboard.totalUnpaid);

        dashboard.printDashboard();


        System.out.println("Remaining unpaid: $" + dashboard.getTotalCostUnpaid());

    }




}
