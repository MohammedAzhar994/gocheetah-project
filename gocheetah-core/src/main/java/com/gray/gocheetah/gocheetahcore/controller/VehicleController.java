package com.gray.gocheetah.gocheetahcore.controller;

import com.gray.gocheetah.gocheetahcore.model.Vehicle;
import com.gray.gocheetah.gocheetahcore.model.dto.VehicleDTO;
import com.gray.gocheetah.gocheetahcore.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 17-Sep-22
 * Time: 11:37 PM
 * gocheetah-core
 */
@RestController
@CrossOrigin
public class VehicleController {

    VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/vehicle")
    public ResponseEntity<VehicleDTO> setVehicle(
            @RequestBody @Validated VehicleDTO vehicleDTO) {
        vehicleDTO.setCreatedDate(Instant.now());
        vehicleDTO.setAvailability(true);
        Optional<Vehicle> vehicle = vehicleService.saveVehicle(vehicleDTO.toEntity());
        return vehicle.map(value -> ResponseEntity.status(HttpStatus.ACCEPTED).body(value.toDto())).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/vehicle")
    public ResponseEntity<List<VehicleDTO>> getAllVehicle() {
        Optional<List<Vehicle>> availability = vehicleService.getVehiclesByAvailability(true);
        if (availability.isPresent()) {
            List<VehicleDTO> vehicleDTOS = availability.get().stream().map(Vehicle::toDto).collect(Collectors.toList());
            return ResponseEntity.ok(vehicleDTOS);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/vehicle/type")
    public ResponseEntity<List<VehicleDTO>> getAllVehicle(@RequestParam String type) {
        Optional<List<Vehicle>> vehiclesByTypes = vehicleService.getVehiclesByTypes(type);
        if (vehiclesByTypes.isPresent()) {
            List<VehicleDTO> vehicleDTOS = vehiclesByTypes.get().stream().map(Vehicle::toDto).collect(Collectors.toList());
            return ResponseEntity.ok(vehicleDTOS);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
