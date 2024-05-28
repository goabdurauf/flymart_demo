package com.rausat.flymart.models.dtos.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class RequestDto {
    @NonNull
    private Long placeId;
    @NonNull
    private Long productId;
}
