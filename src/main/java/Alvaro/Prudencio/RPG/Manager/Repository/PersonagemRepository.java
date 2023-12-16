package Alvaro.Prudencio.RPG.Manager.Repository;

import Alvaro.Prudencio.RPG.Manager.Entidades.Personagem;
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
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    @Override
    void flush();

    @Override
    <S extends Personagem> S saveAndFlush(S entity);

    @Override
    <S extends Personagem> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<Personagem> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<Personagem> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Personagem getOne(Long aLong);

    @Override
    Personagem getById(Long aLong);

    @Override
    Personagem getReferenceById(Long aLong);

    @Override
    <S extends Personagem> List<S> findAll(Example<S> example);

    @Override
    <S extends Personagem> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Personagem> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Personagem> findAll();

    @Override
    List<Personagem> findAllById(Iterable<Long> longs);

    @Override
    <S extends Personagem> S save(S entity);

    @Override
    Optional<Personagem> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Personagem entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Personagem> entities);

    @Override

    void deleteAll();

    @Override
    List<Personagem> findAll(Sort sort);

    @Override
    Page<Personagem> findAll(Pageable pageable);

    @Override
    <S extends Personagem> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Personagem> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Personagem> long count(Example<S> example);

    @Override
    <S extends Personagem> boolean exists(Example<S> example);

    @Override
    <S extends Personagem, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
