package com.gray.gocheetah.gocheetahcore.repository;

import com.gray.gocheetah.gocheetahcore.model.Vehicle;
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
 * Time: 3:18 PM
 * gocheetah-core
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    @Override
    <S extends Vehicle, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
    public Optional<List<Vehicle>> findVehiclesByTypeAndAvailability(String type, Boolean availability);
    public Optional<List<Vehicle>> findVehiclesByAvailability(Boolean availability);

}
