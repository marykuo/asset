package com.marykuo.asset.adapter.in.api.controller.invoice.create.request;

import com.marykuo.asset.adapter.in.api.request.Request;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreateInvoiceRequest extends Request {
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
}
