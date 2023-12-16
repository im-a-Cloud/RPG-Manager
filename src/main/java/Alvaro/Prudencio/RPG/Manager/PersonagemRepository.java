package Alvaro.Prudencio.RPG.Manager;

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
public class PersonagemRepository implements JpaRepository<Personagem, Long> {

    @Override
    public void flush() {

    }

    @Override
    public <S extends Personagem> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Personagem> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Personagem> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Personagem getOne(Long aLong) {
        return null;
    }

    @Override
    public Personagem getById(Long aLong) {
        return null;
    }

    @Override
    public Personagem getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Personagem> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Personagem> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Personagem> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Personagem> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Personagem> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Personagem> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Personagem, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Personagem> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Personagem> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Personagem> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Personagem> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Personagem entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Personagem> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Personagem> findAll() {
        PersonagemRepository repository = new PersonagemRepository();
        return repository.findAll();
    }

    @Override
    public Page<Personagem> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Personagem> findAll(Sort sort) {
        return null;
    }
}
