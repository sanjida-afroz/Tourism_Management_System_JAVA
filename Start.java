import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Start extends Frame implements ActionListener, WindowListener{
	private JButton signupButton,loginButton;
	private JLabel l,l2;
	public static Login log;
	public static Signup sup;
	public Frame parent;
	public Start(){
		super("Travel & Tourism Management System");
		log=new Login();
		sup=new Signup();
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l=new JLabel("WELCOME!");
		l2=new JLabel(" Do you want to");
		loginButton=new JButton("Login");
		signupButton=new JButton("Signup");
		add(loginButton);add(signupButton);
		add(l);add(l2);
		signupButton.addActionListener(this);
		loginButton.addActionListener(this);
		setLayout(null);
		setSize(400,400);
		setLocation(500,175);
		l.setBounds(162,75,150,80);
		l2.setBounds(149,125,150,50);
		loginButton.setBounds(67,175,125,30);
		signupButton.setBounds(197,175,125,30);
		addWindowListener(this);
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){
		String sig=e.getActionCommand();
		if(sig.equals("Signup")){
			this.setVisible(false);
			sup.setVisible(true);
			sup.setParent(this);
		}
		else if(sig.equals("Login")){
			this.setVisible(false);
			log.setVisible(true);
			log.setParent(this);
		}
	}
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
}