package com.marykuo.asset.adapter.out.database.entity;

import com.marykuo.asset.domain.order.Merchant;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "merchant")
public class MerchantEntity extends Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "merchant_id_sequence")
    @SequenceGenerator(name = "merchant_id_sequence", sequenceName = "merchant_id_sequence", allocationSize = 1)
    public Long getMerchantId() {
        return super.merchantId;
    }

    public Long getMemberId() {
        return super.memberId;
    }

    public String getName() {
        return super.name;
    }

    public LocalDateTime getCreatedAt() {
        return super.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return super.updatedAt;
    }

    public MerchantEntity() {
        super();
    }

    public MerchantEntity(Merchant merchant) {
        super();
        this.merchantId = merchant.getMerchantId();
        this.memberId = merchant.getMemberId();
        this.name = merchant.getName();
        this.createdAt = merchant.getCreatedAt();
        this.updatedAt = merchant.getUpdatedAt();
    }

    public Merchant toMerchant() {
        return Merchant.builder()
                .merchantId(this.getMerchantId())
                .memberId(this.getMemberId())
                .name(this.getName())
                .createdAt(this.getCreatedAt())
                .updatedAt(this.getUpdatedAt())
                .build();
    }
}
