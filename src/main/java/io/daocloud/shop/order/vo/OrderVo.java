package io.daocloud.shop.order.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Package io.daocloud.shop.order.vo
 * @Classname OrderVo
 * @Description TODO
 * @Date 2019/3/17 下午10:48
 * @Created by chenghao
 * @desc OrderVo
 * @project order
 */

@Data
@NoArgsConstructor
public class OrderVo {

    private int count;
    private double price;
    private long productId;
    private String productName;

}
