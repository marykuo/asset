package com.marykuo.asset.adapter.in.api.controller.member.register.request;

import com.marykuo.asset.adapter.in.api.request.Request;
import lombok.Getter;

@Getter
public class RegisterRequest extends Request {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
