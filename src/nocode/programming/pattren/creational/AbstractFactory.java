package nocode.programming.pattren.creational;

// 3.Abstract Factory ∆–≈œ (Creational)

public class AbstractFactory {

	static interface Button{
		void click();
	}
	static interface CheckBox{
		void click();
	}
	static interface ScrollBar{
		void scroll();
	}
	static class DarkButton implements Button{

		@Override
		public void click() {
			System.out.println("dark click");
		}
		
	}
	static class LightButton implements Button{

		@Override
		public void click() {
			System.out.println("light click");
		}
		
	}
	static class DarkChekBox implements CheckBox{

		@Override
		public void click() {
			System.out.println("dark click");
		}
		
	}
	static class LightChekBox implements CheckBox{

		@Override
		public void click() {
			System.out.println("light click");
		}
		
	}
	static class DarkScrollBar implements ScrollBar{

		@Override
		public void scroll() {
			System.out.println("dark scroll");
		}
		
	}
	static class LightScrollBar implements ScrollBar{

		@Override
		public void scroll() {
			System.out.println("light scroll");
		}
		
	}
	
	static interface UIFactory{
		Button getButton();
		CheckBox getCheckBox();
		ScrollBar getScroll();
	}
	static class DrakUIFactory implements UIFactory{

		@Override
		public Button getButton() {
			return new DarkButton();
		}

		@Override
		public CheckBox getCheckBox() {
			return new DarkChekBox();
		}

		@Override
		public ScrollBar getScroll() {
			return new DarkScrollBar();
		}
		
	}
	
	static class LightUIFactory implements UIFactory{

		@Override
		public Button getButton() {
			return new LightButton();
		}

		@Override
		public CheckBox getCheckBox() {
			return new LightChekBox();
		}

		@Override
		public ScrollBar getScroll() {
			return new LightScrollBar();
		}
		
	}
	
	public static void main(String[] args) {
		UIFactory f = new DrakUIFactory();
		f.getButton().click();
		f.getCheckBox().click();
		f.getScroll().scroll();
	}
}
