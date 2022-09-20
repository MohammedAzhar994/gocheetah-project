package com.gray.gocheetah.gocheetahcore.model.dto;

import com.gray.gocheetah.gocheetahcore.model.Driver;
import com.gray.gocheetah.gocheetahcore.model.Vehicle;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 24-Aug-22
 * Time: 5:39 PM
 * gocheetah-core
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DriverDTO {
    private long id;
    private String username;
    private String email;
    private String status;
    private Boolean availability;
    private long cityId;
    private String password;
    private String contact;
    private Instant createdDate;
    private VehicleDTO vehicleDTO;

    public Driver toEntity(){
        Driver dto = new Driver();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}
