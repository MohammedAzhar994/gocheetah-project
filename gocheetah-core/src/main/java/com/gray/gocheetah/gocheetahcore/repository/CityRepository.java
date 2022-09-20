package com.gray.gocheetah.gocheetahcore.repository;

import com.gray.gocheetah.gocheetahcore.model.City;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.function.Function;

/**
 * Created by IntelliJ IDEA Ultimate.
 * User: Pasindu Raveen
 * Date: 30-Aug-22
 * Time: 3:13 PM
 * gocheetah-core
 */
@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    @Override
    <S extends City, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
    public City findCityById(long id);
}
