/**
 * 
 */
package com.redis24.address.observer.quartz;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author memo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:testContext.xml", "classpath:quartzContext.xml" })
public class AddressObserverJobTest {

	@Autowired
	AddressObserverTask addressObserverTask;

	@Autowired
	SchedulerFactoryBean schedulerFactoryBean;

	@Test
	public void whenQuartzStartedItShouldBeConfiguredCorrectly() throws Exception {
		JobKey jobKey = new JobKey("complexJobDetail");
		TriggerKey triggerKey = new TriggerKey("cronTrigger");

		assertTrue(schedulerFactoryBean.getScheduler().checkExists(jobKey));
		assertTrue(schedulerFactoryBean.getScheduler().checkExists(triggerKey));

	}
}
