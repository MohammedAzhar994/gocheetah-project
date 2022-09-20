package com.gray.gocheetah.gocheetahcore.model;

import com.gray.gocheetah.gocheetahcore.model.dto.AdminDTO;
import com.gray.gocheetah.gocheetahcore.model.dto.CustomerDTO;
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
 * Time: 5:38 PM
 * gocheetah-core
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String status;
    private String email;
    @OneToOne
    private City city;
    private String password;
    private String contact;
    @Setter(AccessLevel.NONE)
    @CreatedDate
    private Instant createdDate;

    public CustomerDTO toDto(){
        CustomerDTO dto = new CustomerDTO();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}