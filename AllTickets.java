import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AllTickets extends Frame implements ActionListener, WindowListener{
	private JButton exitButton;
	private TextArea ta;
	private JLabel l,l2,l3,l4,l5,l6;
	private Frame parent;
	public AllTickets(){
		super("Tour Packages");
		l=new JLabel("Ticket Id");
		l2=new JLabel("From");
		l3=new JLabel("To");
		l4=new JLabel("Fare");
		l5=new JLabel("Time");
		l6=new JLabel("Route Id");
		exitButton=new JButton("Exit");
		ta=new TextArea(10,100);
		ta.setEditable(false);
		add(ta);add(exitButton);
		add(l);add(l2);add(l3);add(l4);
		add(l5);add(l6);
		exitButton.addActionListener(this);
		addWindowListener(this);
		setLayout(null);
		setSize(800,650);
		setLocation(300,55);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(50,50,100,30);
		l2.setBounds(150,50,100,30);
		l3.setBounds(250,50,100,30);
		l4.setBounds(350,50,100,30);
		l5.setBounds(450,50,100,30);
		l6.setBounds(550,50,100,30);
		ta.setBounds(50,100,700,300);
		exitButton.setBounds(350,520,100,30);
	}
	public void loadData(){
		String sql="select * from ticket";
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			String data="";
			while(rs.next()){
				data=data+rs.getString("ticket_id")+"       ";
				data=data+rs.getString("departure_from")+"       ";
				data=data+rs.getString("destination")+"       ";
				data=data+rs.getString("fare")+"       ";
				data=data+rs.getString("departure_time")+"       ";
				data=data+rs.getString("route_id")+"\n";
			}
			ta.setText(data);
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(this,"Exception Ticket:");
		}
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){
		String sig=e.getActionCommand();
		if(sig.equals("Exit")){
			parent.setVisible(true);
			this.setVisible(false);
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