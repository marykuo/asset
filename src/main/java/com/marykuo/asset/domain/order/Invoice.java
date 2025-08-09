package com.marykuo.asset.domain.order;

import com.marykuo.asset.domain.DomainModel;
import com.marykuo.asset.usecase.invoice.create.input.CreateInvoiceInput;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice extends DomainModel {
    /**
     * 發票 ID
     */
    protected Long invoiceId;
    /**
     * 會員 ID
     */
    protected Long memberId;

    /* 發票號碼 */
    protected String invoiceNumber;
    protected LocalDateTime invoiceDateTime;

    /* 賣方 */
    protected String sellerIdentifier;
    protected String sellerName;

    /* 買方 */
    // protected String buyerIdentifier;
    // protected String buyerName;

    /* 所有權 */
    protected String printMark;
    protected String donateMark;
    protected String npoBan;
    protected String carrierType;
    protected String carrierId;

    /* 金額 */
    // protected BigDecimal salesAmount;
    // protected BigDecimal freeTaxSalesAmount;
    // protected BigDecimal zeroTaxSalesAmount;
    // protected BigDecimal taxAmount;
    // protected BigDecimal totalAmount;
    protected BigDecimal amount;
    protected String currency;

    /* 狀態 */
    protected InvoiceStatusEnum status;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public Invoice(Long memberId, CreateInvoiceInput createInvoiceInput) {
        this.memberId = memberId;
        this.invoiceNumber = createInvoiceInput.getInvoiceNumber();
        this.invoiceDateTime = createInvoiceInput.getInvoiceLocalDateTime();
        this.sellerIdentifier = createInvoiceInput.getSellerIdentifier();
        this.sellerName = createInvoiceInput.getSellerName();
        this.printMark = createInvoiceInput.getPrintMark();
        this.donateMark = createInvoiceInput.getDonateMark();
        this.npoBan = createInvoiceInput.getNpoBan();
        this.carrierType = createInvoiceInput.getCarrierType();
        this.carrierId = createInvoiceInput.getCarrierId();
        this.amount = createInvoiceInput.getAmount();
        this.currency = createInvoiceInput.getCurrency();
        this.status = createInvoiceInput.getStatusEnum();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }
}
