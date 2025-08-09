package com.marykuo.asset.adapter.out.database.impl;

import com.marykuo.asset.adapter.out.database.MerchantRepository;
import com.marykuo.asset.adapter.out.database.entity.MerchantEntity;
import com.marykuo.asset.adapter.out.database.repository.MerchantJpaRepository;
import com.marykuo.asset.domain.order.Merchant;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MerchantRepositoryImpl implements MerchantRepository {
    private final MerchantJpaRepository merchantJpaRepository;

    @Override
    public MerchantEntity save(Merchant merchant) {
        return merchantJpaRepository.save(new MerchantEntity(merchant));
    }

    @Override
    public Optional<Merchant> findById(Long merchantId) {
        return merchantJpaRepository.findById(merchantId)
                .map(MerchantEntity::toMerchant);
    }

    @Override
    public Optional<Merchant> findByMemberIdAndName(Long memberId, String name) {
        return merchantJpaRepository.findByMemberIdAndName(memberId, name)
                .map(MerchantEntity::toMerchant);
    }

    @Override
    public Optional<Merchant> findByMemberIdAndMerchantId(Long memberId, Long merchantId) {
        return merchantJpaRepository.findByMemberIdAndMerchantId(memberId, merchantId)
                .map(MerchantEntity::toMerchant);
    }

    @Override
    public List<Merchant> findAll(Long memberId) {
        return merchantJpaRepository.findAllByMemberId(memberId)
                .stream()
                .map(MerchantEntity::toMerchant)
                .toList();
    }

    @Override
    public Page<Merchant> findAll(
            Long memberId,
            Integer pageSize, Integer pageOffset, String sortBy, boolean isAscending
    ) {
        Sort sort = Sort.by(isAscending ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        PageRequest pageRequest = PageRequest.of(pageOffset, pageSize, sort);

        return merchantJpaRepository.findAllByMemberId(memberId, pageRequest)
                .map(MerchantEntity::toMerchant);
    }
}
