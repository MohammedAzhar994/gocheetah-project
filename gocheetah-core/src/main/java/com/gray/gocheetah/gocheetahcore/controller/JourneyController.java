package com.gray.gocheetah.gocheetahcore.controller;

import com.gray.gocheetah.gocheetahcore.model.*;
import com.gray.gocheetah.gocheetahcore.model.dto.AdminDTO;
import com.gray.gocheetah.gocheetahcore.model.dto.JourneyDTO;
import com.gray.gocheetah.gocheetahcore.model.dto.VehicleDTO;
import com.gray.gocheetah.gocheetahcore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 13-Sep-22
 * Time: 7:01 PM
 * gocheetah-core
 */
@RestController
@CrossOrigin
public class JourneyController {

    JourneyService journeyService;

    DriverService driverService;

    VehicleService vehicleService;

    IntercityPriceService intercityPriceService;

    CustomerService customerService;

    @Autowired
    public JourneyController(JourneyService journeyService, DriverService driverService, VehicleService vehicleService, IntercityPriceService intercityPriceService, CustomerService customerService) {
        this.journeyService = journeyService;
        this.driverService = driverService;
        this.vehicleService = vehicleService;
        this.intercityPriceService = intercityPriceService;
        this.customerService = customerService;
    }

    @PostMapping("/journey")
    public ResponseEntity<JourneyDTO> setJourney(
            @RequestParam @Validated String priceId,
            @RequestParam @Validated String customerId,
            @RequestParam @Validated String date,
            @RequestParam @Validated String desc,
            @RequestParam @Validated String vId) throws ParseException {
        System.out.println("date---" + date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date parse = sdf.parse(date);
        Instant instant = parse.toInstant();
        Optional<IntercityPrice> priceByID = intercityPriceService.getPriceByID(Long.parseLong(priceId));
        Optional<Vehicle> vehicleByID = vehicleService.getVehicleByID(Long.parseLong(vId));
        Optional<Customer> customerByID = customerService.getCustomerByID(Long.valueOf(customerId));
        Random r = new Random();
        Journey journey = new Journey();
        if (priceByID.isPresent()) {
            if (vehicleByID.isPresent()) {
                if (vehicleByID.get().getAvailability() && customerByID.isPresent()) {
                    Optional<List<Driver>> allDriversByAvailability = driverService.getAllDriversByAvailability(true, priceByID.get().getDepartingCity().getName());
                    if (allDriversByAvailability.isPresent()) {
                        int selector = allDriversByAvailability.get().size() <= 1 ? 0 : r.nextInt(allDriversByAvailability.get().size());
                        Driver driver = allDriversByAvailability.get().get(selector);
                        vehicleByID.get().setAvailability(false);
                        driver.setVehicle(vehicleByID.get());
                        journey.setName(desc);
                        journey.setPrice(priceByID.get());
                        journey.setCustomer(customerByID.get());
                        journey.setDriver(driver);
                        journey.setCreatedDate(instant);
                        journey.setStatus("Driver Didn't Accepted");
                        Optional<Journey> optionalJourney = journeyService.saveJourney(journey);
                        return optionalJourney.map(journey1 -> ResponseEntity.ok(journey1.toDto())).orElseGet(() -> ResponseEntity.badRequest().build());
                    }
                } else {
                    return ResponseEntity.badRequest().build();
                }
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
        Optional<Journey> optionalJourney = journeyService.saveJourney(journey);
        return optionalJourney.map(journey1 -> ResponseEntity.ok(journey1.toDto())).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/journey/driver/accept")
    public ResponseEntity<JourneyDTO> setDriverStatus(@RequestParam String id) {
        Optional<Journey> journeyByID = journeyService.getJourneyByID(Long.valueOf(id));
        if (journeyByID.isPresent()) {
            Journey journey = journeyByID.get();
            Driver driver = journey.getDriver();
            driver.setAvailability(false);
            journey.setStatus("Driver Accepted");
            journeyService.saveJourney(journey);
            return ResponseEntity.ok(journey.toDto());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/journey/customer/complete")
    public ResponseEntity<JourneyDTO> setCustomerStatus(@RequestParam String id) {
        Optional<Journey> journeyByID = journeyService.getJourneyByID(Long.valueOf(id));
        if (journeyByID.isPresent()) {
            Journey journey = journeyByID.get();
            Driver driver = journey.getDriver();
            City city = driver.getCity();
            city.setEarning(city.getEarning()+journey.getPrice().getCost());
            Vehicle vehicle = driver.getVehicle();
            vehicle.setAvailability(true);
            driver.setAvailability(true);
            journey.setStatus("Ride Completed");
            journeyService.saveJourney(journey);
            return ResponseEntity.ok(journey.toDto());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/journey/customer/cancel")
    public ResponseEntity<JourneyDTO> setCustomerCancel(@RequestParam String id) {
        Optional<Journey> journeyByID = journeyService.getJourneyByID(Long.valueOf(id));
        if (journeyByID.isPresent()) {
            Journey journey = journeyByID.get();
            Driver driver = journey.getDriver();
            Vehicle vehicle = driver.getVehicle();
            vehicle.setAvailability(true);
            driver.setAvailability(true);
            journey.setStatus("Ride Cancelled");
            journeyService.saveJourney(journey);
            return ResponseEntity.ok(journey.toDto());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/journey")
    public ResponseEntity<List<JourneyDTO>> getAll(){
        List<Journey> allJourney = journeyService.getAllJourney();
        if (!allJourney.isEmpty()){
            List<JourneyDTO> collect = allJourney.stream().map(Journey::toDto).collect(Collectors.toList());
            return ResponseEntity.ok(collect);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/journey/customer")
    public ResponseEntity<List<JourneyDTO>> getAllByCustomer(@RequestParam String id){
        Optional<List<Journey>> allJourneyByCustomer = journeyService.getAllJourneyByCustomer(Long.parseLong(id));
        if (allJourneyByCustomer.isPresent()){
            List<JourneyDTO> journeyDTOS = allJourneyByCustomer.get().stream().map(Journey::toDto).collect(Collectors.toList());
            return ResponseEntity.ok(journeyDTOS);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/journey/driver")
    public ResponseEntity<List<JourneyDTO>> getAllByDriverr(@RequestParam String id){
        Optional<List<Journey>> allJourneybyDriver = journeyService.getAllJourneybyDriver(Long.parseLong(id));
        if (allJourneybyDriver.isPresent()){
            List<JourneyDTO> journeyDTOS = allJourneybyDriver.get().stream().map(Journey::toDto).collect(Collectors.toList());
            return ResponseEntity.ok(journeyDTOS);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

}
