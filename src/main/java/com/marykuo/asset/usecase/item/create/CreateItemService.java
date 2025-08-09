package com.marykuo.asset.usecase.item.create;

import com.marykuo.asset.adapter.out.database.ItemRepository;
import com.marykuo.asset.adapter.out.database.OrderRepository;
import com.marykuo.asset.domain.order.Item;
import com.marykuo.asset.domain.order.Order;
import com.marykuo.asset.usecase.item.create.input.CreateItemInput;
import com.marykuo.asset.usecase.item.create.output.CreateItemOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateItemService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public CreateItemOutput execute(Long loginMemberId, CreateItemInput createItemInput) {
        log.info("CreateItemInput: {}", createItemInput);

        // validate input
        createItemInput.validate();

        // validate data
        Optional<Order> orderOpt = orderRepository.findByMemberIdAndOrderId(loginMemberId, createItemInput.getOrderId());
        if (orderOpt.isEmpty()) {
            throw new IllegalArgumentException("order not exist");
        }

        // execute
        Item item = new Item(loginMemberId, createItemInput);
        itemRepository.save(item);

        return CreateItemOutput.builder()
                .item(item)
                .build();
    }
}
