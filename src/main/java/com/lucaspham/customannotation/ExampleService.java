package com.lucaspham.customannotation;


public class ExampleService {

	@Monitor(serviceName = "sayHello", warningTime = 5, criticalTime = 10)
	public void sayHello(){
		System.out.println("Hello");
	}

	@Monitor(serviceName = "sayGoodbye", warningTime = 5, criticalTime = 10)
	public void sayGoodbye(){
		System.out.println("Goodbye");
	}
}
