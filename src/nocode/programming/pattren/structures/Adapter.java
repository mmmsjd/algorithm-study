package nocode.programming.pattren.structures;

// 7.Adapter ∆–≈œ (Structures)

public class Adapter {
	
	static class Animal{
		void walk() {}
	}
	static class Cat extends Animal{
		void walk() {
			System.out.println("cat walking");
		}
	}
	static class Dog extends Animal{
		void walk() {
			System.out.println("dog walking");
		}
	}
	static class Fish extends Animal{
		void swim() {
			System.out.println("fish swimming");
		}
	}
	static void makeWalk(Animal animal){
		animal.walk();
	}
	
	static class FishAdapter extends Animal{
		Fish fish;
		public FishAdapter(Fish fish) {
			this.fish = fish;
		}
		void walk() {
			fish.swim();
		}
	}
	
	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		
		makeWalk(cat);
		makeWalk(dog);
		
//		Fish fish = new Fish();
//		makeWalk(fish);
		
		Fish fish = new Fish();
		FishAdapter adapter = new FishAdapter(fish);
		
		makeWalk(adapter);
		
	}
}
