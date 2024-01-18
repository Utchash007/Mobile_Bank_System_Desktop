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

public class Bill_Interval implements Initializable {
	static String g="";

    @FXML
    private Button bill;

    @FXML
    private Button bill1;

    @FXML
    private Button bill2;
    
    @FXML
    private Button bill3;


    @FXML
    private Button dashboard;

    @FXML
    void go(ActionEvent event) throws Throwable {
    	g="Electricity";
    	Parent root = FXMLLoader.load(getClass().getResource("paybill.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

    @FXML
    void go1(ActionEvent event) throws Throwable {
    	g="Gas";
    	Parent root = FXMLLoader.load(getClass().getResource("paybill.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

    @FXML
    void go2(ActionEvent event) throws Throwable {
    	g="Water";
    	Parent root = FXMLLoader.load(getClass().getResource("paybill.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

    @FXML
    void go_dashboard(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }
    
    @FXML
    void go_mobile_recharge(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("MobileRecharge.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}

