package com.gray.gocheetah.gocheetahcore.service.impl;

import com.gray.gocheetah.gocheetahcore.model.City;
import com.gray.gocheetah.gocheetahcore.repository.CityRepository;
import com.gray.gocheetah.gocheetahcore.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 31-Aug-22
 * Time: 11:24 AM
 * gocheetah-core
 */
@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;


    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Optional<City> getCityByID(Long id) {
        City byId = cityRepository.findCityById(id);
        if (byId != null) {
            return Optional.of(byId);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<City>> getAllCities() {
        return Optional.of(cityRepository.findAll());
    }

    @Override
    public Optional<City> saveCity(@Validated City city) {
        City save = cityRepository.save(city);
        return Optional.of(save);
    }

    @Override
    public Optional<City> updateCity(City city) {
        City save = cityRepository.save(city);
        return Optional.of(save);
    }

    @Override
    public Optional<City> deleteCity(City city) {
        cityRepository.delete(city);
        return Optional.of(city);
    }

    @Override
    public void deleteCityByID(long id) {
        cityRepository.deleteById(id);
    }
}
