package com.javaex.basics;

public class For_구구단_연습문제 {

	public static void main(String[] args) {
		Gugudan();
	}

	private static void Gugudan() {
		for (int dan = 2; dan < 10; dan++) {
			for (int i = 1; i < 10; i++) {
				System.out.println(dan + "*" + i + "=" + (dan * i));
			}
			System.out.println();
		}
		
	}
	
}
