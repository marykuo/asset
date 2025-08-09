package com.marykuo.asset.usecase.item.create.input;

import com.marykuo.asset.usecase.Input;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class CreateItemInput extends Input {
    private Long orderId;
    private Long productId;
    private Integer sequence;
    private String name;
    private BigDecimal quantity;
    private String unit;
    private BigDecimal unitPrice;
    private BigDecimal amount;
    private String relateNumber;
    private String remark;

    public void validate() {
    }
}
