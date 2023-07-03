package com.green.polymophism;

public class SamsungTv implements TV {

	@Override
	public void powerOn() {
		System.out.println("삼성TV 전원 켬");
	}

	@Override
	public void powerOff() {
		System.out.println("삼성TV 전원 끔");
	}

	@Override
	public void volumeUp() {
		System.out.println("삼성TV 볼륨 업");
	}

	@Override
	public void volumeDown() {
		System.out.println("삼성TV 볼륨 다운");
	}

}
