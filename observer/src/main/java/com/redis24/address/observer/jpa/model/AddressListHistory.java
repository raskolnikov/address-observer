package com.redis24.address.observer.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the address_list_history database table.
 * 
 */
@Entity
@Table(name="address_list_history")
@NamedQuery(name="AddressListHistory.findAll", query="SELECT a FROM AddressListHistory a")
public class AddressListHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="address_dedector_bean")
	private String addressDedectorBean;

	@Column(name="address_id")
	private int addressId;

	@Column(name="address_notification_email")
	private String addressNotificationEmail;

	@Lob
	@Column(name="company_address")
	private String companyAddress;

	@Column(name="company_contact_url")
	private String companyContactUrl;

	@Column(name="company_name")
	private String companyName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="create_user")
	private String createUser;

	public AddressListHistory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressDedectorBean() {
		return this.addressDedectorBean;
	}

	public void setAddressDedectorBean(String addressDedectorBean) {
		this.addressDedectorBean = addressDedectorBean;
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressNotificationEmail() {
		return this.addressNotificationEmail;
	}

	public void setAddressNotificationEmail(String addressNotificationEmail) {
		this.addressNotificationEmail = addressNotificationEmail;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyContactUrl() {
		return this.companyContactUrl;
	}

	public void setCompanyContactUrl(String companyContactUrl) {
		this.companyContactUrl = companyContactUrl;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

}