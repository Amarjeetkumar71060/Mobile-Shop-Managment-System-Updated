package MU.dumy.project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
public class FrmChangePassword implements FocusListener , ActionListener {
JFrame frm;
JLabel lbl_user_name,lbl_sec_que,lbl_show_secques,lbl_txt_sec,lbl_pass,lbl_conf_pass;
JTextField txt_user;
JPasswordField txt_security_ans,txt_pass,txt_conf_pass;
JButton btnChange_Password;
public FrmChangePassword(){
	frm=new JFrame();
	frm.setSize(420, 300);
	frm.setLocation(500,250);
	frm.setLayout(null);
	frm.setResizable(false);
	frm.setTitle("Change Password");
	
	lbl_user_name=new JLabel("USER NAME");
	lbl_user_name.setBounds(20, 20, 100, 30);
	frm.add(lbl_user_name);
	
	txt_user=new JTextField();
	txt_user.setBounds(160, 20, 170, 30);
		frm.add(txt_user);
	txt_user.addFocusListener(this);
	
	lbl_sec_que=new JLabel("SECURITY QUESTION");
	lbl_sec_que.setBounds(20, 60, 120, 30);
	frm.add(lbl_sec_que);
	
	lbl_show_secques=new JLabel("");
	lbl_show_secques.setBounds(160, 60, 220, 30);
	frm.add(lbl_show_secques);
	
	lbl_txt_sec=new JLabel("SECURITY ANSWER");
	lbl_txt_sec.setBounds(20, 100, 120, 30);
	frm.add(lbl_txt_sec);
	
	txt_security_ans=new JPasswordField();
	txt_security_ans.setBounds(160, 100, 170, 30);
	frm.add(txt_security_ans);
	
	lbl_pass=new JLabel("PASSWORD");
	lbl_pass.setBounds(20, 140, 100, 30);
	frm.add(lbl_pass);
	
	txt_pass=new JPasswordField();
	txt_pass.setBounds(160,140,170,30);
	frm.add(txt_pass);
	
	lbl_conf_pass=new JLabel("CONFORM PASSWORD");
	lbl_conf_pass.setBounds(20, 180, 130, 30);
	frm.add(lbl_conf_pass);
	
	txt_conf_pass=new JPasswordField();
	txt_conf_pass.setBounds(160, 180, 170, 30);
	frm.add(txt_conf_pass);
	
	btnChange_Password=new JButton("CHANGE PASSWORD");
	btnChange_Password.setBounds(160, 220, 170, 40);
	frm.add(btnChange_Password);
	btnChange_Password.addActionListener(this);
	//frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frm.setVisible(true);
}
public static void main(String[] args) {
	new FrmChangePassword();
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource().equals(btnChange_Password)){
		ChangePassword chw=new ChangePassword(txt_user.getText(),lbl_sec_que.getText(),txt_conf_pass.getText(),txt_security_ans.getText());
		if(chw.validate_security_ans()==1){
			if(chw.update_password()==1){
				JOptionPane.showMessageDialog(null, "Password Change Successfully");
				txt_user.setText(null);
				txt_security_ans.setText(null);
				txt_pass.setText(null);
				txt_conf_pass.setText(null);
				lbl_show_secques.setText(null);
			}else{
				JOptionPane.showMessageDialog(null, "Password not Change");
			}
		}else {
			JOptionPane.showMessageDialog(null, "wrong answer");
		}
	}
}
@Override
public void focusGained(FocusEvent arg0) {
	// TODO Auto-generated method stub

}
@Override
public void focusLost(FocusEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource().equals(txt_user)){
		ChangePassword cpwd=new ChangePassword(txt_user.getText());
		if(cpwd.get_security_question().equals("User Doesn't Exist")){
			txt_user.setText("");
			txt_conf_pass.grabFocus();		
	}
		else{
		lbl_show_secques.setText(cpwd.get_security_question());
		}
	}else if(e.getSource().equals(txt_conf_pass)){
		if(txt_conf_pass.getText().equals(txt_pass.getText())){
			JOptionPane.showMessageDialog(null, " Confirm Password is Match");
		}
		else{
			JOptionPane.showMessageDialog(null, " Confirm Password is not Match");
			txt_pass.setText("");
			txt_conf_pass.setText("");
			txt_pass.grabFocus();
		}
	}
}
		
}
