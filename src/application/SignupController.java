package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class SignupController implements Initializable{
	
	///Database declaration
	final	String url ="jdbc:mysql:// localhost:3306/testapp";
	final	String user ="root";
	final	String pass="ice007";
	Connection con;
	 Statement stmt;
	 ResultSet rs;
	

	    @FXML
	    private Button login_button;
	
	
	 @FXML
	    private Label First_name;

	    @FXML
	    private Label First_name1;

	    @FXML
	    private Label First_name11;

	    @FXML
	    private Label Last_name;

	    @FXML
	    private TextField txname;

	    @FXML
	    private TextField txname1;

	    @FXML
	    private TextField txname2;
	    @FXML
	    private Button SignUpButton;
	    @FXML
	    private PasswordField txtpass;
	    
	    
	    @FXML
	    void goLogin(ActionEvent event) throws Exception {
	    	Parent root = FXMLLoader.load(getClass().getResource("mockup.fxml"));
	    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(new Scene(root));
	    		//new Main().changeScene("mockup.fxml");
	    }
	    
	    
	    
	    @FXML
	    void SignUpPOO(ActionEvent event) throws Throwable { 
	    	String first_name=txname.getText();
	    	String last_name=txname1.getText();
	    	String Mobile=txname2.getText();
	    	String Pass=txtpass.getText();
	    	int x=Integer.parseInt(Mobile);
        	int y =Integer.parseInt(Pass);
	    	if(first_name.equals("") || last_name.equals("") ||  Mobile.equals("") || Pass.equals("")) {
	    		
	    		JOptionPane.showMessageDialog(null, "Please Fill up the SignUp Form Properly");
	    		txname.setText("");
	    		txtpass.setText("");
	    	}
	    	else {
	    		Class.forName("com.mysql.cj.jdbc.Driver");
    			con = DriverManager.getConnection(url, user, pass);
    			if(con!=null) {System.out.println("Connected");}
    			PreparedStatement pstmt = con.prepareStatement("insert into user(id, firstname, lastname, pin, balance,loan, total_recieved, total_spent) values(?, ?, ?, ?, 2500,0,0,0)");
    			pstmt.setInt(1, x);
    			pstmt.setString(2, first_name);
    			pstmt.setString(3, last_name);
    			pstmt.setInt(4, y);
    			int result=pstmt.executeUpdate();
    			if(result!=0) {
    				JOptionPane.showMessageDialog(null, "Signed Up Successfully. Please Login");
    	    		txname.setText("");
    	    		txname1.setText("");
    	    		txname2.setText("");
    	    		txtpass.setText("");
    	    		
    	    		
    			}
    			
    			
	    	}
	    	
	    }
	    
	   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
