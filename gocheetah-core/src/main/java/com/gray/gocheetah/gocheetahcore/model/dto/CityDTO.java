package com.gray.gocheetah.gocheetahcore.model.dto;

import com.gray.gocheetah.gocheetahcore.model.Admin;
import com.gray.gocheetah.gocheetahcore.model.City;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 24-Aug-22
 * Time: 6:04 PM
 * gocheetah-core
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CityDTO {
    private long id;
    private String name;
    private String postalCode;
    private double earning;
    private Instant createdDate;

    public City toEntity(){
        City dto = new City();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}
