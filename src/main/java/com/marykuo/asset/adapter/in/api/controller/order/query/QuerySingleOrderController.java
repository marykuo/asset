package com.marykuo.asset.adapter.in.api.controller.order.query;

import com.marykuo.asset.adapter.in.api.controller.order.query.response.QuerySingleOrderResponse;
import com.marykuo.asset.adapter.in.api.response.DataResponse;
import com.marykuo.asset.adapter.out.database.OrderRepository;
import com.marykuo.asset.adapter.out.database.entity.MemberEntity;
import com.marykuo.asset.domain.order.Order;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ORDER_SINGLE;
import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ROOT_API;
import static com.marykuo.asset.adapter.in.api.filter.JwtAuthenticationFilter.LOGIN_MEMBER;

@RestController
@RequestMapping(ROOT_API)
@Tag(name = "Order")
@RequiredArgsConstructor
@Slf4j
public class QuerySingleOrderController {
    private final OrderRepository orderRepository;

    @GetMapping(value = "/v1" + ORDER_SINGLE)
    public ResponseEntity<DataResponse<QuerySingleOrderResponse>> query(
            @RequestAttribute(LOGIN_MEMBER) MemberEntity loginMember,
            @PathVariable("orderId") Long orderId
    ) {
        log.debug("member[{}] query order[{}]", loginMember.getMemberId(), orderId);

        Order order = orderRepository.findByMemberIdAndOrderId(loginMember.getMemberId(), orderId)
                .orElseThrow(NoSuchElementException::new);

        return ResponseEntity.ok(new DataResponse<>(
                new QuerySingleOrderResponse(order)
        ));
    }
}
