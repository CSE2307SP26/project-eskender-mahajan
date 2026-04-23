package main;

public class Transfer {
    private BankAccount from;
    private BankAccount to;
    private double amount;
    private String status;
    private Customer requester;
    private String memo;

    public Transfer(Customer requester, BankAccount from, BankAccount to, double amount, String memo) {
        this.requester = requester;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.memo = memo;
        this.status = "PENDING";
    }

    public BankAccount getFrom() { return from; }
    public BankAccount getTo() { return to; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }
    public Customer getRequester() { return requester; }
    public String getMemo() { return memo; }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Transfer[" + requester.getName() + " | $" + amount + " | " + memo + " | " + status + "]";
    }
}