package io.daocloud.shop.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.annotation.Order;

import javax.persistence.*;

/**
 * @Package io.daocloud.shop.order.entity
 * @Classname ItemEntity
 * @Description TODO
 * @Date 2019/3/19 下午5:30
 * @Created by chenghao
 * @desc ItemEntity
 * @project order
 */
@Entity
@Table(name = "t_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private Long productId;

    @Column
    private double price;

    @Column
    private int count;

    @ManyToOne()
    @JoinColumn
    private OrderEntity order;

    @Column
    private String productName;
}
