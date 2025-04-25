package com.machineCode.eCommerceAppImproved.service.observer;

import com.machineCode.eCommerceAppImproved.model.AmazonUser;
import com.machineCode.eCommerceAppImproved.model.Order;
import com.machineCode.eCommerceAppImproved.repository.UserRepositoty;

/**
 * @author anju
 * @created on 24/04/25 and 12:38 PM
 */
public class SendUserOrderUpdateObserverImpl implements OrderObserver {
    UserRepositoty repositoty;
    // notificationService

    @Override
    public void update(Order order) {
        AmazonUser user = repositoty.getUSer(order.getUserId());
        System.out.println("order places successfull for: "+ order.getOrderId());
        // send update to user via notification service
    }
}
