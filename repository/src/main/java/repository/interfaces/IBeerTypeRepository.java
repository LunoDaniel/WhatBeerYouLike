package repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.entities.BeerType;

public interface IBeerTypeRepository extends JpaRepository<BeerType, Long>{
	
	@Query("from BeerType group by nameType")
	public List<BeerType> findAllGroupByNameType();
	
	public BeerType findTypeBeerById(Long typeBeerId);
	

}
