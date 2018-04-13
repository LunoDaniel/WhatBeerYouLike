package business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import business.services.interfaces.IBeerService;
import domain.entities.Beer;
import repository.interfaces.IBeerRepository;

@Service
public class BeerService implements IBeerService {
	
	
	
	@Autowired
	private IBeerRepository beerRepository;

	@Override
	public Beer addBeer(Beer beer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBeer(Beer beer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Beer updateBeer(Beer beer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Beer> listAllBeer() {
		// TODO Auto-generated method stub
		return null;
	}

}
