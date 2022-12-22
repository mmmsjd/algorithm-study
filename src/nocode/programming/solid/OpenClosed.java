package nocode.programming.solid;

// SOLID
// 2. Open-Closed principles 원칙 
// 확장(extension)에 대해서는 개방, 수정(modification)에 대해서는 패쇄 라는 원칙 

// 기능의 확장 가능성은 열려 있는 반면, 기능의 변경 가능성은 닫혀있어야 한다.

// hey 함수는 수정할 필요가 없다.

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
