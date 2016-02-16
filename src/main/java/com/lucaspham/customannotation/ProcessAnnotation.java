package com.lucaspham.customannotation;

import java.lang.reflect.Method;
import java.util.Random;

public class ProcessAnnotation {

	public static void main(String[] args) {
		ExampleService exampleService = new ExampleService();
		Random randomGenerator = new Random();
		Method[] methods = exampleService.getClass().getMethods();

		for (int i = 0; i < 10; i++) {
			for (Method method : methods) {
				Monitor methodAnnotation = method.getAnnotation(Monitor.class);
				if (methodAnnotation != null) {
					try {
						String serviceName = methodAnnotation.serviceName();
						long warningTime = methodAnnotation.warningTime();
						long criticalTime = methodAnnotation.criticalTime();
						method.invoke(exampleService);
						int timeRunning = randomGenerator.nextInt(15);
						if (timeRunning > criticalTime && criticalTime != -1) {
							System.out.println("CRITICAL: " + serviceName + " is running very slow (" + timeRunning + " ms)");
						} else if (timeRunning > warningTime && warningTime != -1) {
							System.out.println("WARNING: " + serviceName + " is running a little slow (" + timeRunning + " ms)");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
