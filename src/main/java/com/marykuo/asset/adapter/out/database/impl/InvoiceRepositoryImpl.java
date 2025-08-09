package com.marykuo.asset.adapter.out.database.impl;

import com.marykuo.asset.adapter.out.database.InvoiceRepository;
import com.marykuo.asset.adapter.out.database.entity.InvoiceEntity;
import com.marykuo.asset.adapter.out.database.repository.InvoiceJpaRepository;
import com.marykuo.asset.domain.order.Invoice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InvoiceRepositoryImpl implements InvoiceRepository {
    private final InvoiceJpaRepository invoiceJpaRepository;

    @Override
    public InvoiceEntity save(Invoice invoice) {
        return invoiceJpaRepository.save(new InvoiceEntity(invoice));
    }

    @Override
    public Optional<Invoice> findById(Long invoiceId) {
        return invoiceJpaRepository.findById(invoiceId)
                .map(InvoiceEntity::toInvoice);
    }

    @Override
    public Optional<Invoice> findByMemberIdAndInvoiceNumber(Long memberId, String invoiceNumber) {
        return invoiceJpaRepository.findByMemberIdAndInvoiceNumber(memberId, invoiceNumber)
                .map(InvoiceEntity::toInvoice);
    }

    @Override
    public Page<Invoice> findAll(
            Long memberId,
            Integer pageSize, Integer pageOffset, String sortBy, boolean isAscending
    ) {
        Sort sort = Sort.by(isAscending ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        PageRequest pageRequest = PageRequest.of(pageOffset, pageSize, sort);

        return invoiceJpaRepository.findAllByMemberId(memberId, pageRequest)
                .map(InvoiceEntity::toInvoice);
    }
}
