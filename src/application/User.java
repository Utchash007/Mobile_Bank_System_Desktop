package application;

public class User {
    public String id;
    public String user_firstname = null;
    public String user_lastname = null;
    public String user_balance;
    public String user_loan;
    public String user_total_spent;
    public String user_total_recieved;
    public String user_pin;

    public User(String id, String user_firstname, String user_lastname, String user_pin, String user_balance,
                String user_loan, String user_total_recieved, String user_total_spent) {
        this.id = id;
        this.user_pin = user_pin;
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_balance = user_balance;
        this.user_loan = user_loan;
        this.user_total_spent = user_total_spent;
        this.user_total_recieved = user_total_recieved;
    }

    public String getId() {
        return id;
    }

    public String getUser_firstname() {
        return user_firstname;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public String getUser_balance() {
        return user_balance;
    }

    public String getUser_loan() {
        return user_loan;
    }

    public String getUser_total_spent() {
        return user_total_spent;
    }

    public String getUser_total_recieved() {
        return user_total_recieved;
    }

    public String getUser_pin() {
        return user_pin;
    }
}
