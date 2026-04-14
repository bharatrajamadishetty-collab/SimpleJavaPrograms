interface PaymentRedirect {
    public void processPayment(double amount);
}

class PayPal implements PaymentRedirect {
    @Override
    public void processPayment(double amount) {
        System.out.println("Paid " + amount + " through PayPal");
    }
}

class CreditCard implements PaymentRedirect {
    @Override
    public void processPayment(double amount) {
        System.out.println("Paid " + amount + " through CreditCard");
    }
}

public class PaymentGateway {
    private final PaymentRedirect pr;

    PaymentGateway(PaymentRedirect p) {
        this.pr = p;
    }

    public static void main(String[] args) {
        double amount = 1000;
        PaymentGateway ppal = new PaymentGateway(new PayPal());
        ppal.pr.processPayment(amount);

        PaymentGateway cc = new PaymentGateway(new CreditCard());
        cc.pr.processPayment(amount);
    }
}
