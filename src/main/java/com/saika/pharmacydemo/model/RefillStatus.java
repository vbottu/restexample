/**
 * 
 */
package com.saika.pharmacydemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author vinodbottu
 *
 */
@Entity
public class RefillStatus {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column
	private String refillId;
	@Column
	private String statusId;
	@Column
	private String statusText;
	@Column
	private String medicineName;

	public RefillStatus() {

	}

	/**
	 * @param refillId
	 * @param statusId
	 * @param statusText
	 * @param medicineName
	 */
	public RefillStatus(String refillId, String statusId, String statusText, String medicineName) {
		super();
		this.refillId = refillId;
		this.statusId = statusId;
		this.statusText = statusText;
		this.medicineName = medicineName;
	}

	/**
	 * @return the refillId
	 */
	public String getRefillId() {
		return refillId;
	}

	/**
	 * @param refillId
	 *            the refillId to set
	 */
	public void setRefillId(String refillId) {
		this.refillId = refillId;
	}

	/**
	 * @return the statusId
	 */
	public String getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId
	 *            the statusId to set
	 */
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the statusText
	 */
	public String getStatusText() {
		return statusText;
	}

	/**
	 * @param statusText
	 *            the statusText to set
	 */
	public void setStatusText(String statusText) {
		this.statusText = statusText;
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

}
