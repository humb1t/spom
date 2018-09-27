package org.zayac.pom.order;

import org.springframework.data.rest.core.config.Projection;
import org.zayac.pom.catalog.Specification;

@Projection(name = "withSpecification", types = {Order.class})
public interface OrderWithSpecification {
    Specification getSpecification();

    Order.Status getStatus();
}
