package com.gray.gocheetah.gocheetahcore.service.impl;

import com.gray.gocheetah.gocheetahcore.model.Admin;
import com.gray.gocheetah.gocheetahcore.model.Customer;
import com.gray.gocheetah.gocheetahcore.repository.CustomerRepository;
import com.gray.gocheetah.gocheetahcore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 31-Aug-22
 * Time: 11:31 AM
 * gocheetah-core
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.customerRepository = repository;
    }

    @Override
    public Optional<Customer> getCustomerByID(Long id) {
       return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> customerLogin(String email, String password) {
        Customer customerByEmailAndPassword = customerRepository.findCustomerByEmailAndPassword(email, password);
        if(customerByEmailAndPassword!=null){
            return Optional.of(customerByEmailAndPassword);
        }else {
            return Optional.empty();
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> saveCustomer(Customer customer) {
        Customer save = customerRepository.save(customer);
        return Optional.of(save);
    }

    @Override
    public Optional<Customer> updateCustomer(Customer customer) {
        Customer save = customerRepository.save(customer);
        return Optional.of(save);
    }

    @Override
    public Optional<Customer> deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
        return Optional.of(customer);
    }

    @Override
    public void deleteCustomerByID(long id) {
        customerRepository.deleteById(id);
    }
}
