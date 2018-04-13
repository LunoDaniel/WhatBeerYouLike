package domain.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Volume {

	private Integer value;
	private String unity;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}
}
