package com.gray.gocheetah.gocheetahcore.model;

import com.gray.gocheetah.gocheetahcore.model.dto.VehicleDTO;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
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
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String type;
    private String brand;
    private int seatCount;
    private Boolean availability = true;
    @CreatedDate
    private Instant createdDate;

    public VehicleDTO toDto() {
        VehicleDTO dto = new VehicleDTO();
        BeanUtils.copyProperties(this, dto);
        return dto;
    }
}
