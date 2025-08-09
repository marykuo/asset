package com.marykuo.asset.usecase.invoice.create.input;

import com.marykuo.asset.domain.order.InvoiceStatusEnum;
import com.marykuo.asset.usecase.Input;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class CreateInvoiceInput extends Input {
    /* 發票號碼 */
    protected String invoiceNumber;
    protected Long invoiceDateTime;

    /* 賣方 */
    protected String sellerIdentifier;
    protected String sellerName;

    /* 所有權 */
    protected String printMark;
    protected String donateMark;
    protected String npoBan;
    protected String carrierType;
    protected String carrierId;

    /* 金額 */
    protected BigDecimal amount;
    protected String currency;

    /* 狀態 */
    protected String status;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public LocalDateTime getInvoiceLocalDateTime() {
        return LocalDateTime.ofEpochSecond(invoiceDateTime / 1000, 0, java.time.ZoneOffset.UTC);
    }

    public InvoiceStatusEnum getStatusEnum() {
        return InvoiceStatusEnum.valueOf(status);
    }

    public void validate() {
    }
}
