package MU.dumy.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrmLogin implements ActionListener {
JFrame frm;
JLabel lbl_user_name,lblpassword;
JTextField txt_user_name;
JPasswordField txt_password;
JButton btnLogin,btnRegister;
boolean flag;
public FrmLogin(){
	frm=new JFrame();
	frm.setTitle("User Login");
	frm.setSize(350, 200);
	frm.setLocation(300, 150);
	frm.setLayout(null);
	frm.setResizable(false);
	
	
	lbl_user_name=new JLabel("USER NAME");
	lbl_user_name.setBounds(20, 20, 100, 30);
	frm.add(lbl_user_name);
	
	txt_user_name=new JTextField();
	txt_user_name.setBounds(150, 20, 170, 30);
	frm.add(txt_user_name);
	
	lblpassword=new JLabel("PASSWORD");
	lblpassword.setBounds(20, 60, 100, 30);
	frm.add(lblpassword);
	
	txt_password=new JPasswordField();
	txt_password.setBounds(150, 60, 170, 30);
	frm.add(txt_password);
	
	btnLogin=new JButton("LOGIN");
	btnLogin.setBounds(150, 100, 85, 40);
	frm.add(btnLogin);
	btnLogin.addActionListener(this);
	
	btnRegister=new JButton("REGISTER");
	btnRegister.setBounds(245, 100, 92, 40);
	frm.add(btnRegister);
    btnRegister.addActionListener(this);
    frm.setVisible(true);
}
public static void main(String [] args){
	new FrmLogin(); 
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnLogin)){
			User_Login ul=new User_Login(txt_user_name.getText(), txt_password.getText());
			if(frmvalidate()){
				if(ul.user_Validatation()){
					JOptionPane.showMessageDialog(null, "Login sucessfully");
					txt_user_name.setText(null);
					txt_password.setText(null);
				}
			}
		}else if(e.getSource().equals(btnRegister)){
			new FrmRegister();
			frm.hide();
		}
		
	}
			public boolean frmvalidate(){
			
		if(txt_user_name.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Enter User Name");
			txt_user_name.grabFocus();
			return false;
		}
		else if(txt_password.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Enter User Password");
			txt_password.grabFocus();
			return false;
		}
		return true;
	}
}
