package com.gray.gocheetah.gocheetahcore.model;

import com.gray.gocheetah.gocheetahcore.model.dto.JourneyDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 01-Sep-22
 * Time: 4:27 PM
 * gocheetah-core
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Journey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToOne(fetch = FetchType.EAGER)
    private IntercityPrice price;
    @OneToOne(fetch = FetchType.EAGER)
    private Driver driver;
    @OneToOne(fetch = FetchType.EAGER)
    private Customer customer;
    private String status;
    @CreatedDate
    private Instant createdDate;

    public JourneyDTO toDto(){
        JourneyDTO dto = new JourneyDTO();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}