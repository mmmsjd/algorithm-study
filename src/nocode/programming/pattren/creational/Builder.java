package nocode.programming.pattren.creational;

// 4.Builder ∆–≈œ (Creational)

public class Builder {

	static class Cat{
		int height;
		int weight;
		String color;
		
		public Cat(int height, int weight, String color) {
			this.height = height;
			this.weight = weight;
			this.color = color;
		}
		void print() {
			System.out.println(height+"cm, "+ weight +"kg, "+color);
		}
	}
	static class CatBuilder {
		int height;
		int weight;
		String color;
		
		public CatBuilder() {
			super();
		}
		public CatBuilder setHeight(int height) {
			this.height = height;
			return this;
		}
		public CatBuilder setWeight(int weight) {
			this.weight = weight;
			return this;
		}
		public CatBuilder setColor(String color) {
			this.color = color;
			return this;
		}
		Cat builder() {
			return new Cat(this.height, this.weight, this.color);
		}
	}
	static class WhiteCatBuilder extends CatBuilder {
		public WhiteCatBuilder() {
			this.color = "white";
		}
	}
	static class BlackCatBuilder extends CatBuilder {
		public BlackCatBuilder() {
			this.color = "black";
		}
	}
	
	
	static class Director {
		void setSmallCat(CatBuilder builder){
			builder.setHeight(5);
			builder.setWeight(5);
		}
		void setBigCat(CatBuilder builder){
			builder.setHeight(100);
			builder.setWeight(100);
		}
	}
	
	public static void main(String[] args) {
//		Cat cat = new CatBuilder().setHeight(20).setWeight(19).setColor("green").builder();
//		cat.print();
		
//		Cat whiteCat = new WhiteCatBuilder().setHeight(10).setWeight(10).builder();
//		whiteCat.print();
		
		
		Director director = new Director();		
		BlackCatBuilder blackCatBuilder = new BlackCatBuilder();
		director.setBigCat(blackCatBuilder);
		Cat blackCat = blackCatBuilder.builder();
		
		blackCat.print();
		
		
		
	}
}
