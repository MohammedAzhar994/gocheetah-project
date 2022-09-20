package com.gray.gocheetah.gocheetahcore.model.dto;

import com.gray.gocheetah.gocheetahcore.model.Admin;
import com.gray.gocheetah.gocheetahcore.model.Customer;
import lombok.*;
import org.springframework.beans.BeanUtils;

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
public class CustomerDTO {
    private long id;
    private String username;
    private String status;
    private String email;
    private String password;
    private String contact;
    private Instant createdDate;
    public Customer toEntity(){
        Customer dto = new Customer();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}