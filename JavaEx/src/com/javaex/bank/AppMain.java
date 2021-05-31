package com.javaex.bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppMain {
	private static Account[] accountArray = new Account[100];
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			try {
				System.out.println("**************************************************");
				System.out.println("| 1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료 |");
				System.out.println("**************************************************");
				System.out.println();
				System.out.print("선택할 번호> ");
				int SelectNum = scan.nextInt();
				System.out.println();

				if (SelectNum == 1) {
					CreateAccount();
				} else if (SelectNum == 2) {
					AccountList();
				} else if (SelectNum == 3) {
					Deposit();
				} else if (SelectNum == 4) {
					Withdraw();
				} else if (SelectNum == 5) {
					System.out.println("프로그램 종료!");
					break;
				} else {
					System.out.println("입력오류!");
					System.out.println("1 ~ 5 까지의 숫자만 입력하세요!");
					System.out.println();
					continue;
				}

			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println("입력오류!");
				System.out.println("1 ~ 5 까지의 숫자만 입력하세요!");
				System.out.println();
				scan.next();
				continue;
			}
		}
	}

	private static void CreateAccount() {
		System.out.println("***********");
		System.out.println("1. 계좌생성");
		System.out.println("***********");
		
		System.out.println();
		System.out.println("(-)빼고 숫자만 입력");
		System.out.print("계좌번호: ");
		String num = scan.next();
		
		System.out.println();
		System.out.println("한글만 입력");
		System.out.print("계좌주: ");
		String owner = scan.next();
		
		System.out.println();
		System.out.print("초기 입금액: ");
		int initial = scan.nextInt();
		System.out.println();
		
		Account NewAccount = new Account(num, owner, initial);
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = NewAccount;
				System.out.println("계좌가 생성되었습니다!");
				System.out.println();
				break;
			}
		}
	}
	
	private static void AccountList() {
		System.out.println("***********");
		System.out.println("2. 계좌목록");
		System.out.println("***********");
		System.out.println();
		for (int i = 0; i < accountArray.length; i++) {
			Account AccountEx = accountArray[i];
			if (AccountEx != null) {
				System.out.println(AccountEx.getNum());
				System.out.println(AccountEx.getOwner());
				System.out.println(AccountEx.getInitial());
				System.out.println();
			}
		}
	}
	
	private static void Deposit() {
		System.out.println("*********");
		System.out.println("3. 예금");
		System.out.println("*********");
		
		System.out.println();
		System.out.println("(-)빼고 숫자만 입력");
		System.out.print("계좌번호: ");
		String num = scan.next();
		
		System.out.println();
		System.out.println("숫자만 입력");
		System.out.print("예금액: ");
		int amount = scan.nextInt();
		
		Account AccountEx = findAccount(num);
		if (AccountEx == null) {
			System.out.println("계좌가 없습니다!");
		}
		
		AccountEx.setInitial(AccountEx.getInitial() + amount);
		System.out.println();
		System.out.println("예금 성공!");
		System.out.println();
		System.out.print("예금 후 잔액: ");
		System.out.println(AccountEx.getInitial());
		System.out.println();
	}
	
	private static void Withdraw() {
		System.out.println("*********");
		System.out.println("4. 출금");
		System.out.println("*********");
		
		System.out.println();
		System.out.println("(-)빼고 숫자만 입력");
		System.out.print("계좌번호: ");
		String num = scan.next();
		
		System.out.println();
		System.out.println("숫자만 입력");
		System.out.print("출금액: ");
		int amount = scan.nextInt();
		
		Account AccountEx = findAccount(num);
		if (AccountEx == null) {
			System.out.println("계좌가 없습니다!");
		}
		
		AccountEx.setInitial(AccountEx.getInitial() - amount);
		System.out.println();
		System.out.println("출금 성공!");
		System.out.println();
		System.out.print("출금 후 잔액: ");
		System.out.println(AccountEx.getInitial());
		System.out.println();
	}
	
	private static Account findAccount(String num) {
		Account AccountEx = null;
		for (int i = 0; i < accountArray.length; i++) {
			String dbnum = accountArray[i].getNum();
			if (dbnum.equals(num)) {
				AccountEx = accountArray[i];
				break;
			}
		}
		return AccountEx;
	}
}
