package nocode.programming.solid;

// SOLID
// 4. Interface Segregation ��Ģ
// �������̽��� �����ϴ� Ŭ������ �ʿ��� �Լ��� ������ �� �ֵ��� ��������.

// �������̽� ������ �۰� �ض� 
// ex) ������� �ڵ��� -> �ڵ��� �� ��Ʈ�� �и� 

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
