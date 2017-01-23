package com.hello.world.beans;

import org.springframework.beans.BeansException;

public class BeanPostProcessor implements org.springframework.beans.factory.config.BeanPostProcessor{

	public Object postProcessAfterInitialization(Object bean, String nombreBean) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("despues de la inicializacion"+ nombreBean);
		
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String nombreBean) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("antes de la inicializacion"+ nombreBean);
		return bean;
	}

}
