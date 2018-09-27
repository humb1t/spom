package org.zayac.pom.order;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RepositoryRestController
@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/{orderId}/start")
    public Order startOrder(@PathVariable Long orderId) {
        orderRepository.findById(orderId).ifPresent(
                order ->
                        orderRepository.save(
                                order.start()
                        )
        );
        return orderRepository.findById(orderId).get();
    }

    @PostMapping("/{orderId}/cancel")
    public Order cancelOrder(@PathVariable Long orderId) {
        orderRepository.findById(orderId).ifPresent(
                order ->
                        orderRepository.save(
                                order.cancel()
                        )
        );
        return orderRepository.findById(orderId).get();
    }
}
