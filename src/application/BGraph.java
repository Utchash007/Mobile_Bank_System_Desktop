package application;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class BGraph implements Initializable {
	static  User_Holder U;
	static int x;
	final   static String url ="jdbc:mysql:// localhost:3306/testapp";
	final	static String user ="root";
	final	static String pass="ice007";
	static Connection con;
	 static ResultSet getId;
	  @FXML
	    private LineChart<?, ?> line;

	    @FXML
	    private Button goback;
	    @FXML
	    private Button graph;
	    @FXML
	    void his(ActionEvent event) throws Throwable {
	    	Parent root = FXMLLoader.load(getClass().getResource("BH.fxml"));
	    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(new Scene(root));
	    }


	    @FXML
	    private Button logout;

	    @FXML
	    void back(ActionEvent event) throws Throwable {
	    	Parent root = FXMLLoader.load(getClass().getResource("Stats.fxml"));
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
			x=Controller.mob;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement(); 
			getId = stmt.executeQuery("select * from Balance where id = "+x+" ORDER BY `D_&_T` ASC;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XYChart.Series series1= new XYChart.Series();
		series1.setName("Balance");
		try {
			while(getId.next()) {
				int a=getId.getInt(2);
				
				Timestamp c=getId.getTimestamp(3);
				String b=String.valueOf(c);
				 series1.getData().add(new XYChart.Data(b,a));
				
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		line.getData().addAll(series1);
		
	}

}
