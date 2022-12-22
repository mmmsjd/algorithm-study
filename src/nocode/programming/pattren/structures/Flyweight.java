package nocode.programming.pattren.structures;

import java.util.HashMap;
import java.util.Map;

// 12.Flyweight ���� (Structures)
// �ö��̿���Ʈ ����(Flyweight pattern)�� �����ϰų� 
// ������ ��ü�� ���̿� ������ ���� �����͸� ���� �����Ͽ� 
// ����ϵ��� �Ͽ� �޸� ��뷮�� �ּ�ȭ�ϴ� ����Ʈ���� ������ �����̴�. 
// ���� ������Ʈ�� �Ϻ� ���� ������ ������ �� �ִµ�, 
// �ö��̿���Ʈ ���Ͽ����� �̿� ���� ���� ������ �ܺ� �ڷ� ������ �����Ͽ� 
// �ö��̿���Ʈ ������Ʈ�� ��� ���� ����� �� �ֵ��� �����Ѵ�.

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