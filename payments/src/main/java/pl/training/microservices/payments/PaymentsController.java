package pl.training.microservices.payments;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class PaymentsController {

    private final PaymentsMapper paymentsMapper;
    private final PaymentsService paymentsService;

    @PostMapping("payments")
    public ResponseEntity<PaymentTo> addPaymentRequest(PaymentsRequestTo paymentsRequestTo) {
        PaymentsRequest paymentsRequest = paymentsMapper.toPaymentRequest(paymentsRequestTo);
        Payment payment = paymentsService.pay(paymentsRequest);
        PaymentTo paymentTo = paymentsMapper.toPaymentTo(payment);
        return ResponseEntity.accepted().body(paymentTo);
    }

}
