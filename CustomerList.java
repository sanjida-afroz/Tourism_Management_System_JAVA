import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CustomerList extends Frame implements ActionListener, WindowListener{
	private JButton a,b,c;
	private TextArea ta;
	private JLabel l,l2,l3,l4,l5,l6;
	public static AddNewCustomer addNewCustomer;
	public static DeleteCustomer deleteCustomer;
	private Frame parent;
	public CustomerList(){
		super("CustomerList");
		l=new JLabel("Customer Id");
		l2=new JLabel("Name");
		l3=new JLabel("Email");
		l4=new JLabel("Gender");
		l5=new JLabel("Mobile No");
		l6=new JLabel("Address");
		addNewCustomer=new AddNewCustomer();
		deleteCustomer=new DeleteCustomer();
		a=new JButton("Add New Customer");
		b=new JButton("Exit");
		c=new JButton("Delete Customer");
		ta=new TextArea(25,100);
		ta.setEditable(false);
		add(ta);add(l);add(l2);add(l3);
		add(a);add(b);add(c);add(l4);add(l5);
		add(l6);
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		addWindowListener(this);
		setLayout(null);
		setSize(800,530);
		setLocation(300,75);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		ta.setBounds(50,70,700,300);
		l.setBounds(50,30,100,30);
		l2.setBounds(150,30,100,30);
		l3.setBounds(250,30,100,30);
		l4.setBounds(350,30,100,30);
		l5.setBounds(450,30,100,30);
		l6.setBounds(550,30,100,30);
		a.setBounds(100,400,200,30);
		c.setBounds(310,400,200,30);
		b.setBounds(520,400,150,30);
	}
	public void loadData(){
		String sql="select * from customer";
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			String data="";
			while(rs.next()){
				data=data+rs.getString("c_id")+"        ";
				data=data+rs.getString("name")+"        ";
				data=data+rs.getString("email")+"        ";
				data=data+rs.getString("gender")+"        ";
				data=data+rs.getString("mobile_No")+"       ";
				data=data+rs.getString("address")+"\n\n";
			}
			ta.setText(data);
		}
		catch(Exception ex){
			System.out.println("Exception in CustomerList");
		}
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){
		String sig=e.getActionCommand();
		if(sig.equals("Add New Customer")){
			addNewCustomer.setVisible(true);
			addNewCustomer.setParent(this);
		}
		else if(sig.equals("Delete Customer")){
			deleteCustomer.setVisible(true);
			deleteCustomer.setParent(this);
		}
		else if(sig.equals("Exit")){
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