package nocode.programming.pattren.behaviors;

// 22.Visitor 패턴 (Behaviors)
// ==방문자 패턴

public class Visitor {
	static class Cat {
		String name;
		int age;
		public Cat(String name, int age) {
			this.name = name;
			this.age = age;
		}
		void speak() {
			System.out.println("meow");
		}
		void accept(Visitors visitor) {
			System.out.println("use implementation of Visitors");
			visitor.visit(this);
		}
	}
	static class Visitors {
		void visit(Cat elem) {}
	}
	static class NameVisitor extends Visitors {
		void visit(Cat elem) {
			System.out.println(elem.name);
		}
	}
	static class AgeVisitor extends Visitors {
		void visit(Cat elem) {
			System.out.println(elem.age);
		}
	}
	
	public static void main(String[] args) {
		Cat cat  = new Cat("kitty", 3);
		cat.speak();
		
		cat.accept(new NameVisitor());
		cat.accept(new AgeVisitor());
		
	}
}
