package MU.dumy.project;
import java.sql.*;

import javax.swing.JOptionPane;

public class Show_Specification extends LoginBase{
	public String[] show_feature(int price){
		int str=0;
		String [] brandname= new String [10];
		super.conn=Oracale_Connections.getConnection();
	String sqlqry="select brand_name from feature where amount<='" + price + "'";
		try {
			super.ps=conn.prepareStatement(sqlqry);
			super.rs=super.ps.executeQuery();
			while(super.rs.next()){
				brandname[str]=rs.getString(1);
				str+=1;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}return brandname;
		
	}
	
}
