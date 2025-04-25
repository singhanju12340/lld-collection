package com.machineCode.eCommerceAppImproved;


import com.machineCode.eCommerceAppImproved.exception.ECommerceException;
import com.machineCode.eCommerceAppImproved.model.*;
import com.machineCode.eCommerceAppImproved.repository.UserRepositoty;
import com.machineCode.eCommerceAppImproved.service.AmazonUserService;
import com.machineCode.eCommerceAppImproved.service.ProductService;
import com.machineCode.eCommerceAppImproved.repository.OrderRepositoty;
import com.machineCode.eCommerceAppImproved.repository.PinCodeAvailabilityRepository;
import com.machineCode.eCommerceAppImproved.repository.ProductRepository;
import com.machineCode.eCommerceAppImproved.service.OrderService;
import com.machineCode.eCommerceAppImproved.service.decorator.GiftProductPriceDecoratorImpl;
import com.machineCode.eCommerceAppImproved.service.decorator.ProductPriceDecorator;
import com.machineCode.eCommerceAppImproved.service.factory.ExpressOrder;
import com.machineCode.eCommerceAppImproved.service.factory.PriceForGiftOrder;
import com.machineCode.eCommerceAppImproved.service.factory.OrderAmountCalculator;
import com.machineCode.eCommerceAppImproved.service.impl.AmazonUserServiceImpl;
import com.machineCode.eCommerceAppImproved.service.impl.OrderServiceImpl;
import com.machineCode.eCommerceAppImproved.service.impl.ProductServiceImpl;
import com.machineCode.eCommerceAppImproved.service.impl.stretegy.PinCodeToPayModeServiceImpl;
import com.machineCode.eCommerceAppImproved.service.strategy.PinPaymentValidationStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anju
 * @created on 24/04/25 and 9:47 AM
 */
public class ECommDriver {


    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl(new ProductRepository());
        Map<String, PinPaymentValidationStrategy> pinPaymentValidationStrategyMap = new HashMap<>();



        OrderService orderService = new OrderServiceImpl(new OrderRepositoty(), pinPaymentValidationStrategyMap, productService);
        AmazonUserService userService = new AmazonUserServiceImpl(new UserRepositoty());

        pinPaymentValidationStrategyMap.put("COD", new PinCodeToPayModeServiceImpl(new PinCodeAvailabilityRepository()));
        pinPaymentValidationStrategyMap.put("CREDIT_CARD", new PinCodeToPayModeServiceImpl(new PinCodeAvailabilityRepository()));

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

        pinPaymentValidationStrategyMap.get("COD").addPinCode("1234",pinPaymentAvailability.getPinCode(), pinPaymentAvailability.getPaymentMode());
        pinPaymentValidationStrategyMap.get("COD").addPinCode("1234",pinPaymentAvailability2.getPinCode(), pinPaymentAvailability2.getPaymentMode());


        Product product = new Product("p1", "product1",5, address, "Gift", 5000);
        // show use of decorator pattern to change product prices
        ProductPriceDecorator productPriceDecorator = new GiftProductPriceDecoratorImpl();
        product.setPrice(productPriceDecorator.getPrice(product));
        productService.addProduct(product);

        Product product1 = new Product("p2", "product2", 7, address, "Basic", 5000);

       // show factory pattern for creating order objects based on order type
        OrderAmountCalculator orderFactory = new PriceForGiftOrder();
        Order order = orderFactory.createOrder("order1", 100.0, user.getId(), product.getId(), 3, PaymentMode.COD, 124234L, user.getAddresses().getPincode() );
        orderService.placeOrder(order);

        orderFactory = new ExpressOrder();
         order = orderFactory.createOrder("order1", 100.0, user.getId(), product.getId(), 3, PaymentMode.COD, 124234L, user.getAddresses().getPincode() );
        orderService.placeOrder(order);















    }
}
