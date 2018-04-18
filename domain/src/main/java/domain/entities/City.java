package domain.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_city")
public class City {

	private Long id;
	private String name;
	private String country;
	private List<Beer> beer;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@OneToMany(mappedBy="originCity", targetEntity=Beer.class)
	public List<Beer> getBeer() {
		return beer;
	}

	public void setBeer(List<Beer> beer) {
		this.beer = beer;
	}
	
	

}
