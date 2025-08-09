package com.marykuo.asset.adapter.in.api.controller.merchant.create.request;

import com.marykuo.asset.adapter.in.api.request.Request;
import lombok.Getter;

@Getter
public class CreateMerchantRequest extends Request {
    private String name;
}
