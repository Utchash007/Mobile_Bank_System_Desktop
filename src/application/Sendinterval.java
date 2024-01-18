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

public class Sendinterval implements Initializable {

    @FXML
    private Button SendMoneyBank;

    @FXML
    private Button SendMoneyUser;

    @FXML
    private Button dashboard;

    @FXML
    void go_dashboard(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

    @FXML
    void go_send_money_bank(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("BankSendMoney.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

    @FXML
    void go_send_money_user(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("SendMoney.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}

