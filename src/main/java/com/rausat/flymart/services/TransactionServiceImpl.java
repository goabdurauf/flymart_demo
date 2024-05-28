package com.rausat.flymart.services;

import com.rausat.flymart.mappers.TransactionMapper;
import com.rausat.flymart.models.dtos.TransactionDto;
import com.rausat.flymart.models.dtos.TransactionResponseDto;
import com.rausat.flymart.models.entities.Product;
import com.rausat.flymart.models.entities.Request;
import com.rausat.flymart.models.entities.Transaction;
import com.rausat.flymart.models.entities.Users;
import com.rausat.flymart.repositories.ProductRepository;
import com.rausat.flymart.repositories.RequestRepository;
import com.rausat.flymart.repositories.TransactionRepository;
import com.rausat.flymart.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionMapper transactionMapper, UserRepository userRepository, RequestRepository requestRepository, ProductRepository productRepository) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
        this.userRepository = userRepository;
        this.requestRepository = requestRepository;
        this.productRepository = productRepository;
    }

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final UserRepository userRepository;
    private final RequestRepository requestRepository;
    private final ProductRepository productRepository;


    @Override
    public List<TransactionResponseDto> getAll() {
        return transactionRepository.findAll().stream()
                .map(transactionMapper::toTransactionResponseDto).toList();
    }

    @Override
    public TransactionResponseDto create(TransactionDto transactionDto) {
        Users user = getUser(transactionDto.getUserId());
        Request request = getRequest(transactionDto.getRequestId());
        Product product = getProduct(transactionDto.getProductId());
        Transaction transaction = transactionMapper.toTransaction(transactionDto);
        transaction.setUsers(user);
        transaction.setProduct(product);
        transaction.setRequest(request);
        return transactionMapper.toTransactionResponseDto(transactionRepository.save(transaction));
    }

    private Request getRequest(Long requestId) {
        return requestRepository.findById(requestId).orElseThrow(() -> new EntityNotFoundException("Request not found"));
    }

    private Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    private Users getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("user not found"));
    }

    @Override
    public TransactionResponseDto update(Long id, TransactionDto transactionDto) {
        Transaction transaction = getTransaction(id);
        Users user = getUser(transactionDto.getUserId());
        Request request = getRequest(transactionDto.getRequestId());
        Product product = getProduct(transactionDto.getProductId());
        transaction.setUsers(user);
        transaction.setProduct(product);
        transaction.setRequest(request);
        transactionMapper.updateTransactionFromDTO(transactionDto, transaction);
        return transactionMapper.toTransactionResponseDto(transactionRepository.save(transaction));
    }

    private Transaction getTransaction(Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Transaction not found"));
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = getTransaction(id);
        transactionRepository.delete(transaction);
    }
}
