package Alvaro.Prudencio.RPG.Manager.Repository;

import Alvaro.Prudencio.RPG.Manager.Entidades.Habilidade;
import Alvaro.Prudencio.RPG.Manager.Entidades.Personagem;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {
    @Override
    void flush();

    @Override
    <S extends Habilidade> S saveAndFlush(S entity);

    @Override
    <S extends Habilidade> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<Habilidade> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<Habilidade> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Habilidade getOne(Long aLong);

    @Override
    Habilidade getById(Long aLong);

    @Override
    Habilidade getReferenceById(Long aLong);

    @Override
    <S extends Habilidade> List<S> findAll(Example<S> example);

    @Override
    <S extends Habilidade> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Habilidade> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Habilidade> findAll();

    @Override
    List<Habilidade> findAllById(Iterable<Long> longs);

    @Override
    <S extends Habilidade> S save(S entity);

    @Override
    Optional<Habilidade> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Habilidade entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Habilidade> entities);

    @Override
    void deleteAll();

    @Override
    List<Habilidade> findAll(Sort sort);

    @Override
    Page<Habilidade> findAll(Pageable pageable);

    @Override
    <S extends Habilidade> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Habilidade> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Habilidade> long count(Example<S> example);

    @Override
    <S extends Habilidade> boolean exists(Example<S> example);

    @Override
    <S extends Habilidade, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    List<Habilidade> findByNomeHabilidadeContaining(String nomeHabilidade);

    List<Habilidade> findByOrigemHabilidadeContaining(String origemHabilidade);
}
