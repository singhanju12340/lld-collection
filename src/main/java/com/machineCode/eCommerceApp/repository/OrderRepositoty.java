package com.machineCode.eCommerceApp.repository;

import com.machineCode.eCommerceApp.exception.ECommerceException;
import com.machineCode.eCommerceApp.model.ErrorCode;
import com.machineCode.eCommerceApp.model.Order;
import lombok.Data;
import lombok.Synchronized;

import java.util.HashMap;
import java.util.Map;

import static com.machineCode.eCommerceApp.utils.ErrorCodeMap.errorCodeStringMap;

/**
 * @author anju
 * @created on 23/04/25 and 7:34 PM
 */

@Data
public class OrderRepositoty {
    Map<String, Order> orders = new HashMap<>();



    public Order getOrder(String orderId){
        if(orders.containsKey(orderId))
            return orders.get(orderId);
        throw new ECommerceException(ErrorCode.ORDER_DOES_NOT_EXIST, errorCodeStringMap.get(ErrorCode.ORDER_DOES_NOT_EXIST) );
    }


    public Order placeOrder(Order order){
        if(orders.get(order.getOrderId()) ==null){
            orders.put(order.getOrderId(), order);
            return order;
        }
        else
            throw new ECommerceException(ErrorCode.ORDER_CREATION_FAILED, errorCodeStringMap.get(ErrorCode.ORDER_CREATION_FAILED));
    }
}
