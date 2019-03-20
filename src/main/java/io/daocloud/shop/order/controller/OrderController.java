package io.daocloud.shop.order.controller;

import io.daocloud.shop.order.entity.ItemEntity;
import io.daocloud.shop.order.entity.OrderEntity;
import io.daocloud.shop.order.repository.ItemRepository;
import io.daocloud.shop.order.repository.OrderRepository;
import io.daocloud.shop.order.vo.OrderVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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
    private final ItemRepository itemRepository;

    public OrderController(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void createOrder(@RequestBody List<OrderVo> orderVos,
                            @RequestHeader("token")Long token){
        Double amount = orderVos.stream().map(e -> e.getCount() * e.getPrice())
                .reduce(Double::sum).orElse(0.0);
        OrderEntity orderEntity = OrderEntity.builder().userId(token).amount(amount).build();

        List<ItemEntity> collect = orderVos.stream().map(e -> {
            ItemEntity itemEntity = ItemEntity.builder().count(e.getCount())
                    .price(e.getPrice())
                    .productId(e.getProductId())
                    .productName(e.getProductName()).build();

            return itemEntity;
        }).collect(Collectors.toList());
        orderEntity.setItems(collect);
        OrderEntity save = orderRepository.save(orderEntity);

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
