package com.marykuo.asset.adapter.out.database;

import com.marykuo.asset.domain.order.Merchant;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface MerchantRepository {
    Merchant save(Merchant merchant);

    Optional<Merchant> findById(Long merchantId);

    Optional<Merchant> findByMemberIdAndName(Long memberId, String name);

    Optional<Merchant> findByMemberIdAndMerchantId(Long memberId, Long merchantId);

    List<Merchant> findAll(Long memberId);

    Page<Merchant> findAll(Long memberId, Integer pageSize, Integer pageOffset, String sortBy, boolean isAscending);
}
