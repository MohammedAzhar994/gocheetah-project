package com.gray.gocheetah.gocheetahcore.model.dto;

import lombok.*;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 17-Sep-22
 * Time: 5:34 PM
 * gocheetah-core
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GeneralUser {
    private long id;
    private String username;
    private String status;
    private String email;
    private String password;
    private String Address;
    private String contact;
    private String role;
}
