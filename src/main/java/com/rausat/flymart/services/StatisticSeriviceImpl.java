package com.rausat.flymart.services;

import com.rausat.flymart.mappers.RegionMapper;
import com.rausat.flymart.models.dtos.RegionDto;
import com.rausat.flymart.models.dtos.RegionPerNTDto;
import com.rausat.flymart.models.entities.Region;
import com.rausat.flymart.models.entities.Transaction;
import com.rausat.flymart.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticSeriviceImpl {
    private final TransactionRepository transactionRepository;
    private final RegionMapper regionMapper;

    public StatisticSeriviceImpl(TransactionRepository transactionRepository, RegionMapper regionMapper) {
        this.transactionRepository = transactionRepository;
        this.regionMapper = regionMapper;
    }

    public List<RegionPerNTDto> getRegionPerBTDto(){
        Map<String, List<Transaction>> map = new HashMap<>();
        List<Transaction> all = transactionRepository.findAll();
        for (Transaction t: all) {
            String key = t.getRequest().getPlace().getRegion().getName();
            if (map.containsKey(key)){
                map.get(key).add(t);
            }else {
                List<Transaction> list = new ArrayList<>();
                list.add(t);
                map.put(key,list);
            }
        }
        Map<Integer, List<RegionDto>> regionMap = new HashMap<>();
        for (Map.Entry<String, List<Transaction>> entry : map.entrySet()) {
            int size = entry.getValue().size();
            if(regionMap.containsKey(size)){
                Region region = entry.getValue().get(0).getRequest().getPlace().getRegion();// get(0) will not throw exception because there will be always item in zero position
                regionMap.get(size).add(regionMapper.toRegionDto(region));
            }else {
                Region region = entry.getValue().get(0).getRequest().getPlace().getRegion();
                List<RegionDto> list = new ArrayList<>();
                list.add(regionMapper.toRegionDto(region));
               regionMap.put(size, list);
            }
        }
        List<RegionPerNTDto> response = new ArrayList<>();
        for (Map.Entry<Integer, List<RegionDto>> entry : regionMap.entrySet()) {
            RegionPerNTDto item = new RegionPerNTDto();
            item.setRegions(entry.getValue());
            item.setTransactionNumber(entry.getKey());
            response.add(item);
        }
        return response;
    }


}
