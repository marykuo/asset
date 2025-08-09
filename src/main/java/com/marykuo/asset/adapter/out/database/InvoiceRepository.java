package com.marykuo.asset.adapter.out.database;

import com.marykuo.asset.domain.order.Invoice;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface InvoiceRepository {
    Invoice save(Invoice invoice);

    Optional<Invoice> findById(Long invoiceId);

    Optional<Invoice> findByMemberIdAndInvoiceNumber(Long memberId, String invoiceNumber);

    Page<Invoice> findAll(Long memberId, Integer pageSize, Integer pageOffset, String sortBy, boolean isAscending);
}
