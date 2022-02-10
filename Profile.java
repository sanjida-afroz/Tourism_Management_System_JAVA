import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Profile extends Frame implements ActionListener, WindowListener{
	private JButton exitButton,upButton;
	private TextArea ta;
	private Frame parent;
	public static UpdateInfo ui;
	public Profile(){
		super("Profile");
		ui=new UpdateInfo();
		upButton=new JButton("Update Info");
		exitButton=new JButton("Exit");
		ta=new TextArea();
		ta.setEditable(false);
		add(ta);
		add(upButton);add(exitButton);
		exitButton.addActionListener(this);
		upButton.addActionListener(this);
		addWindowListener(this);
		setLayout(null);
		setSize(800,300);
		setLocation(300,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		ta.setBounds(50,50,700,60);
		upButton.setBounds(100,200,200,30);
		exitButton.setBounds(310,200,100,30);
	}
	public void loadData(){
		String input= JOptionPane.showInputDialog("Enter Your Password");
		if(input.length() > 0){
			String sql="select * from customer where password='"+input+"'";
			try{
				DataAccess da=new DataAccess();
				ResultSet rs=da.getData(sql);
				String data="";
				while(rs.next()){
					data=data+rs.getString("c_id")+"   			    ";
					data=data+rs.getString("name")+"   			    ";
					data=data+rs.getString("email")+"  			     ";
					data=data+rs.getString("gender")+"  			     ";
					data=data+rs.getString("mobile_No")+"  			     ";
					data=data+rs.getString("address")+"   			    ";
					data=data+rs.getString("password")+"\n";
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
		if(sig.equals("Update Info")){
			ui.setVisible(true);
			ui.setParent(this);
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