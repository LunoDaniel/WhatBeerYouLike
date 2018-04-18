package domain.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import domain.enums.Storage;

@Entity
@Table(name = "tb_beer")
public class Beer {

	private Long id;
	private String name;
	private City originCity;
	private Double abv;
	private Storage storageMode;
	private Volume volume;
	private BeerType type;
	private Double price;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@ManyToOne
	@JoinColumn(name="city_id")
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

	@Column(name = "storage_mode")
	public Storage getStorageMode() {
		return storageMode;
	}

	public void setStorageMode(Storage storageMode) {
		this.storageMode = storageMode;
	}

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "volume_value")),
			@AttributeOverride(name = "unity", column = @Column(name = "volume_unity")) })
	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

	@OneToOne(fetch = FetchType.LAZY, targetEntity = BeerType.class, cascade=CascadeType.ALL)
	public BeerType getType() {
		return type;
	}

	public void setType(BeerType type) {
		this.type = type;
	}

	@Column(name = "price")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beer other = (Beer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Beer [name=" + name + ", originCity=" + originCity.getName() + ", abv=" + abv + ", storageMode="
				+ storageMode + ", volume=" + volume + ", type=" + type.getNameType() + ", price=" + price + "]";
	}

}
