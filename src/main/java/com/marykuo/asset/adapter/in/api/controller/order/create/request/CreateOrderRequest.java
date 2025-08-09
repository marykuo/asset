package com.marykuo.asset.adapter.in.api.controller.order.create.request;

import com.marykuo.asset.adapter.in.api.request.Request;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreateOrderRequest extends Request {
    /* 平台 & 商家 */
    protected Long platformId;
    protected Long merchantId;

    /* 發票號碼 */
    protected String invoiceNumber;

    /* 交易資訊 */
    protected Long dateTime;
    protected BigDecimal amount;
    protected BigDecimal amountInCurrency;
    protected String currency;
    protected Float exchangeRate;
}
