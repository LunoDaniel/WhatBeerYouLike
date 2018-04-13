package repository.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import domain.entities.Beer;
import repository.interfaces.IBeerRepository;
import repository.repositories.Beers;

@Repository
public class BeersImpl implements Beers {
	private static final Logger logger = LoggerFactory.getLogger(BeersImpl.class);

	@Autowired
	private IBeerRepository beers;

	@Override
	public void deleteAllInBatch() {
		beers.deleteAllInBatch();

	}

	@Override
	public void deleteInBatch(Iterable<Beer> beerList) {
		beers.deleteInBatch(beerList);
	}

	@Override
	public List<Beer> findAll() {
		return beers.findAll();
	}

	@Override
	public List<Beer> findAll(Sort sortedBy) {
		return beers.findAll(sortedBy);
	}

	@Override
	public <S extends Beer> List<S> findAll(Example<S> ex) {
		return beers.findAll(ex);
	}

	@Override
	public <S extends Beer> List<S> findAll(Example<S> ex, Sort sorted) {
		return beers.findAll(ex, sorted);
	}

	@Override
	public List<Beer> findAllById(Iterable<Long> beerId) {
		return beers.findAllById(beerId);
	}

	@Override
	public void flush() {
		beers.flush();
	}

	@Override
	public Beer getOne(Long id) {
		return beers.getOne(id);
	}

	@Override
	public <S extends Beer> List<S> saveAll(Iterable<S> beersList) {
		return beers.saveAll(beersList);
	}

	@Override
	public <S extends Beer> S saveAndFlush(S beer) {
		return beers.saveAndFlush(beer);
	}

	@Override
	public Page<Beer> findAll(Pageable pages) {
		return beers.findAll(pages);
	}

	@Override
	public long count() {
		return beers.count();
	}

	@Override
	public void delete(Beer beer) {
		beers.delete(beer);
	}

	@Override
	public void deleteAll() {
		beers.deleteAll();
	}

	@Override
	public void deleteAll(Iterable<? extends Beer> beersList) {
		beers.deleteAll(beersList);
	}

	@Override
	public void deleteById(Long id) {
		beers.deleteById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return beers.existsById(id);
	}

	@Override
	public Optional<Beer> findById(Long id) {
		return beers.findById(id);
	}

	@Override
	public <S extends Beer> S save(S beer) {
		return beers.save(beer);
	}

	@Override
	public <S extends Beer> long count(Example<S> ex) {
		return beers.count(ex);
	}

	@Override
	public <S extends Beer> boolean exists(Example<S> ex) {
		return beers.exists(ex);
	}

	@Override
	public <S extends Beer> Page<S> findAll(Example<S> ex, Pageable page) {
		return beers.findAll(ex, page);
	}

	@Override
	public <S extends Beer> Optional<S> findOne(Example<S> ex) {
		return beers.findOne(ex);
	}
}
