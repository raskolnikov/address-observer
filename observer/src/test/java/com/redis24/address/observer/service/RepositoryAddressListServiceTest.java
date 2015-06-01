package com.redis24.address.observer.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.redis24.address.observer.dto.AddressListDTO;
import com.redis24.address.observer.exception.AddressListNotFoundException;
import com.redis24.address.observer.jpa.model.AddressList;
import com.redis24.address.observer.repository.AddressListRepository;
import com.redis24.address.observer.util.TestUtil;

public class RepositoryAddressListServiceTest {

	private RepositoryAddressListService service;

	private AddressListRepository repositoryMock;

	@Before
	public void setUp() {

		repositoryMock = mock(AddressListRepository.class);
		service = new RepositoryAddressListService(repositoryMock);
	}

	@Test
	public void findAll_ShouldReturnListOfAddressListEntries() {
		List<AddressList> models = new ArrayList<>();
		when(repositoryMock.findAll()).thenReturn(models);

		List<AddressList> actual = service.findAll();

		verify(repositoryMock, times(1)).findAll();
		verifyNoMoreInteractions(repositoryMock);

		assertThat(actual, is(models));
	}

	@Test
	public void findById_AddressListEntryFound_ShouldReturnFoundAddressListEntry() throws AddressListNotFoundException {
		AddressList model = TestUtil.createAddressList();

		when(repositoryMock.findOne(TestUtil.ID)).thenReturn(model);

		AddressList actual = service.findById(TestUtil.ID);

		verify(repositoryMock, times(1)).findOne(TestUtil.ID);
		verifyNoMoreInteractions(repositoryMock);

		assertThat(actual, is(model));
	}

	@Test(expected = AddressListNotFoundException.class)
	public void findById_AddressListEntryNotFound_ShouldThrowException() throws AddressListNotFoundException {
		when(repositoryMock.findOne(TestUtil.ID)).thenReturn(null);

		service.findById(TestUtil.ID);

		verify(repositoryMock, times(1)).findOne(TestUtil.ID);
		verifyNoMoreInteractions(repositoryMock);
	}

	@Test
	public void update_AddressListEntryFound_ShouldUpdateAddressListEntry() throws AddressListNotFoundException {

		AddressListDTO dto = TestUtil.createAddressListDTO();
		AddressList model = TestUtil.createAddressList();
		when(repositoryMock.findOne(dto.getId())).thenReturn(model);
		AddressList actual = service.update(dto);

		verify(repositoryMock, times(1)).findOne(dto.getId());
		verify(repositoryMock, times(1)).save(model);

		verifyNoMoreInteractions(repositoryMock);

		assertThat(dto.getId(), is(actual.getId()));
		assertThat(dto.getAddressDedectorBean(), is(actual.getAddressDedectorBean()));
		assertThat(dto.getCompanyContactUrl(), is(actual.getCompanyContactUrl()));
		assertThat(dto.getAddressNotificationEmail(), is(actual.getAddressNotificationEmail()));
		assertThat(dto.getCompanyName(), is(actual.getCompanyName()));

	}

	@Test(expected = AddressListNotFoundException.class)
	public void update_AddressListEntryNotFound_ShouldThrowException() throws AddressListNotFoundException {
		AddressListDTO dto = TestUtil.createAddressListDTO();

		when(repositoryMock.findOne(dto.getId())).thenReturn(null);

		service.update(dto);

		verify(repositoryMock, times(1)).findOne(dto.getId());
		verifyNoMoreInteractions(repositoryMock);
	}

}
