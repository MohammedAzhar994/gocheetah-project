package com.gray.gocheetah.gocheetahcore.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 01-Sep-22
 * Time: 4:44 PM
 * gocheetah-core
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthenticationException extends RuntimeException{
    private int code;
    private String massage;
}
