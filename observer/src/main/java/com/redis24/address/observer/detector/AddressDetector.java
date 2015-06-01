package com.redis24.address.observer.detector;

import java.io.IOException;

import com.redis24.address.observer.exception.AddressListNotFoundException;
import com.redis24.address.observer.jpa.model.AddressList;

public interface AddressDetector {
	public String contentParser(String contactUrl) throws IOException;
	public boolean isAnyChanges(String urlContent, String currentAddress);
	public void updateAddress(String urlContent,AddressList address) throws AddressListNotFoundException; 
	public void logAddressUpdates(AddressList address);
	public void sendMailToObservers(AddressList address);
	public boolean processAddressDetection(AddressList address) throws IOException, AddressListNotFoundException;  
	
}
