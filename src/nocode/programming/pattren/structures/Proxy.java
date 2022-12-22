package nocode.programming.pattren.structures;

// 8.Proxy ∆–≈œ (Structures)

public class Proxy {
	static class Cat {
		void speak() {
			System.out.println("meow");
		}
	}
	static class CatProxy {
		Cat cat;
		public CatProxy(Cat cat) {
			this.cat = cat;
		}
		void speak() {
			System.out.println("logging start");
			this.cat.speak();
			System.out.println("logging end");
		}
	}

	static class Animal {
		void speak() {
		}
	}

	static class Cat2 extends Animal {
		void speak() {
			System.out.println("meow");
		}
	}

	static class CatProxy2 extends Animal {
		Cat2 cat2;

		public CatProxy2(Cat2 cat2) {
			this.cat2 = cat2;
		}

		void speak() {
			System.out.println("logging start");
			this.cat2.speak();
			System.out.println("logging end");
		}
	}

	public static void main(String[] args) {
		Cat kitty = new Cat();
		CatProxy proxy = new CatProxy(kitty);
		proxy.speak();
		
		Cat2 kitty2 = new Cat2();
		CatProxy2 proxy2 = new CatProxy2(kitty2);
		proxy2.speak();
	}
}
