package pl.training.microservices.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.training.microservices.orders.payments.*;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final PaymentsMapper paymentsMapper;
    private final PaymentsService paymentsService;

    public Long placeOrder(Order order) {
        Payment payment = pay();
        return 1L;
    }

    private Payment pay() {
        CreditCard creditCard = new CreditCard("1234567789", "645", LocalDate.parse("2029-12-10T12:00:00"));
        PaymentsRequest paymentsRequest = new PaymentsRequest(1000L, creditCard);
        PaymentsRequestTo paymentsRequestTo = paymentsMapper.toPaymentRequestTo(paymentsRequest);
        PaymentTo paymentTo = paymentsService.addPaymentRequest(paymentsRequestTo).getBody();
        return paymentsMapper.toPayment(paymentTo);
    }

}
