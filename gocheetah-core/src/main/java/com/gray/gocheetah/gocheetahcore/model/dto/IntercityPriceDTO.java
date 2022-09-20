package com.gray.gocheetah.gocheetahcore.model.dto;

import com.gray.gocheetah.gocheetahcore.model.City;
import com.gray.gocheetah.gocheetahcore.model.Driver;
import com.gray.gocheetah.gocheetahcore.model.IntercityPrice;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

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
public class IntercityPriceDTO {
    private long id;
    private String Name;
    private City departingCity;
    private City arrivingCity;
    private double cost;
    private Timestamp addedDate;
    public IntercityPrice toEntity(){
        IntercityPrice dto = new IntercityPrice();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}