package com.gray.gocheetah.gocheetahcore.model.dto;

import com.gray.gocheetah.gocheetahcore.model.Admin;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 24-Aug-22
 * Time: 2:17 PM
 * gocheetah-core
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdminDTO {
    private long id;
    private String username;
    private String status;
    private String email;
    private String password;
    private String contact;
    private Timestamp joinDate;
    public Admin toEntity(){
        Admin dto = new Admin();
        BeanUtils.copyProperties(this,dto);
        return dto;
    }
}
