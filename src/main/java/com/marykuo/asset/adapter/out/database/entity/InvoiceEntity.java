package com.marykuo.asset.adapter.out.database.entity;

import com.marykuo.asset.domain.order.Invoice;
import com.marykuo.asset.domain.order.InvoiceStatusEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoice")
public class InvoiceEntity extends Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_id_sequence")
    @SequenceGenerator(name = "invoice_id_sequence", sequenceName = "invoice_id_sequence", allocationSize = 1)
    public Long getInvoiceId() {
        return super.invoiceId;
    }

    public Long getMemberId() {
        return super.memberId;
    }

    public String getInvoiceNumber() {
        return super.invoiceNumber;
    }

    public LocalDateTime getInvoiceDateTime() {
        return super.invoiceDateTime;
    }

    public String getYearMonth() {
        String year = String.format("%03d", super.getInvoiceDateTime().getYear() - 1911);
        boolean isOdd = super.getInvoiceDateTime().getMonthValue() % 2 != 0;
        String month = String.format("%02d", super.getInvoiceDateTime().getMonthValue() + (isOdd ? 1 : 0));
        return year + month;
    }

    public void setYearMonth(String yearMonth) {
        // This method is not used in the current implementation
    }

    public String getSellerIdentifier() {
        return super.sellerIdentifier;
    }

    public String getSellerName() {
        return super.sellerName;
    }

    public String getPrintMark() {
        return super.printMark;
    }

    public String getDonateMark() {
        return super.donateMark;
    }

    public String getNpoBan() {
        return super.npoBan;
    }

    public String getCarrierType() {
        return super.carrierType;
    }

    public String getCarrierId() {
        return super.carrierId;
    }

    public BigDecimal getAmount() {
        return super.amount;
    }

    public String getCurrency() {
        return super.currency;
    }

    @Enumerated(EnumType.STRING)
    public InvoiceStatusEnum getStatus() {
        return super.status;
    }

    public LocalDateTime getCreatedAt() {
        return super.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return super.updatedAt;
    }

    public InvoiceEntity() {
        super();
    }

    public InvoiceEntity(Invoice invoice) {
        super();
        this.invoiceId = invoice.getInvoiceId();
        this.memberId = invoice.getMemberId();
        this.invoiceNumber = invoice.getInvoiceNumber();
        this.invoiceDateTime = invoice.getInvoiceDateTime();
        this.sellerIdentifier = invoice.getSellerIdentifier();
        this.sellerName = invoice.getSellerName();
        this.printMark = invoice.getPrintMark();
        this.donateMark = invoice.getDonateMark();
        this.npoBan = invoice.getNpoBan();
        this.carrierType = invoice.getCarrierType();
        this.carrierId = invoice.getCarrierId();
        this.amount = invoice.getAmount();
        this.currency = invoice.getCurrency();
        this.status = invoice.getStatus();
        this.createdAt = invoice.getCreatedAt();
        this.updatedAt = invoice.getUpdatedAt();
    }

    public Invoice toInvoice() {
        return Invoice.builder()
                .invoiceId(this.invoiceId)
                .memberId(this.memberId)
                .invoiceNumber(this.invoiceNumber)
                .invoiceDateTime(this.invoiceDateTime)
                .sellerIdentifier(this.sellerIdentifier)
                .sellerName(this.sellerName)
                .printMark(this.printMark)
                .donateMark(this.donateMark)
                .npoBan(this.npoBan)
                .carrierType(this.carrierType)
                .carrierId(this.carrierId)
                .amount(this.amount)
                .currency(this.currency)
                .status(this.status)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .build();
    }
}
