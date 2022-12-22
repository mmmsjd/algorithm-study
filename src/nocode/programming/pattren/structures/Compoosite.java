package nocode.programming.pattren.structures;

import java.util.ArrayList;
import java.util.List;

// 13.Compoosite 패턴 (Structures)

// 부분과 전체의 계층을 표현하기 위해 객체들을 모아 트리 구조로 구성합니다. 
// 사용자로 하여금 개별 객체와 복합 객체를 모두 동일하게 다룰 수 있도록 하는 패턴입니다.

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