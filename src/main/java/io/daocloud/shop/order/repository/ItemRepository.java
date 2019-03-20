package io.daocloud.shop.order.repository;

import io.daocloud.shop.order.entity.ItemEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @Package io.daocloud.shop.order.repository
 * @Classname ItemRepository
 * @Description TODO
 * @Date 2019/3/19 下午5:33
 * @Created by chenghao
 * @desc ItemRepository
 * @project order
 */

@Repository
public interface ItemRepository extends PagingAndSortingRepository<ItemEntity,Long> {
}
