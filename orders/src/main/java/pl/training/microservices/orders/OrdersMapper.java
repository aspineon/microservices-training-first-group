package pl.training.microservices.orders;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdersMapper {

    Order toOrder(OrderTo orderTo);

    Product toProduct(ProductTo productTo);

}
