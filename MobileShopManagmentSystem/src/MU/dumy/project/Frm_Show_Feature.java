package MU.dumy.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Frm_Show_Feature implements ActionListener,FocusListener,ItemListener,WindowListener {
	JFrame frm;
	JLabel lbl_amount,lbl_brand_name,lbl_model_no,lbl_sepecification,lbl_image;
	JList lst_specifecation;
	JComboBox cmb_brand,cmb_model_no;
	JButton btn_serch;
	JTextField txt_amount;
	
	public Frm_Show_Feature(){
	frm=new JFrame();
	frm.setSize(625, 500);
	frm.setLocation(160,150);
	frm.setLayout(null);
	frm.setResizable(false);
	frm.setTitle("SHOW FEATURE");
	
	lbl_amount=new JLabel("AMOUNT");
	lbl_amount.setBounds(25, 25, 100, 25);
	frm.add(lbl_amount);
	
	lbl_image=new JLabel("PICTURE");
	lbl_image.setBounds(440, 25, 100, 25);
	frm.add(lbl_image);
	
	txt_amount=new JTextField();
	txt_amount.setBounds(150, 25, 150, 25);
	txt_amount.addFocusListener(this);
	frm.add(txt_amount);
	
		lbl_brand_name=new JLabel("BRAND NAME");
		lbl_brand_name.setBounds(25, 65, 100, 25);
		frm.add(lbl_brand_name);
		
		cmb_brand=new JComboBox();
		cmb_brand.setBounds(150, 65, 150, 25);
			frm.add(cmb_brand);
				
		lbl_model_no=new JLabel("MODEL NAME");
		lbl_model_no.setBounds(25, 105, 100, 25);
		frm.add(lbl_model_no);
		
		cmb_model_no=new JComboBox();
		cmb_model_no.setBounds(150, 105, 150, 25);
		frm.add(cmb_model_no);
								
		lbl_sepecification=new JLabel("SEPECIFICATION:-");
		lbl_sepecification.setBounds(25, 140, 150, 25);
		frm.add(lbl_sepecification);
		
		lst_specifecation=new JList();
		lst_specifecation.setBounds(25, 165, 275, 255);
		frm.add(lst_specifecation);
		
		btn_serch=new JButton("SEARCH");
		btn_serch.setBounds(25, 425, 275, 40);
		frm.add(btn_serch);
		btn_serch.addActionListener(this);
		
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
public static void main(String[] args) {
	new Frm_Show_Feature();
}
@Override
public void focusGained(FocusEvent e) {
	
	
}
@Override
public void focusLost(FocusEvent e) {
	String [] strval=null;
	Show_Specification getbran=new Show_Specification();
	strval=getbran.show_feature(Integer.parseInt(txt_amount.getText()));
	int i=strval.length;
	for(int j=0;j<i;j++){
		//cmb_brand.setSelectedIndex(-1);
		cmb_brand.addItem(strval[j].toString());
		//JOptionPane.showMessageDialog(null, strval[0]);
	}
}
@Override
public void actionPerformed(ActionEvent e) {
	
	
}
@Override
public void itemStateChanged(ItemEvent e) {
	
	

 }
@Override
public void windowActivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowClosed(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowClosing(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowDeactivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowDeiconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowIconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	cmb_brand.removeAllItems();
	cmb_model_no.removeAllItems();
	JOptionPane.showMessageDialog(null, "hello");
	
	
}
}

