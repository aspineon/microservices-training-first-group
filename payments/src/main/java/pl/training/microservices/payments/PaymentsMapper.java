package pl.training.microservices.payments;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentsMapper {

    PaymentTo toPaymentTo(Payment payment);

    PaymentsRequest toPaymentRequest(PaymentsRequestTo paymentsRequestTo);

    @Mapping(source = "expirationDate", target = "expiration")
    CreditCard toCreditCard(CreditCardTo creditCardTo);

}
