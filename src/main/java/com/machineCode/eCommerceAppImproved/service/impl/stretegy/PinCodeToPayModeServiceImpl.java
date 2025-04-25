package com.machineCode.eCommerceAppImproved.service.impl.stretegy;

import com.machineCode.eCommerceAppImproved.model.PaymentMode;
import com.machineCode.eCommerceAppImproved.model.PinPaymentAvailability;
import com.machineCode.eCommerceAppImproved.repository.PinCodeAvailabilityRepository;
import com.machineCode.eCommerceAppImproved.service.strategy.PinPaymentValidationStrategy;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @author anju
 * @created on 23/04/25 and 9:55 PM
 */

@Data
public class PinCodeToPayModeServiceImpl implements PinPaymentValidationStrategy {
    private final PinCodeAvailabilityRepository pinCodeAvailabilityRepository;



    public void addPinCode(String sourcePin, String destinationPin, PaymentMode paymentMode) {
        pinCodeAvailabilityRepository.addPinCodeAvailability(sourcePin, new PinPaymentAvailability(destinationPin, paymentMode));
    }

    @Override
    public boolean validate(@NotNull String productPinCode,@NotNull String userPinCode, @NotNull PaymentMode userPaymentMode) {
        Map<String, PinPaymentAvailability> pinPaymentAvailabilityMap = pinCodeAvailabilityRepository.getAllDestinationPins(productPinCode);
        if(null != pinPaymentAvailabilityMap){
            return userPaymentMode.equals(pinPaymentAvailabilityMap.get(userPinCode).getPaymentMode());
        }
        return false;
    }
}
