import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends Frame implements ActionListener, WindowListener{
	private TextField email,pass;
	private JButton b,b2;
	private JLabel l,l2;
	public static Customer customer;
	public static Admin admin;
	private Frame parent;
	public Login(){
		super("Login");
		customer=new Customer();
		admin=new Admin();
		l=new JLabel("Email");
		l2=new JLabel("Password");
		email=new TextField();
		pass=new TextField();
		pass.setEchoChar('*');
		b=new JButton("Login");
		b2=new JButton("Go Back");
		add(l);add(email);
		add(l2);add(pass);
		add(b);add(b2);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);
		setSize(500,300);
		setLocation(460,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(50,50,125,25);
		l2.setBounds(50,100,125,25);
		addWindowListener(this);
		email.setBounds(200,50,250,25);
		pass.setBounds(200,100,250,25);
		b.setBounds(220,140,90,30);
		b2.setBounds(345,140,90,30);
	}
	public void setParent(Frame f){
		parent=f;
	}
	private boolean isEmpty(TextField s){
		boolean flag=false;
		if(s.getText().length()==0)flag=true;
		return flag;
	}
	private boolean checkAdminAuth(){
		boolean flag=false;
		String n=email.getText();
		String p=pass.getText();
		String sql="select * from admin where email='"+n+"' and password='"+p+"'";
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
	private boolean checCustomerkAuth(){
		boolean flag=false;
		String n2=email.getText();
		String p2=pass.getText();
		String sql2="select * from customer where email='"+n2+"' and password='"+p2+"'";
		System.out.println(sql2);
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql2);
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
		String sig=e.getActionCommand();
		if(sig.equals("Login")){
			if(!isEmpty(email) && !isEmpty(pass)){
				if(checkAdminAuth()){
					this.setVisible(false);
					admin.setVisible(true);
					admin.setParent(this);
				}
				else if(checCustomerkAuth()){
					this.setVisible(false);
					customer.setVisible(true);
					customer.setParent(this);
				}
				else{
					JOptionPane.showMessageDialog(this,"Login Error!");
				}
			}
			else if(isEmpty(email) && !isEmpty(pass)){
				JOptionPane.showMessageDialog(this,"Please enter your email!");
			}
			else if(isEmpty(pass) && !isEmpty(email)){
				JOptionPane.showMessageDialog(this,"Please enter your password!");
			}
			else if(isEmpty(email) && isEmpty(pass)){
				JOptionPane.showMessageDialog(this,"Please enter your email & password!");
			}
		}
		else if(sig.equals("Go Back")){
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