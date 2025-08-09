package com.marykuo.asset.usecase.platform.create.output;

import com.marykuo.asset.domain.order.Platform;
import com.marykuo.asset.usecase.Output;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatePlatformOutput extends Output {
    private Platform platform;
}
