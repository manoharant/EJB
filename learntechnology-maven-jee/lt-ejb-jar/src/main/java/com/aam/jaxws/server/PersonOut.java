package com.aam.jaxws.server;

import java.util.Date;

public class PersonOut {

	private String CIN;
	private String name;
	private String firstName;
	private Date birthDate;

	public PersonOut() {

	}

	public PersonOut(String cIN, String name, String firstName, Date birthDate) {
		super();
		CIN = cIN;
		this.name = name;
		this.firstName = firstName;
		this.birthDate = birthDate;
	}

	/**
	 * @return the cIN
	 */
	public String getCIN() {
		return CIN;
	}

	/**
	 * @param cIN
	 *            the cIN to set
	 */
	public void setCIN(String cIN) {
		CIN = cIN;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
