package nocode.programming.pattren.behaviors;

import java.util.Scanner;

// 14.Strategy 패턴 (Behaviors)
// SOLID 의 open-closed 와 같은 내용 

public class Strategy {
	static class Animal{
		void speak() {}
	} 
	static class Cat extends Animal{
		void speak() {
			System.out.println("meow");
		}
	}
	static class Lion extends Animal{
		void speak() {
			System.out.println("roar");
		}
	}
	static void makeSpeak(Animal animal) {
		animal.speak();
	}
	static Animal createAnimal(String in) {
		if("cat".equals(in)) return new Cat();
		else if("lion".equals(in)) return new Lion();
		return null;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String inputString = sc.next();
		
		Animal animal = createAnimal(inputString);
		makeSpeak(animal);
		
	}
}
