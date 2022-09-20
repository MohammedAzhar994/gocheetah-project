package com.gray.gocheetah.gocheetahcore.controller;

import com.gray.gocheetah.gocheetahcore.model.Admin;
import com.gray.gocheetah.gocheetahcore.model.Customer;
import com.gray.gocheetah.gocheetahcore.model.Driver;
import com.gray.gocheetah.gocheetahcore.model.Journey;
import com.gray.gocheetah.gocheetahcore.model.dto.AdminDTO;
import com.gray.gocheetah.gocheetahcore.model.dto.CustomerDTO;
import com.gray.gocheetah.gocheetahcore.model.dto.GeneralUser;
import com.gray.gocheetah.gocheetahcore.service.AdminService;
import com.gray.gocheetah.gocheetahcore.service.CustomerService;
import com.gray.gocheetah.gocheetahcore.service.DriverService;
import org.springframework.beans.BeanUtils;
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
 * Date: 03-Sep-22
 * Time: 6:18 PM
 * gocheetah-core
 */
@RestController
@CrossOrigin
public class CustomerController {

    CustomerService customerService;
    AdminService adminService;
    DriverService driverService;


    @Autowired
    public CustomerController(CustomerService customerService, AdminService adminService, DriverService driverService) {
        this.customerService = customerService;
        this.adminService = adminService;
        this.driverService = driverService;
    }

    @PostMapping("/login")
    public ResponseEntity<GeneralUser> customerLogin(
            @RequestParam String email,
            @RequestParam String password) {
        GeneralUser entity = new GeneralUser();
        Optional<Customer> login = customerService.customerLogin(email, password);
        if(!login.isPresent()){
            Optional<Admin> adminLogin = adminService.getAdminLogin(email, password);
            if(!adminLogin.isPresent()){
                Optional<Driver> driver = driverService.driverLogin(email, password);
                if(!driver.isPresent()){
                    return ResponseEntity.badRequest().build();
                }else {
                    BeanUtils.copyProperties(driver.get(),entity);
                    entity.setRole("Driver");
                    return ResponseEntity.accepted().body(entity);
                }
            }else {
                BeanUtils.copyProperties(adminLogin.get(),entity);
                entity.setRole("Admin");
                return ResponseEntity.accepted().body(entity);
            }
        }else {
            BeanUtils.copyProperties(login.get(),entity);
            entity.setRole("Customer");
            return ResponseEntity.accepted().body(entity);
        }
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerDTO> setCustomer(@RequestBody @Validated CustomerDTO customerDTO){
        customerDTO.setStatus("Active");
        customerDTO.setCreatedDate(Instant.now());
        Optional<Customer> admin = customerService.saveCustomer(customerDTO.toEntity());
        return admin.map(customer -> ResponseEntity.status(HttpStatus.ACCEPTED).body(customer.toDto())).orElseGet(() -> ResponseEntity.badRequest().build());
    }
    @GetMapping("/customer")
    public ResponseEntity<List<CustomerDTO>> getAdmins(){
        List<Customer> allCustomers = customerService.getAllCustomers();
        if(!allCustomers.isEmpty()){
            List<CustomerDTO> dtos = allCustomers.stream().map(Customer::toDto).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(dtos);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
