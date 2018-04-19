package business.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import business.exceptions.NotFoudBeerException;
import business.services.interfaces.IBeerService;
import domain.entities.Beer;
import repository.repositories.Beers;

@Service
public class BeerService implements IBeerService {

	public static final Logger logger = LoggerFactory.getLogger(BeerService.class);

	@Autowired
	private Beers beerRepository;

	@Override
	public Beer addBeer(Beer beer) {
		return beerRepository.saveAndFlush(beer);
	}

	@Override
	public void removeBeer(Beer beer) {
		beerRepository.delete(beer);
	}

	@Override
	public Beer updateBeer(Beer beer) {
		return beerRepository.save(beer);
	}

	@Override
	public List<Beer> listAllBeer() {
		return beerRepository.findAll();
	}

	@Override
	public Beer findOneBeer(Long id) {
		Beer beer = new Beer();
		try {
			Optional<Beer> optional = beerRepository.findById(id);
			if (optional.isPresent()) {
				beer = optional.get();
			} else {
				throw new NotFoudBeerException("Error to find a Beer. :(");
			}

		} catch (NotFoudBeerException e) {
			logger.error(e.getMessage());
		}

		return beer;
	}

}
