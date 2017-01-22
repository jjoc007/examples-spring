package com.hello.world.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hello.world.beans.AppConfig;
import com.hello.world.beans.AppConfig2;
import com.hello.world.beans.Mundo;

public class App {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext appContext =  new AnnotationConfigApplicationContext();
		appContext.register(AppConfig.class);
		appContext.register(AppConfig2.class);
		appContext.refresh();
		
		Mundo m  =  (Mundo) appContext.getBean("marte");
		
		System.out.println(m.getSaludo());
		
		((ConfigurableApplicationContext) appContext).close();
	}

}
