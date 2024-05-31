package com.flyingrain.autotest.domain.service;

import com.flyingrain.autotest.infrastructure.datasource.mapper.CityMapper;
import com.flyingrain.autotest.infrastructure.datasource.model.CityModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityService {

    private final Logger logger = LoggerFactory.getLogger(CityService.class);

    @Autowired
    private CityMapper cityMapper;

    public List<CityModel> queryCityByRelativeId(Integer relativeId) {
        return cityMapper.queryRelativeCity(relativeId);
    }

    public CityModel queryCityByName(String cityName){
        return cityMapper.queryCityByName(cityName);
    }

    public CityModel queryById(Integer id){
        return cityMapper.queryCityById(id);
    }
}
