import java.util.*;

public class BankAccount {
	private static int accountsNumber = 0;
	private static int totalMoney = 0;
	
	private String accountNumber;
	private long checkingBalance;
	private long savingBalance;
	
	BankAccount(){
		this.accountNumber = randomAccountNumber();
		accountsNumber ++;
	}
	
	long getCheckingBalance() {
		return this.checkingBalance;
	}
	long getSavingBalance() {
		return this.savingBalance;
	}
	String accountNumber() {
		return this.accountNumber;
	}
	void depositMoney(long money, String accName) {
		if(accName == "checkingBalance") {
			this.checkingBalance += money;
		} else if(accName == "savingBalance") {
			this.savingBalance += money;
		}
		totalMoney += money;
	}
	
	long seeTotal() {
		return this.checkingBalance + this.savingBalance;
	}
	void withdrawMoney(long money, String accName) {
		if(accName == "checkingBalance") {
			if(this.checkingBalance >= money) {
				this.checkingBalance -= money;
			}
		} else if(accName == "savingBalance") {
			if(this.savingBalance >= money) {
				this.savingBalance -= money;
			}
		}
		totalMoney -= money;
	}
	
	static void seePrivateInfo() {
		System.out.print("total accounts number: ");
		System.out.print(accountsNumber);
		System.out.print(". total money in bank: $");
		System.out.print(totalMoney);
	}
	
	static private String randomAccountNumber() {
		  		int min = 0;
		  		int max = 9;
		         int range = (max - min) + 1;
		         String output = "";
		         
		         for	(int i=0;i<10;i++) {
		        	 	int newNumber = (int)(Math.random() * range) + min;
		        	 	output += Integer.toString(newNumber);
		         }
		         
		         return output;
	}
}
