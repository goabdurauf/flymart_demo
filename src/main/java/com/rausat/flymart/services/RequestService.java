package com.rausat.flymart.services;


import com.rausat.flymart.models.dtos.request.RequestDto;
import com.rausat.flymart.models.dtos.request.RequestResponseDto;

import java.util.List;

public interface RequestService {
    List<RequestResponseDto> getAll();
    RequestResponseDto create(RequestDto requestDto);
    RequestResponseDto update(Long id, RequestDto requestDto);
    void delete(Long id);

    RequestResponseDto getById(Long id);
}
