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
public class QueryPaginationInvoiceResponse extends Response {
    private String invoiceNumber;
    private Timestamp invoiceDateTime;

    private String sellerIdentifier;
    private String sellerName;

    private String type;

    private BigDecimal amount;
    private String currency;

    private String status;

    public QueryPaginationInvoiceResponse(Invoice invoice) {
        this.invoiceNumber = invoice.getInvoiceNumber();
        this.invoiceDateTime = Timestamp.valueOf(invoice.getInvoiceDateTime());
        this.sellerIdentifier = invoice.getSellerIdentifier();
        this.sellerName = invoice.getSellerName();
        this.type = getType(invoice.getPrintMark(), invoice.getDonateMark(), invoice.getCarrierType());
        this.amount = invoice.getAmount();
        this.currency = invoice.getCurrency();
        this.status = invoice.getStatus().name();
    }

    private String getType(String printMark, String donateMark, String carrierType) {
        if (printMark != null) {
            return "紙本";
        } else if (donateMark != null) {
            return "捐贈";
        } else if (carrierType != null) {
            return switch (carrierType) {
                case "3J0002" -> "手機條碼";
                case "CQ0001" -> "自然人憑證";
                case "5G0001" -> "跨境電商載具";
                default -> carrierType;
            };
        } else {
            return "";
        }
    }
}
