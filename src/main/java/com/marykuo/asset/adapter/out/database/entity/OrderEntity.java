package com.marykuo.asset.adapter.out.database.entity;

import com.marykuo.asset.domain.order.Order;
import com.marykuo.asset.domain.order.OrderStatusEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_info")
public class OrderEntity extends Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_id_sequence")
    @SequenceGenerator(name = "order_id_sequence", sequenceName = "order_id_sequence", allocationSize = 1)
    public Long getOrderId() {
        return super.orderId;
    }

    public Long getMemberId() {
        return super.memberId;
    }

    public Long getPlatformId() {
        return super.platformId;
    }

    public Long getMerchantId() {
        return super.merchantId;
    }

    public String getInvoiceNumber() {
        return super.invoiceNumber;
    }

    public LocalDateTime getDateTime() {
        return super.dateTime;
    }

    public BigDecimal getAmount() {
        return super.amount;
    }

    public BigDecimal getAmountInCurrency() {
        return super.amountInCurrency;
    }

    public String getCurrency() {
        return super.currency;
    }

    public Float getExchangeRate() {
        return super.exchangeRate;
    }

    @Enumerated(EnumType.STRING)
    public OrderStatusEnum getStatus() {
        return super.status;
    }

    public LocalDateTime getCreatedAt() {
        return super.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return super.updatedAt;
    }

    public OrderEntity() {
        super();
    }

    public OrderEntity(Order order) {
        super();
        this.orderId = order.getOrderId();
        this.memberId = order.getMemberId();
        this.platformId = order.getPlatformId();
        this.merchantId = order.getMerchantId();
        this.invoiceNumber = order.getInvoiceNumber();
        this.dateTime = order.getDateTime();
        this.amount = order.getAmount();
        this.amountInCurrency = order.getAmountInCurrency();
        this.currency = order.getCurrency();
        this.exchangeRate = order.getExchangeRate();
        this.status = order.getStatus();
        this.createdAt = order.getCreatedAt();
        this.updatedAt = order.getUpdatedAt();
    }

    public Order toOrder() {
        return Order.builder()
                .orderId(this.getOrderId())
                .memberId(this.getMemberId())
                .platformId(this.getPlatformId())
                .merchantId(this.getMerchantId())
                .invoiceNumber(this.getInvoiceNumber())
                .dateTime(this.getDateTime())
                .amount(this.getAmount())
                .amountInCurrency(this.getAmountInCurrency())
                .currency(this.getCurrency())
                .exchangeRate(this.getExchangeRate())
                .status(this.getStatus())
                .createdAt(this.getCreatedAt())
                .updatedAt(this.getUpdatedAt())
                .build();
    }
}
