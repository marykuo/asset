package com.marykuo.asset.adapter.in.api.controller.item.create.request;

import com.marykuo.asset.adapter.in.api.request.Request;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreateItemRequest extends Request {
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
}
