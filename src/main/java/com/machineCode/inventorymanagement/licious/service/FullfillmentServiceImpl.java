package com.machineCode.inventorymanagement.licious.service;

import com.machineCode.inventorymanagement.licious.exception.LiciousOrderException;
import com.machineCode.inventorymanagement.licious.model.FulfillmentCenter;
import com.machineCode.inventorymanagement.licious.model.LOrder;
import com.machineCode.inventorymanagement.licious.repository.FullfillmenetRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.machineCode.inventorymanagement.licious.utils.LocationService.getDeliveryTime;

/**
 * @author anju
 * @created on 26/04/25 and 4:12 PM
 */
public class FullfillmentServiceImpl implements FulfillmentService {
    private FullfillmenetRepository fulfillmentRepository;

    public FullfillmentServiceImpl(FullfillmenetRepository fulfillmentRepository) {
        this.fulfillmentRepository = fulfillmentRepository;
    }
    @Override
    public boolean canfullfill(LOrder order) {
        List<FulfillmentCenter> fcs = fulfillmentRepository.getMatchingFullfillmentCenter(order.getProductId(), order.getQuantity(), order.getDeliveryAddress());
        if(fcs.isEmpty()) {
            // can throw exception
            return false;
        }
        return true;
    }

    @Override
    public void fulfillOrder(LOrder order) throws LiciousOrderException {
        List<FulfillmentCenter> fcs = fulfillmentRepository.getMatchingFullfillmentCenter(order.getProductId(), order.getQuantity(), order.getDeliveryAddress());

        // find min list
        if(fcs.isEmpty()) {
            // can throw exception
            throw new LiciousOrderException("204", "Fulfillment center not found");
        }
        FulfillmentCenter nearestFc = fcs.stream()
                .min(Comparator.comparing(fc -> getDeliveryTime(order.getDeliveryAddress(), fc.getAddress())))
                .get();

        // update fullfillment center
        synchronized (this) {
            int currentCount = nearestFc.getInventory().get(order.getProductId());
            nearestFc.getInventory().put(order.getProductId(), currentCount - order.getQuantity());
            fulfillmentRepository.updateFulfillmentCenter(nearestFc);
        }
    }


}
