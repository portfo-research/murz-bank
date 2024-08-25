package com.ecomurz.bank.utils.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Builder
@Getter
public class GlobalResponse {
    Integer status;
    String message;
}
