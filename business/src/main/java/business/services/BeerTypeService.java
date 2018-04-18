package business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import business.services.interfaces.IBeerTypeService;
import domain.entities.BeerType;
import repository.repositories.BeerTypes;

@Service
public class BeerTypeService implements IBeerTypeService{
	
	@Autowired
	private BeerTypes beerTypeRepository;

	@Override
	public BeerType addBeerType(BeerType beerType) {
		return beerTypeRepository.saveAndFlush(beerType);
	}

	@Override
	public void removeBeerType(BeerType beerType) {
		beerTypeRepository.delete(beerType);
	}

	@Override
	public BeerType updateBeerType(BeerType beerType) {
		return beerTypeRepository.save(beerType);
	}

	@Override
	public List<BeerType> listAllBeerType() {
		return beerTypeRepository.findAll();
	}

}
