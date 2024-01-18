package application;
import java.sql.*;
public class User_Holder extends Controller {
	public  String user_firstname=null;
	public String user_lastname=null;
	public  int user_balance=0;
	public int user_loan=0;
	public int user_total_spent=0;
	public int user_total_recieved=0;
	public int user_pin=0;
	
	User_Holder(String user_firstname, String user_lastname, int user_balance,int user_loan, int user_total_spent,int user_total_recieved,int user_pin){
		this.user_firstname=user_firstname;
		this.user_lastname=user_lastname;
		this.user_balance=user_balance;
		this.user_loan=user_loan;
		this.user_total_spent=user_total_spent;
		this.user_total_recieved=user_total_recieved;
		this.user_pin=user_pin;
	}
	
	String get_firstname() {
		return user_firstname;
	}
	String get_lastname() {
		return user_lastname;
	}
	int getbalance() {
		return user_balance;
	}
	int getloan() {
		return user_loan;
	}
	int gettotal_spent() {
		return user_total_spent;
	}
	int gettotal_recieved() {
		return  user_total_recieved;
	}
	int  get_userpin() {
		return user_pin;
	}
	
	
}
