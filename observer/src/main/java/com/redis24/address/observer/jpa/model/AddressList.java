package com.redis24.address.observer.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the address_list database table.
 * 
 */
@Entity
@Table(name="address_list")
@NamedQuery(name="AddressList.findAll", query="SELECT a FROM AddressList a")
public class AddressList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="address_dedector_bean")
	private String addressDedectorBean;

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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date")
	private Date updateDate;

	@Column(name="update_user")
	private String updateUser;

	public AddressList() {
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

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}