package nocode.programming.pattren.behaviors;

import java.util.ArrayList;
import java.util.List;

// 19.Observer ���� (Behaviors)
// ������ ����(or Subscriber:������ ����), Listener:û�� ����

public class Observer {
	
	static class Observers {
		void update() {}
	}
	static class Cat extends Observers {
		void update() {
			System.out.println("meow");
		}
	}
	static class Dog extends Observers {
		void update() {
			System.out.println("bark");
		}
	}
	static class Owner {
		List<Observers> animal;
		public Owner() {
			this.animal = new ArrayList<>();
		}
		void register(Observers animal) {
			this.animal.add(animal);
		}
		void notifyed() {
			for(Observers observer:animal) {
				observer.update();
			}
		}
	}
	
	public static void main(String[] args) {
		Cat cat = new Cat();
		Dog dog = new Dog();
		
		Owner owner = new Owner();
		owner.register(cat);
		owner.register(dog);
		
		owner.notifyed();
		
	}
	
}
