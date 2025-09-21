package paqueteAccount;

public class Account {
   
    private String id;
    private String name;
    private int balance = 0; 

 
    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Getters
    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        if (amount < 0) {
            System.out.println("Cantidad inválida: no puede ser negativa");
            return balance;
        }
        balance += amount;
        return balance;
    }

    public int debit(int amount) {
        if (amount < 0) {
            System.out.println("Cantidad inválida: no puede ser negativa");
            return balance;
        }
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Saldo insuficiente");
        }
        return balance;
    }

    public int transferTo(Account another, int amount) {
        if (amount < 0) {
            System.out.println("Cantidad inválida: no puede ser negativa");
            return balance;
        }
        if (amount <= balance) {
            this.balance -= amount;
            another.balance += amount;
        } else {
            System.out.println("Saldo insuficiente");
        }
        return this.balance;
    }


    public String toString() {
        return "Cuenta[id=" + id + ",nombre=" + name + ",saldo=" + balance + "]";
    }

    
}
