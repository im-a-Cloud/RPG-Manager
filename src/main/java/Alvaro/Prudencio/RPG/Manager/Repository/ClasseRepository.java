package Alvaro.Prudencio.RPG.Manager.Repository;

import Alvaro.Prudencio.RPG.Manager.Entidades.Classe;
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
public interface ClasseRepository extends JpaRepository<Classe, Long> {
    @Override
    void flush();

    @Override
    <S extends Classe> S saveAndFlush(S entity);

    @Override
    <S extends Classe> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<Classe> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<Classe> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Classe getOne(Long aLong);

    @Override
    Classe getById(Long aLong);

    @Override
    Classe getReferenceById(Long aLong);

    @Override
    <S extends Classe> List<S> findAll(Example<S> example);

    @Override
    <S extends Classe> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Classe> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Classe> findAll();

    @Override
    List<Classe> findAllById(Iterable<Long> longs);

    @Override
    <S extends Classe> S save(S entity);

    @Override
    Optional<Classe> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Classe entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Classe> entities);

    @Override
    void deleteAll();

    @Override
    List<Classe> findAll(Sort sort);

    @Override
    Page<Classe> findAll(Pageable pageable);

    @Override
    <S extends Classe> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Classe> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Classe> long count(Example<S> example);

    @Override
    <S extends Classe> boolean exists(Example<S> example);

    @Override
    <S extends Classe, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
