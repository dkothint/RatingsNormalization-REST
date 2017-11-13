package org.prasad.ratingsnormalization.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "business")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Business implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(name = "business_id")
	private String businessId;

	@Column(name = "name")
	private String businessName;
	
	@Column(name = "stars")
	private double businessRating;

	@Column(name = "normalized_stars")
	private double normalizedRating;
	
	public Business() {
		super();
	}

	public Business(int id, String businessId, String name, double stars, double normalized_stars) {
		super();
		this.id = id;
		this.businessId = businessId;
		this.businessName = name;
		this.businessRating = stars;
		this.normalizedRating = normalized_stars;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public double getBusinessRating() {
		return businessRating;
	}

	public void setBusinessRating(double businessRating) {
		this.businessRating = businessRating;
	}

	public double getNormalizedRating() {
		return normalizedRating;
	}

	public void setNormalizedRating(double normalizedRating) {
		this.normalizedRating = normalizedRating;
	}
	
}
