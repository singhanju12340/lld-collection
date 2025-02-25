package com.machineCode.designPatterns.structural.facade;

/**
 * @author anju
 * @created on 25/02/25 and 1:55 PM
 */
public class OrderFacade {
    private InventoryService inventoryService;
    private PaymentService paymentService;
    private ShipingService shippingService;

    public OrderFacade() {
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
        this.shippingService = new ShipingService();
    }

    public void placeOrder(String accountId, String productId, int quantity, double amount, String address) {
        System.out.println("Placing order for product " + productId);

        // Step 1: Check inventory and reserve product if available.
        if (!inventoryService.checkAvailability(productId, quantity)) {
            System.out.println("Product " + productId + " is not available in required quantity.");
            return;
        }
        inventoryService.reserveProduct(productId, quantity);

        // Step 2: Process payment.
        if (!paymentService.processPayment(accountId, amount)) {
            System.out.println("Payment failed. Order cannot be placed.");
            return;
        }

        // Step 3: Ship product.
        shippingService.shipProduct(productId, quantity, address);
        System.out.println("Order placed successfully!");
    }

}
