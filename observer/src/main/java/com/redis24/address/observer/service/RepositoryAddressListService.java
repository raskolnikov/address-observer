package com.redis24.address.observer.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.redis24.address.observer.dto.AddressListDTO;
import com.redis24.address.observer.exception.AddressListNotFoundException;
import com.redis24.address.observer.jpa.model.AddressList;
import com.redis24.address.observer.repository.AddressListRepository;

/**
 * @author memo
 *
 */

@Service
public class RepositoryAddressListService implements AddressListService {

	 private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryAddressListService.class);

	    private AddressListRepository repository; 

	    @Autowired
	    public RepositoryAddressListService(AddressListRepository repository) {
	        this.repository = repository;
	    }
	
	@Transactional(readOnly = true)
	@Override
	public List<AddressList> findAll() {
		LOGGER.debug("Finding all address list");
	    return repository.findAll();
	}
	
	@Transactional(rollbackFor = {AddressListNotFoundException.class})
    @Override
    public AddressList update(AddressListDTO updated) throws AddressListNotFoundException {
    	
        LOGGER.debug("Updating contact with information: {}", updated);

        AddressList model = findById(updated.getId());
        LOGGER.debug("Found a address  entry: {}", model);
        model.setCompanyAddress(updated.getCompanyAddress());
        model.setUpdateUser(updated.getUpdateUser());
        model.setUpdateDate(updated.getUpdateDate());
        repository.save(model);
        LOGGER.debug("address  entry updated: {}", model);
        return model;
    }
    
    @Transactional(readOnly = true, rollbackFor = {AddressListNotFoundException.class}) 
    @Override
    public AddressList findById(Integer id) throws AddressListNotFoundException {
        LOGGER.debug("Finding a address list entry with id: {}", id);

        AddressList found = repository.findOne(id);
        LOGGER.debug("Found address list entry: {}", found);

        if (found == null) {
            throw new AddressListNotFoundException("No address list entry found with id: " + id);
        }

        return found;
    }
	
	
	 

}
