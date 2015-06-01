/**
 * 
 */
package com.redis24.address.observer.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.redis24.address.observer.jpa.model.AddressListHistory;

/**
 * @author memo
 *
 */
public interface AddressListHistoryRepository extends JpaRepository<AddressListHistory, Integer> {

}
