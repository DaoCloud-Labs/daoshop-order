package io.daocloud.shop.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Package io.daocloud.shop.order.entity
 * @Classname OrderEntity
 * @Description TODO
 * @Date 2019/3/18 上午11:47
 * @Created by chenghao
 * @desc OrderEntity
 * @project order
 */

@Entity
@Table(name = "t_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long productId;

    @Column
    private String productName;

    @Column
    private Long userId;

    @Column
    private double price;

    @Column
    private int count;

    @Column
    private double amount;
}
