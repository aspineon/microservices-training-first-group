package pl.training.microservices.orders.payments;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentsMapper {

    Payment toPayment(PaymentTo paymentTo);

    PaymentsRequestTo toPaymentRequestTo(PaymentsRequest paymentsRequest);

}
