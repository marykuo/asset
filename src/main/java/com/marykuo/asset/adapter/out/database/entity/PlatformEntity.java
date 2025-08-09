package com.marykuo.asset.adapter.out.database.entity;

import com.marykuo.asset.domain.order.Platform;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "platform")
public class PlatformEntity extends Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "platform_id_sequence")
    @SequenceGenerator(name = "platform_id_sequence", sequenceName = "platform_id_sequence", allocationSize = 1)
    public Long getPlatformId() {
        return super.platformId;
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

    public PlatformEntity() {
        super();
    }

    public PlatformEntity(Platform platform) {
        super();
        this.platformId = platform.getPlatformId();
        this.memberId = platform.getMemberId();
        this.name = platform.getName();
        this.createdAt = platform.getCreatedAt();
        this.updatedAt = platform.getUpdatedAt();
    }

    public Platform toPlatform() {
        return Platform.builder()
                .platformId(this.getPlatformId())
                .memberId(this.getMemberId())
                .name(this.getName())
                .createdAt(this.getCreatedAt())
                .updatedAt(this.getUpdatedAt())
                .build();
    }
}
