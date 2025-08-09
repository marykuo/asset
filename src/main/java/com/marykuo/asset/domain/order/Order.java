package com.marykuo.asset.domain.order;

import com.marykuo.asset.domain.DomainModel;
import com.marykuo.asset.usecase.order.create.input.CreateOrderInput;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order extends DomainModel {
    /**
     * 訂單 ID
     */
    protected Long orderId;
    /**
     * 會員 ID
     */
    protected Long memberId;
    /**
     * 平台 ID
     */
    protected Long platformId;
    /**
     * 商家 ID
     */
    protected Long merchantId;
    /**
     * 發票號碼
     */
    protected String invoiceNumber;
    /**
     * 日期
     */
    protected LocalDateTime dateTime;
    /**
     * 金額
     */
    protected BigDecimal amount;
    /**
     * 金額(外幣)
     */
    protected BigDecimal amountInCurrency;
    /**
     * 幣別
     */
    protected String currency;
    /**
     * 匯率
     */
    protected Float exchangeRate;
    /**
     * 訂單狀態
     */
    protected OrderStatusEnum status;
    /**
     * 建立時間
     */
    protected LocalDateTime createdAt;
    /**
     * 更新時間
     */
    protected LocalDateTime updatedAt;

    public Order(Long loginMemberId, CreateOrderInput createOrderInput) {
        this.memberId = loginMemberId;
        this.platformId = createOrderInput.getPlatformId();
        this.merchantId = createOrderInput.getMerchantId();
        this.invoiceNumber = createOrderInput.getInvoiceNumber();
        this.dateTime = createOrderInput.getLocalDateTime();
        this.amount = createOrderInput.getAmount();
        this.amountInCurrency = createOrderInput.getAmountInCurrency();
        this.currency = createOrderInput.getCurrency();
        this.exchangeRate = createOrderInput.getExchangeRate();
        this.status = OrderStatusEnum.CREATED;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }
}
