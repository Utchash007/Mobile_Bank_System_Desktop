package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PayBill implements Initializable {
	
	final	String url ="jdbc:mysql:// localhost:3306/testapp";
	final	String user ="root";
	final	String pass="ice007";
	Connection con;
	 Statement stmt;
	 ResultSet rs;
	
	static  User_Holder U;
	static Bill_Interval b;

    @FXML
    private Label billtype;

    @FXML
    private Button dashboard;

    @FXML
    private TextField getAmount;

    @FXML
    private PasswordField getPass;

    @FXML
    private Button paybill;

    @FXML
    void go_dashboard(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

    @FXML
    void pay_bill(ActionEvent event) throws Throwable, Throwable {
    	U=Controller.downloadObj(Controller.mob);
    	if(getPass.getText()=="" || getAmount.getText()=="") {
    		JOptionPane.showMessageDialog(null, "Fill up the information");
    	}
    	else {
    		//int x=Integer.parseInt(getAmount.getText());  
    		int y =Integer.parseInt(getPass.getText());
    		//System.out.println(x);
    		System.out.println(U.get_userpin());
    		if(y==U.get_userpin()) {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			con = DriverManager.getConnection(url, user, pass);
    			Statement stmt = con.createStatement();
    			
    			if(1000>U.getbalance()) {JOptionPane.showMessageDialog(null, "Insufficient Balance");}
    			else {
    				Random r = new Random();
    			int rs1= stmt.executeUpdate("update user set balance ="+(U.getbalance()-1000)+", total_spent= "+(1000+U.gettotal_spent())+" where id="+Controller.mob+" ;");
    			if(rs1!=0) {
    				JOptionPane.showMessageDialog(null, "You Have paid 1000$ for "+b.g+" bill\nTxnID : "+b.g+""+r.nextInt(5));
    				getPass.setText("");getAmount.setText("");
    			}}}
    		else {JOptionPane.showMessageDialog(null, "Incoreect Pin");}
    	}
    }

    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		billtype.setText(b.g);
		
	}

}

