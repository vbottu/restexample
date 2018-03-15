/**
 * 
 */
package com.saika.pharmacydemo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author vinodbottu
 *
 */
@Entity
public class Refill {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column
	private String id;
	@Column
	private String medicineName;
	@Column
	private double quantity;
	@Column
	private Date refillDate;
	@Lob
	@Column
	private byte[] image;
	@Column
	private String userId;

	public Refill() {

	}

	public Refill(String id, String medicineName, double quantity, Date refillDate,String userId) {
		this.id = id;
		this.medicineName = medicineName;
		this.quantity = quantity;
		this.refillDate = refillDate;
		this.userId=userId;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the medicineName
	 */
	public String getMedicineName() {
		return medicineName;
	}

	/**
	 * @param medicineName
	 *            the medicineName to set
	 */
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	/**
	 * @return the quantity
	 */
	public double getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the refillDate
	 */
	public Date getRefillDate() {
		return refillDate;
	}

	/**
	 * @param refillDate
	 *            the refillDate to set
	 */
	public void setRefillDate(Date refillDate) {
		this.refillDate = refillDate;
	}

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
