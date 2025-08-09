package com.marykuo.asset.usecase.platform.create;

import com.marykuo.asset.adapter.out.database.PlatformRepository;
import com.marykuo.asset.domain.order.Platform;
import com.marykuo.asset.usecase.platform.create.input.CreatePlatformInput;
import com.marykuo.asset.usecase.platform.create.output.CreatePlatformOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreatePlatformService {
    private final PlatformRepository platformRepository;

    public CreatePlatformOutput execute(Long loginMemberId, CreatePlatformInput createPlatformInput) {
        log.info("CreatePlatformInput: {}", createPlatformInput);

        // validate input
        createPlatformInput.validate();

        // validate data
        platformRepository.findByMemberIdAndName(loginMemberId, createPlatformInput.getName())
                .ifPresent(platform -> {
                    throw new IllegalArgumentException("Platform with the same name already exists for this member.");
                });

        // execute
        Platform platform = new Platform(loginMemberId, createPlatformInput);
        platformRepository.save(platform);

        return CreatePlatformOutput.builder()
                .platform(platform)
                .build();
    }
}
