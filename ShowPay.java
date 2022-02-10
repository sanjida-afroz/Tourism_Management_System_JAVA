import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ShowPay extends Frame implements ActionListener, WindowListener{
	private JButton exitButton,cancelButton;
	private JLabel l,l2,l3,l4,l5,l6,l7;
	private TextArea ta;
	public static CancelPayment cp;
	private Frame parent;
	public ShowPay(){
		super("ShowPay");
		cp=new CancelPayment();
		l=new JLabel("Pay Id");
		l2=new JLabel("Customer Id");
		l3=new JLabel("Package Id");
		l4=new JLabel("Ticket Id");
		l5=new JLabel("Total Amount");
		l6=new JLabel("Paid");
		l7=new JLabel("Due");
		cancelButton=new JButton("Cancel Payment");
		exitButton=new JButton("Exit");
		ta=new TextArea();
		ta.setEditable(false);
		add(ta);add(l);
		add(l2);add(l3);add(l4);
		add(l5);add(l6);add(l7);
		add(exitButton);
		add(cancelButton);
		exitButton.addActionListener(this);
		cancelButton.addActionListener(this);
		addWindowListener(this);
		setLayout(null);
		setSize(850,330);
		setLocation(300,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(50,30,100,30);
		l2.setBounds(150,30,100,30);
		l3.setBounds(250,30,100,30);
		l4.setBounds(350,30,100,30);
		l5.setBounds(450,30,100,30);
		l6.setBounds(550,30,100,30);
		l7.setBounds(650,30,100,30);
		ta.setBounds(50,70,750,100);
		cancelButton.setBounds(290,200,140,30);
		exitButton.setBounds(310,250,100,30);
	}
	public void aloadData(){
		String sql="select * from payment";
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			String data="";
			while(rs.next()){
				data=data+rs.getString("pay_id")+"		";
				data=data+rs.getString("c_id")+"		";
				data=data+rs.getString("package_id")+"		";
				data=data+rs.getString("ticket_id")+"		";
				data=data+rs.getString("total_amount")+"		";
				data=data+rs.getString("paid")+"		";
				data=data+rs.getString("due")+"\n";
			}
				ta.setText(data);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(this,"Error!");
		}
	}
	public void loadData(){
		String input= JOptionPane.showInputDialog("Enter Your password");
		if(input.length() > 0){
			String sql="select * from payment where payment.c_id=(select c_id from customer where password='"+input+"')";
			try{
				DataAccess da=new DataAccess();
				ResultSet rs=da.getData(sql);
				String data="";
				while(rs.next()){
					data=data+rs.getString("pay_id")+"       ";
					data=data+rs.getString("c_id")+"       ";
					data=data+rs.getString("package_id")+"       ";
					data=data+rs.getString("ticket_id")+"       ";
					data=data+rs.getString("total_amount")+"       ";
					data=data+rs.getString("paid")+"       ";
					data=data+rs.getString("due")+"\n";
				}
				ta.setText(data);
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(this,"Error!");
			}
		}
		else{
			JOptionPane.showMessageDialog(this,"Error!");
		}
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){
		String sig=e.getActionCommand();
		if(sig.equals("Cancel Payment")){
			cp.setVisible(true);
			cp.setParent(this);
		}
		if(sig.equals("Exit")){
			this.setVisible(false);
			parent.setVisible(true);
		}
	}
	public void windowActivated(WindowEvent e){	}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		this.setVisible(false);
		parent.setVisible(true);
	}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
}