package com.marykuo.asset.usecase.order.create;

import com.marykuo.asset.adapter.out.database.InvoiceRepository;
import com.marykuo.asset.adapter.out.database.MerchantRepository;
import com.marykuo.asset.adapter.out.database.OrderRepository;
import com.marykuo.asset.adapter.out.database.PlatformRepository;
import com.marykuo.asset.domain.order.Invoice;
import com.marykuo.asset.domain.order.Merchant;
import com.marykuo.asset.domain.order.Order;
import com.marykuo.asset.domain.order.Platform;
import com.marykuo.asset.usecase.order.create.input.CreateOrderInput;
import com.marykuo.asset.usecase.order.create.output.CreateOrderOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateOrderService {
    private final PlatformRepository platformRepository;
    private final MerchantRepository merchantRepository;
    private final InvoiceRepository invoiceRepository;
    private final OrderRepository orderRepository;

    public CreateOrderOutput execute(Long loginMemberId, CreateOrderInput createOrderInput) {
        log.info("CreateOrderInput: {}", createOrderInput);

        // validate input
        createOrderInput.validate();

        // validate data
        if (createOrderInput.getPlatformId() != null) {
            Optional<Platform> platformOpt = platformRepository.findByMemberIdAndPlatformId(loginMemberId, createOrderInput.getPlatformId());
            if (platformOpt.isEmpty()) {
                throw new IllegalArgumentException("platform not exist");
            }
        }
        if (createOrderInput.getMerchantId() != null) {
            Optional<Merchant> merchantOpt = merchantRepository.findByMemberIdAndMerchantId(loginMemberId, createOrderInput.getMerchantId());
            if (merchantOpt.isEmpty()) {
                throw new IllegalArgumentException("merchant not exist");
            }
        }
        if (StringUtils.isNotEmpty(createOrderInput.getInvoiceNumber())) {
            Optional<Invoice> invoiceOpt = invoiceRepository.findByMemberIdAndInvoiceNumber(loginMemberId, createOrderInput.getInvoiceNumber());
            if (invoiceOpt.isEmpty()) {
                throw new IllegalArgumentException("invoice not exist");
            }
        }

        // execute
        Order order = new Order(loginMemberId, createOrderInput);
        orderRepository.save(order);

        return CreateOrderOutput.builder()
                .order(order)
                .build();
    }
}
