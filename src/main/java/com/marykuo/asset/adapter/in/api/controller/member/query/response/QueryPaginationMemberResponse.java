package com.marykuo.asset.adapter.in.api.controller.member.query.response;

import com.marykuo.asset.adapter.in.api.response.Response;
import com.marykuo.asset.domain.member.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryPaginationMemberResponse extends Response {
    private Long memberId;
    private String firstName;
    private String lastName;

    public static QueryPaginationMemberResponse mapper(Member member) {
        return QueryPaginationMemberResponse.builder()
                .memberId(member.getMemberId())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .build();
    }
}
