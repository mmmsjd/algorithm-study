package nocode.programming.solid;

// SOLID
// 3. Liskov Substitution (리스코프 치환) 원칙
// 자식 클래스를 부모 클래스처럼 사용할 수 있도록 설계해야 한다.

public class LiskovSubstitution {

	static class Cat{
		void speak() {System.out.println("meow");}
	}
	static class BlackCat extends Cat{
		void speak() {System.out.println("black meow");}
	}
	static class Fish extends Cat {
		void speak()  {
			System.err.println("Fish cannot speak");
		}
	}
	
	public static void main(String[] args) {
		
//		Cat cat = new Cat();
//		Cat blackCat = new BlackCat();
		
//		cat.speak();		
//		blackCat.speak();
		
		Cat fish = new Fish();
		fish.speak();
		
	}
}
