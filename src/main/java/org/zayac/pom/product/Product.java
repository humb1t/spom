package org.zayac.pom.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.zayac.pom.catalog.Specification;
import org.zayac.pom.order.Order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Specification specification;
    @OneToMany
    private List<Order> orders;

    public Product(Specification specification, List<Order> orders) {
        this.specification = specification;
        this.orders = orders;
    }
}
