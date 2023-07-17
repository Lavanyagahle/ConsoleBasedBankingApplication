package com.bankapp;
import java.util.*;

public class BankingApplication {
public static void main(String[] args) throws InsufficientFundsException, NegativeAmountException {
	BankAcc bank1=new BankAcc();
	bank1.showMenu();
}
}
