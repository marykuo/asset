package com.marykuo.asset.usecase.invoice;

import com.marykuo.asset.adapter.out.database.InvoiceRepository;
import com.marykuo.asset.domain.order.Invoice;
import com.marykuo.asset.usecase.invoice.create.input.CreateInvoiceInput;
import com.marykuo.asset.usecase.invoice.create.output.CreateInvoiceOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateInvoiceService {
    private final InvoiceRepository invoiceRepository;

    public CreateInvoiceOutput execute(Long loginMemberId, CreateInvoiceInput createInvoiceInput) {
        log.info("CreateInvoiceInput: {}", createInvoiceInput);

        // validate input
        createInvoiceInput.validate();

        // validate data
        invoiceRepository.findByMemberIdAndInvoiceNumber(loginMemberId, createInvoiceInput.getInvoiceNumber())
                .ifPresent(invoice -> {
                    log.info("member[{}] create duplicate invoice number: {}", loginMemberId, createInvoiceInput.getInvoiceNumber());
                    throw new IllegalArgumentException("invoice already exists: " + createInvoiceInput.getInvoiceNumber());
                });

        // execute
        Invoice invoice = new Invoice(loginMemberId, createInvoiceInput);
        invoiceRepository.save(invoice);

        return CreateInvoiceOutput.builder()
                .invoice(invoice)
                .build();
    }
}
