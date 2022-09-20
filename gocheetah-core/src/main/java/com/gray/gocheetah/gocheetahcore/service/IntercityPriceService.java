package com.gray.gocheetah.gocheetahcore.service;

import com.gray.gocheetah.gocheetahcore.model.Admin;
import com.gray.gocheetah.gocheetahcore.model.IntercityPrice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 31-Aug-22
 * Time: 11:15 AM
 * gocheetah-core
 */

@Service
public interface IntercityPriceService {
    public Optional<IntercityPrice> getPriceByID(Long id);
    public List<IntercityPrice> getAllPrices();
    public Optional<IntercityPrice> savePrice(IntercityPrice price);
    public Optional<IntercityPrice> updatePrice(IntercityPrice price);
    public Optional<IntercityPrice> deletePrice(IntercityPrice price);
    public void deletePriceByID(long id);
    public Optional<IntercityPrice> getPriceByCities(String city1,String city2);

}
