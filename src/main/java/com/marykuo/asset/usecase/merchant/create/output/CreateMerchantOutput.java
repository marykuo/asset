package com.marykuo.asset.usecase.merchant.create.output;

import com.marykuo.asset.domain.order.Merchant;
import com.marykuo.asset.usecase.Output;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateMerchantOutput extends Output {
    private Merchant merchant;
}
