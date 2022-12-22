package nocode.programming.pattren.creational;

// 1.Factory(공장) 패턴 (Creational)

public class Factory {

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
	
	 // 1. fn 
	static Animal FactoryFn(Type animal) {
		if(Type.Cat.equals(animal)) return new Cat();
		else if(Type.Dog.equals(animal)) return new Dog();
		return null;
		
	}
	// 2. class Obj
	static class AnimalFactory{
		Animal createAnimal(Type animal){
			if(Type.Cat.equals(animal)) return new Cat();
			else if(Type.Dog.equals(animal)) return new Dog();
			return null;
		}
	}

	// enum
	enum Type{
		Cat, Dog, Cow();
	} 
	public static void main(String[] args) {
		
		// 1
		Animal cat = FactoryFn(Type.Cat);
		Animal dog = FactoryFn(Type.Dog);
		
		cat.speak();
		dog.speak();
		
		// 2 
		AnimalFactory factory = new AnimalFactory();
		Animal animal = factory.createAnimal(Type.Cat);
		
		animal.speak();
	}

}
