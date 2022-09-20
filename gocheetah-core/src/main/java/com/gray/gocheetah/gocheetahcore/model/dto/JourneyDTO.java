package com.gray.gocheetah.gocheetahcore.model.dto;

import com.gray.gocheetah.gocheetahcore.model.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 13-Sep-22
 * Time: 7:04 PM
 * gocheetah-core
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JourneyDTO {
    private long id;
    private String name;
    private IntercityPrice price;
    private Vehicle vehicle;
    private Customer customer;
    private Driver driver;
    private Instant createdDate;
    private String status;

    public Journey toEntity(){
        Journey entity = new Journey();
        BeanUtils.copyProperties(this,entity);
        return entity;
    }
}