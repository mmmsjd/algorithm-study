package nocode.programming.pattren.creational;

// 5.Singleton ∆–≈œ (Creational)

public class Singleton {

	static class Cat{		
		static Cat instance = new Cat();
		String name;
		public Cat() {}
		
		public Cat(String name) {
			this.name = name;
		}
		public static Cat getInstance() {
			if(instance == null) {
				instance = new Cat();
    		}
    		return instance;
		}
		void speak() {
			System.out.println(name+", meow");
		}
	}
	
	public static void main(String[] args) {
		
		Cat kitty = new Cat("kitty");
		Cat navi = new Cat("navi");		
		kitty.speak();
		navi.speak();

		if(kitty.getInstance() == navi.getInstance()) {
			System.out.println("they are same Singleton!");
		}else {
			System.out.println("they are not same");
		}
		
	}
}
