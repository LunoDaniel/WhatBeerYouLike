package repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.entities.Beer;

public interface IBeerRepository extends JpaRepository<Beer, Long>{

}
