package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	static Connection con;
	static Stage pstage;
	@Override
	public void start(Stage stage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("mockup.fxml"));
		    
	        Scene scene = new Scene(root);
	    
	        stage.setTitle("Führer");
	        stage.setScene(scene);
	        stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(String gui) { //method for changing scene within the same window
		try {
			Parent root=FXMLLoader.load(getClass().getResource(gui));//loading FXML file
			Scene scene = new Scene(root);  //setting width and height of the window 
			
			pstage.setScene(scene);  // scene=content inside window
			pstage.setTitle("Führer"); //Title of the window
			pstage.setResizable(false); //Making window non resizable
			pstage.show();  //Showing window to user
		} catch(Exception e) {
			e.printStackTrace();  //Printing Exception
		}
	}
	
	
	public static void connectDB(String url,String user,String pass) throws SQLException{ //Connecting to database at the start of the program
		con=DriverManager.getConnection(url, user, pass);
		System.out.println(con);
		}
	
	public static void main(String[] args) {
		
		launch(args);
	}
}
