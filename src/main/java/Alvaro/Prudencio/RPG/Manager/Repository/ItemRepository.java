package Alvaro.Prudencio.RPG.Manager.Repository;

import Alvaro.Prudencio.RPG.Manager.Entidades.Item;
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
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Override
    void flush();

    @Override
    <S extends Item> S saveAndFlush(S entity);

    @Override
    <S extends Item> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<Item> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<Item> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Item getOne(Long aLong);

    @Override
    Item getById(Long aLong);

    @Override
    Item getReferenceById(Long aLong);

    @Override
    <S extends Item> List<S> findAll(Example<S> example);

    @Override
    <S extends Item> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Item> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Item> findAll();

    @Override
    List<Item> findAllById(Iterable<Long> longs);

    @Override
    <S extends Item> S save(S entity);

    @Override
    Optional<Item> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Item entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Item> entities);

    @Override
    void deleteAll();

    @Override
    List<Item> findAll(Sort sort);

    @Override
    Page<Item> findAll(Pageable pageable);

    @Override
    <S extends Item> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Item> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Item> long count(Example<S> example);

    @Override
    <S extends Item> boolean exists(Example<S> example);

    @Override
    <S extends Item, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    List<Item> findByNomeItemContaining(String nomeItem);

    //List<Item> findByRariradeItem(String raridadeItem);
}
