package nocode.programming.pattren.creational;

// 2.Factory Method ∆–≈œ (Creational)

public class FactoryMethod {

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
	interface IFactory{
		Animal createAnimal();
	}
	
	// CatCreator
	static class CatCreator implements IFactory {
		int catCount = 0;
		public Animal createAnimal(){
			catCount +=1;
			return new Cat();
		}
		// factory method
		int count() {return catCount;}
	}
	
	//DogManager
	static class DogManager implements IFactory {
		public Animal createAnimal(){
			return new Dog();
		}
		// factory method
		Dog makeWings(Dog dog) {
			System.out.println("dog wings added");
			return dog;
		};
	}

	// enum
	enum Type{
		Cat, Dog, Cow();
	} 
	public static void main(String[] args) {
				
		CatCreator cf = new CatCreator();
		cf.createAnimal();
		System.out.println(cf.count() + " cats are created");
		
		
		DogManager f = new DogManager();
		Dog dog = (Dog) f.createAnimal();
		f.makeWings(dog);
		
	}

}
