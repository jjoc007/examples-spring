package com.hello.world.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hello.world.beans.AppConfig;
import com.hello.world.beans.AppConfig2;
import com.hello.world.beans.Mundo;
import com.hello.world.beans.Persona;

public class App {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext appContext =  new AnnotationConfigApplicationContext();
		appContext.register(AppConfig.class);
		appContext.register(AppConfig2.class);
		appContext.refresh();
		
		Mundo m  =  (Mundo) appContext.getBean("marte");
		
		System.out.println("Configuracion por anotaciones");
		System.out.println(m.getSaludo());
		
		((ConfigurableApplicationContext) appContext).close();
		
		ApplicationContext appContext2 = new ClassPathXmlApplicationContext("com/hello/world/xml/beans.xml");
		Persona per = (Persona) appContext2.getBean("persona");
		Persona per2 = (Persona) appContext2.getBean("persona");
		
		System.out.println("Configuracion por XML y enviando valores de contructor al beans.xml");
		System.out.println("Id: "+per.getId()+" nombre:"+per.getNombre()+" apodo:"+per.getApodo() + " pais: "+per.getPais().getNombre()+"ciudad pr:"+per.getCiudad().getNombre());
		System.out.println("Id: "+per2.getId()+" nombre:"+per2.getNombre()+" apodo:"+per2.getApodo() + " pais: "+per2.getPais().getNombre()+"ciudad pr:"+per2.getCiudad().getNombre());
		
		System.out.println(per);
		System.out.println(per2);
		
		
		
		
		((ConfigurableApplicationContext) appContext2).close();
		
	}

}
