package business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import business.services.interfaces.IBeerService;
import domain.entities.Beer;
import repository.repositories.Beers;

@Service
public class BeerService implements IBeerService {
	
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

}
