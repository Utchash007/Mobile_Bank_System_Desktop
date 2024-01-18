package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Loan_Interval implements Initializable {
	
	 @FXML
	    private Button Take_loan;

	    @FXML
	    private Button dashboard;

	    @FXML
	    private Button payloan;

	    @FXML
	    void go_dashboard(ActionEvent event) throws Throwable {
	    	Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
	    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(new Scene(root));
	    }

	    @FXML
	    void go_pay_due_loan(ActionEvent event) throws Throwable {
	    	Parent root = FXMLLoader.load(getClass().getResource("PayLoan.fxml"));
	    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(new Scene(root));
	    }

	    @FXML
	    void go_take_loan(ActionEvent event) throws Throwable {
	    	Parent root = FXMLLoader.load(getClass().getResource("TakeLoan.fxml"));
	    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(new Scene(root));
	    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
