package com.machineCode.eCommerceApp;

import com.machineCode.eCommerceApp.exception.ECommerceException;
import com.machineCode.eCommerceApp.model.*;
import com.machineCode.eCommerceApp.repository.OrderRepositoty;
import com.machineCode.eCommerceApp.repository.PinCodeAvailabilityRepository;
import com.machineCode.eCommerceApp.repository.ProductRepository;
import com.machineCode.eCommerceApp.repository.UserRepositoty;
import com.machineCode.eCommerceApp.service.AmazonUserService;
import com.machineCode.eCommerceApp.service.OrderService;
import com.machineCode.eCommerceApp.service.PinCodeService;
import com.machineCode.eCommerceApp.service.ProductService;
import com.machineCode.eCommerceApp.service.impl.AmazonUserServiceImpl;
import com.machineCode.eCommerceApp.service.impl.OrderServiceImpl;
import com.machineCode.eCommerceApp.service.impl.PinCodeServiceImpl;
import com.machineCode.eCommerceApp.service.impl.ProductServiceImpl;

/**
 * @author anju
 * @created on 24/04/25 and 9:47 AM
 */
public class ECommDriver {


    public static void main(String[] args) {
        PinCodeService pinCodeService = new PinCodeServiceImpl(new PinCodeAvailabilityRepository());
        ProductService productService = new ProductServiceImpl(new ProductRepository());
        OrderService orderService = new OrderServiceImpl(new OrderRepositoty(), pinCodeService, productService);
        AmazonUserService userService = new AmazonUserServiceImpl(new UserRepositoty());


        //1234 hyd oin code
        // 5687 bangalore pin code

        Address address = new Address("add1", "Hyd", "l2", "1234", "34234234", "2432342");
        Address address2 = new Address("add2", "Bangalore", "l2", "5678", "34234234", "2432342");


        AmazonUser user = new AmazonUser("Anju", "anju1", address2);
        AmazonUser user1 = new AmazonUser("Santosh","santosh1", address);
        userService.addUser(user);
        userService.addUser(user1);


        PinPaymentAvailability pinPaymentAvailability = new PinPaymentAvailability( "5678", PaymentMode.COD);
        PinPaymentAvailability pinPaymentAvailability2 = new PinPaymentAvailability( "1234", PaymentMode.CREDIT_CARD);

        pinCodeService.addPinCode("1234",pinPaymentAvailability.getPinCode(), pinPaymentAvailability.getPaymentMode());
        pinCodeService.addPinCode("1234",pinPaymentAvailability2.getPinCode(), pinPaymentAvailability2.getPaymentMode());


        Product product = new Product("p1", "product1",5, address);
        productService.addProduct(product);

        Product product1 = new Product("p2", "product2", 7, address);

        // success
        Order order = Order.builder()
                .userId("user1")
                .orderId("order1")
                .billAmount(100.0)
                .userPinCode(user.getAddresses().getPincode())
                .date(124234L)
                .productId(product.getId())
                .paymentMode(PaymentMode.COD)
                .quantity(3)
                .build();


        // fail due to invalid quantity
        Order order2 = Order.builder()
                .userId("user2")
                .orderId("order2")
                .billAmount(100.0)
                .userPinCode(user.getAddresses().getPincode())
                .date(124234L)
                .productId(product.getId())
                .paymentMode(PaymentMode.COD)
                .quantity(8)
                .build();


// fail due to non matching payment mode
        Order order3 = Order.builder()
                .userId("user2")
                .orderId("order2")
                .billAmount(100.0)
                .userPinCode(user.getAddresses().getPincode())
                .date(124234L)
                .productId(product.getId())
                .paymentMode(PaymentMode.CREDIT_CARD)
                .quantity(1)
                .build();


        // fail due to non matching payment mode
        Order order4 = Order.builder()
                .userId("user2")
                .orderId("order2")
                .billAmount(100.0)
                .userPinCode(user1.getAddresses().getPincode())
                .date(124234L)
                .productId(product.getId())
                .paymentMode(PaymentMode.COD)
                .quantity(1)
                .build();

        try{
            orderService.placeOrder(order);
            System.out.println("order is success full "+ order.getOrderId());
//            orderService.placeOrder(order2);
//            orderService.placeOrder(order3);
            orderService.placeOrder(order4);

        }catch (ECommerceException e){
            System.out.println(e.getErrorCode() + " : " +e.getErrorMessage());
        }














    }
}
