package com.marykuo.asset.adapter.in.api.controller.item.query;

import com.marykuo.asset.adapter.in.api.controller.item.query.response.QuerySingleItemResponse;
import com.marykuo.asset.adapter.in.api.response.DataResponse;
import com.marykuo.asset.adapter.out.database.ItemRepository;
import com.marykuo.asset.adapter.out.database.entity.MemberEntity;
import com.marykuo.asset.domain.order.Item;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ITEM_SINGLE;
import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ROOT_API;
import static com.marykuo.asset.adapter.in.api.filter.JwtAuthenticationFilter.LOGIN_MEMBER;

@RestController
@RequestMapping(ROOT_API)
@Tag(name = "Item")
@RequiredArgsConstructor
@Slf4j
public class QuerySingleItemController {
    private final ItemRepository itemRepository;

    @GetMapping(value = "/v1" + ITEM_SINGLE)
    public ResponseEntity<DataResponse<QuerySingleItemResponse>> query(
            @RequestAttribute(LOGIN_MEMBER) MemberEntity loginMember,
            @PathVariable("itemId") Long itemId
    ) {
        log.debug("member[{}] query item[{}]", loginMember.getMemberId(), itemId);

        Item item = itemRepository.findByMemberIdAndItemId(loginMember.getMemberId(), itemId)
                .orElseThrow(NoSuchElementException::new);

        return ResponseEntity.ok(new DataResponse<>(
                new QuerySingleItemResponse(item)
        ));
    }
}
