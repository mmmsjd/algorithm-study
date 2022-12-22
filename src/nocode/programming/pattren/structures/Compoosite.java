package nocode.programming.pattren.structures;

import java.util.ArrayList;
import java.util.List;

// 13.Compoosite ���� (Structures)

// �κа� ��ü�� ������ ǥ���ϱ� ���� ��ü���� ��� Ʈ�� ������ �����մϴ�. 
// ����ڷ� �Ͽ��� ���� ��ü�� ���� ��ü�� ��� �����ϰ� �ٷ� �� �ֵ��� �ϴ� �����Դϴ�.

public class Compoosite {
	
	static class Component{
		void fn() {}
	}
	static class Leaf extends Component{
		void fn() {
			System.out.println("Leaf");
		}
	}
	static class Composite extends Component{
		List<Component> component = new ArrayList<>();
		
		public Composite() {
			this.component = new ArrayList<>();
		}
		void add(Component component) {
			this.component.add(component);
		}
		
		void fn() {
			System.out.println("Composite");
			for(Component component:this.component) {
				component.fn();
			}
		}
	}
	public static void main(String[] args) {
		Composite composite1 = new Composite();
		composite1.add(new Leaf());
		composite1.add(new Leaf());
		
		Composite composite0 = new Composite();
		composite0.add(new Leaf());
		composite0.add(composite1);
		
		
		composite0.fn();
	}
}