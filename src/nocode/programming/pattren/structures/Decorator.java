package nocode.programming.pattren.structures;

// 10.Decorator 패턴 (Structures)
// 기능을 감싸서 기능을 제공하는 패턴

public class Decorator {
	
	static class Animal{
		void speak() {}
	}
	static class Cat extends Animal{
		void speak() {
			System.out.print("meow");
		}
	}
	static void makeSpeak(Animal animal){
		animal.speak();
		System.out.println();
	}
	static class Deco extends Animal{
		Animal animal;
		public Deco(Animal animal) {
			this.animal = animal;
		}
		void speak() {
			this.animal.speak();
		}
	}
	static class WithSmile extends Deco{

		public WithSmile(Animal animal) {
			super(animal);
			this.animal = animal;
		}
		void speak() {
			animal.speak();
			System.out.print("^^");
		}
	}
	static class WithHeart extends Deco{

		public WithHeart(Animal animal) {
			super(animal);
			this.animal = animal;
		}
		void speak() {
			animal.speak();
			System.out.print("♥");
		}
	}
	
	public static void main(String[] args) {
		Cat cat = new Cat();
		makeSpeak(cat);
		
		WithSmile withSmile = new WithSmile(cat);		
		makeSpeak(withSmile);
		
		WithHeart withHeart = new WithHeart(withSmile);		
		makeSpeak(withHeart);
		
	}
}