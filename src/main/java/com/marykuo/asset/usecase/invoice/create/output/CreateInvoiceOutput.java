package com.marykuo.asset.usecase.invoice.create.output;

import com.marykuo.asset.domain.order.Invoice;
import com.marykuo.asset.usecase.Output;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateInvoiceOutput extends Output {
    private Invoice invoice;
}
