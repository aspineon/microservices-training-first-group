package pl.training.microservices.payments;

import lombok.Data;

@Data
public class PaymentTo {

    private Long id;
    private PaymentStatusTo status;

}
