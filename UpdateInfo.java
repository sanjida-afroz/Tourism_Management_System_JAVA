import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateInfo extends Frame implements ActionListener, WindowListener{
	private JButton b,b2,b3,b4,b5,b6,b7;
	public static UpdateName un;
	public static UpdateEmail ue;
	public static UpdatePass up;
	public static UpdateMob um;
	public static UpdateAdds ua;
	public static UpdateGender ug;
	private Frame parent;
	public UpdateInfo(){
		super("UpdateInfo");
		un=new UpdateName();
		ue=new UpdateEmail();
		up=new UpdatePass();
		um=new UpdateMob();
		ua=new UpdateAdds();
		ug=new UpdateGender();
		b=new JButton("Name");
		b2=new JButton("Email");
		b3=new JButton("Password");
		b4=new JButton("Mobile.No");
		b5=new JButton("Address");
		b6=new JButton("Gender");
		b7=new JButton("Exit");
		add(b);add(b2);add(b5);
		add(b3);add(b4);add(b6);add(b7);
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		setLayout(null);
		setSize(300,450);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		b.setBounds(75,50,150,30);
		b2.setBounds(75,100,150,30);
		b3.setBounds(75,150,150,30);
		b4.setBounds(75,200,150,30);
		b5.setBounds(75,250,150,30);
		b6.setBounds(75,300,150,30);
		b7.setBounds(100,370,100,30);
		addWindowListener(this);
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Name")){
			un.setVisible(true);
			un.setParent(this);
		}
		else if(sig.equals("Email")){
			ue.setVisible(true);
			ue.setParent(this);
		}
		else if(sig.equals("Password")){
			up.setVisible(true);
			up.setParent(this);
		}
		else if(sig.equals("Mobile.No")){
			um.setVisible(true);
			um.setParent(this);
		}
		else if(sig.equals("Address")){
			ua.setVisible(true);
			ua.setParent(this);
		}
		else if(sig.equals("Gender")){
			ug.setVisible(true);
			ug.setParent(this);
		}
		else if(sig.equals("Exit")){
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