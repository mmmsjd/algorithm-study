package nocode.programming.solid;

// SOLID
// 3. Liskov Substitution (�������� ġȯ) ��Ģ
// �ڽ� Ŭ������ �θ� Ŭ����ó�� ����� �� �ֵ��� �����ؾ� �Ѵ�.

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
