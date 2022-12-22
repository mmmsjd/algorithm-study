package nocode.programming.solid;

import java.util.logging.Logger;

// SOLID
// 1. Single-Responsibility 는 패턴이라기 보단 원칙으로 생각하는 것이 좋다.
// 이 원칙이란 하나의 fuctions 이나 class 는 하나의 part 에 대해서만 
// 책임을 가져야 한다는 원칙 

// 모든 클래스는 하나의 책임만을 부여받으며, 단 하나의 이유만을 바탕으로 변경되어야 한다.

// Cat 에서 print, logging 원칙적으로 빠져야 한다.

public class SingleResponsibility {

	static class Cat {
		int age;
		String name;
		
		public Cat(int age, String name) {this.age = age; this.name=name;}
		void eat(String food) {}
		void walk() {}
		void speak() {}
		
		// 묘사
		Cat representation(){
			return this;
		}
	}
	
	public static void main(String[] args) {
		Cat kitty = new Cat(2, "kitty");
		//Print
		System.out.println(kitty);
		
		//Logging
		Logger log = Logger.getLogger(SingleResponsibility.class.getName());
		
		log.info(kitty.toString());
	}
}
