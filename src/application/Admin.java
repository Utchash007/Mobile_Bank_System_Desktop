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

public class Admin implements Initializable {

    @FXML
    private Button logout;

    @FXML
    private Button t_history;

    @FXML
    private Button u_b_graph;

    @FXML
    private Button user_info;

    @FXML
    void go_t_history(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("THistory.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

    @FXML
    void go_u_b_graph(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("AllGraph.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

    @FXML
    void go_user_info(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("ShowTable1.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

    @FXML
    void logout(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
