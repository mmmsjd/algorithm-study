package nocode.programming.solid;

// SOLID
// 2. Open-Closed principles ��Ģ 
// Ȯ��(extension)�� ���ؼ��� ����, ����(modification)�� ���ؼ��� �м� ��� ��Ģ 

// ����� Ȯ�� ���ɼ��� ���� �ִ� �ݸ�, ����� ���� ���ɼ��� �����־�� �Ѵ�.

// hey �Լ��� ������ �ʿ䰡 ����.

public class OpenClosed {

	static class Animal{
		// extends
		void speak(){}
		
		// modification
		void hey(Animal animal) {
			animal.speak();
		}
	}
	static class Cat extends Animal{
		void speak(){
			System.out.println("meow");
		}
	}
	static class Dog extends Animal{
		void speak(){
			System.out.println("bark");
		}
	}
	static class Sheep extends Animal{
		void speak(){
			System.out.println("meh");
		}
	}
	static class Cow extends Animal{
		void speak(){
			System.out.println("moo");
		}
	}

	public static void main(String[] args) {
		Animal ani = new Animal();
		Cat cat = new Cat();
		Dog dog = new Dog();
		Cow cow = new Cow();
		
		
		
		ani.hey(cat);
		ani.hey(dog);
		ani.hey(cow);
	}
}
