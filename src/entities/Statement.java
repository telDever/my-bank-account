package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import enums.TransactionType;

public class Statement {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	public static final String STATEMENT_HEADER = "operation      | date           | amount         | balance";

	private Account account;
	private List<Transaction> transactions = new ArrayList();

	public Statement(Account account, List<Transaction> transactions) {
		this.account = account;
		this.transactions = transactions;
	}

	public void computeStatment() {
		StringBuilder sb = new StringBuilder();
		sb.append(STATEMENT_HEADER).append("\n");
		for (Transaction trans : this.transactions) {

			// set Balance
			if (trans.getType().equals(TransactionType.DEPOSIT)) {
				this.account.setBalance(this.account.getBalance() + trans.getAmount());
			} else if (trans.getType().equals(TransactionType.WITHDRAWAL)) {
				this.account.setBalance(account.getBalance() - trans.getAmount());
			}

			concatStatementColumn(sb, trans.getType().toString());
			concatStatementColumn(sb, sdf.format(trans.getDate()));
			concatStatementColumn(sb, String.valueOf(trans.getAmount()));
			sb.append(this.account.getBalance());
			sb.append("\n");

		}

		System.out.println(sb.toString());

	}

	private void concatStatementColumn(StringBuilder sb, String value) {
		int initialLength = sb.length();
		sb.append(value);
		while ((sb.length() - initialLength) < 15) {
			sb.append(" ");
		}
		sb.append("| ");
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
