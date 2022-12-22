package nocode.programming.solid;

import java.util.ArrayList;
import java.util.List;

// SOLID
// 5. Dependency Inversion ��Ģ
// ���� ���� ���� ����� �߻����� ����� ������� �����ؾ� �Ѵ�.
// �ڼ��� ������ �߻����� ���信 ����ؾ� �Ѵ�.

// �߻�ȭ ����� ���� �������踦 ������ �� 

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
