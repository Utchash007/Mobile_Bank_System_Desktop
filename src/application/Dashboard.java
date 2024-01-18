package application;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Dashboard  implements Initializable {
	
	
	  @FXML
	    private Label NameField;

	    @FXML
	    private Label blance;

	    @FXML
	    private Label loan;

	    @FXML
	    private Button logout;

	    @FXML
	    private Button paybill;

	    @FXML
	    private Button sendmoney;

	    @FXML
	    private Button stats;

	    @FXML
	    private Button takeloan;

	    @FXML
	    void go_pay_bill(ActionEvent event) throws Throwable {
	    	Parent root = FXMLLoader.load(getClass().getResource("Bill_Interval.fxml"));
	    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(new Scene(root));
	    }

	    @FXML
	    void go_send_money(ActionEvent event) throws Throwable {
	    	Parent root = FXMLLoader.load(getClass().getResource("Send_Interval.fxml"));
	    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(new Scene(root));
	    }

	    @FXML
	    void go_stats(ActionEvent event) throws Throwable {
	    	Parent root = FXMLLoader.load(getClass().getResource("Stats.fxml"));
	    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(new Scene(root));
	    }

	    @FXML
	    void gotake_loan(ActionEvent event) throws Throwable {
	    	Parent root = FXMLLoader.load(getClass().getResource("LoanInterval.fxml"));
	    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(new Scene(root));
	    }

	    @FXML
	    void logout(ActionEvent event) throws Exception {
	    	Parent root = FXMLLoader.load(getClass().getResource("mockup.fxml"));
	    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(new Scene(root));
	    }
    
  static  User_Holder U;
   
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println(Controller.mob);
			U=Controller.downloadObj(Controller.mob);
			NameField.setText(U.get_firstname());
			blance.setText(String.valueOf(U.getbalance())+"$");
			loan.setText(String.valueOf(U.getloan())+"$");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //NameField.setText("");
		 //blance.setText(String.valueOf()+"$");
	}

}
