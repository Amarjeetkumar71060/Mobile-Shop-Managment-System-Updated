package MU.dumy.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Oracale_Connections {
 public static Connection getConnection(){
	 String url="jdbc:oracle:thin:@localhost:1521:xe";
	 String username="system";
	 String password="manager";
	 Connection conn=null;
	 try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	//System.out.println("Driver Register");
	try {
		conn=DriverManager.getConnection(url, username, password);
	//	System.out.println("Connection Established");
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,e);

	}
	
	} catch (ClassNotFoundException e) {
		JOptionPane.showMessageDialog(null,e);

	}
	 return conn;
	 	 
 }
/*public static void main(String[]args){
	new Oracale_Connections().getConnection();
	}*/
}
