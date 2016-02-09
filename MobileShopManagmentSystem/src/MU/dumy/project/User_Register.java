package MU.dumy.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;
public class User_Register extends LoginBase {
		Boolean flag=true;
	Connection conn;
	//Statement stmt;
	ResultSet rs;
	PreparedStatement ps;
	public User_Register(String uname){
		super.username=uname;
	}
	public User_Register(String uname,String pass,String sec_que,String sec_ans){
		super.username=uname;
		super.userpassword=pass;
		super.security_question=sec_que;
		super.security_answer=sec_ans;
		if(login_Validate(uname)){
			insrec(username, userpassword, security_question, security_answer);
		}

	}
	public boolean login_Validate(String use_name){
		conn=Oracale_Connections.getConnection();
		String sqlqry="select user_name from user_info where user_name='"+use_name+"'";
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
			if(rs.next()){
					flag=false;
					
			}
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,e);

		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		return flag;
		
	}
	public void insrec(String uname,String upass,String secques,String secans){
		conn=Oracale_Connections.getConnection();
		String sqlqry="insert into user_info values ('" + uname + "','" + upass + "','" + secques + "','" + secans + "')";
		try {
		//stmt=conn.createStatement();
		//stmt.executeQuery(sqlqry);
			ps=conn.prepareStatement(sqlqry);
			//ps.executeQuery();
			int status=ps.executeUpdate(sqlqry);
		conn.commit();
		if(status==1){
			JOptionPane.showMessageDialog(null, "User Registered");
		}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,e);

		}
			finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,e);

			}
		}
	}
}

