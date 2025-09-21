package paqueteAccount;

public class ProgramaAccount {

	public static void main(String[] args) {
		Account acc1 = new Account("A001", "Alice", 500);
		Account acc2 = new Account("A002", "Bob", 300);

		System.out.println(acc1);
		System.out.println(acc2);

		System.out.println("Saldo de " + acc1.getName() + ": " + acc1.getBalance());
		System.out.println("Saldo de " + acc2.getName() + ": " + acc2.getBalance());

		acc1.credit(200);
		acc2.debit(100);

		System.out.println("Despues de operaciones:");
		System.out.println(acc1);
		System.out.println(acc2);

		acc1.transferTo(acc2, 150);

		System.out.println("Despues de transferencia:");
		System.out.println(acc1);
		System.out.println(acc2);
	}

}
