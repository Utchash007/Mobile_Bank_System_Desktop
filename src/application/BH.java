package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
public class BH implements Initializable{
	
	static int x;

	final   static String url ="jdbc:mysql:// localhost:3306/testapp";
	final	static String user ="root";
	final	static String pass="ice007";
	static Connection con;
	 static ResultSet getId;
	 ObservableList<C> data;
	
	@FXML
    private TableColumn<C, String> A;

    @FXML
    private TableColumn<C, String> B;

    @FXML
    private Button goback;

    @FXML
    private Button graph;

    @FXML
    private TableView<C> lib;

    @FXML
    private Button logout;

    @FXML
    void back(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("Stats.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

    @FXML
    void graph(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("BGraph.fxml"));
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
		data=FXCollections.observableArrayList();
		lib.setItems(data);
		try {
			x=Controller.mob;
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 try {
			getId = stmt.executeQuery("SELECT * FROM Balance Where id ="+x+ " ORDER BY `D_&_T` DESC ;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 A.setCellValueFactory(new PropertyValueFactory<>("A"));
		 B.setCellValueFactory(new PropertyValueFactory<>("B"));
		 
		 try {
			while(getId.next()) {
					int a=getId.getInt(2);
					
					Timestamp c=getId.getTimestamp(3);
					String b=String.valueOf(c);
					String d=String.valueOf(a);
					data.add(new C(b,d));
					 //series1.getData().add(new XYChart.Data(b,a));
					
				 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
