package io.daocloud.shop.order.controller;

import io.daocloud.shop.order.entity.OrderEntity;
import io.daocloud.shop.order.repository.OrderRepository;
import io.daocloud.shop.order.vo.OrderVo;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Package io.daocloud.shop.order.controller
 * @Classname OrderController
 * @Description TODO
 * @Date 2019/3/17 下午10:45
 * @Created by chenghao
 * @desc OrderController
 * @project order
 */
@RestController
@RequestMapping()
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderVo orderVo,
                            @RequestHeader("token")Long token){

        orderRepository.save(OrderEntity.builder().userId(token).amount(orderVo.getAmount())
                .count(orderVo.getCount())
                .price(orderVo.getPrice())
                .productId(orderVo.getProductId())
                .productName(orderVo.getProductName()).build());

    }
    @GetMapping("/user/{id}/orders")
    public Iterable<OrderEntity> getOrdersByUser(@RequestHeader("token")Long token){
        return orderRepository.findAllByUserId(token);
    }
    @GetMapping("/orders/{id}")
    public OrderEntity getOrdersDetail(@RequestHeader("token")Long token,
                                       @PathVariable("id")long id){
        return orderRepository.findById(id)
                .get();
    }

    private String getUserName(String token){
        return token;
    }
}
