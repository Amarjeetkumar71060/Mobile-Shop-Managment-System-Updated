package MU.dumy.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class User_Login extends LoginBase {
Connection conn;
PreparedStatement ps;
ResultSet rs;
public User_Login(String uname,String upass){
	super.username=uname;
	super.userpassword=upass;
	}
public boolean user_Validatation(){
	conn=Oracale_Connections.getConnection();
	String sqlqry="select *from user_info";
	try {
		ps=conn.prepareStatement(sqlqry);
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,e);
	}
	try {
		rs=ps.executeQuery();
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,e);
	}
	try {
		while(rs.next()){
			if(super.username.equals(rs.getString(1)) && super.userpassword.equals(rs.getString(2))){
				return true;
			}
		}
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,e);
	}
	finally{
		try {
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e);
		}
	}
	return false;
		}
}

