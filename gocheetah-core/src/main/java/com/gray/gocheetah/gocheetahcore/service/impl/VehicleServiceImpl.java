package com.gray.gocheetah.gocheetahcore.service.impl;

import com.gray.gocheetah.gocheetahcore.model.Vehicle;
import com.gray.gocheetah.gocheetahcore.repository.VehicleRepository;
import com.gray.gocheetah.gocheetahcore.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 31-Aug-22
 * Time: 11:34 AM
 * gocheetah-core
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Optional<Vehicle> getVehicleByID(Long id) {
        return vehicleRepository.findById(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> saveVehicle(Vehicle vehicle) {
        Vehicle save = vehicleRepository.save(vehicle);
        return Optional.of(save);
    }

    @Override
    public Optional<Vehicle> updateVehicle(Vehicle vehicle) {
        Vehicle save = vehicleRepository.save(vehicle);
        return Optional.of(save);
    }

    @Override
    public Optional<Vehicle> deleteVehicle(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
        return Optional.of(vehicle);
    }

    @Override
    public void deleteVehicleByID(long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public Optional<List<Vehicle>> getVehiclesByTypes(String type) {
        return vehicleRepository.findVehiclesByTypeAndAvailability(type, true);
    }

    @Override
    public Optional<List<Vehicle>> getVehiclesByAvailability(Boolean availability) {
        return vehicleRepository.findVehiclesByAvailability(availability);
    }
}
