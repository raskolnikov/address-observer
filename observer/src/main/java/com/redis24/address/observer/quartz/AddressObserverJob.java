package com.redis24.address.observer.quartz;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@DisallowConcurrentExecution
public class AddressObserverJob extends QuartzJobBean {

	private AddressObserverTask addressObserverTask;

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		addressObserverTask.executeAddressObserver();
	}

	public void setAddressObserverTask(AddressObserverTask addressObserverTask) {
		this.addressObserverTask = addressObserverTask;
	}

}
