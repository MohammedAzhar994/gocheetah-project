package com.gray.gocheetah.gocheetahcore.repository;

import com.gray.gocheetah.gocheetahcore.model.IntercityPrice;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.function.Function;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 30-Aug-22
 * Time: 3:20 PM
 * gocheetah-core
 */
@Repository
public interface IntercityPriceRepository extends JpaRepository<IntercityPrice,Long> {
    @Override
    <S extends IntercityPrice, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
    Optional<IntercityPrice> findIntercityPriceByArrivingCityNameAndDepartingCityName (String arrivingCity, String departingCity);
}
