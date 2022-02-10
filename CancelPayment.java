import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CancelPayment extends Frame implements ActionListener, WindowListener{
	private JButton b,b2;
	private TextField t,t3;
	private JLabel l,l3;
	private Frame parent;
	public CancelPayment(){
		super("Cancel Payment");
		l=new JLabel("Pay Id");
		l3=new JLabel("Password");
		t=new TextField();
		t3=new TextField();
		t3.setEchoChar('*');
		b=new JButton("Ok");
		b2=new JButton("Cancel");
		add(b);add(b2);
		add(l);add(l3);
		add(t);add(t3);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);
		setSize(400,400);
		setLocation(500,175);
		addWindowListener(this);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(20,50,100,30);
		l3.setBounds(20,100,100,30);
		t.setBounds(140,50,200,30);
		t3.setBounds(140,100,200,30);
		b.setBounds(140,160,95,30);
		b2.setBounds(240,160,95,30);
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
		String p=t3.getText();
		String sql3="select * from admin where password='"+p+"'";
		System.out.println(sql3);
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql3);
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
		if(sig.equals("Ok")){
			if(isEmpty(t) || isEmpty(t3)){
				JOptionPane.showMessageDialog(this,"All fields are mendatory!");
			}
			else{
				DataAccess da=new DataAccess();
				if(!checkAdminAuth()){
					try{
					String sql="DELETE FROM payment WHERE payment.pay_id = '"+t.getText()+"' && c_id = (select c_id from customer where password = '"+t3.getText()+"')";
						if(da.updateDB(sql) > 0){
							JOptionPane.showMessageDialog(this,"Payment canceld!");
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
				else if(checkAdminAuth()){
					try{
					String sql2="DELETE FROM payment WHERE payment.pay_id = '"+t.getText()+"'";
						if(da.updateDB(sql2) > 0){
							JOptionPane.showMessageDialog(this,"Payment canceld!");
						}
						else{
							JOptionPane.showMessageDialog(this,"Error!");
						}
					System.out.println(sql2);
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(this,"Error!");
					}
				}
			}
		}
		if(sig.equals("Cancel")){
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