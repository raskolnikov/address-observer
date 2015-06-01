package com.redis24.address.observer.quartz;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.redis24.address.observer.detector.AddressDetector;
import com.redis24.address.observer.exception.AddressListNotFoundException;
import com.redis24.address.observer.jpa.model.AddressList;
import com.redis24.address.observer.service.AddressListService;

@Component("addressObserverTask")
public class AddressObserverTask {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddressObserverTask.class);

	private AddressListService service;

	@Autowired
	public AddressObserverTask(AddressListService service) {
		this.service = service;
	}

	public void executeAddressObserver() {

		// open/read the application context file
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		LOGGER.info("Quartz job started");
		List<AddressList> addressList = service.findAll();
		if (addressList != null && addressList.size() > 0) {
			for (AddressList address : addressList) {

				String addressDetector = address.getAddressDedectorBean();
				// instantiate our spring dao object from the application
				// context
				AddressDetector addressDetectorBean = (AddressDetector) ctx.getBean(addressDetector);

				try {
					boolean isThereAnyChanges;

					isThereAnyChanges = addressDetectorBean.processAddressDetection(address);

					LOGGER.debug(" Is there any address changes on comany   :  " + address.getCompanyName()
							+ " Result : " + isThereAnyChanges);

				} catch (IOException e) {
					LOGGER.error(addressDetectorBean.toString() + " detector is failed beause of : ", e);

				} catch (AddressListNotFoundException e) {
					LOGGER.error(addressDetectorBean.toString() + " detector is failed beause of : ", e);
				}

			}
		}
		LOGGER.info("Quartz job ended");
	}
}
