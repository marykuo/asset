package com.marykuo.asset.adapter.in.api.controller.merchant.query;

import com.marykuo.asset.adapter.in.api.controller.merchant.query.response.QueryMerchantResponse;
import com.marykuo.asset.adapter.in.api.response.DataResponse;
import com.marykuo.asset.adapter.out.database.MerchantRepository;
import com.marykuo.asset.adapter.out.database.entity.MemberEntity;
import com.marykuo.asset.domain.order.Merchant;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.MERCHANT;
import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ROOT_API;
import static com.marykuo.asset.adapter.in.api.filter.JwtAuthenticationFilter.LOGIN_MEMBER;

@RestController
@RequestMapping(ROOT_API)
@Tag(name = "Merchant API")
@RequiredArgsConstructor
@Slf4j
public class QueryMerchantController {
    private final MerchantRepository merchantRepository;

    @GetMapping(value = "/v1" + MERCHANT)
    public ResponseEntity<DataResponse<QueryMerchantResponse>> endpoint(
            @RequestAttribute(LOGIN_MEMBER) MemberEntity loginMember
    ) {
        List<Merchant> merchantList = merchantRepository.findAll(loginMember.getMemberId());

        return ResponseEntity.ok(new DataResponse(
                merchantList.stream()
                        .map(QueryMerchantResponse::mapper)
                        .toList()
        ));
    }
}
