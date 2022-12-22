package nocode.programming.pattren.structures;

import java.util.HashMap;
import java.util.Map;

// 12.Flyweight 패턴 (Structures)
// 플라이웨이트 패턴(Flyweight pattern)는 동일하거나 
// 유사한 객체들 사이에 가능한 많은 데이터를 서로 공유하여 
// 사용하도록 하여 메모리 사용량을 최소화하는 소프트웨어 디자인 패턴이다. 
// 종종 오브젝트의 일부 상태 정보는 공유될 수 있는데, 
// 플라이웨이트 패턴에서는 이와 같은 상태 정보를 외부 자료 구조에 저장하여 
// 플라이웨이트 오브젝트가 잠깐 동안 사용할 수 있도록 전달한다.

public class Flyweight {
	
	static interface CoffeeOrder{
		void serveCoffee(CoffeeOrderContext context);
	}
	static class CoffeeFlavor implements CoffeeOrder{
		String flavor;
		public CoffeeFlavor(String newFlavor) {
			this.flavor = newFlavor;
		}
		public String getFlavor() {
			return this.flavor;
		}
		public void serveCoffee(CoffeeOrderContext context) {
			System.out.println("Serving Coffee Flavor "+flavor+ "to Table Number" + context.getTable());
		}
	}
	//tables
	static class CoffeeOrderContext{
		int tableNumber;
		public CoffeeOrderContext(int tableNumber) {
			this.tableNumber = tableNumber;
		}
		public int getTable() {
			return this.tableNumber;
		}
	}
	//factory
	static class CoffeeFlavorFactory{
		private Map<String, CoffeeFlavor> flavors = new HashMap<>();
		
		public CoffeeFlavor getCoffeeFlavor(String flavorName) {
			CoffeeFlavor flavor = flavors.get(flavorName);
			if(flavor == null) {
				flavor = new CoffeeFlavor(flavorName);
				flavors.put(flavorName, flavor);
			}
			return flavor;
		}
		int getTotalCoffeeFlavorsMade() {
			return flavors.size();
		}
	}
	static CoffeeFlavor[] flavors = new CoffeeFlavor[100];
	static CoffeeOrderContext[] tables = new CoffeeOrderContext[100];
	static int orderMade = 0;
	static CoffeeFlavorFactory factory;
	
	static void takeOrder(String flavorIn, int table) {
		flavors[orderMade] = factory.getCoffeeFlavor(flavorIn);
		tables[orderMade++] = new CoffeeOrderContext(table);
	}
	public static void main(String[] args) {
		factory = new CoffeeFlavorFactory();
		takeOrder("Cappuchino", 2);
		takeOrder("Cappuchino", 2);
		takeOrder("Frappe", 1);
		takeOrder("Cappuchino", 2);
		takeOrder("Frappe", 2);
		takeOrder("Espresso", 1);
		takeOrder("Frappe", 897);
		takeOrder("Cappuchino", 97);
		takeOrder("Espresso", 97);
		
		for (int i = 0; i < orderMade; i++) {
			flavors[i].serveCoffee(tables[i]);
		}
		System.out.println();
		System.out.println("total CoffeeFlavor Make Objects Count:"+factory.getTotalCoffeeFlavorsMade());
	}
}