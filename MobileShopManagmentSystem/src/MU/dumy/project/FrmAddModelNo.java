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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.soap.Text;

public class FrmAddModelNo implements ActionListener,FocusListener,WindowListener,ItemListener{
	JFrame frm;
	JLabel lbl_product_id,lbl_brand_name,lbl_model_name,lbl_amount,lbl_os,lbl_processor,lbl_ram,
	lbl_primary_cam,lbl_secondray_cam,lbl_screen_size,lbl_internal_stroge,lbl_expandable_upto,
	lbl_resulation,lbl_protection,lbl_battery,lbl_nw,lbl_image;
	JComboBox cmb_brand,cmb_model_name;
	JButton btn_add_model_no,btn_edit_model_no,btn_src_model_no;
	JTextField txt_amount,txt_primary_cam,txt_os,txt_processor,txt_secondray_cam,
	txt_screen_size,txt_internal_stroge,txt_expandable_upto,txt_ram,txt_resulation,txt_protection,
	txt_battery,txt_nw,txt_show_product;
public FrmAddModelNo(){
	frm=new JFrame();
	frm.setSize(870, 450);
	frm.setLocation(90,100);
	frm.setLayout(null);
	frm.setResizable(false);
	frm.setTitle("MODEL");
	frm.addWindowListener(this);
	
	lbl_brand_name=new JLabel("BRAND NAME");
	lbl_brand_name.setBounds(25, 25, 100, 25);
	frm.add(lbl_brand_name);
	
	cmb_brand=new JComboBox();
	cmb_brand.setBounds(150, 25, 150, 25);
		frm.add(cmb_brand);
	cmb_brand.addFocusListener(this);
	cmb_brand.addItemListener(this);
	
	lbl_product_id=new JLabel("PRODUCT_ID");
	lbl_product_id.setBounds(330, 25, 150, 25);
	frm.add(lbl_product_id);
	
	txt_show_product=new JTextField();
	txt_show_product.setBounds(420, 25, 150, 25);
	frm.add(txt_show_product);
	txt_show_product.setEditable(false);
	
	
	lbl_image=new JLabel("PICTURE");
	lbl_image.setBounds(700, 25, 150, 25);
	frm.add(lbl_image);
	
	lbl_model_name=new JLabel("MODEL NAME");
	lbl_model_name.setBounds(25, 65, 100, 25);
	frm.add(lbl_model_name);
					
	cmb_model_name=new JComboBox();
	cmb_model_name.setBounds(150, 65, 150, 25);
	frm.add(cmb_model_name);
	cmb_model_name.setSelectedIndex(-1);
	cmb_model_name.setEditable(true);
	
	lbl_amount=new JLabel("AMOUNT");
	lbl_amount.setBounds(330, 65, 100, 25);
	frm.add(lbl_amount);
	
	txt_amount=new JTextField();
	txt_amount.setBounds(420, 65, 150, 25);
	frm.add(txt_amount);
	
	lbl_os=new JLabel("OS");
	lbl_os.setBounds(330, 105, 100, 25);
	frm.add(lbl_os);
	
	txt_os=new JTextField();
	txt_os.setBounds(420, 105, 150, 25);
	frm.add(txt_os);
	
	lbl_ram=new JLabel("RAM");
	lbl_ram.setBounds(330, 145, 100, 25);
	frm.add(lbl_ram);
	
	txt_ram=new JTextField();
	txt_ram.setBounds(420, 145, 150, 25);
	frm.add(txt_ram);
	
	lbl_processor=new JLabel("PROCESSOR");
	lbl_processor.setBounds(25, 185, 122, 25);
	frm.add(lbl_processor);
	
	txt_processor=new JTextField();
	txt_processor.setBounds(150, 185, 150, 25);
	frm.add(txt_processor);
	
	lbl_primary_cam=new JLabel("REAR CAMERA");
	lbl_primary_cam.setBounds(330, 185, 100, 25); 
	frm.add(lbl_primary_cam);
	
	txt_primary_cam=new JTextField();
	txt_primary_cam.setBounds(420,185, 150, 25);
	frm.add(txt_primary_cam);
	
	lbl_secondray_cam=new JLabel("FRONT CAMERA");
	lbl_secondray_cam.setBounds(25, 225, 122, 25);
	frm.add(lbl_secondray_cam);
	
	txt_secondray_cam=new JTextField();
	txt_secondray_cam.setBounds(150, 225, 150, 25);
	frm.add(txt_secondray_cam);
	
	lbl_resulation=new JLabel("RESULATION");
	lbl_resulation.setBounds(25, 265, 122, 25);
	frm.add(lbl_resulation);
	
	txt_resulation=new JTextField();
	txt_resulation.setBounds(150, 265, 150, 25);
	frm.add(txt_resulation);
	
	lbl_battery=new JLabel("BATTERY");
	lbl_battery.setBounds(330, 265, 100, 25);
	frm.add(lbl_battery);
	
	txt_battery=new JTextField();
	txt_battery.setBounds(420, 265, 150, 25);
	frm.add(txt_battery);
	
	lbl_nw=new JLabel("NETWROK SUPPORT");
	lbl_nw.setBounds(25, 305, 122, 25);
	frm.add(lbl_nw);
	
	txt_nw=new JTextField();
	txt_nw.setBounds(150, 305, 150, 25);
	frm.add(txt_nw);
	
	lbl_protection=new JLabel("PROTECTION");
	lbl_protection.setBounds(330, 305, 122, 25);
	frm.add(lbl_protection);
	
	txt_protection=new JTextField();
	txt_protection.setBounds(420, 305, 150, 25);
	frm.add(txt_protection);
	
	lbl_screen_size=new JLabel("SCREEN SIZE");
	lbl_screen_size.setBounds(330, 225, 100, 25);
	frm.add(lbl_screen_size);
	
	txt_screen_size=new JTextField();
	txt_screen_size.setBounds(420,225, 150, 25);
	frm.add(txt_screen_size);
	
	lbl_internal_stroge=new JLabel("INTERNAL STORAGE");
	lbl_internal_stroge.setBounds(25, 105, 122, 25);
	frm.add(lbl_internal_stroge);
	
	txt_internal_stroge=new JTextField();
	txt_internal_stroge.setBounds(150, 105, 150, 25);
	frm.add(txt_internal_stroge);
	
	lbl_expandable_upto=new JLabel("EXPANDABLE UPTO");
	lbl_expandable_upto.setBounds(25, 145, 122, 25);
	frm.add(lbl_expandable_upto);
	
	txt_expandable_upto=new JTextField();
	txt_expandable_upto.setBounds(150, 145, 150, 25);
	frm.add(txt_expandable_upto);
	
	btn_src_model_no=new JButton("SEARCH");
	btn_src_model_no.setBounds(220, 350, 150, 40);
	frm.add(btn_src_model_no);
	btn_src_model_no.addActionListener(this);
	
	btn_add_model_no=new JButton("ADD");
	btn_add_model_no.setBounds(25, 350, 150, 40);
	frm.add(btn_add_model_no);
	btn_add_model_no.addActionListener(this);
		
	btn_edit_model_no=new JButton("EDIT");
	btn_edit_model_no.setBounds(420, 350, 150, 40);
	frm.add(btn_edit_model_no);
	btn_edit_model_no.addActionListener(this);
	btn_edit_model_no.setEnabled(false);
	frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frm.setVisible(true);
}
public static void main(String[] args) {
	new FrmAddModelNo();
}
@Override
public void focusGained(FocusEvent e) {
	// TODO Auto-generated method stub
}
@Override
public void focusLost(FocusEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource().equals(btn_add_model_no)&&btn_add_model_no.getText().equals("ADD")){
		Insert_Feature get_brand=new Insert_Feature();
		get_brand.insertfeture(cmb_brand.getSelectedItem().toString(), Integer.parseInt(txt_show_product.getText()), cmb_model_name.getSelectedItem().toString(), Integer.parseInt(txt_amount.getText()), txt_internal_stroge.getText(), txt_os.getText(), txt_expandable_upto.getText(), txt_ram.getText(), txt_processor.getText(), txt_primary_cam.getText(), txt_secondray_cam.getText(), txt_screen_size.getText(), txt_resulation.getText(), txt_battery.getText(), txt_nw.getText(), txt_protection.getText());
		cmb_brand.setSelectedIndex(-1);
		txt_show_product.setText(null);
		cmb_model_name.setSelectedIndex(-1);
		txt_amount.setText(null);
		txt_internal_stroge.setText(null);
		txt_os.setText(null);
		txt_expandable_upto.setText(null);
		txt_ram.setText(null);
		txt_processor.setText(null);
		txt_primary_cam.setText(null);
		txt_secondray_cam.setText(null);
		txt_screen_size.setText(null);
		txt_resulation.setText(null);
		txt_battery.setText(null);
		txt_nw.setText(null);
		txt_protection.setText(null);
	}
		if(btn_add_model_no.getText()=="UPDATE"){
			
			Insert_Feature up=new Insert_Feature();
			up.update_model(Integer.parseInt(txt_amount.getText()), txt_internal_stroge.getText(), txt_os.getText(), txt_expandable_upto.getText(), txt_ram.getText(), txt_processor.getText(), txt_primary_cam.getText(), txt_secondray_cam.getText(), txt_screen_size.getText(), txt_resulation.getText(), txt_battery.getText(), txt_nw.getText(), txt_protection.getText(), cmb_model_name.getSelectedItem().toString());
			//String strup[]=up.update_model(cmb_model_name.getSelectedItem().toString());
			
		}
	if(e.getSource().equals(btn_src_model_no)){
		btn_add_model_no.setText("DELETE");
		btn_edit_model_no.setEnabled(true);
		btn_src_model_no.setEnabled(false);
		cmb_model_name.setEditable(false);
		txt_amount.setEditable(false);
		txt_internal_stroge.setEditable(false);
		txt_os.setEditable(false);
		txt_expandable_upto.setEditable(false);
		txt_ram.setEditable(false);
		txt_processor.setEditable(false);
		txt_primary_cam.setEditable(false);
		txt_secondray_cam.setEditable(false);
		txt_screen_size.setEditable(false);
		txt_resulation.setEditable(false);
		txt_battery.setEditable(false);
		txt_nw.setEditable(false);
		txt_protection.setEditable(false);
		Insert_Feature get_speci=new Insert_Feature();
		String[] strval=get_speci.get_specification(cmb_model_name.getSelectedItem().toString(),(cmb_brand.getSelectedItem().toString()));
		txt_amount.setText(strval[0]);
		txt_internal_stroge.setText(strval[1]);
		txt_os.setText(strval[2]);
		txt_expandable_upto.setText(strval[3]);
		txt_ram.setText(strval[4]);
		txt_processor.setText(strval[5]);
		txt_primary_cam.setText(strval[6]);
		txt_secondray_cam.setText(strval[7]);
		txt_screen_size.setText(strval[8]);
		txt_resulation.setText(strval[9]);
		txt_battery.setText(strval[10]);
		txt_nw.setText(strval[11]);
		txt_protection.setText(strval[12]);
		if(btn_src_model_no.getText()=="SEARCH"){
			btn_add_model_no.setText("DELETE");
			btn_add_model_no.setEnabled(true);
			btn_edit_model_no.setEnabled(true);
		}
	}
			if(e.getSource().equals(btn_edit_model_no)){
				cmb_model_name.setEnabled(false);
				cmb_brand.setEnabled(false);
			btn_add_model_no.setText("UPDATE");
			btn_edit_model_no.setEnabled(false);
			cmb_model_name.setEditable(false);
			txt_amount.setEditable(true);
			txt_internal_stroge.setEditable(true);
			txt_os.setEditable(true);
			txt_expandable_upto.setEditable(true);
			txt_ram.setEditable(true);
			txt_processor.setEditable(true);
			txt_primary_cam.setEditable(true);
			txt_secondray_cam.setEditable(true);
			txt_screen_size.setEditable(true);
			txt_resulation.setEditable(true);
			txt_battery.setEditable(true);
			txt_nw.setEditable(true);
			txt_protection.setEditable(true);
			btn_src_model_no.setText("NEXT");
			btn_src_model_no.setEnabled(true);
		}
		if(e.getSource().equals(btn_add_model_no) && (btn_add_model_no).getText()=="DELETE"){
			btn_add_model_no.setText("ADD");
			btn_edit_model_no.setEnabled(false);
			Insert_Feature delitem=new Insert_Feature();
			//delitem.del_model(cmb_model_name.getSelectedItem().toString());
		}		
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
	
