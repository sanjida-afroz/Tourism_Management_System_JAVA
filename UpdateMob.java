import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateMob extends Frame implements ActionListener, WindowListener{
	private JButton b,b2;
	private TextField t,t3;
	private JLabel l,l3;
	private Frame parent;
	public UpdateMob(){
		super("Update Mobile No");
		l=new JLabel("MobIle No");
		l3=new JLabel("Password");
		t=new TextField();
		t3=new TextField();
		t3.setEchoChar('*');
		b=new JButton("Change");
		b2=new JButton("Cancel");
		add(b);add(b2);
		add(l);add(l3);
		add(t);add(t3);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);
		setSize(400,400);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(20,50,100,30);
		l3.setBounds(20,100,100,30);
		t.setBounds(140,50,200,30);
		t3.setBounds(140,100,200,30);
		b.setBounds(140,160,95,30);
		b2.setBounds(240,160,95,30);
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
		String p=t3.getText();
		String sql2="select * from customer where password='"+p+"'";
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
	private boolean isValidMobileNo(TextField v){
		boolean flag=true;
		String n=v.getText().substring(0,5);
		String p=v.getText().substring(0,2);
		if(n.equals("+8801")){
			if(v.getText().length()==14){
				flag=true;
			}
			else{
				flag=false;
			}
		}
		else if(p.equals("01")){
			if(v.getText().length()==11){
				flag=true;
			}
			else{
				flag=false;
			}
		}
		else{
			flag=false;
		}
		return flag;
	}
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Change")){
			if(isEmpty(t) || isEmpty(t3)){
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else{
				if(checkAuth()){
					if(isValidMobileNo(t)){
						DataAccess da=new DataAccess();
						try{
							String sql="update customer set mobile_no='"+t.getText()+"' where password='"+t3.getText()+"'";
							if(da.updateDB(sql) > 0){
								JOptionPane.showMessageDialog(this,"Updated!");
							}
							else{
								JOptionPane.showMessageDialog(this,"Error!");
							}
							System.out.println(sql);
						}
						catch(Exception ex){
							JOptionPane.showMessageDialog(this,"Exception in Mobile No Update");
						}
					}
					else{
						JOptionPane.showMessageDialog(this,"Invalid Mobile No");
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