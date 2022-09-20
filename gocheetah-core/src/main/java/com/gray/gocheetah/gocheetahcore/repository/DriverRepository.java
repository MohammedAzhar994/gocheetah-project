package com.gray.gocheetah.gocheetahcore.repository;

import com.gray.gocheetah.gocheetahcore.model.Customer;
import com.gray.gocheetah.gocheetahcore.model.Driver;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 30-Aug-22
 * Time: 3:16 PM
 * gocheetah-core
 */
@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
    @Override
    <S extends Driver, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
    public Optional<List<Driver>> findDriversByAvailabilityAndCityName(Boolean availability, String city_branchName);
    public Optional<Driver> findDriversByEmailAndPassword(String email, String password);
}
