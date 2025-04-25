package com.machineCode.eCommerceAppImproved.service.impl;

import com.machineCode.eCommerceAppImproved.exception.ECommerceException;
import com.machineCode.eCommerceAppImproved.model.ErrorCode;
import com.machineCode.eCommerceAppImproved.model.Order;
import com.machineCode.eCommerceAppImproved.repository.OrderRepositoty;
import com.machineCode.eCommerceAppImproved.service.OrderService;
import com.machineCode.eCommerceAppImproved.service.ProductService;
import com.machineCode.eCommerceAppImproved.service.observer.OrderObserverHandler;
import com.machineCode.eCommerceAppImproved.service.strategy.PinPaymentValidationStrategy;
import lombok.Data;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.machineCode.eCommerceApp.utils.ErrorCodeMap.errorCodeStringMap;

/**
 * @author anju
 * @created on 23/04/25 and 9:24 PM
 */

@Data
public class OrderServiceImpl implements OrderService {
    private final OrderRepositoty orderRepositoty;
    private final ProductService productService;
    private final Lock lock = new ReentrantLock();
    private final Map<String,PinPaymentValidationStrategy> paymentValidationStrategy;
    private final OrderObserverHandler orderObserverHandler;




    public OrderServiceImpl(OrderRepositoty orderRepositoty, Map<String,PinPaymentValidationStrategy> paymentValidationStrategy, ProductService productService) {
        this.orderRepositoty = orderRepositoty;
        this.paymentValidationStrategy = paymentValidationStrategy;
        this.productService = productService;
        this.orderObserverHandler = new OrderObserverHandler();
    }



    @Override
    public Order getOrder(String orderId) {
        return orderRepositoty.getOrder(orderId);
    }

    //    @Override
//    @Synchronized // this is for learning
    public Order placeOrdert(Order order) {
        // check if pincode is servicable
        // check if product quantity is available
        synchronized (this){
            if(productService.checkInventory(order.getQuantity(), order.getProductId())){
                String productSourcePinCode = productService.getProduct(order.getProductId()).getAddress().getPincode();
                if(paymentValidationStrategy.get(order.getPaymentMode()).validate(productSourcePinCode, order.getUserPinCode(), order.getPaymentMode())){
                    Order placesOrder = orderRepositoty.placeOrder(order);
                    orderObserverHandler.notify(order);
                    return placesOrder;
                }else{
                    throw new ECommerceException(ErrorCode.PINCODE_UNSERVICEABLE,errorCodeStringMap.get(ErrorCode.PINCODE_UNSERVICEABLE));
                }
            }else{
                throw new ECommerceException(ErrorCode.IN_SUFFICIENT_INVENTORY,errorCodeStringMap.get(ErrorCode.IN_SUFFICIENT_INVENTORY)+" : " +order.getOrderId());
            }
        }


    }

    @Override
    public Order placeOrder(Order order) {
        // check if pincode is servicable
        // check if product quantity is available
        lock.lock();
        try {
            if(productService.checkInventory(order.getQuantity(), order.getProductId())){
                String productSourcePinCode = productService.getProduct(order.getProductId()).getAddress().getPincode();
                if(paymentValidationStrategy.get(order.getPaymentMode()).validate(productSourcePinCode, order.getUserPinCode(), order.getPaymentMode())){
                    Order placesOrder = orderRepositoty.placeOrder(order);
                    orderObserverHandler.notify(order);
                    return placesOrder;
                }else{
                    throw new ECommerceException(ErrorCode.PINCODE_UNSERVICEABLE,errorCodeStringMap.get(ErrorCode.PINCODE_UNSERVICEABLE));
                }
            }else{
                throw new ECommerceException(ErrorCode.IN_SUFFICIENT_INVENTORY,errorCodeStringMap.get(ErrorCode.IN_SUFFICIENT_INVENTORY)+" : " +order.getOrderId());
            }
        }finally {
            lock.unlock();
        }
    }
}
