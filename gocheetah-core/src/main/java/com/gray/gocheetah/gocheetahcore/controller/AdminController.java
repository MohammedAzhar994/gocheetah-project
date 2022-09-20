package com.gray.gocheetah.gocheetahcore.controller;

import com.gray.gocheetah.gocheetahcore.exception.AuthenticationException;
import com.gray.gocheetah.gocheetahcore.model.Admin;
import com.gray.gocheetah.gocheetahcore.model.Driver;
import com.gray.gocheetah.gocheetahcore.model.Vehicle;
import com.gray.gocheetah.gocheetahcore.model.dto.AdminDTO;
import com.gray.gocheetah.gocheetahcore.model.dto.DriverDTO;
import com.gray.gocheetah.gocheetahcore.model.dto.VehicleDTO;
import com.gray.gocheetah.gocheetahcore.service.AdminService;
import com.gray.gocheetah.gocheetahcore.service.DriverService;
import com.gray.gocheetah.gocheetahcore.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 01-Sep-22
 * Time: 10:51 AM
 * gocheetah-core
 */
@RestController
@CrossOrigin
public class AdminController {

    AdminService adminService;
    DriverService driverService;
    VehicleService vehicleService;


    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

//    @PostMapping("/admin/login")
//    public ResponseEntity<AdminDTO> adminLogin(
//            @RequestParam("username")String email,
//            @RequestParam("password")String password){
//        AtomicReference<ResponseEntity<AdminDTO>> body = new AtomicReference<>(ResponseEntity.noContent().build());
//        Optional<Admin> login = adminService.getAdminLogin(email, password);
//        return login.map(admin -> ResponseEntity.accepted().body(admin.toDto())).orElseGet(() -> ResponseEntity.badRequest().build());
//    }
    @PostMapping("/admin")
    public ResponseEntity<AdminDTO> setAdmin(
            @RequestBody @Validated AdminDTO adminDTO){
        adminDTO.setJoinDate(new Timestamp(System.currentTimeMillis()));
        Optional<Admin> admin = adminService.saveAdmin(adminDTO.toEntity());
        return admin.map(value -> ResponseEntity.status(HttpStatus.ACCEPTED).body(value.toDto())).orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @DeleteMapping("/admin")
    public ResponseEntity<AdminDTO> deleteAdmin(
            @RequestBody @Validated AdminDTO adminDTO){
        Optional<Admin> admin = adminService.deleteAdmin(adminDTO.toEntity());
        return admin.map(value -> ResponseEntity.status(HttpStatus.ACCEPTED).body(value.toDto())).orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @GetMapping("/admin")
    public ResponseEntity<List<AdminDTO>> getAdmins(){
        List<Admin> allAdmins = adminService.getAllAdmins();
        if(!allAdmins.isEmpty()){
            List<AdminDTO> dtos = allAdmins.stream().map(Admin::toDto).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(dtos);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/admin/driver")
    public ResponseEntity<DriverDTO>setDriver(
        @RequestBody @Validated DriverDTO driverDTO){
            Optional<Driver> driver = driverService.saveDriver(driverDTO.toEntity());
        return driver.map(value -> ResponseEntity.status(HttpStatus.ACCEPTED).body(value.toDto())).orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @PostMapping("/admin/vehicle")
    public ResponseEntity<VehicleDTO>setDriver(
            @RequestBody @Validated VehicleDTO vehicleDTO){
        Optional<Vehicle> vehicle = vehicleService.saveVehicle(vehicleDTO.toEntity());
        return vehicle.map(value -> ResponseEntity.status(HttpStatus.ACCEPTED).body(value.toDto())).orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
