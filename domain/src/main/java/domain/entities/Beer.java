package domain.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import domain.enums.Storage;

@Entity
@Table(name="tb_beer")
public class Beer {
	
	private Long id;
	private String name;
	private City originCity;
	private Double abv;
	private Storage storageMode;
	private Volume volume;

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

	@OneToOne
	@NotNull
	public City getOriginCity() {
		return originCity;
	}

	public void setOriginCity(City originCity) {
		this.originCity = originCity;
	}

	@NotNull
	public Double getAbv() {
		return abv;
	}

	public void setAbv(Double abv) {
		this.abv = abv;
	}

	public Storage getStorageMode() {
		return storageMode;
	}

	public void setStorageMode(Storage storageMode) {
		this.storageMode = storageMode;
	}

	@Embedded
	   @AttributeOverrides({
	       @AttributeOverride(name="value", column=@Column(name="value")),
	       @AttributeOverride(name="unity", column=@Column(name="unity"))
	   })
	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

}
