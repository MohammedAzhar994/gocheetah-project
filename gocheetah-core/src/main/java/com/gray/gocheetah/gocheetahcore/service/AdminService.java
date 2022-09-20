package com.gray.gocheetah.gocheetahcore.service;

import com.gray.gocheetah.gocheetahcore.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 31-Aug-22
 * Time: 11:08 AM
 * gocheetah-core
 */
@Service
public interface AdminService {
    public Optional<Admin> getAdminByID(Long id);
    public Optional<Admin> getAdminLogin(String email ,String password);
    public List<Admin> getAllAdmins();
    public Optional<Admin> saveAdmin(Admin admin);
    public Optional<Admin> updateAdmin(Admin admin);
    public Optional<Admin> deleteAdmin(Admin admin);
    public Optional<Admin> deleteAdminByID(long id);
}
