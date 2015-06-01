package com.redis24.address.observer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis24.address.observer.dto.AddressListHistoryDTO;
import com.redis24.address.observer.jpa.model.AddressListHistory;
import com.redis24.address.observer.repository.AddressListHistoryRepository;

/**
 * @author memo
 *
 */

@Service
public class RepositoryAddressListHistoryService implements AddressListHistoryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryAddressListHistoryService.class);

	private AddressListHistoryRepository repository;

	@Autowired
	public RepositoryAddressListHistoryService(AddressListHistoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public AddressListHistory add(AddressListHistoryDTO added) {

		AddressListHistory addressListHistory = new AddressListHistory();
		addressListHistory.setAddressDedectorBean(added.getAddressDedectorBean());
		addressListHistory.setAddressId(added.getAddressId());
		addressListHistory.setAddressNotificationEmail(added.getAddressNotificationEmail());
		addressListHistory.setCompanyAddress(added.getCompanyAddress());
		addressListHistory.setCompanyContactUrl(added.getCompanyContactUrl());
		addressListHistory.setCompanyName(added.getCompanyName());
		addressListHistory.setCreateDate(added.getCreateDate());
		addressListHistory.setCreateUser(added.getCreateUser());

		return repository.save(addressListHistory);
	}

}
