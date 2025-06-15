package com.marykuo.asset.usecase.member.register.output;

import com.marykuo.asset.domain.member.Member;
import com.marykuo.asset.usecase.Output;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RegisterOutput extends Output {
    private Member member;
}
