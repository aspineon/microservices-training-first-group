package pl.training.microservices.orders.payments;

import lombok.Data;

@Data
public class PaymentTo {

    private Long id;
    private PaymentStatusTo status;

}
