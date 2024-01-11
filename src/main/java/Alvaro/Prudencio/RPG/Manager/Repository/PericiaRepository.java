package Alvaro.Prudencio.RPG.Manager.Repository;

import Alvaro.Prudencio.RPG.Manager.Entidades.Pericia;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface PericiaRepository extends JpaRepository<Pericia,Long> {
    @Override
    void flush();

    @Override
    <S extends Pericia> S saveAndFlush(S entity);

    @Override
    <S extends Pericia> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<Pericia> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<Pericia> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Pericia getOne(Long aLong);

    @Override
    Pericia getById(Long aLong);

    @Override
    Pericia getReferenceById(Long aLong);

    @Override
    <S extends Pericia> List<S> findAll(Example<S> example);

    @Override
    <S extends Pericia> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Pericia> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Pericia> findAll();

    @Override
    List<Pericia> findAllById(Iterable<Long> longs);

    @Override
    <S extends Pericia> S save(S entity);

    @Override
    Optional<Pericia> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Pericia entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Pericia> entities);

    @Override
    void deleteAll();

    @Override
    List<Pericia> findAll(Sort sort);

    @Override
    Page<Pericia> findAll(Pageable pageable);

    @Override
    <S extends Pericia> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Pericia> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Pericia> long count(Example<S> example);

    @Override
    <S extends Pericia> boolean exists(Example<S> example);

    @Override
    <S extends Pericia, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
