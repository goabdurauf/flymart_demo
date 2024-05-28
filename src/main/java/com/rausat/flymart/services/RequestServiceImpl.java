package com.rausat.flymart.services;

import com.rausat.flymart.mappers.RequestMapper;
import com.rausat.flymart.models.dtos.request.RequestDto;
import com.rausat.flymart.models.dtos.request.RequestResponseDto;
import com.rausat.flymart.models.entities.Place;
import com.rausat.flymart.models.entities.Product;
import com.rausat.flymart.models.entities.Request;
import com.rausat.flymart.repositories.PlaceRepository;
import com.rausat.flymart.repositories.ProductRepository;
import com.rausat.flymart.repositories.RequestRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RequestServiceImpl implements RequestService {
    public RequestServiceImpl(RequestRepository requestRepository, RequestMapper requestMapper, PlaceRepository placeRepository, ProductRepository productRepository) {
        this.requestRepository = requestRepository;
        this.requestMapper = requestMapper;
        this.placeRepository = placeRepository;
        this.productRepository = productRepository;
    }

    private final RequestRepository requestRepository;
    private final RequestMapper requestMapper;
    private final PlaceRepository placeRepository;
    private final ProductRepository productRepository;


    @Override
    public List<RequestResponseDto> getAll() {
        return requestRepository.findAll().stream()
                .map(requestMapper::toRequestResponseDto)
                .toList();
    }

    @Override
    public RequestResponseDto create(RequestDto requestDto) {
        Place place = getPlace(requestDto.getPlaceId());
        Product product = getProduct(requestDto.getProductId());
        Request request = requestMapper.toRequest(requestDto);
        request.setPlace(place);
        request.setProduct(product);
        return requestMapper.toRequestResponseDto(requestRepository.save(request));
    }


    @Override
    public RequestResponseDto update(Long id, RequestDto requestDto) {
        Request request = getRequest(id);
        Place place = getPlace(requestDto.getPlaceId());
        Product product = getProduct(requestDto.getProductId());
        requestMapper.updateRegionFroDTO(requestDto, request);
        request.setProduct(product);
        request.setPlace(place);
        return requestMapper.toRequestResponseDto(requestRepository.save(request));
    }

    private Request getRequest(Long id) {
        return requestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Request not found"));
    }

    @Override
    public void delete(Long id) {
        Request request = getRequest(id);
        requestRepository.delete(request);
    }

    @Override
    public RequestResponseDto getById(Long id) {
        return requestMapper.toRequestResponseDto(getRequest(id));
    }

    private Place getPlace(Long id) {
        return placeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Place not found"));
    }

    private Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }
}
