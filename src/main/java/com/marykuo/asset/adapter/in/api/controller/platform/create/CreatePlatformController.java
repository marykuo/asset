package com.marykuo.asset.adapter.in.api.controller.platform.create;

import com.marykuo.asset.adapter.in.api.controller.platform.create.request.CreatePlatformRequest;
import com.marykuo.asset.adapter.in.api.response.BaseResponse;
import com.marykuo.asset.adapter.out.database.entity.MemberEntity;
import com.marykuo.asset.usecase.platform.create.CreatePlatformService;
import com.marykuo.asset.usecase.platform.create.input.CreatePlatformInput;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.PLATFORM;
import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ROOT_API;
import static com.marykuo.asset.adapter.in.api.filter.JwtAuthenticationFilter.LOGIN_MEMBER;

@RestController
@RequestMapping(ROOT_API)
@Tag(name = "Platform API")
@RequiredArgsConstructor
@Slf4j
public class CreatePlatformController {
    private final CreatePlatformService createPlatformService;

    @PostMapping(value = "/v1" + PLATFORM)
    public ResponseEntity<BaseResponse> endpoint(
            @RequestAttribute(LOGIN_MEMBER) MemberEntity loginMember,
            @RequestBody CreatePlatformRequest request
    ) {
        createPlatformService.execute(
                loginMember.getMemberId(),
                CreatePlatformInput.builder()
                        .name(request.getName())
                        .build()
        );
        return ResponseEntity.ok(BaseResponse.success());
    }
}
