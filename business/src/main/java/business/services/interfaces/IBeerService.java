package business.services.interfaces;

import java.util.List;

import domain.entities.Beer;

public interface IBeerService {
	
	public Beer addBeer(Beer beer);
	public void removeBeer(Beer beer);
	public Beer updateBeer(Beer beer);
	public List<Beer> listAllBeer();

}
