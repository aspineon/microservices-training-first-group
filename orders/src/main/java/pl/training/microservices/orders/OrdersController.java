package pl.training.microservices.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersMapper ordersMapper;
    private final OrdersService ordersService;
    private final UriBuilder uriBuilder = new UriBuilder();

    @PostMapping("orders")
    public ResponseEntity<Void> placeOrder(@RequestBody OrderTo orderTo) {
        Order order = ordersMapper.toOrder(orderTo);
        Long orderId = ordersService.placeOrder(order);
        URI locationUri = uriBuilder.requestUriWithAppendedId(orderId);
        return ResponseEntity.created(locationUri).build();
    }

}
