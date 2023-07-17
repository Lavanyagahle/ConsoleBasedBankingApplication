package com.bankapp;
import java.util.*;
class NegativeAmountException extends Exception{
	public NegativeAmountException(String message) {
		super(message);
	}
}
class InsufficientFundsException extends Exception{
	InsufficientFundsException(String message){
		super(message);
	}
}

public class BankAcc {
      private int balance;
      private int previousTransaction;
    private String customerName;
     String customerId;
     
    // public BankAcc(String customerName, String customerId) {
   // 	this.customerName= customerName;
    //	this.customerId= customerId;
    	
    // }
    public  BankAcc(){
    	 balance=0;
    	 previousTransaction=0;
    	 customerName="";
    	 customerId="";
    	 
     }
     
     //for deposit
     void deposit(int amount)throws NegativeAmountException {
    	 if(amount<0) {
    		 throw new NegativeAmountException ("Invalid deposit amount"+amount);
    		  }
    	 balance=balance+amount;
    	 System.out.println("Deposited Successful.. Curent Balance: "+balance);
		 previousTransaction=amount;
	
     }
     
     //for withdraw
     void withdraw(int amount)throws InsufficientFundsException, NegativeAmountException {
    	 if(amount<0) {
    		 throw new NegativeAmountException ("Invalid deposit amount"+amount);
    		 }
    	 if(amount>balance) {
    		 throw new InsufficientFundsException("Insufficient balance..Current balanace: "+balance);
    	 }
    	 balance=balance-amount;
    	 System.out.println("Withdrawn Successful.. Curent Balance: "+balance);
		 previousTransaction= -amount;
	 
     }
     
     //for previoustransaction
     void getPreviousTransaction() {
    	 if(previousTransaction>0) {
    		 System.out.println("Deposited: "+previousTransaction);
    	 }else if(previousTransaction<0){
    		 System.out.println("Withdrawn "+Math.abs(previousTransaction));
    		 
    	 }else {
    		 System.out.println("No transaction is occured!");
    	 }
    	 
     }

     void showMenu() throws InsufficientFundsException, NegativeAmountException {
    	 
    	 
    	 
    	 char option;
    	 Scanner sc=new Scanner(System.in);
    	 
    	 
    	 
    	 System.out.println("Enter customer name");
    	 customerName=sc.nextLine();
    	 
    	 System.out.println("Enter cutomer Id");
    	 customerId=sc.nextLine();
    	 
    	 System.out.println("********************************************");
    	 System.out.println();
    	 System.out.println("Welcome "+customerName);
    	 System.out.println("Your ID is: "+customerId);
    	 System.out.println();
    	 System.out.println("A. Check Balance");
    	 System.out.println("B. Deposit");
    	 System.out.println("C. Withdraw");
    	 System.out.println("D. Previous Transcation");
    	 System.out.println("E. Exit");
    	 
    	 
    	 do {
    		 System.out.println("**************************************************");
    		 System.out.println("Enter option");
    		 option= Character.toUpperCase(sc.next().charAt(0));
    		 
    		 try {
    		 switch(option) {
    		 
    		 case 'A':
    			 System.out.println("***********************************************");
    			 System.out.println("Balance is: "+balance);
    			 System.out.println();
    			 break;
    		 case 'B':
    			 System.out.println("***********************************************");
    			 System.out.println("Enter the amount to deposit");
    			 int amount=sc.nextInt();
    			 deposit(amount);
    			 System.out.println();
    			 break;
    		 case 'C':
    			 System.err.println("***********************************************");
    			 System.out.println("Enter the amount to withdraw");
    			 int amount2=sc.nextInt();
    			 withdraw(amount2);
    			 System.out.println();
    			 break;
    		 case 'D':
    			 System.out.println("************************************************");
    			 getPreviousTransaction();
    			 System.out.println();
    			 break;
    		 case 'E':
    			 System.out.println("*************************************************");
    			 break;
    		 default:
    				 System.out.println("Invalid option! Please try again");
    			 
    		 }
    		 }
    		 catch(Exception e) {
    			 System.out.println(e.getMessage());
    		 }
    		 
    	 }while(option !='E');
     }

}
