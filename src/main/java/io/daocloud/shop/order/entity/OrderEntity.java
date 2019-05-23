package io.daocloud.shop.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private Long userId;

    @Column
    private double amount;
    @Column
    private String version;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn
    private List<ItemEntity> items =  new ArrayList<>();

}
