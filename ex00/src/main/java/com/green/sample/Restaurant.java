package com.green.sample;

import org.springframework.stereotype.Component;

import lombok.Setter;


// 레스토랑은 Chef 타입의 객체를 필요로 함
@Component
public class Restaurant {

	@Setter
	private Chef chef;	//  컴파일 시 자동으로 setChef()를 생성

}
