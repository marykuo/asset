package com.marykuo.asset.adapter.in.api.controller.order.create;

import com.marykuo.asset.adapter.in.api.controller.order.create.request.CreateOrderRequest;
import com.marykuo.asset.adapter.in.api.response.BaseResponse;
import com.marykuo.asset.adapter.out.database.entity.MemberEntity;
import com.marykuo.asset.usecase.order.create.CreateOrderService;
import com.marykuo.asset.usecase.order.create.input.CreateOrderInput;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ORDER;
import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ROOT_API;
import static com.marykuo.asset.adapter.in.api.filter.JwtAuthenticationFilter.LOGIN_MEMBER;

@RestController
@RequestMapping(ROOT_API)
@Tag(name = "Order API")
@RequiredArgsConstructor
@Slf4j
public class CreateOrderController {
    private final CreateOrderService createOrderService;

    @PostMapping(value = "/v1" + ORDER)
    public ResponseEntity<BaseResponse> endpoint(
            @RequestAttribute(LOGIN_MEMBER) MemberEntity loginMember,
            @RequestBody CreateOrderRequest request
    ) {
        createOrderService.execute(
                loginMember.getMemberId(),
                CreateOrderInput.builder()
                        .platformId(request.getPlatformId())
                        .merchantId(request.getMerchantId())
                        .invoiceNumber(request.getInvoiceNumber())
                        .dateTime(request.getDateTime())
                        .amount(request.getAmount())
                        .amountInCurrency(request.getAmountInCurrency())
                        .currency(request.getCurrency())
                        .exchangeRate(request.getExchangeRate())
                        .build()
        );
        return ResponseEntity.ok(BaseResponse.success());
    }
}
