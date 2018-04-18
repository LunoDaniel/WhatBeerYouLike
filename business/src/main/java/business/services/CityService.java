package business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import business.services.interfaces.ICityService;
import domain.entities.City;
import repository.repositories.Cities;

@Service
public class CityService implements ICityService {
	
	@Autowired
	private Cities citiesReposistory;

	@Override
	public City addCity(City city) {
		return citiesReposistory.saveAndFlush(city);
	}

	@Override
	public void removeCity(City city) {
		citiesReposistory.delete(city);
	}

	@Override
	public City updateCity(City city) {
		return citiesReposistory.save(city);
	}

	@Override
	public List<City> listAllCity() {
		return citiesReposistory.findAll();
	}

}
