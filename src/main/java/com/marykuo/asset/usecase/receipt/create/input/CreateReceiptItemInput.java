package com.marykuo.asset.usecase.receipt.create.input;

import com.marykuo.asset.domain.receipt.ReceiptStatusEnum;
import com.marykuo.asset.usecase.Input;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class CreateReceiptInput extends Input {
    /* 發票號碼 */
    protected String invoiceNumber;
    protected LocalDateTime invoiceDateTime;

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
    protected ReceiptStatusEnum status;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    private List<ReceiptItem> itemList;

    @Getter
    @Builder
    public static class ReceiptItem {
        private Integer sequence;
        private String name;
        private BigDecimal quantity;
        private String unit;
        private BigDecimal unitPrice;
        private BigDecimal amount;
        private String relateNumber;
        private String remark;
    }

    public void validate() {
    }
}
