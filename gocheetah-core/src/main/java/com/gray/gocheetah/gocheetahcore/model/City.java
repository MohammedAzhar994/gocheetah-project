package com.gray.gocheetah.gocheetahcore.model;

import com.gray.gocheetah.gocheetahcore.model.dto.CityDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String postalCode;
    private double earning;
    @CreatedDate
    private Instant createdDate;
    public CityDTO toDto(){
        CityDTO dto = new CityDTO();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}
