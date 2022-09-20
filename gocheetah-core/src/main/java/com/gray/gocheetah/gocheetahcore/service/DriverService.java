package com.gray.gocheetah.gocheetahcore.service;

import com.gray.gocheetah.gocheetahcore.model.Customer;
import com.gray.gocheetah.gocheetahcore.model.Driver;
import com.gray.gocheetah.gocheetahcore.model.dto.DriverDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 31-Aug-22
 * Time: 11:13 AM
 * gocheetah-core
 */
@Service
public interface DriverService {
    public Optional<Driver> getDriverByID(Long id);
    public List<Driver> getAllDrivers();
    public Optional<Driver> saveDriver(Driver driver);
    public Optional<Driver> updateDriver(Driver driver);
    public Optional<Driver> deleteDriver(Driver driver);
    public void deleteDriverByID(long id);
    public Optional<List<Driver>> getAllDriversByAvailability(Boolean availability,String cityName);
    public Optional<Driver> driverLogin(String email, String password);
}
