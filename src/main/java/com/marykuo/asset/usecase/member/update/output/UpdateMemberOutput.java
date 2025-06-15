package com.marykuo.asset.usecase.member.update.output;

import com.marykuo.asset.domain.member.Member;
import com.marykuo.asset.usecase.Output;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateMemberOutput extends Output {
    private Member member;
}
