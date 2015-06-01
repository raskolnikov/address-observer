/**
 * 
 */
package com.redis24.address.observer.service;

import java.util.List;

import com.redis24.address.observer.dto.AddressListDTO;
import com.redis24.address.observer.exception.AddressListNotFoundException;
import com.redis24.address.observer.jpa.model.AddressList;

/**
 * @author memo
 *
 */
public interface AddressListService {
	
 
    public List<AddressList> findAll(); 


    public AddressList findById(Integer id) throws AddressListNotFoundException ;

    public AddressList update(AddressListDTO updated) throws AddressListNotFoundException; 

}
