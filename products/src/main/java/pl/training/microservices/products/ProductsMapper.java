package pl.training.microservices.products;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import pl.training.microservices.products.api.ProductTo;
import pl.training.microservices.products.api.ResultPageTo;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductsMapper {

    Product toProduct(ProductTo productTo);

    @IterableMapping(elementTargetType = ProductTo.class)
    List<ProductTo> toProductTo(List<Product> products);

    ResultPageTo<ProductTo> toResultPageTo(ResultPage<Product> resultPage);

}
