package nocode.programming.pattren.behaviors;

// 16.TemplateMethod ���� (Behaviors)
// class �� �޼ҵ���� ���ø����� �����Ǵ� ���� 
public class TemplateMethod {
	
	static class BasicRecipe {
		void cookRaem() {
			boilWater();
			addRamen();
			addOnes();
			wating();
		}
		void boilWater() {
			System.out.println("boil 550ml if water");
		}
		void addRamen() {
			System.out.println("add Nodles, soup Base, flakes");
		}
		void addOnes() {
			
		}
		void wating() {
			System.out.println("wait.. 4min 30s");
		}
		
	}
	static class NocopeRecipe extends BasicRecipe {
		void addOnes() {
			System.out.println("add onions");
		}
		
	}
	
	public static void main(String[] args) {
		BasicRecipe recipe = new BasicRecipe();
		recipe.cookRaem();
		
		System.out.println();
		
		NocopeRecipe nocopeRecipe = new NocopeRecipe();
		nocopeRecipe.cookRaem();
		
		
		
	}
}
