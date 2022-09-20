package com.gray.gocheetah.gocheetahcore.repository;

import com.gray.gocheetah.gocheetahcore.model.Journey;
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
 * Date: 01-Sep-22
 * Time: 4:32 PM
 * gocheetah-core
 */
@Repository
public interface JourneyRepository extends JpaRepository<Journey, Long> {
    @Override
    <S extends Journey, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
    public Optional<Journey> findJourneyByName(String name);
    public Optional<List<Journey>> findJourneyByDriverId(long id);
    public Optional<List<Journey>> findJourneyByCustomer_Id(long id);

}
