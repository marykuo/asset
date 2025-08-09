package com.marykuo.asset.adapter.in.api.controller.order.query;

import com.marykuo.asset.adapter.in.api.controller.order.query.response.QueryPaginationOrderResponse;
import com.marykuo.asset.adapter.in.api.response.PaginationResponse;
import com.marykuo.asset.adapter.out.database.OrderRepository;
import com.marykuo.asset.adapter.out.database.entity.MemberEntity;
import com.marykuo.asset.domain.order.Order;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ORDER;
import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ROOT_API;
import static com.marykuo.asset.adapter.in.api.filter.JwtAuthenticationFilter.LOGIN_MEMBER;

@RestController
@RequestMapping(ROOT_API)
@Tag(name = "Order")
@RequiredArgsConstructor
@Slf4j
public class QueryPaginationOrderController {
    private final OrderRepository orderRepository;

    @GetMapping(value = "/v1" + ORDER)
    public ResponseEntity<PaginationResponse<QueryPaginationOrderResponse>> query(
            @RequestAttribute(LOGIN_MEMBER) MemberEntity loginMember,
            @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
            @RequestParam(value = "pageOffset", defaultValue = "0") Integer pageOffset,
            @RequestParam(value = "sortBy", defaultValue = "orderId") String sortBy,
            @RequestParam(value = "isAscending", defaultValue = "true") boolean isAscending
    ) {
        log.debug("member[{}] query pagination order", loginMember.getMemberId());

        Page<Order> orderPage = orderRepository.findAll(loginMember.getMemberId(), pageSize, pageOffset, sortBy, isAscending);

        return ResponseEntity.ok(new PaginationResponse<>(
                orderPage.getContent().stream()
                        .map(QueryPaginationOrderResponse::new)
                        .toList(),
                orderPage.getTotalElements(),
                orderPage.getTotalPages(),
                pageOffset,
                pageSize
        ));
    }
}
