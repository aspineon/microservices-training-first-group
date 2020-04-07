package pl.training.microservices.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.training.microservices.orders.payments.*;
import pl.training.microservices.payments.api.PaymentTo;
import pl.training.microservices.payments.api.PaymentsRequestTo;
import pl.training.microservices.payments.api.Payments;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private static final String RESOURCE_URI = "http://payments-service/payments";

    private final PaymentsMapper paymentsMapper;
    private final Payments payments;
    private final RestTemplate restTemplate;

    public Long placeOrder(Order order) {
        Payment payment = pay();
        return 1L;
    }

    private Payment pay() {
        CreditCard creditCard = new CreditCard("1234567789", "645", LocalDate.now());
        PaymentsRequest paymentsRequest = new PaymentsRequest(1000L, creditCard);
        PaymentsRequestTo paymentsRequestTo = paymentsMapper.toPaymentRequestTo(paymentsRequest);
        //PaymentTo paymentTo = paymentsService.addPaymentRequest(paymentsRequestTo).getBody();
        //return paymentsMapper.toPayment(paymentTo);

        try {
            URI uri = new URI(RESOURCE_URI);
            ResponseEntity<PaymentTo> paymentTo = restTemplate.postForEntity(uri, paymentsRequestTo, PaymentTo.class);
            return paymentsMapper.toPayment(paymentTo.getBody());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException();
        }
    }

}
