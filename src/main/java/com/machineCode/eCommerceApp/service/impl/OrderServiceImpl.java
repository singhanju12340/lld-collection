package com.machineCode.eCommerceApp.service.impl;

import com.machineCode.eCommerceApp.exception.ECommerceException;
import com.machineCode.eCommerceApp.model.ErrorCode;
import com.machineCode.eCommerceApp.model.Order;
import com.machineCode.eCommerceApp.model.Product;
import com.machineCode.eCommerceApp.repository.OrderRepositoty;
import com.machineCode.eCommerceApp.service.OrderService;
import com.machineCode.eCommerceApp.service.PinCodeService;
import com.machineCode.eCommerceApp.service.ProductService;
import lombok.Data;
import lombok.Synchronized;

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
    private final PinCodeService pinCodeService;
    private final ProductService productService;
    private final Lock lock = new ReentrantLock();



    public OrderServiceImpl(OrderRepositoty orderRepositoty, PinCodeService pinCodeService, ProductService productService) {
        this.orderRepositoty = orderRepositoty;
        this.pinCodeService = pinCodeService;
        this.productService = productService;
    }

    @Override
    public Order getOrder(String orderId) {
        return orderRepositoty.getOrder(orderId);
    }

//    @Override
//    @Synchronized
    public Order placeOrdert(Order order) {
        // check if pincode is servicable
        // check if product quantity is available
        synchronized (this){
            if(productService.checkInventory(order.getQuantity(), order.getProductId())){
                String productSourcePinCode = productService.getProduct(order.getProductId()).getAddress().getPincode();
                if(pinCodeService.checkIfPinAndPaymentModeValid(productSourcePinCode, order.getUserPinCode(), order.getPaymentMode())){
                    Order placesOrder = orderRepositoty.placeOrder(order);
                    System.out.println("order places successfull for: "+ order.getOrderId());
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
                if(pinCodeService.checkIfPinAndPaymentModeValid(productSourcePinCode, order.getUserPinCode(), order.getPaymentMode())){
                    Order placesOrder = orderRepositoty.placeOrder(order);
                    System.out.println("order places successfull for: "+ order.getOrderId());
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
