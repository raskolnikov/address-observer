/**
 * 
 */
package com.redis24.address.observer.util;

import com.redis24.address.observer.dto.AddressListDTO;
import com.redis24.address.observer.dto.AddressListHistoryDTO;
import com.redis24.address.observer.jpa.model.AddressList;

/**
 * @author memo
 *
 */
public class TestUtil {

	public static final String CHARACTER = "a";
	public static final Integer ID = 1;
	public static final String COMPANY_CONTACT_URL = "http://www.savage-wear.com/impressum/index.html";
	public static final String ADDRESS_NOTIFICATION_EMAIL = "yahoo@yahoo.com";
	public static final String COMPANY_NAME = "redis24";
	public static final String ADDRESS_DEDECTOR_BEAN = "DefaultDedector";

	public static String createStringWithLength(int length) {
		StringBuilder builder = new StringBuilder();

		for (int index = 0; index < length; index++) {
			builder.append(CHARACTER);
		}

		return builder.toString();
	}

	public static AddressList createAddressList() {

		AddressList model = new AddressList();
		model.setId(ID);
		model.setAddressDedectorBean(ADDRESS_DEDECTOR_BEAN);
		model.setCompanyContactUrl(COMPANY_CONTACT_URL);
		model.setAddressNotificationEmail(ADDRESS_NOTIFICATION_EMAIL);
		model.setCompanyName(COMPANY_NAME);

		return model;
	}

	public static AddressListDTO createAddressListDTO() {

		AddressListDTO dto = new AddressListDTO();
		dto.setId(ID);
		dto.setAddressDedectorBean(ADDRESS_DEDECTOR_BEAN);
		dto.setCompanyContactUrl(COMPANY_CONTACT_URL);
		dto.setAddressNotificationEmail(ADDRESS_NOTIFICATION_EMAIL);
		dto.setCompanyName(COMPANY_NAME);

		return dto;
	}

	public static AddressListHistoryDTO createAddressListHistoryDTO() {

		AddressListHistoryDTO dto = new AddressListHistoryDTO();
		dto.setId(ID);
		dto.setAddressDedectorBean(ADDRESS_DEDECTOR_BEAN);
		dto.setCompanyContactUrl(COMPANY_CONTACT_URL);
		dto.setAddressNotificationEmail(ADDRESS_NOTIFICATION_EMAIL);
		dto.setCompanyName(COMPANY_NAME);

		return dto;
	}

	public static AddressListHistoryDTO createAddAddressListHistoryDTO() {

		AddressListHistoryDTO dto = new AddressListHistoryDTO();
		dto.setAddressId(ID);
		dto.setAddressDedectorBean(ADDRESS_DEDECTOR_BEAN);
		dto.setCompanyContactUrl(COMPANY_CONTACT_URL);
		dto.setAddressNotificationEmail(ADDRESS_NOTIFICATION_EMAIL);
		dto.setCompanyName(COMPANY_NAME);

		return dto;
	}

}
