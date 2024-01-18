package application;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.*;
import javafx.stage.Stage;

public class Controller  implements Initializable {
	  @FXML
	    private Button AdminLog;

	  @FXML
	    private Button btn;

	    @FXML
	    private Button signup;

	    @FXML
	    private TextField txname;

	    @FXML
	    private PasswordField txtpass;
	    //*********************************************************
	    final   static String url ="jdbc:mysql:// localhost:3306/testapp";
		final	static String user ="root";
		final	static String pass="ice007";
		static Connection con;
		 static ResultSet getId;
		int a;
		public static String s1=null,s2=null;
		 static int mob;
//*******************************************************************
	    @FXML
	    void SignUp(ActionEvent event) throws Throwable {
	    	
	    	Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
	    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(new Scene(root));
	    }

	    @FXML
	    void login(ActionEvent event) throws Throwable {
	    	String show_First_Name=null, show_Second_Name=null;
	    	String uname = txname.getText();
	    	String pass1= txtpass.getText();
	    	System.out.println(pass1);
	    	//int x=Integer.parseInt(uname);
	    	//int y =Integer.parseInt(pass1);
	    	if(uname.equals("") && pass1.equals("")) {
	    		
	    		JOptionPane.showMessageDialog(null, "Please Fill up the Login Form");
	    		txname.setText("");
	    		txtpass.setText("");
	    	}else {
	    		int x=Integer.parseInt(uname);
	        	int y =Integer.parseInt(pass1);
	    		try {
	    			Class.forName("com.mysql.cj.jdbc.Driver");
	    			con = DriverManager.getConnection(url, user, pass);
	    			if(con!=null) {System.out.println("Connected");}else {System.out.println("UNCONNECTED");}
				Statement stmt = con.createStatement(); 
				System.out.println(x+" "+y);//**
				 getId = stmt.executeQuery("select * from user where pin = "+y+";");
				
					while(getId.next()) {a=getId.getInt(1);show_First_Name=getId.getString(2);show_Second_Name=getId.getString(3); mob=getId.getInt(1);}
					//s1=getId.getString(2);
					//s2=getId.getString(3);
					//a=getId.getInt(5);
					//mob=a;
					System.out.println("Mobile="+mob);
					
	    		}
	    		catch(Exception e) {e.printStackTrace();}
					if(a==(x)) {
						
	    		try {
					JOptionPane.showMessageDialog(null,"Welcome "+show_First_Name+" "+show_Second_Name);
					Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
			    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
			    	window.setScene(new Scene(root));
			    	
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		txname.setText("");
	    		txtpass.setText("");
	    						}
				else {

		    		JOptionPane.showMessageDialog(null, "Wrong Mobile No Or Password");
		    		txname.setText("");
		    		txtpass.setText("");
				}
				
				}
	    }
	    
	    static public User_Holder downloadObj(int id) throws SQLException, Throwable{
	    	System.out.println(mob);
	    	String f1 = null;
	    	String f2 = null;
	    	int b1=0,b2=0,b3=0,b4=0,b5=0;
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement(); 
			getId = stmt.executeQuery("select * from user where id = "+id+";");
			while(getId.next()){
				System.out.println(getId.getString(2));
			 f1=getId.getString(2);
			 f2=getId.getString(3);
			 b1=getId.getInt(5);
			 b2=getId.getInt(6);
			 b3=getId.getInt(8);
			 b4=getId.getInt(7);
			 b5=getId.getInt(4);}
			System.out.println(f1+f2);
			User_Holder u = new User_Holder(f1, f2, b1,b2,b3,b4,b5);
			return u;
	    	
	    }
	    @FXML
	    void AdminLog(ActionEvent event) throws Throwable {
	    	Parent root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
	    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(new Scene(root));
	    }
	    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
