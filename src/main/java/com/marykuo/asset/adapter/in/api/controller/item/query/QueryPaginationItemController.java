package com.marykuo.asset.adapter.in.api.controller.item.query;

import com.marykuo.asset.adapter.in.api.controller.item.query.response.QueryPaginationItemResponse;
import com.marykuo.asset.adapter.in.api.response.PaginationResponse;
import com.marykuo.asset.adapter.out.database.ItemRepository;
import com.marykuo.asset.adapter.out.database.entity.MemberEntity;
import com.marykuo.asset.domain.order.Item;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ITEM;
import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ROOT_API;
import static com.marykuo.asset.adapter.in.api.filter.JwtAuthenticationFilter.LOGIN_MEMBER;

@RestController
@RequestMapping(ROOT_API)
@Tag(name = "Item")
@RequiredArgsConstructor
@Slf4j
public class QueryPaginationItemController {
    private final ItemRepository itemRepository;

    @GetMapping(value = "/v1" + ITEM)
    public ResponseEntity<PaginationResponse<QueryPaginationItemResponse>> query(
            @RequestAttribute(LOGIN_MEMBER) MemberEntity loginMember,
            @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
            @RequestParam(value = "pageOffset", defaultValue = "0") Integer pageOffset,
            @RequestParam(value = "sortBy", defaultValue = "itemId") String sortBy,
            @RequestParam(value = "isAscending", defaultValue = "true") boolean isAscending
    ) {
        log.debug("member[{}] query pagination item", loginMember.getMemberId());

        Page<Item> itemPage = itemRepository.findAll(loginMember.getMemberId(), pageSize, pageOffset, sortBy, isAscending);

        return ResponseEntity.ok(new PaginationResponse<>(
                itemPage.getContent().stream()
                        .map(QueryPaginationItemResponse::new)
                        .toList(),
                itemPage.getTotalElements(),
                itemPage.getTotalPages(),
                pageOffset,
                pageSize
        ));
    }
}
