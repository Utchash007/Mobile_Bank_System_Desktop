package application;



import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PayLoan implements Initializable {
	
	final	String url ="jdbc:mysql:// localhost:3306/testapp";
	final	String user ="root";
	final	String pass="ice007";
	Connection con;
	 Statement stmt;
	 ResultSet rs;
	
	
	 static  User_Holder U;

    @FXML
    private Button dashboard;

    @FXML
    private TextField getAmount;

    @FXML
    private PasswordField getPass;

    @FXML
    private Label loan;

    @FXML
    private Button takeloan;

    @FXML
    void go_dashboard(ActionEvent event) throws Throwable {
    	Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
    	Stage window =(Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(new Scene(root));
    }

    @FXML
    void take_loan(ActionEvent event) throws Throwable, Throwable {
    	U=Controller.downloadObj(Controller.mob);
    	if(getPass.getText()=="" || getAmount.getText()=="") {
    		JOptionPane.showMessageDialog(null, "Fill up the information");
    	}
    	else {
    		int x=Integer.parseInt(getAmount.getText());  int y =Integer.parseInt(getPass.getText());
    		System.out.println(x);
    		System.out.println(U.get_userpin());
    		if(y==U.get_userpin()) {
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			con = DriverManager.getConnection(url, user, pass);
    			Statement stmt = con.createStatement();
    			
    			if(x>U.getloan()) {JOptionPane.showMessageDialog(null, "Amount is greater than pay due");}
    			else {
    			int loan=Math.abs(x-U.getloan());
    			System.out.println(x+U.gettotal_spent());
    			int rs1= stmt.executeUpdate("update user set balance ="+(U.getbalance()-x)+", loan ="+loan +", total_spent= "+(x+U.gettotal_spent())+" where id="+Controller.mob+" ;");
    			PreparedStatement pstmt1 = con.prepareStatement("insert into Loan(id, amount, `D_&_T`) VALUES(?, ?, NOW())");
    			pstmt1.setInt(1, Controller.mob);
    			pstmt1.setInt(2, (U.getloan()-x));
    			int result1=pstmt1.executeUpdate();
    			
    			PreparedStatement pstmt2 = con.prepareStatement("insert into Balance(id, amount, `D_&_T`) VALUES(?, ?, NOW())");
    			pstmt2.setInt(1, Controller.mob);
    			pstmt2.setInt(2, (U.getbalance()-x));
    			int result2=pstmt2.executeUpdate();
    			if(rs1!=0) {
    				JOptionPane.showMessageDialog(null, "Pay Loan Succesfull");
    				getPass.setText("");getAmount.setText("");
    			}}}
    		else {JOptionPane.showMessageDialog(null, "Incoreect Pin");}
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			System.out.println(Controller.mob);
			U=Controller.downloadObj(Controller.mob);
			loan.setText(String.valueOf(U.getloan())+"$");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
