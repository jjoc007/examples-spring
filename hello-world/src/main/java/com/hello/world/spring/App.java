package com.hello.world.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hello.world.beans.Mundo;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext appContext =  new ClassPathXmlApplicationContext("com/hello/world/xml/beans.xml");
		Mundo m  =  (Mundo) appContext.getBean("mundo");
		
		System.out.println(m.getSaludo());
		
		((ConfigurableApplicationContext) appContext).close();
	}

}
