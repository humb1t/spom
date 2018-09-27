package org.zayac.pom.order;

import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;
import org.zayac.pom.product.Product;
import org.zayac.pom.product.ProductRepository;

import java.util.Collections;

@RepositoryEventHandler(Order.class)
@Component
public class OrderEventHandler {
    private final ProductRepository productRepository;

    public OrderEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @HandleAfterCreate(Order.class)
    public void handleOrderCreate(Order order) {
        productRepository.save(
                new Product(
                        order.getSpecification(),
                        Collections.singletonList(order)
                )
        );
    }
}
