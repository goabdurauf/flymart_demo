package com.rausat.flymart.mappers;

import com.rausat.flymart.models.dtos.TransactionDto;
import com.rausat.flymart.models.dtos.TransactionResponseDto;
import com.rausat.flymart.models.entities.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {UsersMapper.class, RequestMapper.class, ProductMapper.class})
public interface TransactionMapper {
    TransactionResponseDto toTransactionResponseDto(Transaction transaction);

    Transaction toTransaction(TransactionDto transactionDto);

    void updateTransactionFromDTO(TransactionDto transactionDto, @MappingTarget Transaction transaction);
}
