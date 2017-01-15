package com.margoConseil.rst.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "attraction")
public class Attraction implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public Attraction() {
		super();
	}

	public Attraction(String attractionName) {
		super();
		this.attractionName = attractionName;
	}

	private Integer attractionId;
	private String attractionName;

	@Id
	@GenericGenerator(name = "kaugen", strategy = "increment")
	@GeneratedValue(generator = "kaugen")
	@Column(name = "attractionId")
	public Integer getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(Integer attractionId) {
		this.attractionId = attractionId;
	}

	@Column(name = "attractionName")
	public String getAttractionName() {
		return attractionName;
	}

	public void setAttractionName(String attractionName) {
		this.attractionName = attractionName;
	}

}
