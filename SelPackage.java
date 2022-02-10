import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SelPackage extends Frame implements ActionListener, WindowListener{
	private JButton b,b2;
	private TextField t,t2,t3;
	private JLabel l,l2,l3;
	private Frame parent;
	public SelPackage(){
		super("Select Package");
		l=new JLabel("Customer Id");
		l2=new JLabel("Password");
		l3=new JLabel("Package Id");
		t=new TextField();
		t2=new TextField();
		t3=new TextField();
		t2.setEchoChar('*');
		b=new JButton("Ok");
		b2=new JButton("Cancel");
		add(b);add(b2);
		add(l);add(l3);
		add(t);add(t3);
		add(l2);add(t2);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);
		setSize(400,400);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(20,50,100,30);
		l3.setBounds(20,100,100,30);
		l2.setBounds(20,150,100,30);
		t.setBounds(140,50,200,30);
		t3.setBounds(140,100,200,30);
		t2.setBounds(140,150,200,30);
		b.setBounds(140,210,95,30);
		b2.setBounds(240,210,95,30);
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
		String c=t.getText();
		String p=t2.getText();
		String sql2="select * from customer where c_id='"+c+"' and password='"+p+"'";
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
		System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Ok")){
			if(isEmpty(t) || isEmpty(t3)){
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else{
				if(checkAuth()){
				DataAccess da=new DataAccess();
				try{
					String sql="insert into booking(c_id,package_id) values('"+t.getText()+"','"+t3.getText()+"')";
						if(da.updateDB(sql) > 0){
							JOptionPane.showMessageDialog(this,"Booking Complete!");
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
				else{
					JOptionPane.showMessageDialog(this,"Error!");
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