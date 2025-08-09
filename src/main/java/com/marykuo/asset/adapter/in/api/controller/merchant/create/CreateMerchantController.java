package com.marykuo.asset.adapter.in.api.controller.merchant.create;

import com.marykuo.asset.adapter.in.api.controller.merchant.create.request.CreateMerchantRequest;
import com.marykuo.asset.adapter.in.api.response.BaseResponse;
import com.marykuo.asset.adapter.out.database.entity.MemberEntity;
import com.marykuo.asset.usecase.merchant.create.CreateMerchantService;
import com.marykuo.asset.usecase.merchant.create.input.CreateMerchantInput;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.MERCHANT;
import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ROOT_API;
import static com.marykuo.asset.adapter.in.api.filter.JwtAuthenticationFilter.LOGIN_MEMBER;

@RestController
@RequestMapping(ROOT_API)
@Tag(name = "Merchant API")
@RequiredArgsConstructor
@Slf4j
public class CreateMerchantController {
    private final CreateMerchantService createMerchantService;

    @PostMapping(value = "/v1" + MERCHANT)
    public ResponseEntity<BaseResponse> endpoint(
            @RequestAttribute(LOGIN_MEMBER) MemberEntity loginMember,
            @RequestBody CreateMerchantRequest request
    ) {
        createMerchantService.execute(
                loginMember.getMemberId(),
                CreateMerchantInput.builder()
                        .name(request.getName())
                        .build()
        );
        return ResponseEntity.ok(BaseResponse.success());
    }
}
