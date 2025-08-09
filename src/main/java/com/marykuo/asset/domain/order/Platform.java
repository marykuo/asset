package com.marykuo.asset.domain.order;

import com.marykuo.asset.domain.DomainModel;
import com.marykuo.asset.usecase.platform.create.input.CreatePlatformInput;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Platform extends DomainModel {
    /**
     * 平台 ID
     */
    protected Long platformId;
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

    public Platform(Long memberId, CreatePlatformInput createPlatformInput) {
        this.memberId = memberId;
        this.name = createPlatformInput.getName();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
    }
}
