import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ShowTickets extends Frame implements ActionListener, WindowListener{
	private JButton exitButton,seButton;
	private JLabel l,l2,l3,l4,l5;
	private TextArea ta;
	private Frame parent;
	public static SelTicket st;
	public static CTickets ct=new CTickets();
	public ShowTickets(){
		super("Show Tickets");
		st=new SelTicket();
		l=new JLabel("Ticket Id");
		l2=new JLabel("From");
		l3=new JLabel("To");
		l4=new JLabel("Fare");
		l5=new JLabel("Departure Time");
		seButton=new JButton("Select Ticket");
		exitButton=new JButton("Exit");
		ta=new TextArea();
		ta.setEditable(false);
		add(ta);add(l);add(l2);
		add(l3);add(l4);add(l5);
		add(seButton);add(exitButton);
		exitButton.addActionListener(this);
		seButton.addActionListener(this);
		addWindowListener(this);
		setLayout(null);
		setSize(800,300);
		setLocation(300,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(50,30,70,30);
		l2.setBounds(130,30,50,30);
		l3.setBounds(190,30,50,30);
		l4.setBounds(250,30,50,30);
		l5.setBounds(310,30,100,30);
		ta.setBounds(50,60,700,100);
		seButton.setBounds(100,200,200,30);
		exitButton.setBounds(310,200,100,30);
	}
	public void loadData(){
			String sql="select * from ticket where route_id = (select route_id from route where type = '"+ct.r.getText()+"') && departure_from = '"+ct.r2.getText()+"' && destination = '"+ct.r3.getText()+"'";
			try{
				DataAccess da=new DataAccess();
				ResultSet rs=da.getData(sql);
				String data="";
				while(rs.next()){
					data=data+rs.getString("ticket_id")+"       ";
					data=data+rs.getString("departure_from")+"       ";
					data=data+rs.getString("destination")+"       ";
					data=data+rs.getString("fare")+"       ";
					data=data+rs.getString("departure_time")+"n";
				}
				ta.setText(data);
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(this,"Exception in Show Tickets:");
			}
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){
		String sig=e.getActionCommand();
		if(sig.equals("Select Ticket")){
			st.setVisible(true);
			st.setParent(this);
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