	Insert_Feature ins_rec=new Insert_Feature();
	for(String pname:ins_rec.get_brand_name()){
		cmb_brand.addItem(pname);
		cmb_model_name.removeAllItems();
	}
	cmb_brand.setSelectedIndex(-1);
	cmb_model_name.setSelectedIndex(-1);
	txt_show_product.setText(null);
	cmb_model_name.removeAllItems();
	
}
@Override
public void itemStateChanged(ItemEvent e) {
	// TODO Auto-generated method stub
	if(cmb_brand.getSelectedIndex()!=-1){
		Insert_Feature ser_pro=new Insert_Feature();
		txt_show_product.setText(Integer.toString(ser_pro.get_product_id(cmb_brand.getSelectedItem().toString())));
		 String[] modelname=ser_pro.get_model(cmb_brand.getSelectedItem().toString());
		 int j=modelname.length;
		for(int i=0;i<j;i++){
			cmb_model_name.setSelectedIndex(-1);
			 cmb_model_name.addItem(modelname[i]);
		}
	}
	if((cmb_brand.getSelectedIndex()==-1)){
		btn_src_model_no.setEnabled(false);
		btn_add_model_no.setEnabled(false);
	}else{
		btn_src_model_no.setEnabled(true);
		btn_add_model_no.setEnabled(true);
	}
}
	

}
