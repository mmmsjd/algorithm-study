package nocode.programming.solid;

import java.util.ArrayList;
import java.util.List;

// SOLID
// 5. Dependency Inversion 원칙
// 상위 모듈과 하위 모듈은 추상적인 약속을 기반으로 소통해야 한다.
// 자세한 구현은 추상적인 개념에 기반해야 한다.

// 추상화 모듈을 만들어서 의존관계를 뒤집는 것 

public class DependencyInversion {

	static class Animal{
		void speak() {};
	}
	
	static class Cat extends Animal{
		void speak() {
			System.out.println("meow");
		};
	}
	static class Dog extends Animal{
		void speak() {
			System.out.println("bark");
		};
	}
	static class Cow extends Animal{
		void speak() {
			System.out.println("moo");
		};
	}
	
	static class Zoo {
		List<Animal> animals = new ArrayList<>();
		void add(Animal animal){
			animals.add(animal);
		}
		void speakAll() {
			for(Animal animal:animals)
				animal.speak();
		}
	}
	
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		
		zoo.add(new Cat());
		zoo.add(new Dog());
		zoo.add(new Cow());
		
		zoo.speakAll();
	}
	
}
