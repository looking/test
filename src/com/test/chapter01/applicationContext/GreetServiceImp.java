package com.test.chapter01.applicationContext;

public class GreetServiceImp implements GreetService {

	public String say;
	
	public GreetServiceImp(){};
	
	public GreetServiceImp(String say) {
		super();
		this.say = say;
	}

	
	public String getSay() {
		return say;
	}

	public void setSay(String say) {
		this.say = say;
	}

	public void sayGreeting() {
		System.out.println(say);

	}

}
