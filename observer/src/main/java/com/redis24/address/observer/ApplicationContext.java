package com.redis24.address.observer;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author memo
 *
 */

public class ApplicationContext {

	private static AbstractApplicationContext applicationContext;

	// Application context has to be uniq during aplication life cycle
	public static AbstractApplicationContext getApplicationContext() {
		if (applicationContext == null) {
			applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		return applicationContext;
	}

}
