/**
 * 
 */
package com.redis24.address.observer.service;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.redis24.address.observer.dto.AddressListHistoryDTO;
import com.redis24.address.observer.jpa.model.AddressListHistory;
import com.redis24.address.observer.repository.AddressListHistoryRepository;
import com.redis24.address.observer.util.TestUtil;

/**
 * @author memo
 *
 */
public class RepositoryAddressListHistoryServiceTest {

	private RepositoryAddressListHistoryService service;

	private AddressListHistoryRepository repositoryMock;

	@Before
	public void setUp() {

		repositoryMock = mock(AddressListHistoryRepository.class);
		service = new RepositoryAddressListHistoryService(repositoryMock);
	}

	@Test
	public void add() {
		AddressListHistoryDTO dto = TestUtil.createAddAddressListHistoryDTO();

		service.add(dto);

		ArgumentCaptor<AddressListHistory> addressListHistoryArgument = ArgumentCaptor
				.forClass(AddressListHistory.class);
		verify(repositoryMock, times(1)).save(addressListHistoryArgument.capture());
		verifyNoMoreInteractions(repositoryMock);

		AddressListHistory model = addressListHistoryArgument.getValue();

		assertEquals(dto.getAddressDedectorBean(), model.getAddressDedectorBean());
		assertEquals(dto.getAddressId(), model.getAddressId());
		assertEquals(dto.getAddressNotificationEmail(), model.getAddressNotificationEmail());
		assertEquals(dto.getCompanyAddress(), model.getCompanyAddress());
		assertEquals(dto.getCompanyName(), model.getCompanyName());

	}

}
