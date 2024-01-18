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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Stats implements Initializable  {

	
	 static  User_Holder U;
	

		    @FXML
		    private Label X;

		    @FXML
		    private Label Y;

		    @FXML
		    private Button bg;

		    @FXML
		    private Button dashboard;

		    @FXML
		    private Button lg;
		    @FXML
		    private Button th1;

		    @FXML
		    private Button logout;
		    @FXML
		    void th(ActionEvent event) throws Throwable {
		    	Parent root = FXMLLoader.load(getClass().getResource("UTHistory.fxml"));
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
		    void bg(ActionEvent event) throws Throwable {
		    	Parent root = FXMLLoader.load(getClass().getResource("BGraph.fxml"));
		    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
		    	window.setScene(new Scene(root));
		    }
		    
		    @FXML
		    void lg(ActionEvent event) throws Throwable {
		    	Parent root = FXMLLoader.load(getClass().getResource("LGraph.fxml"));
		    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
		    	window.setScene(new Scene(root));
		    }

		    @FXML
		    void logout(ActionEvent event) throws Throwable {
		    	Parent root = FXMLLoader.load(getClass().getResource("mockup.fxml"));
		    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
		    	window.setScene(new Scene(root));
		    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			U=Controller.downloadObj(Controller.mob);
			X.setText(String.valueOf(U.gettotal_spent())+"$");
			Y.setText(String.valueOf(U.gettotal_recieved())+"$");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

