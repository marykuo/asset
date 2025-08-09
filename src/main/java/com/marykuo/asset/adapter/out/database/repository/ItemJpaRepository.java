package com.marykuo.asset.adapter.out.database.repository;

import com.marykuo.asset.adapter.out.database.entity.ItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemJpaRepository extends JpaRepository<ItemEntity, Long> {
    Optional<ItemEntity> findByMemberIdAndItemId(Long memberId, Long itemId);

    Page<ItemEntity> findAllByMemberId(Long memberId, Pageable pageable);

    List<ItemEntity> findAllByOrderId(Long orderId);
}
