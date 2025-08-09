package com.marykuo.asset.adapter.out.database.impl;

import com.marykuo.asset.adapter.out.database.ItemRepository;
import com.marykuo.asset.adapter.out.database.entity.ItemEntity;
import com.marykuo.asset.adapter.out.database.repository.ItemJpaRepository;
import com.marykuo.asset.domain.order.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {
    private final ItemJpaRepository itemJpaRepository;

    @Override
    public ItemEntity save(Item item) {
        return itemJpaRepository.save(new ItemEntity(item));
    }

    @Override
    public Optional<Item> findById(Long itemId) {
        return itemJpaRepository.findById(itemId)
                .map(ItemEntity::toItem);
    }

    @Override
    public Optional<Item> findByMemberIdAndItemId(Long memberId, Long itemId) {
        return itemJpaRepository.findByMemberIdAndItemId(memberId, itemId)
                .map(ItemEntity::toItem);
    }

    @Override
    public Page<Item> findAll(
            Long memberId,
            Integer pageSize, Integer pageOffset, String sortBy, boolean isAscending
    ) {
        Sort sort = Sort.by(isAscending ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        PageRequest pageRequest = PageRequest.of(pageOffset, pageSize, sort);

        return itemJpaRepository.findAllByMemberId(memberId, pageRequest)
                .map(ItemEntity::toItem);
    }

    @Override
    public List<Item> findAllByOrderId(Long orderId) {
        return itemJpaRepository.findAllByOrderId(orderId)
                .stream()
                .map(ItemEntity::toItem)
                .toList();
    }
}
