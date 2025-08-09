package com.marykuo.asset.adapter.in.api.controller.item.create;

import com.marykuo.asset.adapter.in.api.controller.item.create.request.CreateItemRequest;
import com.marykuo.asset.adapter.in.api.response.BaseResponse;
import com.marykuo.asset.adapter.out.database.entity.MemberEntity;
import com.marykuo.asset.usecase.item.create.CreateItemService;
import com.marykuo.asset.usecase.item.create.input.CreateItemInput;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ITEM;
import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ROOT_API;
import static com.marykuo.asset.adapter.in.api.filter.JwtAuthenticationFilter.LOGIN_MEMBER;

@RestController
@RequestMapping(ROOT_API)
@Tag(name = "Item API")
@RequiredArgsConstructor
@Slf4j
public class CreateItemController {
    private final CreateItemService createItemService;

    @PostMapping(value = "/v1" + ITEM)
    public ResponseEntity<BaseResponse> endpoint(
            @RequestAttribute(LOGIN_MEMBER) MemberEntity loginMember,
            @RequestBody CreateItemRequest request
    ) {
        createItemService.execute(
                loginMember.getMemberId(),
                CreateItemInput.builder()
                        .orderId(request.getOrderId())
                        .productId(request.getProductId())
                        .sequence(request.getSequence())
                        .name(request.getName())
                        .quantity(request.getQuantity())
                        .unit(request.getUnit())
                        .unitPrice(request.getUnitPrice())
                        .amount(request.getAmount())
                        .relateNumber(request.getRelateNumber())
                        .remark(request.getRemark())
                        .build()
        );
        return ResponseEntity.ok(BaseResponse.success());
    }
}
