package com.gray.gocheetah.gocheetahcore.service.impl;

import com.gray.gocheetah.gocheetahcore.model.Admin;
import com.gray.gocheetah.gocheetahcore.repository.AdminRepository;
import com.gray.gocheetah.gocheetahcore.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 31-Aug-22
 * Time: 11:22 AM
 * gocheetah-core
 */
@Service
public class AdminServiceImpl implements AdminService {

    AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Optional<Admin> getAdminByID(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Admin> getAdminLogin(String email, String password) {
        Admin adminByEmailAndPassword = adminRepository.findAdminByEmailAndPassword(email, password);
        if(adminByEmailAndPassword!=null){
            Optional<Admin> admin = Optional.of(adminByEmailAndPassword);
            return admin;
        }else {
            return Optional.empty();
        }
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> saveAdmin(Admin admin) {
        Admin save = adminRepository.save(admin);
        return Optional.of(save);
    }

    @Override
    public Optional<Admin> updateAdmin(Admin admin) {
        return Optional.empty();
    }

    @Override
    public Optional<Admin> deleteAdmin(Admin admin) {
        return Optional.empty();
    }

    @Override
    public Optional<Admin> deleteAdminByID(long id) {
        return Optional.empty();
    }
}
