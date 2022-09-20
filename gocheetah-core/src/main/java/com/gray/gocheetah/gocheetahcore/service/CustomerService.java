package com.gray.gocheetah.gocheetahcore.service;

import com.gray.gocheetah.gocheetahcore.model.Admin;
import com.gray.gocheetah.gocheetahcore.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 31-Aug-22
 * Time: 11:09 AM
 * gocheetah-core
 */
@Service
public interface CustomerService {
    public Optional<Customer> getCustomerByID(Long id);
    public Optional<Customer> customerLogin(String email,String password);
    public List<Customer> getAllCustomers();
    public Optional<Customer> saveCustomer(Customer customer);
    public Optional<Customer> updateCustomer(Customer customer);
    public Optional<Customer> deleteCustomer(Customer customer);
    public void deleteCustomerByID(long id);


}
