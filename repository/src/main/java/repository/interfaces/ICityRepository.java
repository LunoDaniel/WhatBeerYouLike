package repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.entities.City;

public interface ICityRepository extends JpaRepository<City, Long>{

}
