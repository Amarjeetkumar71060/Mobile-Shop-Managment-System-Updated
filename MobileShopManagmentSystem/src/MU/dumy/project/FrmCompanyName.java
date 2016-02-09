package MU.dumy.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.Writer;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.Text;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

import oracle.sql.ConverterArchive;

public class FrmCompanyName implements ActionListener,FocusListener,MouseListener,WindowListener,TextListener {
	JFrame frm;
	JLabel lbl_name_brand,lbl_product_id;
	JTextField txt_name_brand, txt_product_id;
	JButton btnAdd,btnEdit,btnsrc;
	boolean flag;
	public FrmCompanyName() {
		// TODO Auto-generated constructor stub
		frm=new JFrame();
		frm.setTitle("BRAND");
		frm.setSize(300, 180);
		frm.setLocation(300, 150);
		frm.setLayout(null);
		frm.setResizable(false);
		frm.addWindowListener(this);


		lbl_product_id=new JLabel("PRODUCT ID");
		lbl_product_id.setBounds(10, 10, 80, 30);
		frm.add(lbl_product_id);

		txt_product_id=new JTextField();
		txt_product_id.setBounds(150, 10, 120, 30);
		frm.add(txt_product_id);
		txt_product_id.setEditable(false);
		txt_product_id.addFocusListener(this);


		lbl_name_brand=new JLabel("BRAND NAME");
		lbl_name_brand.setBounds(10, 60, 100, 30);
		frm.add(lbl_name_brand);

		txt_name_brand=new JTextField();
		txt_name_brand.setBounds(150, 60, 120, 30);
		frm.add(txt_name_brand);
		txt_name_brand.addFocusListener(this);

		btnsrc=new JButton("SRC");
		btnsrc.setBounds(108, 100, 80, 40);
		frm.add(btnsrc);
		btnsrc.addMouseListener(this);

		btnAdd=new JButton("ADD");
		btnAdd.setBounds(10, 100, 80, 40);
		frm.add(btnAdd);
		btnAdd.addActionListener(this);

		btnEdit=new JButton("EDIT");
		btnEdit.setBounds(205, 100, 80, 40);
		frm.add(btnEdit);
		btnEdit.setEnabled(false);
		btnEdit.addMouseListener(this);
		btnEdit.addActionListener(this);
		frm.setVisible(true);
	}
	public static void main(String[] args) {
		new FrmCompanyName();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int pid=0;int str=0;
		if(e.getSource().equals(btnAdd)){
			if(btnAdd.getText()=="ADD"){
				company_Add ca=new company_Add();
				//if(txt_name_brand.getText().equals(null)){
					if(ca.validate_brand_name(txt_name_brand.getText())){
						if(ca.insert(Integer.parseInt(txt_product_id.getText().toString()),txt_name_brand.getText())==1){
							txt_name_brand.grabFocus();
							str=pid+=(Integer.parseInt(txt_product_id.getText()))+1;
							txt_product_id.setText(Integer.toString(pid));
							txt_name_brand.grabFocus();
							JOptionPane.showMessageDialog(null, "Records Inserted");
							txt_name_brand.setText(null);
						} if(btnAdd.getText()=="DELETE"){
							btnAdd.setText("DELETE");	
							btnAdd.setEnabled(true);	
						} 

					}
					else{
						JOptionPane.showMessageDialog(null, "This Brand all ready Eixst");	
						txt_name_brand.setText(null);
					}
					
				}
				//else{
					//JOptionPane.showMessageDialog(null, "Enter Brand Name");	

				//}
			}		
			if(e.getSource()==btnEdit){
				btnEdit.setEnabled(false);
				btnAdd.setText("UPDATE");
				btnsrc.setText("SRC");
				btnAdd.setEnabled(true);
				txt_product_id.setEditable(false);
				txt_name_brand.setEditable(true);
			} else if(btnAdd.getText()=="UPDATE"){
				company_Add ca=new company_Add();
				ca.update(txt_product_id.getText(),txt_name_brand.getText());
				txt_product_id.setEditable(false);;
				txt_name_brand.setText(null);
				btnAdd.setEnabled(true);
				btnsrc.setEnabled(true);
				btnAdd.setText("ADD");
				btnsrc.setText("SRC");
				company_Add ac=new company_Add();
				txt_product_id.setText(Integer.toString(ac.gen_Product_Id()));
			}else if(btnAdd.getText()=="ADD"){
				str+=(Integer.parseInt(txt_product_id.getText()))+1;
				btnAdd.setText("ADD");
				
			} 
			if(btnAdd.getText()==("DELETE")){
				company_Add de=new company_Add();
				de.del(txt_product_id.getText());
				txt_product_id.setEditable(false);
				txt_product_id.setText(null);
				txt_name_brand.setText(null);
				btnsrc.setEnabled(true);
				btnEdit.setEnabled(false);
				btnAdd.setText("ADD");
				btnAdd.setEnabled(true);
				txt_name_brand.setEditable(true);
			
			}/*else {
				btnAdd.setEnabled(true);	
				str+=(Integer.parseInt(txt_product_id.getText()))+1;
				btnsrc.setEnabled(true);
			}	*/
	}


	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource()==txt_product_id){
			company_Add ca=new company_Add();
			txt_name_brand.setText(ca.search(txt_product_id.getText()));

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==btnsrc){
			txt_product_id.setEditable(true);
			txt_product_id.setText(null);
			txt_name_brand.grabFocus();
			txt_name_brand.setEditable(false);
			btnEdit.setEnabled(true);
			btnAdd.setEnabled(true);
			btnAdd.setText("DELETE");
			btnEdit.setText("EDIT");
			btnsrc.setEnabled(false);

		}		
		if(e.getSource()==btnAdd){
			btnAdd.setText("UPDATE");
			btnEdit.setEnabled(false);
			txt_name_brand.setEditable(true);
			txt_product_id.setEditable(false);
			txt_name_brand.grabFocus();

		}
		/* if(e.getSource()==btnEdit){
			 btnEdit.setEnabled(false);
			 btnAdd.setText("UPDATE");
			 btnsrc.setText("BACK");
			 btnAdd.setEnabled(true);
			 txt_product_id.setEditable(false);
			 txt_name_brand.setEditable(true);
      		 }*/
	}
	@Override
	public void mousePressed(MouseEvent e) {	}
	@Override
	public void mouseReleased(MouseEvent e) {		
	}
	@Override
	public void mouseEntered(MouseEvent e) {	
	}
	@Override
	public void mouseExited(MouseEvent e) {		
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
		company_Add ca=new company_Add();
		txt_product_id.setText(Integer.toString(ca.gen_Product_Id()));
	}
	
	@Override
	public void textValueChanged(TextEvent e) {
		// TODO Auto-generated method stub
		if(txt_product_id!=null){
			company_Add src=new company_Add();
			txt_name_brand.setText(src.search(txt_product_id.getText()));
		}
	}
	
}
