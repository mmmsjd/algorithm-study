package nocode.programming.pattren.behaviors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 17.Command 패턴 (Behaviors)
// 명령을 추상화하여 실행시키는 패턴

public class Command {
	
	static class Cmd {
		void excute() {}
	}
	
	static class PrintCmd extends Cmd {
		String print;
		public PrintCmd(String printStr) {
			this.print = printStr;
		}
		void excute() {
			System.out.println(this.print);
		}
	}
	static class Dog {
		void sit() {
			System.out.println("The dog sat down");
		}
		void stay() {
			System.out.println("The dog is staying");
		}
	}
	static class DogCmd extends Cmd {
		Dog dog;
		List<String> commands;
		public DogCmd(Dog dog , List<String> commands) {
			this.dog = dog;
			this.commands = commands;
		}
		void excute() {
			for(String cmd: commands) {
				if(cmd.equals("sit"))
					dog.sit();
				else if(cmd.equals("stay"))
					dog.stay();
			}
		}
		
	}
	static class Invoker {
		List<Cmd> commands;
		public Invoker() {
			this.commands = new ArrayList<>();
		}
		void addCommand(Cmd cmd) {
			commands.add(cmd);
		}
		void run() {
			for(Cmd cmd:commands) {
				cmd.excute();
			}
		}
	}
	
	
	public static void main(String[] args) {
		PrintCmd printCmd = new PrintCmd("야야 이걸로 출력해야");
//		printCmd.excute();
		
		Dog baduk = new Dog();
		DogCmd dogCmd = new DogCmd(baduk, new ArrayList<>(Arrays.asList(new String[] {"sit","stay", "sit"})));
//		dogCmd.excute();
		
		Invoker invoker = new Invoker();
		invoker.addCommand(printCmd);
		invoker.addCommand(dogCmd);
		
		invoker.run();
		
		
		
	}
}
