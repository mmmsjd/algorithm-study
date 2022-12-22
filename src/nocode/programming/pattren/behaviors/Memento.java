package nocode.programming.pattren.behaviors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

// 20.Memento ���� (Behaviors)
// ������Ʈ�� ���¸� ����ó�� �� ����ߴٰ� ����ϴ� ���� 

// Object(-stat, createMemento, restore)

public class Memento {
	
	static class Cat {
		int age;
		int height;
		
		public Cat(int age, int height) {
			this.age = age;
			this.height = height;
		}
		void speak() {
			System.out.println("����:"+this.age + " year old, Ű:"+height + "cm, meow");
		}
		CatMemento creagteMemento() {
			return new CatMemento(this.age, this.height);
		}
		void restore(CatMemento catMemento) {
			this.age = catMemento.age;
			this.height = catMemento.height;
			
			System.out.println("restore|" +age+ "|"+height+ "|");
			
		}
		
	}
	static class CatMemento {
		String uuid;
		Date createTime;
		int age;
		int height;
		public CatMemento(int age, int height) {
			this.uuid = UUID.randomUUID().toString();
			this.createTime = new Date();
			this.age = age;
			this.height = height;
			
			System.out.println("save|" + uuid + "|"+createTime+ "|"+age+ "|"+height+ "|");
		}
	}
	public static void main(String[] args) {
		
		List<CatMemento> catHistory = new ArrayList<>();
		
		//1 
		Cat cat = new Cat(0, 10);		
		CatMemento memento0 = cat.creagteMemento();		
		catHistory.add(memento0);
		
		//2
		cat.age = 1;
		cat.height = 25;
		catHistory.add(cat.creagteMemento());
		
		//3
		cat.age = 3;
		cat.height = 50;
		catHistory.add(cat.creagteMemento());
		
		// Ȯ��
		cat.speak();
		
		// ����
		cat.restore(catHistory.get(0));
		cat.speak();
		
		
		
		
		
	}
}
