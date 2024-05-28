package com.rausat.flymart.services;

import com.rausat.flymart.mappers.PlaceMapper;
import com.rausat.flymart.models.dtos.place.PlaceDto;
import com.rausat.flymart.models.dtos.place.PlaceResponseDto;
import com.rausat.flymart.models.entities.Place;
import com.rausat.flymart.models.entities.Region;
import com.rausat.flymart.repositories.PlaceRepository;
import com.rausat.flymart.repositories.RegionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;
    private final PlaceMapper placeMapper;
    private final RegionRepository regionRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository, PlaceMapper placeMapper, RegionRepository regionRepository, RegionService regionService, RegionRepository regionService1, RegionRepository regionRepository1) {
        this.placeRepository = placeRepository;
        this.placeMapper = placeMapper;
        this.regionRepository = regionRepository;
    }

    @Override
    public List<PlaceResponseDto> getAll() {
        return placeRepository.findAll()
                .stream()
                .map(placeMapper::toPlaceResponseDto)
                .toList();
    }

    @Override
    @Transactional
    public PlaceResponseDto create(PlaceDto placeDto) {

        Region region = getRegion(placeDto.getRegionId());
        Place place = placeMapper.toPlace(placeDto);
        place.setRegion(region);

        Place saveed = placeRepository.save(place);
        return placeMapper.toPlaceResponseDto(saveed);
    }


    @Override
    public PlaceResponseDto update(Long id, PlaceDto placeDto) {
        Region region = getRegion(placeDto.getRegionId());
        Place place = getPlace(id);
        placeMapper.updatePlaceFroDTO(placeDto,place);
        place.setRegion(region);
        placeRepository.save(place);
        return placeMapper.toPlaceResponseDto(place);
    }

    @Override
    public void delete(Long id) {
        Place place = getPlace(id);
        placeRepository.delete(place);
    }

    private Region getRegion(Long regionId) {
        return regionRepository.findById(regionId)
                .orElseThrow(() -> new EntityNotFoundException("Region Entity not found with this id: " + regionId));
    }

    private Place getPlace(Long placeId){
        return placeRepository.findById(placeId)
                .orElseThrow(() -> new EntityNotFoundException("Place Entity not found with this id: " + placeId));
    }

}
