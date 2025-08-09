package com.marykuo.asset.usecase.order.create.input;

import com.marykuo.asset.usecase.Input;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class CreateOrderInput extends Input {
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

    public LocalDateTime getLocalDateTime() {
        return LocalDateTime.ofEpochSecond(dateTime, 0, java.time.ZoneOffset.UTC);
    }

    public void validate() {
    }
}
