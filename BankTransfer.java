import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BankTransfer extends Frame implements ActionListener, WindowListener{
	private TextField c_id,port,accnum,Tamount,pay,pass;
	private JRadioButton jRadioButton, jRadioButton2;
	private ButtonGroup g;
	private JButton payButton,cancelButton;
	private JLabel l,l2,l3,l4,l5,l6,l7;
	public Frame parent;
	public BankTransfer(){
		super("BankTransfer");
		l=new JLabel("Customer Id");
		c_id=new TextField();
		l2=new JLabel("Account No:");
		accnum=new TextField();
		jRadioButton = new JRadioButton();
		jRadioButton2 = new JRadioButton();
		jRadioButton.setText("Tour");
		jRadioButton2.setText("Ticket");
		l4=new JLabel("P or T id:");
		port=new TextField();
		l5=new JLabel("Total amount:");
		Tamount=new TextField();
		l6=new JLabel("Pay amount:");
		pay=new TextField();
		l7=new JLabel("Password:");
		pass=new TextField();
		pass.setEchoChar('*');
		payButton=new JButton("Pay");
		cancelButton=new JButton("Cancel");
		g=new ButtonGroup();
		add(l);add(c_id);add(accnum);add(l4);
		add(l2);add(port);add(Tamount);add(pay);add(l5);
		add(payButton);add(cancelButton);add(l6);add(pass);
		add(jRadioButton);add(jRadioButton2);add(l7);
		g.add(jRadioButton);
		g.add(jRadioButton2);
		l.setBounds(20,60,70,30);
		c_id.setBounds(135,60,207,30);
		l2.setBounds(20,95,70,30);
		accnum.setBounds(135,95,207,30);
		jRadioButton.setBounds(135,130,100,30);
		jRadioButton2.setBounds(242,130,100,30);
		l4.setBounds(20,165,70,30);
		port.setBounds(135,165,207,30);
		l5.setBounds(20,200,100,30);
		Tamount.setBounds(135,200,207,30);
		l6.setBounds(20,235,100,30);
		pay.setBounds(135,235,207,30);
		l7.setBounds(20,270,100,30);
		pass.setBounds(135,270,207,30);
		payButton.setBounds(135,305,100,30);
		cancelButton.setBounds(250,305,100,30);
		payButton.addActionListener(this);
		cancelButton.addActionListener(this);
		setLayout(null);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		setSize(500,500);
		addWindowListener(this);
	}
	public void setParent(Frame f){
		parent=f;
	}
	private boolean isEmpty(TextField s){
		boolean flag=false;
		if(s.getText().length()==0)flag=true;
		return flag;
	}
	private boolean checkAuth(){
		boolean flag=false;
		String n=c_id.getText();
		String p=pass.getText();
		String sql="select * from customer where c_id='"+n+"' and password='"+p+"'";
		System.out.println(sql);
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			while(rs.next()){
					flag=true;
			}
		}
		catch(Exception ex){
			System.out.println("Exception occurred");
		}
		return flag;
	}
	private boolean checkBooking(){
		boolean flag=false;
		String n=c_id.getText();
		String p=pass.getText();
		String sql9="select * from booking where booking.c_id= (select c_id from customer where password='"+p+"')";
		System.out.println(sql9);
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql9);
			while(rs.next()){
					flag=true;
			}
		}
		catch(Exception ex){
			System.out.println("Exception occurred");
		}
		return flag;
	}
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		String ta=Tamount.getText();
		String pa=pay.getText();
		int t = Integer.valueOf(ta);
		int p = Integer.valueOf(pa); 
		int due=t-p;
		if(sig.equals("Pay")){
			if(isEmpty(c_id) || isEmpty(accnum) || isEmpty(port) || isEmpty(Tamount) || isEmpty(pay)){
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else{
				if(checkAuth() && checkBooking()){
					if(jRadioButton.isSelected()){
						DataAccess da=new DataAccess();
						try{
							String sql="insert into payment(c_id,package_id,total_amount,paid,due) values('"+c_id.getText()+"','"+port.getText()+"','"+Tamount.getText()+"','"+pay.getText()+"','"+due+"')";
							if(da.updateDB(sql) > 0 ){
								JOptionPane.showMessageDialog(this,"Payment Complete!");
							}
							else{
								JOptionPane.showMessageDialog(this,"Error!");
							}
							System.out.println(sql);
						}
						catch(Exception ex){
							JOptionPane.showMessageDialog(this,"Error!");
						}
					}
					else if(jRadioButton2.isSelected()){
						DataAccess da=new DataAccess();
						try{
							String sql3="insert into payment(c_id,ticket_id,total_amount,paid,due) values('"+c_id.getText()+"','"+port.getText()+"','"+Tamount.getText()+"','"+pay.getText()+"','"+due+"')";
							if(da.updateDB(sql3) > 0 ){
								JOptionPane.showMessageDialog(this,"Payment Complete!");
							}
							else{
								JOptionPane.showMessageDialog(this,"Error!");
							}
							System.out.println(sql3);
						}
						catch(Exception ex){
							JOptionPane.showMessageDialog(this,"Error!");
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(this,"Error! Check you id or password");
				}
			}
		}
		else if(sig.equals("Cancel")){
			parent.setVisible(true);
			this.setVisible(false);
		}
	}
	public void windowActivated(WindowEvent e){}
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