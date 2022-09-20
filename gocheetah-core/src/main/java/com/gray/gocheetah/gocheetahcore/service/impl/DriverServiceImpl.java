package com.gray.gocheetah.gocheetahcore.service.impl;

import com.gray.gocheetah.gocheetahcore.model.Customer;
import com.gray.gocheetah.gocheetahcore.model.Driver;
import com.gray.gocheetah.gocheetahcore.model.dto.DriverDTO;
import com.gray.gocheetah.gocheetahcore.repository.DriverRepository;
import com.gray.gocheetah.gocheetahcore.service.DriverService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 31-Aug-22
 * Time: 11:32 AM
 * gocheetah-core
 */
@Service
public class DriverServiceImpl implements DriverService {
    private DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Optional<Driver> getDriverByID(Long id) {
        return driverRepository.findById(id);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Optional<Driver> saveDriver(Driver driver) {
        Driver save = driverRepository.save(driver);
        return Optional.of(save);
    }

    @Override
    public Optional<Driver> updateDriver(Driver driver) {
        Driver save = driverRepository.save(driver);
        return Optional.of(save);
    }

    @Override
    public Optional<Driver> deleteDriver(Driver driver) {
        driverRepository.delete(driver);
        return Optional.of(driver);
    }

    @Override
    public void deleteDriverByID(long id) {
        driverRepository.deleteById(id);
    }

    @Override
    public Optional<List<Driver>> getAllDriversByAvailability(Boolean availability, String name) {
        return driverRepository.findDriversByAvailabilityAndCityName(availability, name);
    }

    @Override
    public Optional<Driver> driverLogin(String email, String password) {
        return driverRepository.findDriversByEmailAndPassword(email, password);
    }
}
