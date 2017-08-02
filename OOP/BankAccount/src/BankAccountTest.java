
public class BankAccountTest {
	public static void main(String[] arg) {
		BankAccount first = new BankAccount();
		
		
		first.depositMoney(5000, "checkingBalance");
		first.depositMoney(2000, "savingBalance");
		
		first.withdrawMoney(50, "checkingBalance");
		
		System.out.println( first.accountNumber() );
		System.out.println( first.getCheckingBalance() );
		System.out.println( first.getSavingBalance() );
		
		System.out.print( "total on both accounts: " );
		System.out.println( first.seeTotal() );
		
		
		
		BankAccount.seePrivateInfo();
	}

}
