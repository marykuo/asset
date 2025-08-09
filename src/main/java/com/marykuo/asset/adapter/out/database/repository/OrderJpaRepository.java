package com.marykuo.asset.adapter.out.database.repository;

import com.marykuo.asset.adapter.out.database.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
    Optional<OrderEntity> findByMemberIdAndOrderId(Long memberId, Long orderId);

    Page<OrderEntity> findAllByMemberId(Long memberId, Pageable pageable);
}
