package com.machineCode.eCommerceApp.service.impl;

import com.machineCode.eCommerceApp.model.PaymentMode;
import com.machineCode.eCommerceApp.model.PinPaymentAvailability;
import com.machineCode.eCommerceApp.repository.PinCodeAvailabilityRepository;
import com.machineCode.eCommerceApp.service.PinCodeService;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @author anju
 * @created on 23/04/25 and 9:55 PM
 */

@Data
public class PinCodeServiceImpl implements PinCodeService {
    private final PinCodeAvailabilityRepository pinCodeAvailabilityRepository;



    @Override
    public void addPinCode(String sourcePin, String destinationPin, PaymentMode paymentMode) {
        pinCodeAvailabilityRepository.addPinCodeAvailability(sourcePin, new PinPaymentAvailability(destinationPin, paymentMode));
    }

    @Override
    public Boolean checkIfPinAndPaymentModeValid(@NotNull String sourcePin,@NotNull String destinationPin, @NotNull PaymentMode paymentMode) {
        Map<String, PinPaymentAvailability> pinPaymentAvailabilityMap = pinCodeAvailabilityRepository.getAllDestinationPins(sourcePin);
        if(null != pinPaymentAvailabilityMap){
            return paymentMode.equals(pinPaymentAvailabilityMap.get(destinationPin).getPaymentMode());
        }
        return false;
    }
}
