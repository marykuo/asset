package com.marykuo.asset.adapter.out.database;

import com.marykuo.asset.domain.order.Item;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    Item save(Item item);

    Optional<Item> findById(Long itemId);

    Optional<Item> findByMemberIdAndItemId(Long memberId, Long itemId);

    Page<Item> findAll(Long memberId, Integer pageSize, Integer pageOffset, String sortBy, boolean isAscending);

    List<Item> findAllByOrderId(Long orderId);
}
