package com.rausat.flymart.controllers;

import com.rausat.flymart.models.dtos.RegionDto;
import com.rausat.flymart.models.dtos.TransactionDto;
import com.rausat.flymart.models.dtos.TransactionResponseDto;
import com.rausat.flymart.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    @PreAuthorize("hasRole('TRANSACTION_READ')")
    public ResponseEntity<List<TransactionResponseDto>> getAll() {
        return ResponseEntity.ok(transactionService.getAll());
    }

    @PostMapping
    @PreAuthorize("hasRole('TRANSACTION_CREATE')")
    public ResponseEntity<TransactionResponseDto> create(@RequestBody TransactionDto transactionDto) {
        return ResponseEntity.ok(transactionService.create(transactionDto));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('TRANSACTION_EDIT')")
    public ResponseEntity<TransactionResponseDto> update(
            @PathVariable Long id,
            @RequestBody TransactionDto transactionDto) {
        return ResponseEntity.ok(transactionService.update(id, transactionDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('TRANSACTION_DELETE')")
    public void delete(
            @PathVariable Long id) {
        transactionService.delete(id);
    }
}
