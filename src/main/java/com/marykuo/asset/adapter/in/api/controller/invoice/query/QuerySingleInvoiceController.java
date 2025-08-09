package com.marykuo.asset.adapter.in.api.controller.invoice.query;

import com.marykuo.asset.adapter.in.api.controller.invoice.query.response.QuerySingleInvoiceResponse;
import com.marykuo.asset.adapter.in.api.response.DataResponse;
import com.marykuo.asset.adapter.out.database.InvoiceRepository;
import com.marykuo.asset.adapter.out.database.entity.MemberEntity;
import com.marykuo.asset.domain.order.Invoice;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.INVOICE_SINGLE;
import static com.marykuo.asset.adapter.in.api.constant.ApiPathConst.ROOT_API;
import static com.marykuo.asset.adapter.in.api.filter.JwtAuthenticationFilter.LOGIN_MEMBER;

@RestController
@RequestMapping(ROOT_API)
@Tag(name = "Invoice API")
@RequiredArgsConstructor
@Slf4j
public class QuerySingleInvoiceController {
    private final InvoiceRepository invoiceRepository;

    @GetMapping(value = "/v1" + INVOICE_SINGLE)
    public ResponseEntity<DataResponse<QuerySingleInvoiceResponse>> endpoint(
            @RequestAttribute(LOGIN_MEMBER) MemberEntity loginMember,
            @PathVariable("invoiceNumber") String invoiceNumber
    ) {
        log.debug("member[{}] query invoice[{}]", loginMember.getMemberId(), invoiceNumber);

        Invoice invoice = invoiceRepository.findByMemberIdAndInvoiceNumber(loginMember.getMemberId(), invoiceNumber)
                .orElseThrow(NoSuchElementException::new);

        return ResponseEntity.ok(new DataResponse<>(
                new QuerySingleInvoiceResponse(invoice)
        ));
    }
}
