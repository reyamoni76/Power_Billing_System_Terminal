package billing;

public class Payment {

    private double amount;
    private String method;
    private String transactionId;
    private boolean paid;

    public Payment(double amount,
                   String method,
                   String transactionId) {

        this.amount = amount;
        this.method = method;
        this.transactionId = transactionId;
        this.paid = true;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public boolean isPaid() {
        return paid;
    }
}
