package nocode.programming.pattren.behaviors;

// 18.ChainOfResponsibility ���� (Behaviors)
// å�� ü�� ����, å�� ���� ����
// payment process
// �������� ���� ����� ����� ������� ���� ó�� 
// Cash Handler, CreditCard Handler, DebitCard Handler(����ī��)


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
