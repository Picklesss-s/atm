package atm;

public class Account {
    private int cardId;
    private int pin;
    private int balance;

    public Account(int cardId, int pin, int balance) {
        this.cardId = cardId;
        this.pin = pin;
        this.balance = balance;
    }

    public int getCardId() {
        return cardId;
    }

    public int getPin() {
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean validatePin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public boolean withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

