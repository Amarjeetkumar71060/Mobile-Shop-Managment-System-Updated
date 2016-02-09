package MU.dumy.project;
import java.sql.*;

import javax.swing.JOptionPane;
public class ChangePassword extends LoginBase {
String Query;
int status=0;
public ChangePassword(String uname){
	 super.username=uname;
	}
public ChangePassword(String usrname,String sec_ques,String urspass,String sec_ques_ans){
	super.security_question=sec_ques;
	super.security_answer=sec_ques_ans;
	super.userpassword=urspass;
	super.username=usrname;
	}
public String get_security_question(){
	String str_security_ques="";
	User_Register urs=new User_Register(super.username);
	if(!urs.login_Validate(super.username)){
		super.conn=Oracale_Connections.getConnection();
		Query="select user_question from user_info where user_name='"+ super.username + "' ";
		try {
			super.ps=conn.prepareStatement(Query);
			super.rs=ps.executeQuery();
			while(super.rs.next()){
				str_security_ques=super.rs.getString(1);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		
	}else{
		str_security_ques="User Doesn't Exist";
	}
	
			return str_security_ques;
	}
public int validate_security_ans(){
	int sta=0;
	super.conn=Oracale_Connections.getConnection();
	Query="select user_answer from user_info where user_name='" + super.username+ "' and  user_answer= '" + super.security_answer + "' ";
	try {
		super.ps=conn.prepareStatement(Query);
		super.rs=ps.executeQuery();
				while(rs.next()){	
					sta=1;
				}
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e);
	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	return sta;
	}
public int update_password(){
	int status=0;
	super.conn=Oracale_Connections.getConnection();
	Query="update user_info set user_password='" + super.userpassword + "' where user_name='" + super.username +"'";
	try {
		super.ps=conn.prepareStatement(Query);
		status=super.ps.executeUpdate();
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e);

	}finally{
		try {
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	return status;
	
}

}
