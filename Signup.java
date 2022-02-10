import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup extends Frame implements ActionListener, WindowListener{
	private TextField name,email,mob,pass,adds,gender;
	private JRadioButton jRadioButton, jRadioButton2;
	private ButtonGroup g;
	private JButton signupButton,cancelButton;
	private JLabel l,l2,l3,l4,l5,l6;
	public Frame parent;
	public Signup(){
		super("Signup");
		l=new JLabel("Name: ");
		name=new TextField();
		l2=new JLabel("Email:");
		email=new TextField();
		l3=new JLabel("Gender:");
		jRadioButton = new JRadioButton();
		jRadioButton2 = new JRadioButton();
		jRadioButton.setText("Male");
		jRadioButton2.setText("Female");
		l4=new JLabel("Mobile No:");
		mob=new TextField();
		l5=new JLabel("Address:");
		adds=new TextField();
		l6=new JLabel("Password:");
		pass=new TextField();
		pass.setEchoChar('*');
		signupButton=new JButton("Signup");
		cancelButton=new JButton("Cancel");
		g=new ButtonGroup();
		add(l);add(name);add(pass);add(l3);add(l4);
		add(l2);add(email);add(mob);add(adds);add(l5);
		add(signupButton);add(cancelButton);add(l6);
		add(jRadioButton);add(jRadioButton2);
		g.add(jRadioButton);
		g.add(jRadioButton2);
		l.setBounds(20,60,50,30);
		name.setBounds(115,60,207,30);
		l2.setBounds(20,95,50,30);
		email.setBounds(115,95,207,30);
		l3.setBounds(20,130,100,30);
		jRadioButton.setBounds(115,130,100,30);
		jRadioButton2.setBounds(222,130,100,30);
		l4.setBounds(20,165,70,30);
		mob.setBounds(115,165,207,30);
		l5.setBounds(20,200,100,30);
		adds.setBounds(115,200,207,30);
		l6.setBounds(20,235,100,30);
		pass.setBounds(115,235,207,30);
		signupButton.setBounds(115,270,100,30);
		cancelButton.setBounds(220,270,100,30);
		signupButton.addActionListener(this);
		cancelButton.addActionListener(this);
		setLayout(null);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		setSize(400,400);
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
	private boolean isValidEmail(String e){
		boolean flag=true;
		int atIdx=e.indexOf("@");
		int dotIdx=e.indexOf(".");
		if(dotIdx<atIdx)flag=false;
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
		String pas=pass.getText();
		if(sig.equals("Signup")){
			if(isEmpty(name) || isEmpty(email) || isEmpty(mob) || isEmpty(adds) || isEmpty(pass)){
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else if(!isValidEmail(email.getText())){
				JOptionPane.showMessageDialog(this,"Invalid Email");
			}
			else if(!isValidMobileNo(mob)){
				JOptionPane.showMessageDialog(this,"Invalid Mobile No");
			}
			else if(pas.length() < 6){
				JOptionPane.showMessageDialog(this,"Length of Password should be atleast 6");
			}
			else{
				DataAccess da=new DataAccess();
				try{
					String sql="insert into customer(name,email,mobile_No,address,password) values('"+name.getText()+"','"+email.getText()+"','"+mob.getText()+"','"+adds.getText()+"','"+pass.getText()+"')";
						if(da.updateDB(sql) > 0){
							JOptionPane.showMessageDialog(this,"Signup Complete!");
						}
						else{
							JOptionPane.showMessageDialog(this,"Signup Error!");
						}
					System.out.println(sql);
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(this,"Signup Error!");
				}
				if(jRadioButton.isSelected()){
					String sql2="UPDATE customer SET gender = 'Male' WHERE email = '"+email.getText()+"'";
					da.updateDB(sql2);
				}
				else if(jRadioButton2.isSelected()){
					String sql2="UPDATE customer SET gender = 'Female' WHERE email = '"+email.getText()+"'";
					da.updateDB(sql2);
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