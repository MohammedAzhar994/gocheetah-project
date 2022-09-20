package com.gray.gocheetah.gocheetahcore.service;

import com.gray.gocheetah.gocheetahcore.model.Admin;
import com.gray.gocheetah.gocheetahcore.model.City;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 31-Aug-22
 * Time: 11:08 AM
 * gocheetah-core
 */
@Service
public interface CityService {
    public Optional<City> getCityByID(Long id);
    public Optional<List<City>> getAllCities();
    public Optional<City> saveCity(City city);
    public Optional<City> updateCity(City city);
    public Optional<City> deleteCity(City city);
    public void deleteCityByID(long id);
}
