package com.marykuo.asset.usecase.merchant.create.input;

import com.marykuo.asset.usecase.Input;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateMerchantInput extends Input {
    protected String name;

    public void validate() {
    }
}
