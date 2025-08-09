package com.marykuo.asset.adapter.in.api.controller.platform.query;

import com.marykuo.asset.adapter.in.api.controller.platform.query.response.QueryPlatformResponse;
import com.marykuo.asset.adapter.in.api.response.DataResponse;
import com.marykuo.asset.adapter.out.database.PlatformRepository;
import com.marykuo.asset.adapter.out.database.entity.MemberEntity;
import com.marykuo.asset.domain.order.Platform;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.PLATFORM;
import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ROOT_API;
import static com.marykuo.asset.adapter.in.api.filter.JwtAuthenticationFilter.LOGIN_MEMBER;

@RestController
@RequestMapping(ROOT_API)
@Tag(name = "Platform API")
@RequiredArgsConstructor
@Slf4j
public class QueryPlatformController {
    private final PlatformRepository platformRepository;

    @GetMapping(value = "/v1" + PLATFORM)
    public ResponseEntity<DataResponse<List<QueryPlatformResponse>>> endpoint(
            @RequestAttribute(LOGIN_MEMBER) MemberEntity loginMember
    ) {
        List<Platform> platformList = platformRepository.findAll(loginMember.getMemberId());

        return ResponseEntity.ok(new DataResponse(
                platformList.stream()
                        .map(QueryPlatformResponse::mapper)
                        .toList()
        ));
    }
}
