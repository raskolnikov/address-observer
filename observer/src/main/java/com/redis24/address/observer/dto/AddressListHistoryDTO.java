package com.redis24.address.observer.dto;

import java.util.Date;

public class AddressListHistoryDTO {

	private Integer id;

	private String addressDedectorBean;

	private String addressNotificationEmail;

	private String companyAddress;

	private String companyContactUrl;

	private String companyName;

	private Date createDate;

	private String createUser;

	private int addressId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressDedectorBean() {
		return addressDedectorBean;
	}

	public void setAddressDedectorBean(String addressDedectorBean) {
		this.addressDedectorBean = addressDedectorBean;
	}

	public String getAddressNotificationEmail() {
		return addressNotificationEmail;
	}

	public void setAddressNotificationEmail(String addressNotificationEmail) {
		this.addressNotificationEmail = addressNotificationEmail;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyContactUrl() {
		return companyContactUrl;
	}

	public void setCompanyContactUrl(String companyContactUrl) {
		this.companyContactUrl = companyContactUrl;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

}
