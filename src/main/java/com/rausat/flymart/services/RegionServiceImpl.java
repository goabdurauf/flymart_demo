package com.rausat.flymart.services;

import com.rausat.flymart.mappers.RegionMapper;
import com.rausat.flymart.models.dtos.RegionDto;
import com.rausat.flymart.models.entities.Region;
import com.rausat.flymart.repositories.RegionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;
    private final RegionMapper regionMapper;

    public RegionServiceImpl(RegionRepository regionRepository, RegionMapper regionMapper, RegionMapper regionMapper1) {
        this.regionRepository = regionRepository;
        this.regionMapper = regionMapper1;
    }


    @Override
    public List<RegionDto> getAll() {
        return regionRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Region::getName))
                .map(regionMapper::toRegionDto)
                .toList();
    }

    @Override
    public RegionDto create(RegionDto regionDto) {
        regionRepository.save(regionMapper.toRegion(regionDto));
        return regionDto;
    }

    @Override
    public RegionDto update(Long id, RegionDto regionDto) {
        Region byId = findById(id);
        regionMapper.updateRegionFroDTO(regionDto, byId, id);

        return regionMapper.toRegionDto(regionRepository.save(byId));
    }


    @Override
    public void delete(Long id) {
        regionRepository.delete(findById(id));
    }

    private Region findById(Long id) {
        return regionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("entity not found with this id: " + id));
    }
}
