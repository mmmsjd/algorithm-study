package nocode.programming.solid;

import java.util.logging.Logger;

// SOLID
// 1. Single-Responsibility �� �����̶�� ���� ��Ģ���� �����ϴ� ���� ����.
// �� ��Ģ�̶� �ϳ��� fuctions �̳� class �� �ϳ��� part �� ���ؼ��� 
// å���� ������ �Ѵٴ� ��Ģ 

// ��� Ŭ������ �ϳ��� å�Ӹ��� �ο�������, �� �ϳ��� �������� �������� ����Ǿ�� �Ѵ�.

// Cat ���� print, logging ��Ģ������ ������ �Ѵ�.

public class SingleResponsibility {

	static class Cat {
		int age;
		String name;
		
		public Cat(int age, String name) {this.age = age; this.name=name;}
		void eat(String food) {}
		void walk() {}
		void speak() {}
		
		// ����
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
