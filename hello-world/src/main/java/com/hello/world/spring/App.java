package com.hello.world.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hello.world.beans.AppConfig;
import com.hello.world.beans.AppConfig2;
import com.hello.world.beans.Ciudad;
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
		
		System.out.println("Configuracion por XML y enviando valores de contructor al beans.xml");
		System.out.println("Id: "+per.getId()+" nombre:"+per.getNombre()+" apodo:"+per.getApodo() + " pais: "+per.getPais().getNombre()+"ciudad pr:"+per.getCiudad().getNombre());
		
		String ciudades = "";
		for(Ciudad c : per.getPais().getCiudades()){
			ciudades += " "+c.getNombre();
		}
		
		System.out.println("Ciudades:" +ciudades);
		
		
		((ConfigurableApplicationContext) appContext2).close();
		
	}

}
