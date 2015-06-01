package com.redis24.address.observer.detector;

import java.io.IOException;
import java.net.URL;

import com.redis24.address.observer.exception.AddressListNotFoundException;
import com.redis24.address.observer.jpa.model.AddressList;
import com.redis24.address.observer.jpa.model.AddressListHistory;

public interface AddressDetector {
	public String contentParser(URL url) throws IOException;

	public boolean isAnyChanges(String urlContent, String currentAddress);

	public AddressList updateAddress(String urlContent, AddressList address) throws AddressListNotFoundException;

	public AddressListHistory logAddressUpdates(AddressList address);

	public void sendMailToObservers(AddressList address);

	public boolean processAddressDetection(AddressList address) throws IOException, AddressListNotFoundException;

}
