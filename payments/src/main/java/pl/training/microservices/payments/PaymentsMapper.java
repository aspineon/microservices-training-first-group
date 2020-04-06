package pl.training.microservices.payments;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentsMapper {

    PaymentsRequest toPaymentRequest(PaymentsRequestTo paymentsRequestTo);

    @Mapping(source = "expirationDate", target = "expiration")
    CreditCard toCreditCard(CreditCardTo creditCardTo);

    PaymentTo toPaymentTo(Payment payment);

}
