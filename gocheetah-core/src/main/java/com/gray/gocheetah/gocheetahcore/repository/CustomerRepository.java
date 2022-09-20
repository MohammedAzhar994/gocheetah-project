package com.gray.gocheetah.gocheetahcore.repository;

import com.gray.gocheetah.gocheetahcore.model.Admin;
import com.gray.gocheetah.gocheetahcore.model.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.function.Function;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 28-Aug-22
 * Time: 12:28 PM
 * gocheetah-core
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>
{
    @Override
    <S extends Customer, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
    public Customer findCustomerByEmailAndPassword(String email, String password);
}
