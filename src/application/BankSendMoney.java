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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BankSendMoney implements Initializable {
	final	String url ="jdbc:mysql:// localhost:3306/testapp";
	final	String user ="root";
	final	String pass="ice007";
	Connection con;
	 Statement stmt;
	 ResultSet rs;
	 static  User_Holder U;

    @FXML
    private TextField amount;

    @FXML
    private Button back;

    @FXML
    private TextField banknofield;

    @FXML
    private Button dashboard;

    @FXML
    private PasswordField pin;

    @FXML
    private Button send;

    @FXML
    void Send(ActionEvent event) throws Throwable, Throwable {
    	U=Controller.downloadObj(Controller.mob);
    	if(pin.getText()=="" || amount.getText()=="") {
    		JOptionPane.showMessageDialog(null, "Fill up the information");
    	}
    	else {
    		int x=Integer.parseInt(amount.getText());  int y =Integer.parseInt(pin.getText());
    		String L=pin.getText();
    		System.out.println(x);
    		System.out.println(U.get_userpin());
    		if(y==U.get_userpin()) {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			con = DriverManager.getConnection(url, user, pass);
    			Statement stmt = con.createStatement();
    			
    			if(x>U.getbalance()) {JOptionPane.showMessageDialog(null, "Insufficient balance");}
    			
    			else {
    				Random r = new Random();
    			System.out.println(x+U.gettotal_spent());
    			int rs1= stmt.executeUpdate("update user set balance ="+(U.getbalance()-x)+", total_spent= "+(x+U.gettotal_spent())+" where id="+Controller.mob+" ;");
    			if(rs1!=0) {
    				JOptionPane.showMessageDialog(null, "You have sent"+ amount.getText()+"$ to "+banknofield.getText()+""+"\nTxnID : "+"Bank"+r.nextInt(500));
    				pin.setText("");amount.setText("");banknofield.setText("");
    			}}}
    		else {JOptionPane.showMessageDialog(null, "Incoreect Pin");}
    	}
    }

    @FXML
    void goBack(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("Send_Interval.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

    @FXML
    void go_dashboard(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}

