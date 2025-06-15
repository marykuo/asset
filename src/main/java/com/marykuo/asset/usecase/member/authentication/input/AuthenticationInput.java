package com.marykuo.asset.usecase.member.authentication.input;

import com.marykuo.asset.usecase.Input;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthenticationInput extends Input {
    private String email;
    private String password;

    public void validate() {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
    }
}
