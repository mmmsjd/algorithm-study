package nocode.programming.pattren.creational;

import java.lang.reflect.Field;

// 6.Prototype 패턴 (Creational)
// 프로토타입 패턴은 new 키워드를 사용하지 않고 객체를 복제해 생성하는 패턴이다.

public class Prototype {

	static class Cat {		
		String color;
		String eyeColor;
		String noseColor;
		String tailColor;
		String name;
				
		public Cat() {}
		public Cat(String color, String eyeColor, String noseColor, String tailColor, String name) {
			this.color = color;
			this.eyeColor = eyeColor;
			this.noseColor = noseColor;
			this.tailColor = tailColor;
			this.name = name;
		}
		public Cat clone(){
			return new Cat(this.color, this.eyeColor, this.noseColor, this.tailColor, this.name);
		}
	}
	static class BlackCat extends Cat{
		public BlackCat() {
			this.color = "black";
		}
		
		public BlackCat(String color, String eyeColor, String noseColor, String tailColor, String name) {
			this.color = color;
			this.eyeColor = eyeColor;
			this.noseColor = noseColor;
			this.tailColor = tailColor;
			this.name = name;
		}

		public BlackCat clone(){
			return new BlackCat(this.color, this.eyeColor, this.noseColor, this.tailColor, this.name);
		}
		
	}
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		BlackCat cat = new BlackCat();
		cat.noseColor = "pink";
		cat.tailColor = "green";
		
		BlackCat kitty = cat.clone();
		kitty.eyeColor = "white";
		kitty.name = "kitty";
						
		System.out.println("cat ->");
		for(Field f : cat.getClass().getSuperclass().getDeclaredFields()) {		
			System.out.print(f.getName() + ":" +f.get(cat)+", ");
				
		}
		System.out.println();
		System.out.println("kitty ->");
		for(Field f : kitty.getClass().getSuperclass().getDeclaredFields()) {		
			System.out.print(f.getName() + ":" +f.get(kitty)+", ");
				
		}
		
		
	}
}
