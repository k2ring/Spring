package com.green.polymophism;

import org.springframework.context.support.AbstractApplicationContext;		// ApplicationContext의 구현체
import org.springframework.context.support.GenericXmlApplicationContext;	// 설정 파일이 xml

public class TVUser {

	public static void main(String[] args) {
		
		// 기존 방식
//		SamsungTv stv = new SamsungTv();
//		stv.powerOn();
//		stv.volumeUp();
//		stv.volumeDown();
//		stv.powerOff();
//		System.out.println("----------------------");
//		LgTV ltv = new LgTV();
//		ltv.powerOn();
//		ltv.volumeUp();
//		ltv.volumeDown();
//		ltv.powerOff();
		
		// 스프링 컨테이너 구동
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		TV stv = (TV) factory.getBean("samsungTV");
		TV ltv = (TV) factory.getBean("lgTV");
		stv.powerOn();
		ltv.powerOn();
	}

}
