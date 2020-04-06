package pl.training.microservices.payments;

import org.springframework.stereotype.Service;

@Service
public class PaymentsService {

    public Payment pay(PaymentsRequest paymentsRequest) {
        return new Payment(1L, PaymentStatus.STARTED);
    }

}
