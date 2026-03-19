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
}