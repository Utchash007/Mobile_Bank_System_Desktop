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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class UTHistory implements Initializable {
	//static  User_Holder U;
	static int x;

	final   static String url ="jdbc:mysql:// localhost:3306/testapp";
	final	static String user ="root";
	final	static String pass="ice007";
	static Connection con;
	 static ResultSet getId;
	 ObservableList<UTH> data;
	 @FXML
	    private TableColumn<UTH, String> amo;

	    @FXML
	    private TableColumn<UTH, String> d_t;

	    @FXML
	    private Button goback;

	    @FXML
	    private Button logout;

	  

	    @FXML
	    private TableColumn<UTH, String> s_id;

	    @FXML
	    private TableColumn<UTH, String> s_name;

	    @FXML
	    private TableView<UTH> tbl;

	    @FXML
	    void back(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("Stats.fxml"));
	    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(new Scene(root));
	    }

	    @FXML
	    void logout(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("AdminHome.fxml"));
	    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(new Scene(root));
	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			data=FXCollections.observableArrayList();
			tbl.setItems(data);
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
				getId = stmt.executeQuery("SELECT * FROM T_History Where r_id ="+x+ "  ORDER BY `D_&_T` DESC ;");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		        amo.setCellValueFactory(new PropertyValueFactory<>("amount"));
		        s_id.setCellValueFactory(new PropertyValueFactory<>("sender_ID"));
		        s_name.setCellValueFactory(new PropertyValueFactory<>("sender_Name"));
		        d_t.setCellValueFactory(new PropertyValueFactory<>("date_Time"));
			 try {
					while(getId.next()) {
						//int a0=(getId.getInt(1));String a=String.valueOf(a0);
						//String b=getId.getString(2);
						int c0=getId.getInt(3);String c=String.valueOf(c0);
						String d=getId.getString(4);
						int e0=getId.getInt(5);String e=String.valueOf(e0);
						Timestamp f0=(getId.getTimestamp(6));String f=String.valueOf(f0);
						
						 data.add(new UTH(c,e,d,f));
					 }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
}
