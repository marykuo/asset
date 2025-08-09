package com.marykuo.asset.adapter.in.api.controller.item.query;

import com.marykuo.asset.adapter.in.api.controller.item.query.response.QueryOrderItemResponse;
import com.marykuo.asset.adapter.in.api.response.DataResponse;
import com.marykuo.asset.adapter.out.database.ItemRepository;
import com.marykuo.asset.adapter.out.database.entity.MemberEntity;
import com.marykuo.asset.domain.order.Item;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ORDER_ITEM;
import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ROOT_API;
import static com.marykuo.asset.adapter.in.api.filter.JwtAuthenticationFilter.LOGIN_MEMBER;

@RestController
@RequestMapping(ROOT_API)
@Tag(name = "Item")
@RequiredArgsConstructor
@Slf4j
public class QueryOrderItemController {
    private final ItemRepository itemRepository;

    @GetMapping(value = "/v1" + ORDER_ITEM)
    public ResponseEntity<DataResponse<List<QueryOrderItemResponse>>> query(
            @RequestAttribute(LOGIN_MEMBER) MemberEntity loginMember,
            @PathVariable("orderId") Long orderId
    ) {
        log.debug("member[{}] query order[{}]'s item", loginMember.getMemberId(), orderId);

        List<Item> itemList = itemRepository.findAllByOrderId(orderId);

        return ResponseEntity.ok(new DataResponse<>(
                itemList.stream().map(QueryOrderItemResponse::new).toList()
        ));
    }
}
