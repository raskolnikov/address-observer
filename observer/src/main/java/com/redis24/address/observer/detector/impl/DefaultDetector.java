package com.redis24.address.observer.detector.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.redis24.address.observer.detector.AddressDetector;
import com.redis24.address.observer.dto.AddressListDTO;
import com.redis24.address.observer.dto.AddressListHistoryDTO;
import com.redis24.address.observer.exception.AddressListNotFoundException;
import com.redis24.address.observer.jpa.model.AddressList;
import com.redis24.address.observer.jpa.model.AddressListHistory;
import com.redis24.address.observer.service.AddressListHistoryService;
import com.redis24.address.observer.service.AddressListService;
import com.redis24.address.observer.util.AddressObserverConstants;

@Component("DefaultDetector")
public class DefaultDetector implements AddressDetector {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultDetectorTest.class);

	private AddressListService service;
	private AddressListHistoryService logHistoryService;

	@Autowired
	public DefaultDetector(AddressListService service, AddressListHistoryService logHistoryService) {
		this.service = service;
		this.logHistoryService = logHistoryService;
	}

	@Override
	public boolean processAddressDetection(AddressList address) throws IOException, AddressListNotFoundException {

		LOGGER.debug("Processing comany address :  " + address.getCompanyName());
		URL url = new URL(address.getCompanyContactUrl());
		String urlContent = this.contentParser(url);

		if (this.isAnyChanges(urlContent, address.getCompanyAddress())) {

			LOGGER.debug("Address differences found! Company name :  " + address.getCompanyName());

			this.updateAddress(urlContent, address);
			this.logAddressUpdates(address);
			this.sendMailToObservers(address);

			return true;

		}

		LOGGER.debug("No changes found Company name :  " + address.getCompanyName());
		return false;

	}

	public String contentParser(URL url) throws IOException {

		LOGGER.debug("url parsing started");

		URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(in, encoding);
		LOGGER.debug("url parsed : " + body);
		return body;

	}

	public boolean isAnyChanges(String urlContent, String currentAddress) {
		LOGGER.debug("is there any changes ?");
		if (!urlContent.equals(currentAddress)) {
			LOGGER.debug("Changes found!");
			return true;
		}
		LOGGER.debug("there is no changes!");
		return false;

	}

	public AddressList updateAddress(String urlContent, AddressList address) throws AddressListNotFoundException {

		LOGGER.debug("address updateing");
		AddressListDTO addressListDTO = new AddressListDTO();
		addressListDTO.setId(address.getId());
		addressListDTO.setCompanyAddress(urlContent);
		addressListDTO.setUpdateDate(new Date());
		addressListDTO.setUpdateUser(AddressObserverConstants.OBSERVER_CRON);

		AddressList addressList = service.update(addressListDTO);
		// TODO Auto-generated method stub
		LOGGER.debug("address updated");
		return addressList;

	}

	public AddressListHistory logAddressUpdates(AddressList address) {

		LOGGER.debug("logging address changes to database");

		AddressListHistoryDTO addressListHistoryDTO = new AddressListHistoryDTO();
		addressListHistoryDTO.setAddressDedectorBean(address.getAddressDedectorBean());
		addressListHistoryDTO.setAddressId(address.getId());
		addressListHistoryDTO.setAddressNotificationEmail(address.getAddressNotificationEmail());
		addressListHistoryDTO.setCompanyAddress(address.getCompanyAddress());
		addressListHistoryDTO.setCompanyContactUrl(address.getCompanyContactUrl());
		addressListHistoryDTO.setCompanyName(address.getCompanyName());
		addressListHistoryDTO.setCreateDate(new Date());
		addressListHistoryDTO.setCreateUser(AddressObserverConstants.OBSERVER_CRON);

		AddressListHistory addressListHistory = logHistoryService.add(addressListHistoryDTO);

		LOGGER.debug("logged address changes to database");
		return addressListHistory;

	}

	public void sendMailToObservers(AddressList address) {

		LOGGER.debug("sending mail to the queue to process it ");
		// TODO Auto-generated method stub
		LOGGER.debug("sent mail to the queue to process it ");

	}

}
