package com.gray.gocheetah.gocheetahcore.model.dto;

import com.gray.gocheetah.gocheetahcore.model.IntercityPrice;
import com.gray.gocheetah.gocheetahcore.model.Vehicle;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 24-Aug-22
 * Time: 6:07 PM
 * gocheetah-core
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VehicleDTO {

    private long id;
    private String name;
    private String type;
    private String brand;
    private int seatCount;
    private Boolean availability;
    private Instant createdDate;
    public Vehicle toEntity(){
        Vehicle dto = new Vehicle();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}
