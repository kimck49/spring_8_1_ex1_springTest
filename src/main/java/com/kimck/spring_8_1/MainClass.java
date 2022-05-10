package com.kimck.spring_8_1;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext) ctx;
		gCtx.load("applicationCTX.xml");
		gCtx.refresh();
		
		AdminConnection adminConn1 = gCtx.getBean("adminConn", AdminConnection.class);
		System.out.println(adminConn1.getAdminId());
		System.out.println(adminConn1.getAdminPw());
		
		gCtx.close();
		ctx.close();

	}

}
