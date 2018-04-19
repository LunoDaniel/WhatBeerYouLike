package repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import domain.entities.Beer;

public interface IBeerRepository extends JpaRepository<Beer, Long>, CrudRepository<Beer, Long>{

}
