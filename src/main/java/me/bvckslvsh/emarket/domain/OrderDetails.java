package me.bvckslvsh.emarket.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders_details")
public class OrderDetails {

    private static final String NAMESEQ = "ordersdetailsseq ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = NAMESEQ)
    @SequenceGenerator(name = NAMESEQ, sequenceName = NAMESEQ, allocationSize = 1)
    private long id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;
    private BigDecimal amount;
    private BigDecimal price;

}
