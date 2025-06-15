package com.marykuo.asset.adapter.in.api.controller.member.login.response;

import com.marykuo.asset.adapter.in.api.response.Response;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse extends Response {
    private String token;
}
