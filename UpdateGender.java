import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateGender extends Frame implements ActionListener, WindowListener{
	private JButton b,b2;
	private TextField t3;
	private JRadioButton jRadioButton, jRadioButton2;
	private ButtonGroup g;
	private JLabel l,l3;
	private Frame parent;
	public UpdateGender(){
		super("Update Gender");
		l=new JLabel("Gender");
		l3=new JLabel("Password");
		t3=new TextField();
		t3.setEchoChar('*');
		b=new JButton("Change");
		b2=new JButton("Cancel");
		jRadioButton = new JRadioButton();
		jRadioButton2 = new JRadioButton();
		jRadioButton.setText("Male");
		jRadioButton2.setText("Female");
		add(b);add(b2);
		add(l);add(l3);add(t3);
		add(jRadioButton);add(jRadioButton2);
		g=new ButtonGroup();
		g.add(jRadioButton);
		g.add(jRadioButton2);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);
		setSize(400,400);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(20,50,100,30);
		l3.setBounds(20,100,100,30);
		jRadioButton.setBounds(140,50,95,30);
		jRadioButton2.setBounds(245,50,95,30);
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
		String sql7="select * from customer where password='"+p+"'";
		System.out.println(sql7);
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql7);
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
		if(sig.equals("Change")){
			if(isEmpty(t3)){
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else{
				if(checkAuth()){
				DataAccess da=new DataAccess();
				if(jRadioButton.isSelected()){
					try{
						String sql="UPDATE customer SET gender = 'Male' WHERE password = '"+t3.getText()+"'";
						if(da.updateDB(sql) > 0){
							JOptionPane.showMessageDialog(this,"Updated!");
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
				else if(jRadioButton.isSelected()){
					try{
						String sql2="UPDATE customer SET gender = 'Female' WHERE password = '"+t3.getText()+"'";
						if(da.updateDB(sql2) > 0){
							JOptionPane.showMessageDialog(this,"Updated!");
						}
						else{
							JOptionPane.showMessageDialog(this,"Error!");
						}
						System.out.println(sql2);
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(this,"Exception in Gender Update");
					}
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