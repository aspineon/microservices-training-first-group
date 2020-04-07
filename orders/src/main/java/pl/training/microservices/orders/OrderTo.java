package pl.training.microservices.orders;

import lombok.Data;

import java.util.List;

@Data
public class OrderTo {

    private List<ProductTo> products;

}
