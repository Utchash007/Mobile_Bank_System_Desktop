package application;



import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminHome{

    @FXML
    private Button UserLog;

    @FXML
    private Button btn;

    @FXML
    private TextField txname;

    @FXML
    private PasswordField txtpass;

    @FXML
    void GoUserLog(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("mockup.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

    @FXML
    void login(ActionEvent event) throws Throwable {
    	String show_First_Name=null, show_Second_Name=null;
    	String uname = txname.getText();
    	String pass1= txtpass.getText();
    	System.out.println(pass1);
    	
    	if(uname.equals("") && pass1.equals("")) {
    		
    		JOptionPane.showMessageDialog(null, "Please Fill up the Login Form");
    		txname.setText("");
    		txtpass.setText("");
    	}
    	else {
    		
    			if(uname.equals("Admin") && pass1.equals("123")) {
    				JOptionPane.showMessageDialog(null, "Admin Login Successful");
    				Parent root = FXMLLoader.load(getClass().getResource("AdminDash.fxml"));
			    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
			    	window.setScene(new Scene(root));
    				
    			}
    			else {JOptionPane.showMessageDialog(null, "Invalid Admin Authorization");
    		}
    	}
    }

}

