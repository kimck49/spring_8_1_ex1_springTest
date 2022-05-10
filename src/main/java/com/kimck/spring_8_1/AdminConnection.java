package com.kimck.spring_8_1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements InitializingBean, DisposableBean, EnvironmentAware {
	
	private String adminId;
	private String adminPw;
	private Environment env;

	@Override
	public void setEnvironment(Environment env) {
		// TODO Auto-generated method stub
		System.out.println("setEnvironment 메서도 호출!!");
        setEnv(env);
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy 메서도 호출!!");

	}

	@Override
	public void afterPropertiesSet() throws Exception {//빈이 초기화될 때 자동 호출
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSet 메서도 호출!!");
		setAdminId(env.getProperty("admin.Id"));
		setAdminPw(env.getProperty("admin.Pw"));

	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	

	
}
