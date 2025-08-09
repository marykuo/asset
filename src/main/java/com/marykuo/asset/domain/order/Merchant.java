package com.marykuo.asset.domain.order;

import com.marykuo.asset.domain.DomainModel;
import com.marykuo.asset.usecase.merchant.create.input.CreateMerchantInput;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Merchant extends DomainModel {
    /**
     * 平台 ID
     */
    protected Long merchantId;
    /**
     * 會員 ID
     */
    protected Long memberId;
    /**
     * 平台名稱
     */
    protected String name;
    /**
     * 建立時間
     */
    protected LocalDateTime createdAt;
    /**
     * 更新時間
     */
    protected LocalDateTime updatedAt;

    public Merchant(Long memberId, CreateMerchantInput createMerchantInput) {
        this.memberId = memberId;
        this.name = createMerchantInput.getName();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }
}
