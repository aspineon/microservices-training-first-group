package pl.training.microservices.orders;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    private Long id;
    private List<ProductTo> products;

}
