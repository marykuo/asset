package com.marykuo.asset.usecase.platform.create.input;

import com.marykuo.asset.usecase.Input;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreatePlatformInput extends Input {
    protected String name;

    public void validate() {
    }
}
