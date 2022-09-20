package com.gray.gocheetah.gocheetahcore.service.impl;

import com.gray.gocheetah.gocheetahcore.model.IntercityPrice;
import com.gray.gocheetah.gocheetahcore.repository.IntercityPriceRepository;
import com.gray.gocheetah.gocheetahcore.service.IntercityPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 31-Aug-22
 * Time: 11:33 AM
 * gocheetah-core
 */
@Service
public class IntercityPriceServiceImpl implements IntercityPriceService {

    private IntercityPriceRepository priceRepository;
    @Autowired
    public IntercityPriceServiceImpl(IntercityPriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Optional<IntercityPrice> getPriceByID(Long id) {
        return priceRepository.findById(id);
    }

    @Override
    public List<IntercityPrice> getAllPrices() {
        return priceRepository.findAll();
    }

    @Override
    public Optional<IntercityPrice> savePrice(IntercityPrice price) {
        IntercityPrice save = priceRepository.save(price);
        return Optional.of(save);
    }

    @Override
    public Optional<IntercityPrice> updatePrice(IntercityPrice price) {
        IntercityPrice save = priceRepository.save(price);
        return Optional.of(save);
    }

    @Override
    public Optional<IntercityPrice> deletePrice(IntercityPrice price) {
        priceRepository.delete(price);
        return Optional.of(price);
    }

    @Override
    public void deletePriceByID(long id) {
       priceRepository.deleteById(id);
    }

    @Override
    public Optional<IntercityPrice> getPriceByCities(String city1, String city2) {
        Optional<IntercityPrice> intercityPriceByArrivingCityNameAndDepartingCityName1 = priceRepository.findIntercityPriceByArrivingCityNameAndDepartingCityName(city2, city1);
        if(!intercityPriceByArrivingCityNameAndDepartingCityName1.isPresent()){
            return priceRepository.findIntercityPriceByArrivingCityNameAndDepartingCityName(city1, city2);
        }else {
            return intercityPriceByArrivingCityNameAndDepartingCityName1;
        }
    }
}
