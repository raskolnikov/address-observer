package com.redis24.address.observer.detector.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import com.redis24.address.observer.dto.AddressListDTO;
import com.redis24.address.observer.dto.AddressListHistoryDTO;
import com.redis24.address.observer.exception.AddressListNotFoundException;
import com.redis24.address.observer.jpa.model.AddressList;
import com.redis24.address.observer.jpa.model.AddressListHistory;
import com.redis24.address.observer.service.AddressListHistoryService;
import com.redis24.address.observer.service.AddressListService;
import com.redis24.address.observer.util.TestUtil;

public class DefaultDetectorTest {

	private AddressListService serviceMock;
	private AddressListHistoryService logHistoryServiceMock;

	private DefaultDetector defaultDetector;
	private String updatedAddress = "Handelsregisternummer: Amtsgericht Charlottenburg HRB 89381 Steuernummer: 37/243/20584";

	@Before
	public void setUp() {
		serviceMock = mock(AddressListService.class);
		logHistoryServiceMock = mock(AddressListHistoryService.class);
		defaultDetector = new DefaultDetector(serviceMock, logHistoryServiceMock);
	}

	@Test
	public void whenCompanyAddressChangedItShouldUpdateTheAddress() throws AddressListNotFoundException {
		AddressList addressList = TestUtil.createAddressList();
		AddressList addressListUpdated = TestUtil.createAddressList();
		addressListUpdated.setCompanyAddress(updatedAddress);

		when(serviceMock.update(any(AddressListDTO.class))).thenReturn(addressListUpdated);
		AddressList actual = defaultDetector.updateAddress(updatedAddress, addressList);
		assertThat(actual, is(addressListUpdated));
		verify(serviceMock, times(1)).update(any(AddressListDTO.class));
		verifyNoMoreInteractions(serviceMock);

	}

	@Test
	public void whenCompanyAddressChangedItShouldInsertTheLogToDatabase() {

		AddressListHistory addressListHistory = new AddressListHistory();
		AddressListHistoryDTO addressListHistoryDTO = TestUtil.createAddressListHistoryDTO();
		AddressList addressList = TestUtil.createAddressList();
		when(logHistoryServiceMock.add(any(AddressListHistoryDTO.class))).thenReturn(addressListHistory);
		AddressListHistory actualAddressListHistory = defaultDetector.logAddressUpdates(addressList);
		assertThat(actualAddressListHistory, is(addressListHistory));
		verify(logHistoryServiceMock, times(1)).add(any(AddressListHistoryDTO.class));
		verifyNoMoreInteractions(logHistoryServiceMock);

	}

	@Test
	public void whenCompanyAddressChangedItShouldSendTheMailToClient() {
		// TODO : Not implemented yet
	}

	@Test
	public void whenUrlPassedTocontentParserThenItShouldParseTheContent() throws IOException {
		String expectedContent;
		try (FileInputStream inputStream = new FileInputStream("./src/test/resources/testUrlContentFile.html")) {
			expectedContent = IOUtils.toString(inputStream);
		}

		URL filePathToUrl = new File("./src/test/resources/testUrlContentFile.html").toURI().toURL();
		String actualContent = defaultDetector.contentParser(filePathToUrl);
		assertThat(expectedContent, is(actualContent));
	}

	@Test
	public void whenThereisDifferenceBetweenTwoContentThenItShouldReturTrue() {
		String previousAddress = "Handelsregisternummer: Amtsgericht Charlottenburg HRB 89381 Steuernummer: 37/243/20584 Umsatz-Steuer-Identifikationsnummer gemäß §27a Umsatzsteuergesetz: DE813755359 ";
		String updatedAddress = "Handelsregisternummer: Amtsgericht Charlottenburg HRB 89381 Steuernummer: 37/243/20584";
		Boolean actual = defaultDetector.isAnyChanges(previousAddress, updatedAddress);
		assertThat(actual, is(true));
	}

}
