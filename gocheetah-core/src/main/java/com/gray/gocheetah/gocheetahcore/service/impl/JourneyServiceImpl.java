package com.gray.gocheetah.gocheetahcore.service.impl;

import com.gray.gocheetah.gocheetahcore.model.Journey;
import com.gray.gocheetah.gocheetahcore.repository.JourneyRepository;
import com.gray.gocheetah.gocheetahcore.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 02-Sep-22
 * Time: 12:53 PM
 * gocheetah-core
 */
@Service
public class JourneyServiceImpl implements JourneyService {

    private JourneyRepository journeyRepository;

    @Autowired
    public JourneyServiceImpl(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }

    @Override
    public Optional<Journey> getJourneyByID(Long id) {
        return journeyRepository.findById(id);
    }

    @Override
    public Optional<Journey> getJourneyByName(String name) {
        return journeyRepository.findJourneyByName(name);
    }

    @Override
    public List<Journey> getAllJourney() {
        return  journeyRepository.findAll();
    }

    @Override
    public Optional<List<Journey>> getAllJourneybyDriver(long id) {
        return journeyRepository.findJourneyByDriverId(id);
    }

    @Override
    public Optional<List<Journey>> getAllJourneyByCustomer(long id) {
        return journeyRepository.findJourneyByCustomer_Id(id);
    }

    @Override
    public Optional<Journey> saveJourney(Journey price) {
        Journey save = journeyRepository.save(price);
        return Optional.of(save);
    }

    @Override
    public Optional<Journey> updateJourney(Journey price) {
        Journey save = journeyRepository.save(price);
        return Optional.of(save);
    }

    @Override
    public Optional<Journey> deleteJourney(Journey price) {
        journeyRepository.delete(price);
        return Optional.of(price);
    }

    @Override
    public void deleteJourneyByID(long id) {
        journeyRepository.deleteById(id);
    }
}
