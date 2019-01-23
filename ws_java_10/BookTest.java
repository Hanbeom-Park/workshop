package com.ssafy.ws;

import java.util.ArrayList;
import java.util.Arrays;

public class BookTest {

	public static void main(String[] args) {
		BookMgrlmpl manager=BookMgrlmpl.getInstance();

		manager.open();
		//System.out.println(manager.search());
		
		//번호 못찾음
		try {
			manager.buy("828384692",5);
		} catch (ISBNNotFoundException e) {
			System.out.println(e);
		}
		//수량 부족
		try {
			manager.sell("828384656",100);
		} catch (QuantityException e) {
			System.out.println(e);
		} catch (ISBNNotFoundException e) {
			System.out.println(e);
		}
		
		try {
			manager.buy("828384651",1);
		} catch (ISBNNotFoundException e) {
			System.out.println(e);
		}
		//수량 부족
		try {
			manager.sell("828384652",1);
		} catch (QuantityException e) {
			System.out.println(e);
		} catch (ISBNNotFoundException e) {
			System.out.println(e);
		}

		
		
		print((ArrayList<Book>) manager.search());
		System.out.println(manager.getTotalAmount());	
		manager.close();
	}
	static void print(ArrayList<Book> books) {
		for (Book i:books) {
			System.out.println(i);
		}
	}

}
