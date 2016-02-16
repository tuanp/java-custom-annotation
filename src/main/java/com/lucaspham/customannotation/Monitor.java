package com.lucaspham.customannotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Monitor {

	/**
	 * @return the name of the service that we will monitor
	 */
	String serviceName();

	/**
	 * @return the duration threshold in milliseconds, when a WARN message
	 *   is emitted in the log,
	 *   or -1 if such a WARN message should never be emitted
	 */
	long warningTime() default -1;

	/**
	 * @return the duration threshold in milliseconds, when a CRITICAL message
	 *   is emitted in the log,
	 *   or -1 if such a CRITICAL message should never be emitted
	 */
	long criticalTime() default -1;
}

