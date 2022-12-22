package nocode.programming.pattren.behaviors;

// 18.ChainOfResponsibility 패턴 (Behaviors)
// 책임 체인 패턴, 책임 연쇄 패턴
// payment process
// 결재방법에 따른 모듈을 만드는 방법으로 결재 처리 
// Cash Handler, CreditCard Handler, DebitCard Handler(직불카드)


public class ChainOfResponsibility {
	
	static class Handler {
		Handler next;
		void setNext(Handler handler) {
			this.next = handler;
		}
		Handler handle(String[] req) {
			if(this.next != null) {
				return this.next.handle(req);
			}else {
				return null;
			} 
		}
	}
	static class CashHandler extends Handler{
		
		Handler handle(String[] req) {
			if(req[0].equals("cash")) {
				System.out.println("processing cash "+req[1] + " won");
				return null;
			}else {
				System.out.println("cash Handler cannot processing");
				return super.handle(req);
			}
			
		}
	}
	static class CreditCardHandler extends Handler{
		
		Handler handle(String[] req) {
			if(req[0].equals("credit")) {
				System.out.println("processing Credit Card "+req[1] + " won");
				return null;
			}else {
				System.out.println("credit Card Handler cannot processing");
				return super.handle(req);
			}
			
		}
	}
	static class DebitCardHandler extends Handler{
		
		Handler handle(String[] req) {
			if(req[0].equals("debit")) {
				System.out.println("processing Debit Card "+req[1] + " won");
				return null;
			}else {
				System.out.println("debit Card Handler cannot processing");
				return super.handle(req);
			}
			
		}
	}
	
	public static void main(String[] args) {
		CashHandler cashHandler = new CashHandler();
		CreditCardHandler creditCardHandler = new CreditCardHandler();
		DebitCardHandler debitCardHandler = new DebitCardHandler();
		
		cashHandler.setNext(creditCardHandler);
		creditCardHandler.setNext(debitCardHandler);
		
		String[] req = {"paypal", "10000"};
		cashHandler.handle(req);
		
	}
}
