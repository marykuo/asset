package com.marykuo.asset.adapter.out.database.repository;

import com.marykuo.asset.adapter.out.database.entity.MerchantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MerchantJpaRepository extends JpaRepository<MerchantEntity, Long> {
    @Query("SELECT m " +
            "FROM MerchantEntity m " +
            "WHERE m.memberId = :memberId " +
            "  AND m.name LIKE CONCAT('%', :name, '%')")
    Optional<MerchantEntity> findByMemberIdAndName(Long memberId, String name);

    Optional<MerchantEntity> findByMemberIdAndMerchantId(Long memberId, Long merchantId);

    @Query("SELECT m " +
            "FROM MerchantEntity m " +
            "WHERE m.memberId = :memberId " +
            "ORDER BY m.createdAt DESC")
    List<MerchantEntity> findAllByMemberId(Long memberId);

    Page<MerchantEntity> findAllByMemberId(Long memberId, Pageable pageable);
}
