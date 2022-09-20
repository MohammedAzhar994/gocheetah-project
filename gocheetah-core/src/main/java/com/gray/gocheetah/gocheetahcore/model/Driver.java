package com.gray.gocheetah.gocheetahcore.model;

import com.gray.gocheetah.gocheetahcore.model.dto.CityDTO;
import com.gray.gocheetah.gocheetahcore.model.dto.DriverDTO;
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
 * Time: 5:39 PM
 * gocheetah-core
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String email;
    private String status;
    @OneToOne
    private City city;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehi_id")
    private Vehicle vehicle;
    private Boolean availability;
    private String password;
    private String contact;
    @CreatedDate
    private Instant createdDate;

    public DriverDTO toDto(){
        DriverDTO dto = new DriverDTO();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }

}
