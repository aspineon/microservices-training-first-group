package pl.training.microservices.orders.payments;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("payments-service")
public interface PaymentsService {

    @PostMapping("payments")
    ResponseEntity<PaymentTo> addPaymentRequest(PaymentsRequestTo paymentsRequestTo);

}
