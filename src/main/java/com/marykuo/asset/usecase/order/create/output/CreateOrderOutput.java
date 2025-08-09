package com.marykuo.asset.usecase.order.create.output;

import com.marykuo.asset.domain.order.Order;
import com.marykuo.asset.usecase.Output;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateOrderOutput extends Output {
    private Order order;
}
