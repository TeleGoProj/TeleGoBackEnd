package com.telego.database.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Cabin {

	@Id
	@Column(name = "CABIN_ID")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cabinGenerator")
	@SequenceGenerator(name = "cabinGenerator", sequenceName = "cabin_sequence", initialValue = 1000, allocationSize = 1)
	private Long cabinId;

	@Column(name = "CABIN_NAME")
	private String cabinName;

	@OneToMany(mappedBy = "cabin", cascade = CascadeType.ALL)
	private List<Box> boxes;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AREA_ID", referencedColumnName = "AREA_ID")
	private Area area;

	public Long getCabinId() {
		return cabinId;
	}

	public void setCabinId(Long cabinId) {
		this.cabinId = cabinId;
	}

	public String getCabinName() {
		return cabinName;
	}

	public void setCabinName(String cabinName) {
		this.cabinName = cabinName;
	}

	public List<Box> getBoxes() {
		return boxes;
	}

	public void setBoxes(List<Box> boxes) {
		this.boxes = boxes;
	}

	public Area getArea() {
		return area;
	}
	
	public void setArea(Area area) {
		this.area = area;
	}
}
