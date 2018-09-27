package org.zayac.pom.order;

import lombok.Data;
import org.zayac.pom.catalog.Specification;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Specification specification;
    private Long quantity;
    private Status status;

    public Order(Specification specification) {
        this.specification = specification;
    }

    public Order() {
    }

    public Order start() {
        this.status = Status.IN_PROGRESS;
        return this;
    }

    public Order cancel() {
        this.status = Status.CANCELLED;
        return this;
    }

    public enum Status {
        ENTERING, IN_PROGRESS, CANCELLED, COMPLETED
    }
}
