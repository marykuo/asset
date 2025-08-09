package com.marykuo.asset.adapter.in.api.controller.platform.query.response;

import com.marykuo.asset.adapter.in.api.response.Response;
import com.marykuo.asset.domain.order.Platform;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class QueryPlatformResponse extends Response {
    private Long platformId;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public static QueryPlatformResponse mapper(Platform platform) {
        return QueryPlatformResponse.builder()
                .platformId(platform.getPlatformId())
                .name(platform.getName())
                .createdAt(Timestamp.valueOf(platform.getCreatedAt()))
                .updatedAt(Timestamp.valueOf(platform.getUpdatedAt()))
                .build();
    }
}
