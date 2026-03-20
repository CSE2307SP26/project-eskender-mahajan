public class TransactionHistory{

   private BankAccount account;
   ArrayList<Double> transactionHistory = new ArrayList<>();

   public TransactionHistory(BankAccount account){
    this.account = account;
   }

   public void deposit(double moneyAmount){
        account.deposit(moneyAmount);
        transactionHistory.add(moneyAmount);
   }
   public void withdrawal(double moneyAmount){
        account.withdraw(moneyAmount);
        transactionHistory.add(-moneyAmount);
   }
   public double[] returnTransactionHistory(){
    double[] historyArray = new double[transactionhistory.size()];
    for(int i =0; i<history.size();i++){
        historyArray[i]=transactionHistory.get(i);
    }
    return historyArray;
   }
  
}