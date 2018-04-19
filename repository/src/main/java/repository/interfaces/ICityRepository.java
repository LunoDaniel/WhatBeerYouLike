package repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.entities.City;

public interface ICityRepository extends JpaRepository<City, Long>{
	
	@Query("from City group by name")
	public List<City> findAllGroupByName();
	
	public City findCityById(Long id);
}
