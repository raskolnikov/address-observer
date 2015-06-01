package com.redis24.address.observer.detector.impl;

import static org.mockito.Mockito.mock;

import org.junit.Before;

import com.redis24.address.observer.service.AddressListHistoryService;
import com.redis24.address.observer.service.AddressListService;

public class DefaultDetectorTest {

	private AddressListService serviceMock;
	private AddressListHistoryService logHistoryServiceMock;

	private DefaultDetector defaultDetector;

	@Before
	public void setUp() {
		serviceMock = mock(AddressListService.class);
		logHistoryServiceMock = mock(AddressListHistoryService.class);
		defaultDetector = new DefaultDetector(serviceMock, logHistoryServiceMock);
	}

}
