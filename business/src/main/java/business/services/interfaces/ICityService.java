package business.services.interfaces;

import java.util.List;

import domain.entities.City;


public interface ICityService {

	public City addCity(City city);
	public void removeCity(City city);
	public City updateCity(City city);
	public List<City> listAllCity();
}
