package com.marykuo.asset.adapter.out.database.impl;

import com.marykuo.asset.adapter.out.database.OrderRepository;
import com.marykuo.asset.adapter.out.database.entity.OrderEntity;
import com.marykuo.asset.adapter.out.database.repository.OrderJpaRepository;
import com.marykuo.asset.domain.order.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderJpaRepository orderJpaRepository;

    @Override
    public OrderEntity save(Order order) {
        return orderJpaRepository.save(new OrderEntity(order));
    }

    @Override
    public Optional<Order> findById(Long orderId) {
        return orderJpaRepository.findById(orderId)
                .map(OrderEntity::toOrder);
    }

    @Override
    public Optional<Order> findByMemberIdAndOrderId(Long memberId, Long orderId) {
        return orderJpaRepository.findByMemberIdAndOrderId(memberId, orderId)
                .map(OrderEntity::toOrder);
    }

    @Override
    public Page<Order> findAll(
            Long memberId,
            Integer pageSize, Integer pageOffset, String sortBy, boolean isAscending
    ) {
        Sort sort = Sort.by(isAscending ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        PageRequest pageRequest = PageRequest.of(pageOffset, pageSize, sort);

        return orderJpaRepository.findAllByMemberId(memberId, pageRequest)
                .map(OrderEntity::toOrder);
    }
}
