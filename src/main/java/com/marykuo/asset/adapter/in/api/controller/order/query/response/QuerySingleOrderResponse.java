package com.marykuo.asset.adapter.in.api.controller.order.query.response;

import com.marykuo.asset.adapter.in.api.response.Response;
import com.marykuo.asset.domain.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuerySingleOrderResponse extends Response {
    private Long orderId;
    private Long platformId;
    private Long merchantId;
    private String invoiceNumber;
    private Timestamp dateTime;
    private BigDecimal amount;
    private BigDecimal amountInCurrency;
    private String currency;
    private Float exchangeRate;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public QuerySingleOrderResponse(Order order) {
        this.orderId = order.getOrderId();
        this.platformId = order.getPlatformId();
        this.merchantId = order.getMerchantId();
        this.invoiceNumber = order.getInvoiceNumber();
        this.dateTime = Timestamp.valueOf(order.getDateTime());
        this.amount = order.getAmount();
        this.amountInCurrency = order.getAmountInCurrency();
        this.currency = order.getCurrency();
        this.exchangeRate = order.getExchangeRate();
        this.status = order.getStatus().name();
        this.createdAt = Timestamp.valueOf(order.getCreatedAt());
        this.updatedAt = Timestamp.valueOf(order.getUpdatedAt());
    }
}
