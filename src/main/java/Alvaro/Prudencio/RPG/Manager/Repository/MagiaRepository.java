package Alvaro.Prudencio.RPG.Manager.Repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import Alvaro.Prudencio.RPG.Manager.Entidades.Magia;

import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface MagiaRepository extends JpaRepository<Magia, Long> {
    @Override
    void flush();

    @Override
    <S extends Magia> S saveAndFlush(S entity);

    @Override
    <S extends Magia> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<Magia> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<Magia> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Magia getOne(Long aLong);

    @Override
    Magia getById(Long aLong);

    @Override
    Magia getReferenceById(Long aLong);

    @Override
    <S extends Magia> List<S> findAll(Example<S> example);

    @Override
    <S extends Magia> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Magia> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Magia> findAll();

    @Override
    List<Magia> findAllById(Iterable<Long> longs);

    @Override
    <S extends Magia> S save(S entity);

    @Override
    Optional<Magia> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Magia entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Magia> entities);

    @Override
    void deleteAll();

    @Override
    List<Magia> findAll(Sort sort);

    @Override
    Page<Magia> findAll(Pageable pageable);

    @Override
    <S extends Magia> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Magia> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Magia> long count(Example<S> example);

    @Override
    <S extends Magia> boolean exists(Example<S> example);

    @Override
    <S extends Magia, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    List<Magia> findByNomeMagiaContaining(String nomeMagia);

    List<Magia> findByEscolaMagiaContaining(String nomeEscolaMagia);

    List<Magia> findByConjuradoresMagiaContaining(String conjuradoresMagia);

    List<Magia> findByNivelMagia(int nivelMagia);

}
