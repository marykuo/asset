package com.marykuo.asset.adapter.in.api.controller.invoice.query.response;

import com.marykuo.asset.adapter.in.api.response.Response;
import com.marykuo.asset.domain.order.Invoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuerySingleInvoiceResponse extends Response {
    private String invoiceNumber;
    private Timestamp invoiceDateTime;

    private String sellerIdentifier;
    private String sellerName;

    private String printMark;
    private String donateMark;
    private String npoBan;
    private String carrierType;
    private String carrierId;

    protected BigDecimal amount;
    protected String currency;

    public QuerySingleInvoiceResponse(Invoice invoice) {
        this.invoiceNumber = invoice.getInvoiceNumber();
        this.invoiceDateTime = Timestamp.valueOf(invoice.getInvoiceDateTime());

        this.sellerIdentifier = invoice.getSellerIdentifier();
        this.sellerName = invoice.getSellerName();

        this.printMark = invoice.getPrintMark();
        this.donateMark = invoice.getDonateMark();
        this.npoBan = invoice.getNpoBan();
        this.carrierType = invoice.getCarrierType();
        this.carrierId = invoice.getCarrierId();

        this.amount = invoice.getAmount();
        this.currency = invoice.getCurrency();
    }
}
