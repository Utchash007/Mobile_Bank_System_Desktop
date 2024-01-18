package application;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.ResourceBundle;
import java.io.IOException;

import javax.swing.JOptionPane;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ShowTable1  implements Initializable  {

   


	@FXML
    private TableColumn<User, String> Balance;

    @FXML
    private TableColumn<User, String > First_Name;
    
    @FXML
    private TableView<User> tbl;

    @FXML
    private TableColumn<User, String> Last_Name;

    @FXML
    private TableColumn<User, String> Loan;

    @FXML
    private TableColumn<User, String> id;

    @FXML
    private TableColumn<User, String> pin;

    @FXML
    private TableColumn<User, String> t_r;

    @FXML
    private TableColumn<User, String> t_s;
    
    ObservableList<User>data;

    @FXML
    private Button u_b_graph;
    
    final   static String url ="jdbc:mysql:// localhost:3306/testapp";
	final	static String user ="root";
	final	static String pass="ice007";
	static Connection con;
	 static ResultSet getId;
	

    @FXML
    void go_u_b_graph(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("AdminDash.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		data=FXCollections.observableArrayList();
		tbl.setItems(data);
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
		 
		 id.setCellValueFactory(new PropertyValueFactory<User, String>("id"));
		 First_Name.setCellValueFactory(new PropertyValueFactory<User, String>("user_firstname"));
		 Last_Name.setCellValueFactory(new PropertyValueFactory<User, String>("user_lastname"));
		 pin.setCellValueFactory(new PropertyValueFactory<User, String>("user_pin"));
		 Balance.setCellValueFactory(new PropertyValueFactory<User, String>("user_balance"));
		 t_r.setCellValueFactory(new PropertyValueFactory<User, String>("user_total_recieved"));
		 t_s.setCellValueFactory(new PropertyValueFactory<User, String>("user_total_spent"));
		 try {
			while(getId.next()) {
				int a0=(getId.getInt(1));String a=String.valueOf(a0);
				String b=getId.getString(2);
				String c=getId.getString(3);
				int d0=getId.getInt(4);String d=String.valueOf(d0);
				int e0=getId.getInt(5);String e=String.valueOf(e0);
				int f0=getId.getInt(6);String f=String.valueOf(f0);
				int g0= getId.getInt(7);String g=String.valueOf(g0);
				int h0=getId.getInt(8);String h=String.valueOf(h0);
				 data.add(new User(a,b,c,d,e,f,g,h));
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	}

}
