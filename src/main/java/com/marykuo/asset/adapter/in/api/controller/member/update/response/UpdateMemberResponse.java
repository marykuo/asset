package com.marykuo.asset.adapter.in.api.controller.member.update.response;

import com.marykuo.asset.adapter.in.api.response.Response;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateMemberResponse extends Response {
    private String firstName;
    private String lastName;
}
