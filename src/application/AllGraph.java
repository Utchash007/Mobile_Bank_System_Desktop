package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AllGraph implements Initializable {

    @FXML
    private BarChart<?, ?> bar;

    @FXML
    private Button goback;

    @FXML
    private Button logout;

    @FXML
    void back(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("AdminDash.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

    @FXML
    void logout(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

    static String url ="jdbc:mysql:// localhost:3306/testapp";
	final	static String user ="root";
	final	static String pass="ice007";
	static Connection con;
	 static ResultSet getId;
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
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
			getId = stmt.executeQuery("select * from user ;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 XYChart.Series series1= new XYChart.Series();
		 XYChart.Series series2= new XYChart.Series();
		 series1.setName("Balance");
		 series2.setName("Loan");
		 try {
			while(getId.next()) {
				String a=getId.getString(2);
				String b=" ";
				String c=getId.getString(3);
				int d=getId.getInt(5);
				int e=getId.getInt(6);
				 series1.getData().add(new XYChart.Data(a+b+c,d));
				 series2.getData().add(new XYChart.Data(a+b+c,e));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 bar.getData().addAll(series1);
		 bar.getData().addAll(series2);
	}

}