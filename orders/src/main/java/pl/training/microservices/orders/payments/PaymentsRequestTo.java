package pl.training.microservices.orders.payments;

import lombok.Data;

@Data
public class PaymentsRequestTo {

    private Long amount;
    private CreditCardTo creditCard;

}
