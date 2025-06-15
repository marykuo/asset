package com.marykuo.asset.adapter.in.api.controller.member.login.request;

import com.marykuo.asset.adapter.in.api.request.Request;
import lombok.Getter;

@Getter
public class LoginRequest extends Request {
    private String email;
    private String password;
}
