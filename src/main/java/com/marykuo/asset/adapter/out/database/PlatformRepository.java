package com.marykuo.asset.adapter.out.database;

import com.marykuo.asset.domain.order.Platform;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface PlatformRepository {
    Platform save(Platform platform);

    Optional<Platform> findById(Long platformId);

    Optional<Platform> findByMemberIdAndName(Long memberId, String name);

    Optional<Platform> findByMemberIdAndPlatformId(Long memberId, Long platformId);

    List<Platform> findAll(Long memberId);

    Page<Platform> findAll(Long memberId, Integer pageSize, Integer pageOffset, String sortBy, boolean isAscending);
}
