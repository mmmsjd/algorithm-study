package nocode.programming.pattren.behaviors;

// 21.Mediator 패턴 (Behaviors)
// ==중재자 패턴 dependency를 줄이는 패턴

public class Mediator {
	static class Mediators {
		void notifyed(String signal) {}
	}
	
	// 각각의 가젯들은 Mediator ref 를 가지고 있어야 함
	// 가젯에서 Action 이 일어나면  Mediator 의 notifyed를 호출하며 중재자에 연결된 가젯들에 noti 한다.
	static class Clock{
		Mediators mediator;
		void setMediator(Mediators mediator) {
			this.mediator = mediator;
		}
		void alram() {
			System.out.println("alram on");
			this.mediator.notifyed("AlramOn");
		}
	}
	static class Light{
		Mediators mediator;
		void setMediator(Mediators mediator) {
			this.mediator = mediator;
		}
		void on() {
			System.out.println("light on");
			this.mediator.notifyed("LightOn");
		}
		void off() {
			System.out.println("light off");
			this.mediator.notifyed("LightOff");
		}
	}
	static class Speaker{
		Mediators mediator;
		void setMediator(Mediators mediator) {
			this.mediator = mediator;
		}
		void on() {
			System.out.println("speaker on");
			this.mediator.notifyed("SpeakerOn");
		}
		void off() {
			System.out.println("speaker off");
			this.mediator.notifyed("SpeakerOff");
		}
	}
	static class HomeMediator extends Mediators {
		Clock clock;
		Light light;
		Speaker speaker;
		public HomeMediator(Clock clock, Light light, Speaker speaker) {
			this.clock = clock;
			this.light = light;
			this.speaker = speaker;

		}
		void notifyed(String signal) {
			if(signal.equals("AlramOn")) {
				this.light.on();
				this.speaker.on();
			}else if(signal.equals("LightOff")) {
				this.speaker.off();
			}
		}
	}
	public static void main(String[] args) {
		Clock clock = new Clock();
		Light light = new Light();
		Speaker speaker = new Speaker();
		
		HomeMediator mediator = new HomeMediator(clock, light, speaker);
		clock.setMediator(mediator);
		light.setMediator(mediator);
		speaker.setMediator(mediator);
		
		clock.alram();
		light.off();
		
		
	}
}
