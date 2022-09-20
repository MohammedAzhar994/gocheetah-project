package com.gray.gocheetah.gocheetahcore.service;

import com.gray.gocheetah.gocheetahcore.model.IntercityPrice;
import com.gray.gocheetah.gocheetahcore.model.Journey;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 02-Sep-22
 * Time: 12:51 PM
 * gocheetah-core
 */
@Service
public interface JourneyService {
    public Optional<Journey> getJourneyByID(Long id);

    public Optional<Journey> getJourneyByName(String name);

    public List<Journey> getAllJourney();
    public Optional<List<Journey>> getAllJourneybyDriver(long id);
    public Optional<List<Journey>> getAllJourneyByCustomer(long id);

    public Optional<Journey> saveJourney(Journey price);

    public Optional<Journey> updateJourney(Journey price);

    public Optional<Journey> deleteJourney(Journey price);

    public void deleteJourneyByID(long id);
}
