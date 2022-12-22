package nocode.programming.pattren.structures;

// 9.Facade 패턴 (Structures)
// 건물의 앞쪽면 만 공개한다. 
// 뒤에서 뭔 활동을 하던 client Code 에서는 알지 못하고 알고 싶지도 않다.

public class Facade {

	static class Stage1 {
		void ignite() {
			System.out.println("1st stage ignition");
		}

		void liftOff() {
			System.out.println("1st stage liftOff");
		}

		void eject() {
			System.out.println("1st stage ejection");
		}

		void comeBack() {
			System.out.println("1st stage return");
		}
	}

	static class Stage2 {
		void ignite() {
			System.out.println("2nd stage ignition");
		}

		void eject() {
			System.out.println("2nd stage ignition");
		}
	}

	static class Capsule {
		void ignite() {
			System.out.println("capsule ignition");
		}

		void landing() {
			System.out.println("capsule landing/deploy");
		}
	}

	static class Rocket {
		Stage1 stage1;
		Stage2 stage2;
		Capsule capsule;

		public Rocket() {
			stage1 = new Stage1();
			stage2 = new Stage2();
			capsule = new Capsule();
		}

		void launch() {// facade call
			this.stage1.ignite();
			this.stage1.liftOff();
			this.stage1.eject();
			this.stage2.ignite();
			this.stage1.comeBack();
			this.stage2.eject();
			this.capsule.ignite();
			this.capsule.landing();
		}
	}
	public static void main(String[] args) {
		Rocket r = new Rocket();
		
		r.launch();
		
	}

}
