package io.daocloud.shop.order.repository;

import io.daocloud.shop.order.entity.OrderEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Package io.daocloud.shop.order.repository
 * @Classname OrderRepository
 * @Description TODO
 * @Date 2019/3/18 下午3:54
 * @Created by chenghao
 * @desc OrderRepository
 * @project order
 */

public interface OrderRepository extends PagingAndSortingRepository<OrderEntity,Long> {


    Iterable<OrderEntity> findAllByUserId(long id);


}
