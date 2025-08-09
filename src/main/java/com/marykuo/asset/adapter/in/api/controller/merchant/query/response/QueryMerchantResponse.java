package com.marykuo.asset.adapter.in.api.controller.merchant.query.response;

import com.marykuo.asset.adapter.in.api.response.Response;
import com.marykuo.asset.domain.order.Merchant;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class QueryMerchantResponse extends Response {
    private Long merchantId;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public static QueryMerchantResponse mapper(Merchant merchant) {
        return QueryMerchantResponse.builder()
                .merchantId(merchant.getMerchantId())
                .name(merchant.getName())
                .createdAt(Timestamp.valueOf(merchant.getCreatedAt()))
                .updatedAt(Timestamp.valueOf(merchant.getUpdatedAt()))
                .build();
    }
}
