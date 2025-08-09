package com.marykuo.asset.adapter.in.api.controller.invoice.create;

import com.marykuo.asset.adapter.in.api.controller.invoice.create.request.CreateInvoiceRequest;
import com.marykuo.asset.adapter.in.api.response.BaseResponse;
import com.marykuo.asset.adapter.out.database.entity.MemberEntity;
import com.marykuo.asset.usecase.invoice.CreateInvoiceService;
import com.marykuo.asset.usecase.invoice.create.input.CreateInvoiceInput;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class CreateInvoiceController {
    private final CreateInvoiceService createInvoiceService;

    @PostMapping(value = "/v1" + INVOICE)
    public ResponseEntity<BaseResponse> endpoint(
            @RequestAttribute(LOGIN_MEMBER) MemberEntity loginMember,
            @RequestBody CreateInvoiceRequest request
    ) {
        createInvoiceService.execute(
                loginMember.getMemberId(),
                CreateInvoiceInput.builder()
                        .invoiceNumber(request.getInvoiceNumber())
                        .invoiceDateTime(request.getInvoiceDateTime())
                        .sellerIdentifier(request.getSellerIdentifier())
                        .sellerName(request.getSellerName())
                        .printMark(request.getPrintMark())
                        .donateMark(request.getDonateMark())
                        .npoBan(request.getNpoBan())
                        .carrierType(request.getCarrierType())
                        .carrierId(request.getCarrierId())
                        .amount(request.getAmount())
                        .currency(request.getCurrency())
                        .status(request.getStatus())
                        .build()
        );
        return ResponseEntity.ok(BaseResponse.success());
    }
}
