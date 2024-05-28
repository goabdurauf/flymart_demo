package com.rausat.flymart.services;

import com.rausat.flymart.models.dtos.RoleDto;
import com.rausat.flymart.models.dtos.TransactionDto;
import com.rausat.flymart.models.dtos.TransactionResponseDto;

import java.util.List;

public interface TransactionService {
    List<TransactionResponseDto> getAll();
    TransactionResponseDto create(TransactionDto transactionDto);
    TransactionResponseDto update(Long id, TransactionDto transactionDto);
    void delete(Long id);
}
