package com.marykuo.asset.usecase.merchant.create;

import com.marykuo.asset.adapter.out.database.MerchantRepository;
import com.marykuo.asset.domain.order.Merchant;
import com.marykuo.asset.usecase.merchant.create.input.CreateMerchantInput;
import com.marykuo.asset.usecase.merchant.create.output.CreateMerchantOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateMerchantService {
    private final MerchantRepository merchantRepository;

    public CreateMerchantOutput execute(Long loginMemberId, CreateMerchantInput createMerchantInput) {
        log.info("CreateMerchantInput: {}", createMerchantInput);

        // validate input
        createMerchantInput.validate();

        // validate data
        merchantRepository.findByMemberIdAndName(loginMemberId, createMerchantInput.getName())
                .ifPresent(merchant -> {
                    throw new IllegalArgumentException("Merchant with the same name already exists for this member.");
                });

        // execute
        Merchant merchant = new Merchant(loginMemberId, createMerchantInput);
        merchantRepository.save(merchant);

        return CreateMerchantOutput.builder()
                .merchant(merchant)
                .build();
    }
}
