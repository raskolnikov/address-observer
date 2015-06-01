/**
 * 
 */
package com.redis24.address.observer.service;

import com.redis24.address.observer.dto.AddressListHistoryDTO;
import com.redis24.address.observer.jpa.model.AddressListHistory;

/**
 * @author memo
 *
 */
public interface AddressListHistoryService {
	public AddressListHistory add(AddressListHistoryDTO added);	 
	

}
