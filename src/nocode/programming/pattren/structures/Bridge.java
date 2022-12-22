package nocode.programming.pattren.structures;

// 11.Bridge ∆–≈œ (Structures)
// abstraction ==(Bridge)== implement


public class Bridge {
	
	static class Animal {
		void speak() {}
	}
	static class Cat extends Animal{
		void speak(){
			System.out.print("a cat ");
		}
	}
	static class Dog extends Animal{
		void speak(){
			System.out.print("a dog ");
		}
	}
	static class Vehicle{
		Animal animal;
		public Vehicle(Animal animal) {
			this.animal = animal;
		}
		void start() {}
	}
	
	static class Airplane extends Vehicle {

		public Airplane(Animal animal) {
			super(animal);
			this.animal = animal;
		}
		void start() {
			animal.speak();
			System.out.println("flies a plane");
		}
	}
	
	static class Boat extends Vehicle {

		public Boat(Animal animal) {
			super(animal);
			this.animal = animal;
		}
		void start() {
			animal.speak();
			System.out.println("sails a boat");
		}
	}
	
	
	// second example
	
	// implement
	static class Power{
		void powerUp() {}
		void powerDown() {}
	}
	static class Engine extends Power{
		void powerUp() {
			System.out.println("engine power up!");
		}
		void powerDown() {
			System.out.println("engine power down!");
		}
	}
	static class Moter extends Power{
		void powerUp() {
			System.out.println("moter power up!");
		}
		void powerDown() {
			System.out.println("moter power down!");
		}
	}
	//abstraction car
	static class Car{
		Power power;
		public Car(Power power) {
			this.power = power;
		}
		void dirve() {
			power.powerUp();
		}
		void stop() {
			power.powerDown();
		}
	}
	static class Sedan extends Car{

		public Sedan(Power power) {
			super(power);
			this.power = power;
		}
		void sedanOnlyFn() {
			System.out.println("sedan only");
		}
		
	}
	
	public static void main(String[] args) {
//		Cat cat = new Cat();
//		Boat boat = new Boat(cat);
//		boat.start();
//		
//		Airplane airplane = new Airplane(new Dog());
//		airplane.start();
		
		Sedan sedan = new Sedan(new Moter());
		sedan.dirve();
		sedan.stop();
		sedan.sedanOnlyFn();
	}
}