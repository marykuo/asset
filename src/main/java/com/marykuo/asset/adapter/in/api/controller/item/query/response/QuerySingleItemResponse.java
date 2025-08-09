package com.marykuo.asset.adapter.in.api.controller.item.query.response;

import com.marykuo.asset.adapter.in.api.response.Response;
import com.marykuo.asset.domain.order.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuerySingleItemResponse extends Response {
    private Long itemId;
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
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public QuerySingleItemResponse(Item item) {
        this.itemId = item.getItemId();
        this.orderId = item.getOrderId();
        this.productId = item.getProductId();
        this.sequence = item.getSequence();
        this.name = item.getName();
        this.quantity = item.getQuantity();
        this.unit = item.getUnit();
        this.unitPrice = item.getUnitPrice();
        this.amount = item.getAmount();
        this.relateNumber = item.getRelateNumber();
        this.remark = item.getRemark();
        this.createdAt = Timestamp.valueOf(item.getCreatedAt());
        this.updatedAt = Timestamp.valueOf(item.getUpdatedAt());
    }
}
