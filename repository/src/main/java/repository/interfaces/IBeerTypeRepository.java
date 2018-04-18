package repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.entities.BeerType;

public interface IBeerTypeRepository extends JpaRepository<BeerType, Long>{

}
