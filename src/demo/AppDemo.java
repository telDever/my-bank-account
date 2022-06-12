package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entities.Account;
import entities.Statement;
import entities.Transaction;
import enums.TransactionType;

public class AppDemo {

	public static void main(String[] args) throws ParseException {

		Account myAccount = new Account();

		// set initial balance
		myAccount.setBalance(57600.00);

		// add Transactions
		List<Transaction> transactions = new ArrayList();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		Transaction trans01 = new Transaction(TransactionType.DEPOSIT, 3200.555, sdf.parse("05/04/2022"));
		Transaction trans02 = new Transaction(TransactionType.WITHDRAWAL, 1150.366, sdf.parse("11/04/2022"));
		Transaction trans03 = new Transaction(TransactionType.WITHDRAWAL, 600.123, sdf.parse("30/05/2022"));
		Transaction trans04 = new Transaction(TransactionType.DEPOSIT, 2700.12, sdf.parse("12/06/2022"));

		transactions.addAll(Arrays.asList(trans01, trans02, trans03, trans04));

		Statement statement = new Statement(myAccount, transactions);

		statement.computeStatment();
	}

}
