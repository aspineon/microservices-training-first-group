package pl.training.microservices.payments;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PaymentsMapper {

    PaymentTo toPaymentTo(Payment payment);

    PaymentStatus toPaymentStatus(PaymentStatus paymentStatus);

    PaymentsRequest toPaymentRequest(PaymentsRequestTo paymentsRequestTo);

    @Mapping(source = "expirationDate", target = "expiration")
    CreditCard toCreditCard(CreditCardTo creditCardTo);

}
