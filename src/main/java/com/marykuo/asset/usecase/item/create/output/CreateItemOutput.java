package com.marykuo.asset.usecase.item.create.output;

import com.marykuo.asset.domain.order.Item;
import com.marykuo.asset.usecase.Output;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateItemOutput extends Output {
    private Item item;
}
