package Alvaro.Prudencio.RPG.Manager.Repository;

import Alvaro.Prudencio.RPG.Manager.Entidades.ClasseConjuradora;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface ClasseConjuradoraRepository extends JpaRepository<ClasseConjuradora, Long> {
    @Override
    void flush();

    @Override
    <S extends ClasseConjuradora> S saveAndFlush(S entity);

    @Override
    <S extends ClasseConjuradora> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<ClasseConjuradora> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<ClasseConjuradora> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    ClasseConjuradora getOne(Long aLong);

    @Override
    ClasseConjuradora getById(Long aLong);

    @Override
    ClasseConjuradora getReferenceById(Long aLong);

    @Override
    <S extends ClasseConjuradora> List<S> findAll(Example<S> example);

    @Override
    <S extends ClasseConjuradora> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends ClasseConjuradora> List<S> saveAll(Iterable<S> entities);

    @Override
    List<ClasseConjuradora> findAll();

    @Override
    List<ClasseConjuradora> findAllById(Iterable<Long> longs);

    @Override
    <S extends ClasseConjuradora> S save(S entity);

    @Override
    Optional<ClasseConjuradora> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(ClasseConjuradora entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends ClasseConjuradora> entities);

    @Override
    void deleteAll();

    @Override
    List<ClasseConjuradora> findAll(Sort sort);

    @Override
    Page<ClasseConjuradora> findAll(Pageable pageable);

    @Override
    <S extends ClasseConjuradora> Optional<S> findOne(Example<S> example);

    @Override
    <S extends ClasseConjuradora> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends ClasseConjuradora> long count(Example<S> example);

    @Override
    <S extends ClasseConjuradora> boolean exists(Example<S> example);

    @Override
    <S extends ClasseConjuradora, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
