package MU.dumy.project;


import java.sql.*;

import javax.swing.JOptionPane;

public class company_Add extends LoginBase {
	
	public int gen_Product_Id(){
		int num=1;
	super.conn=Oracale_Connections.getConnection();
	String sqlqry="select product_id from company_name order by product_id desc";
	try {
		super.ps=conn.prepareStatement(sqlqry);
		rs=ps.executeQuery();
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e);
	}
	try {
		if(rs.next()){
			return rs.getInt(1)+1;
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
		return num;
	
}
	public int insert(int product_id,String brandname){
		int status=0;
		super.conn=Oracale_Connections.getConnection();
		String sqlqry="insert into company_name values('" + product_id +"','" + brandname +"')";
		try {
			ps=conn.prepareStatement(sqlqry);
			 status=ps.executeUpdate();
		conn.commit();
		if(status==1){
			
		}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}return status;
		
	}
	public void update(String product_id,String brand_name){
		super.conn=Oracale_Connections.getConnection();
		String sqlqry="update company_name set brand_name='"+brand_name+"'where product_id='" + product_id+ "'";
		try {
			super.ps=conn.prepareStatement(sqlqry);
			int status=super.ps.executeUpdate();
			conn.commit();
			if(status==1){
				JOptionPane.showMessageDialog(null, "Row Updated");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e);
			}
		}
		
	}
	public void del(String product){
		super.conn=Oracale_Connections.getConnection();
		String sqlqry="delete from company_name where product_id='" + product + "'";
		try {
			super.ps=conn.prepareStatement(sqlqry);
			int sta=super.ps.executeUpdate();
			conn.commit();
			if(sta==1){
				JOptionPane.showMessageDialog(null, "Row Deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		
	}
	public String search(String product_id){
		super.conn=Oracale_Connections.getConnection();
		String brand_name=null;
		 String sqlqry="select brand_name from company_name where product_id='" + product_id + "'";
		try {
			super.ps=conn.prepareStatement(sqlqry);
			super.rs=ps.executeQuery();
			if(rs.next()){
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
		
		return brand_name;
	}
	public boolean validate_brand_name(String brandname){
		super.conn=Oracale_Connections.getConnection();
		String sqlqry="select brand_name from company_name where brand_name='"+brandname+"'";
		try {
			super.ps=conn.prepareStatement(sqlqry);
			super.rs=ps.executeQuery();
			
			if(super.rs.next()){
				return false;
	}
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
			
		}
		return true;
	
	}
}
