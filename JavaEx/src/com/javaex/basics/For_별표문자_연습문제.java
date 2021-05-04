package com.javaex.basics;

public class For_별표문자_연습문제 {

	public static void main(String[] args) {
		Star();
	}
	
	private static void Star() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
