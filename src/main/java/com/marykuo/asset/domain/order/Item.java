package com.marykuo.asset.domain.order;

import com.marykuo.asset.domain.DomainModel;
import com.marykuo.asset.usecase.item.create.input.CreateItemInput;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item extends DomainModel {
    /**
     * 明細 ID
     */
    protected Long itemId;
    /**
     * 會員 ID
     */
    protected Long memberId;
    /**
     * 訂單 ID
     */
    protected Long orderId;
    /**
     * 商品 ID
     */
    protected Long productId;
    /**
     * 明細排列序號
     */
    protected Integer sequence;
    /**
     * 品名
     */
    protected String name;
    /**
     * 數量
     */
    protected BigDecimal quantity;
    /**
     * 單位
     */
    protected String unit;
    /**
     * 單價
     */
    protected BigDecimal unitPrice;
    /**
     * 金額
     */
    protected BigDecimal amount;
    /**
     * 相關號碼
     */
    protected String relateNumber;
    /**
     * 備註
     */
    protected String remark;
    /**
     * 建立時間
     */
    protected LocalDateTime createdAt;
    /**
     * 更新時間
     */
    protected LocalDateTime updatedAt;

    public Item(Long loginMemberId, CreateItemInput createItemInput) {
        this.memberId = loginMemberId;
        this.orderId = createItemInput.getOrderId();
        this.sequence = createItemInput.getSequence();
        this.name = createItemInput.getName();
        this.quantity = createItemInput.getQuantity();
        this.unit = createItemInput.getUnit();
        this.unitPrice = createItemInput.getUnitPrice();
        this.amount = createItemInput.getAmount();
        this.relateNumber = createItemInput.getRelateNumber();
        this.remark = createItemInput.getRemark();
    }
}
