/**
 * 
 */
package com.redis24.address.observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author memo
 *
 */

public class ApplicationContextTest {
	private AbstractApplicationContext applicationContext;
	private AbstractApplicationContext applicationContextOther;

	@Before
	public void setUp() {
		applicationContext = ApplicationContext.getApplicationContext();
		applicationContextOther = ApplicationContext.getApplicationContext();
	}

	@Test
	public void whenMultipleApplicationContextInstancesCreatedTheyShouldBeSameInstances() {

		assertNotNull(applicationContext);
		assertNotNull(applicationContextOther);
		assertEquals(true, applicationContext == applicationContextOther);

	}
}
