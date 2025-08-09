package com.marykuo.asset.adapter.out.database.entity;

import com.marykuo.asset.domain.order.Item;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
public class ItemEntity extends Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_sequence")
    @SequenceGenerator(name = "item_id_sequence", sequenceName = "item_id_sequence", allocationSize = 1)
    public Long getItemId() {
        return super.itemId;
    }

    public Long getMemberId() {
        return super.memberId;
    }

    public Long getOrderId() {
        return super.orderId;
    }

    public Long getProductId() {
        return super.productId;
    }

    public Integer getSequence() {
        return super.sequence;
    }

    public String getName() {
        return super.name;
    }

    public BigDecimal getQuantity() {
        return super.quantity;
    }

    public String getUnit() {
        return super.unit;
    }

    public BigDecimal getUnitPrice() {
        return super.unitPrice;
    }

    public BigDecimal getAmount() {
        return super.amount;
    }

    public String getRelateNumber() {
        return super.relateNumber;
    }

    public String getRemark() {
        return super.remark;
    }

    public LocalDateTime getCreatedAt() {
        return super.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return super.updatedAt;
    }

    public ItemEntity() {
        super();
    }

    public ItemEntity(Item item) {
        super();
        this.itemId = item.getItemId();
        this.memberId = item.getMemberId();
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
        this.createdAt = item.getCreatedAt();
        this.updatedAt = item.getUpdatedAt();
    }

    public Item toItem() {
        return Item.builder()
                .itemId(this.getItemId())
                .memberId(this.getMemberId())
                .orderId(this.getOrderId())
                .productId(this.getProductId())
                .sequence(this.getSequence())
                .name(this.getName())
                .quantity(this.getQuantity())
                .unit(this.getUnit())
                .unitPrice(this.getUnitPrice())
                .amount(this.getAmount())
                .relateNumber(this.getRelateNumber())
                .remark(this.getRemark())
                .createdAt(this.getCreatedAt())
                .updatedAt(this.getUpdatedAt())
                .build();
    }
}
