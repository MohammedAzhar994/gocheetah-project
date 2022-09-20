package com.gray.gocheetah.gocheetahcore.model;

import com.gray.gocheetah.gocheetahcore.model.dto.IntercityPriceDTO;
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
 * Time: 6:10 PM
 * gocheetah-core
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class IntercityPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Name;
    @OneToOne
    private City departingCity;
    @OneToOne
    private City arrivingCity;
    private double cost;
    @CreatedDate
    private Instant createdDate;
    public IntercityPriceDTO toDto(){
        IntercityPriceDTO dto = new IntercityPriceDTO();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}