package com.gray.gocheetah.gocheetahcore.service;

import com.gray.gocheetah.gocheetahcore.model.IntercityPrice;
import com.gray.gocheetah.gocheetahcore.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 31-Aug-22
 * Time: 11:16 AM
 * gocheetah-core
 */
@Service
public interface VehicleService {
    public Optional<Vehicle> getVehicleByID(Long id);
    public List<Vehicle> getAllVehicles();
    public Optional<Vehicle> saveVehicle(Vehicle vehicle);
    public Optional<Vehicle> updateVehicle(Vehicle vehicle);
    public Optional<Vehicle> deleteVehicle(Vehicle vehicle);
    public void deleteVehicleByID(long id);
    public Optional<List<Vehicle>> getVehiclesByTypes(String type);
    public Optional<List<Vehicle>> getVehiclesByAvailability(Boolean availability);

}
