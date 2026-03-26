public class Customer{
    private ArrayList<BankAccount> accounts;

    public Customer(){
        accounts = new ArrayList<>();
    }

    public ArrayList<BankAccount>getAccounts(){
        return accounts;
    }

    public void createBankAccount(){
        accounts.add(new BankAccount());
    }
}