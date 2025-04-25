package com.machineCode.eCommerceAppImproved.repository;

import com.machineCode.eCommerceAppImproved.model.PinPaymentAvailability;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anju
 * @created on 23/04/25 and 9:02 PM
 */
public class PinCodeAvailabilityRepository {

    private static Map<String, Map<String,PinPaymentAvailability>> pinCodeAvailabilityMap = new HashMap<>();

    public void addPinCodeAvailability(String sourcePin, PinPaymentAvailability pinPaymentAvailability){
        Map<String,PinPaymentAvailability> pins = pinCodeAvailabilityMap.getOrDefault(sourcePin, new HashMap<>());
        pins.put(pinPaymentAvailability.getPinCode(), pinPaymentAvailability);
        pinCodeAvailabilityMap.put(sourcePin, pins);
    }

    public Map<String,PinPaymentAvailability> getAllDestinationPins(String sourcePin){
        return pinCodeAvailabilityMap.get(sourcePin);
    }


}
