package com.marykuo.asset.adapter.out.database.repository;

import com.marykuo.asset.adapter.out.database.entity.PlatformEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlatformJpaRepository extends JpaRepository<PlatformEntity, Long> {
    @Query("SELECT p " +
            "FROM PlatformEntity p " +
            "WHERE p.memberId = :memberId " +
            "  AND p.name LIKE CONCAT('%', :name, '%')")
    Optional<PlatformEntity> findByMemberIdAndName(Long memberId, String name);

    Optional<PlatformEntity> findByMemberIdAndPlatformId(Long memberId, Long platformId);

    @Query("SELECT p " +
            "FROM PlatformEntity p " +
            "WHERE p.memberId = :memberId " +
            "ORDER BY p.createdAt DESC")
    List<PlatformEntity> findAllByMemberId(Long memberId);

    Page<PlatformEntity> findAllByMemberId(Long memberId, Pageable pageable);
}
