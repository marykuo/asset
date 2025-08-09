package com.marykuo.asset.adapter.out.database;

import com.marykuo.asset.domain.order.Order;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);

    Optional<Order> findById(Long orderId);

    Optional<Order> findByMemberIdAndOrderId(Long memberId, Long orderId);

    Page<Order> findAll(Long memberId, Integer pageSize, Integer pageOffset, String sortBy, boolean isAscending);
}
