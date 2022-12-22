package nocode.programming.solid;

// SOLID
// 4. Interface Segregation 원칙
// 인터페이스를 구현하는 클래스는 필요한 함수만 구현할 수 있도록 설계하자.

// 인터페이스 구성은 작게 해라 
// ex) 수륙양용 자동차 -> 자동차 와 보트로 분리 

public class InterfaceSegregation {

	interface ICar{
		void drive();
		void turnLeft();
		void turnRight();
	}
	
	interface IBoat{
		void steer();
		void steerLeft();
		void steerRight();
	}
	
	class Niro implements ICar{
		public void drive() {};
		public void turnLeft() {};
		public void turnRight() {};
	}
	
	class CatBoat implements ICar, IBoat{
		public void drive() {};
		public void turnLeft() {};
		public void turnRight() {};

		public void steer() {};
		public void steerLeft() {};
		public void steerRight() {};
	}
	
	
	
}
