/**
 * 
 */
package com.redis24.address.observer.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.redis24.address.observer.jpa.model.AddressList;

/**
 * @author memo
 *
 */
public interface AddressListRepository extends JpaRepository<AddressList, Integer> {

}
