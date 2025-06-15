package com.marykuo.asset.adapter.in.api.controller.member.query.response;

import com.marykuo.asset.adapter.in.api.response.Response;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QuerySingleMemberResponse extends Response {
    private Long memberId;
    private String firstName;
    private String lastName;
}
