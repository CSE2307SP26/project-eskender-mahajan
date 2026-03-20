<<<<<<< Updated upstream
class transactionHistoryTest{
    //A bank customer should be able to view their transaction history for an account.
    
    //Empty Account should have no transaction history
    @Test
	emptyAccount void test() {
		//1. Create the object to be tested
		bankAccount account = new bankAccount();
		//2. Call the method being tested
		int words = account.returnTransactionHistory();

		//3. Use assertions to validate
		assertEquals(0, words);
	}
=======
class transactionHistoryTest{
    //A bank customer should be able to view their transaction history for an account.
    
    //New Account should have no transaction history
    @Test
	void emptyAccount () {
		//1. Create the object to be tested
		bankAccount account = new bankAccount();
		//2. Call the method being tested
		double[] history = account.returnTransactionHistory();

		//3. Use assertions to validate
		assertEquals(0, history.length);
	}
    //Deposit into an Account should have a transaction history
    @Test
	 void depositAccount () {
		//1. Create the object to be tested
		bankAccount account = new bankAccount();
		//2. Call the method being tested
        account.deposit(200);
		double [] history = account.returnTransactionHistory();

		//3. Use assertions to validate
		assertEquals(200, history[0]);
	}
    //Withdrawal from an Account should have a transaction history
    @Test
	void withdrawalAccount () {
		//1. Create the object to be tested
		bankAccount account = new bankAccount();
		//2. Call the method being tested
        account.deposit(200);
        account.withdrawal(100);
		double [] history = account.returnTransactionHistory();

		//3. Use assertions to validate
		assertEquals(200, history[0]);
        assertEquals(-100, history[1]);
	}
>>>>>>> Stashed changes
}