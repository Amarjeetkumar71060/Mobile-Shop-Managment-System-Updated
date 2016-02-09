package MU.dumy.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FrmRegister implements ActionListener  {

	JFrame frm;
	JLabel lbl_user_name,lbl_password,lbl_security_question,lbl_security_ans;
	JTextField txt_user_name;
	JPasswordField txt_password,txt_security_ans;
	JButton btnRegister,btnLogin;
	JComboBox cmbxSecurityQuestion;
	String question[]={"What is your fav friend","what is your aim","what is your fav game"};
	 public FrmRegister() {
		// TODO Auto-generated constructor stub
		 frm=new JFrame();
			frm.setTitle("REGISTRATION");
			frm.setSize(350,300);
			frm.setLocation(400, 200);
			frm.setLayout(null);
			frm.setResizable(false);
			
				
			lbl_user_name=new JLabel("User Name");
			lbl_user_name.setBounds(20,20, 100, 20);
			frm.add(lbl_user_name);
			
			txt_user_name=new JTextField();
			txt_user_name.setBounds(150,20,150,20);
			frm.add(txt_user_name);
			
			lbl_password=new JLabel("Password");
			lbl_password.setBounds(20,50, 100, 20);
			frm.add(lbl_password);
			
			txt_password=new JPasswordField();
			txt_password.setBounds(150,50,150,20);
			frm.add(txt_password);
			
			lbl_security_question=new JLabel("SECURITY QUESTION");
			lbl_security_question.setBounds(20,80, 120, 20);
			frm.add(lbl_security_question);
	
			cmbxSecurityQuestion=new JComboBox();
			cmbxSecurityQuestion.setBounds(150,80,150,20);
			frm.add(cmbxSecurityQuestion);
			int i=question.length;
			for(int j=0;j<i;j++){
				cmbxSecurityQuestion.addItem(question[j]);
			}
			//cmbxSecurityQuestion.addItem(question[0]);
			//cmbxSecurityQuestion.addItem(question[1]);
			//cmbxSecurityQuestion.addItem(question[2]);
			
			lbl_security_ans=new JLabel("SECURITY ANSWER");
			lbl_security_ans.setBounds(20,120, 130, 20);
			frm.add(lbl_security_ans);
			
			txt_security_ans=new JPasswordField();
			txt_security_ans.setBounds(150,120,150,20);
			frm.add(txt_security_ans);
			
			btnRegister=new JButton("REGISTER");
			btnRegister.setBounds(200, 200, 100, 40);
			frm.add(btnRegister);
			btnRegister.addActionListener(this);
			
			btnLogin=new JButton("LOGIN");
			btnLogin.setBounds(50, 200, 100, 40);
			frm.add(btnLogin);
			btnLogin.addActionListener(this);
			frm.setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(btnLogin)){
					new FrmLogin();
			frm.hide();
				}
			else if(e.getSource().equals(btnRegister)){
			if(frmvalidate()){
				User_Register ur=new User_Register(txt_user_name.getText().toString(),txt_password.getText().toString(),cmbxSecurityQuestion.getSelectedItem().toString(),txt_security_ans.getText());
				txt_user_name.setText("");
				txt_user_name.grabFocus();
				txt_password.setText("");
				txt_security_ans.setText("");
			 }
			}
		}
	
		
		
	public boolean frmvalidate(){
		if(txt_user_name.getText()==""){
			JOptionPane.showMessageDialog(null, "Enter User Name ");
			return false;
		}else if(txt_password.getText()==""){
			JOptionPane.showMessageDialog(null, "Enter Password");
			return false;
		}else if(cmbxSecurityQuestion.getSelectedIndex()==-1){
			JOptionPane.showMessageDialog(null, "Select Security Question");
			return false;
		}else if(txt_security_ans.getText()==""){
			JOptionPane.showMessageDialog(null, "Enter Your Security Answer");
			return false;
		}else{
			return true;
		}
	}
	public static void main(String[]args){
		new FrmRegister();
	}
	
}