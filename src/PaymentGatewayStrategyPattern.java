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

public class PaymentGatewayStrategyPattern {

    public static void main(String[] args) {
        double amount = 1000;
        PaymentRedirect ppal = new PayPal();
        ppal.processPayment(amount);

        PaymentRedirect cc = new CreditCard();
        cc.processPayment(amount);
    }
}
