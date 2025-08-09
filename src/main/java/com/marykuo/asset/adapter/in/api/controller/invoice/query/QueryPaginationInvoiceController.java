package com.marykuo.asset.adapter.in.api.controller.invoice.query;

import com.marykuo.asset.adapter.in.api.controller.invoice.query.response.QueryPaginationInvoiceResponse;
import com.marykuo.asset.adapter.in.api.response.PaginationResponse;
import com.marykuo.asset.adapter.out.database.InvoiceRepository;
import com.marykuo.asset.adapter.out.database.entity.MemberEntity;
import com.marykuo.asset.domain.order.Invoice;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.INVOICE;
import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ROOT_API;
import static com.marykuo.asset.adapter.in.api.filter.JwtAuthenticationFilter.LOGIN_MEMBER;

@RestController
@RequestMapping(ROOT_API)
@Tag(name = "Invoice API")
@RequiredArgsConstructor
@Slf4j
public class QueryPaginationInvoiceController {
    private final InvoiceRepository invoiceRepository;

    @GetMapping(value = "/v1" + INVOICE)
    public ResponseEntity<PaginationResponse<QueryPaginationInvoiceResponse>> endpoint(
            @RequestAttribute(LOGIN_MEMBER) MemberEntity loginMember,
            @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
            @RequestParam(value = "pageOffset", defaultValue = "0") Integer pageOffset,
            @RequestParam(value = "sortBy", defaultValue = "createdAt") String sortBy,
            @RequestParam(value = "isAscending", defaultValue = "true") boolean isAscending
    ) {
        log.debug("member[{}] query pagination invoice", loginMember.getMemberId());

        Page<Invoice> page = invoiceRepository.findAll(
                loginMember.getMemberId(),
                pageSize, pageOffset, sortBy, isAscending
        );

        return ResponseEntity.ok(new PaginationResponse<QueryPaginationInvoiceResponse>(
                page.getContent().stream()
                        .map(QueryPaginationInvoiceResponse::new)
                        .toList(),
                page.getTotalElements(),
                page.getTotalPages(),
                pageOffset,
                pageSize
        ));
    }
}
