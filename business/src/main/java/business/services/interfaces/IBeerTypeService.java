package business.services.interfaces;

import java.util.List;

import domain.entities.BeerType;

public interface IBeerTypeService {

	public BeerType addBeerType(BeerType beerType);
	public void removeBeerType(BeerType beerType);
	public BeerType updateBeerType(BeerType beerType);
	public List<BeerType> listAllBeerType();
	public List<BeerType> findAllGroupedByNameType();
	public BeerType findTypeBeerById(Long typeBeerId);
}
