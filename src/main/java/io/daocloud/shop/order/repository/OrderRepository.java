package io.daocloud.shop.order.repository;

import io.daocloud.shop.order.entity.OrderEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @Package io.daocloud.shop.order.repository
 * @Classname OrderRepository
 * @Description TODO
 * @Date 2019/3/18 下午3:54
 * @Created by chenghao
 * @desc OrderRepository
 * @project order
 */
@Repository
public interface OrderRepository extends PagingAndSortingRepository<OrderEntity,Long> {


    Iterable<OrderEntity> findAllByUserId(long id);


}
