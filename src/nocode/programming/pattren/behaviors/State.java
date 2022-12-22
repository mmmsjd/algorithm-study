package nocode.programming.pattren.behaviors;

// 15.State 패턴 (Behaviors)
// EX) 신호등, programming stat (Design-Coding-Test-Review-Done)

public class State {
//	static class TrafficLight{
//		String state = "green";
//		
//		void setState(String state) {
//			this.state = state;
//		}
//		void speak() {
//			if(this.state == "green") {
//				System.out.println("green Light");
//			}else if(this.state == "red") {
//				System.out.println("red Light");
//			}
//		}
//		void waiting() {
//			System.out.println("wait.. the light changed");
//			if(this.state == "green") {
//				this.state = "red";
//			}else if(this.state == "red") {
//				this.state = "green";
//			}
//		}
	
	
	// ex
	static class TrafficLight{
		States state = new GreenLight();
		
		void setState(States state) {
			this.state = state;
		}
		void speak() {
			this.state.speak();
		}
		void waiting() {
			this.state.waiting(this);
		}
	}
	static class States {
		void speak() {}
		void waiting(TrafficLight trafficLight) {}
	}
	static class GreenLight extends States{
		void speak() {
			System.out.println("green Light");
		}
		void waiting(TrafficLight trafficLight) {
			System.out.println("wait.. the light changed");
			trafficLight.setState(new RedLight());
		}
	}
	static class RedLight extends States{
		void speak() {
			System.out.println("red Light");
		}
		void waiting(TrafficLight trafficLight) {
			System.out.println("wait.. the light changed");
			trafficLight.setState(new GreenLight());
		}
	}
	
	public static void main(String[] args) {
		//단순 구현
		TrafficLight t = new TrafficLight();
		t.speak();
		t.waiting();
		t.speak();
	}
}
