package com.marykuo.asset.adapter.out.database.impl;

import com.marykuo.asset.adapter.out.database.PlatformRepository;
import com.marykuo.asset.adapter.out.database.entity.PlatformEntity;
import com.marykuo.asset.adapter.out.database.repository.PlatformJpaRepository;
import com.marykuo.asset.domain.order.Platform;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PlatformRepositoryImpl implements PlatformRepository {
    private final PlatformJpaRepository platformJpaRepository;

    @Override
    public PlatformEntity save(Platform platform) {
        return platformJpaRepository.save(new PlatformEntity(platform));
    }

    @Override
    public Optional<Platform> findById(Long platformId) {
        return platformJpaRepository.findById(platformId)
                .map(PlatformEntity::toPlatform);
    }

    @Override
    public Optional<Platform> findByMemberIdAndName(Long memberId, String name) {
        return platformJpaRepository.findByMemberIdAndName(memberId, name)
                .map(PlatformEntity::toPlatform);
    }

    @Override
    public Optional<Platform> findByMemberIdAndPlatformId(Long memberId, Long platformId) {
        return platformJpaRepository.findByMemberIdAndPlatformId(memberId, platformId)
                .map(PlatformEntity::toPlatform);
    }

    @Override
    public List<Platform> findAll(Long memberId) {
        return platformJpaRepository.findAllByMemberId(memberId)
                .stream()
                .map(PlatformEntity::toPlatform)
                .toList();
    }

    @Override
    public Page<Platform> findAll(
            Long memberId,
            Integer pageSize, Integer pageOffset, String sortBy, boolean isAscending
    ) {
        Sort sort = Sort.by(isAscending ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        PageRequest pageRequest = PageRequest.of(pageOffset, pageSize, sort);

        return platformJpaRepository.findAllByMemberId(memberId, pageRequest)
                .map(PlatformEntity::toPlatform);
    }
}
