package com.marykuo.asset.adapter.in.api.controller.resource.response;

import com.marykuo.asset.adapter.in.api.response.Response;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryResourceResponse extends Response {
    private Integer id;
    private String name;
}
