package pl.training.microservices.orders.payments;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PaymentsMapper {

    Payment toPayment(PaymentTo paymentTo);

    PaymentStatus toPaymentStatus(PaymentStatus paymentStatus);

    PaymentsRequestTo toPaymentRequestTo(PaymentsRequest paymentsRequest);

    @Mapping(source = "expiration", target = "expirationDate")
    CreditCardTo toCreditCardTo(CreditCard creditCard);

}
