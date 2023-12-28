package Alvaro.Prudencio.RPG.Manager.Repository;

import Alvaro.Prudencio.RPG.Manager.Entidades.ItemMagico;
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
public interface ItemMagicoRepository extends JpaRepository<ItemMagico, Long> {
    @Override
    void flush();

    @Override
    <S extends ItemMagico> S saveAndFlush(S entity);

    @Override
    <S extends ItemMagico> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<ItemMagico> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<ItemMagico> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    ItemMagico getOne(Long aLong);

    @Override
    ItemMagico getById(Long aLong);

    @Override
    ItemMagico getReferenceById(Long aLong);

    @Override
    <S extends ItemMagico> List<S> findAll(Example<S> example);

    @Override
    <S extends ItemMagico> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends ItemMagico> List<S> saveAll(Iterable<S> entities);

    @Override
    List<ItemMagico> findAll();

    @Override
    List<ItemMagico> findAllById(Iterable<Long> longs);

    @Override
    <S extends ItemMagico> S save(S entity);

    @Override
    Optional<ItemMagico> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(ItemMagico entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends ItemMagico> entities);

    @Override
    void deleteAll();

    @Override
    List<ItemMagico> findAll(Sort sort);

    @Override
    Page<ItemMagico> findAll(Pageable pageable);

    @Override
    <S extends ItemMagico> Optional<S> findOne(Example<S> example);

    @Override
    <S extends ItemMagico> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends ItemMagico> long count(Example<S> example);

    @Override
    <S extends ItemMagico> boolean exists(Example<S> example);

    @Override
    <S extends ItemMagico, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    //List<ItemMagico> findByNomeItemMagicoContaining(String nomeItem);

    //List<ItemMagico> findByRaridadeItemMagico(String raridadeItem);

}
