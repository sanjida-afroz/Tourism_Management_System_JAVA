import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Booking extends Frame implements ActionListener, WindowListener{
	private JButton mpButton,exitButton,dbButton;
	private TextArea ta;
	private Frame parent;
	private JLabel l,l2,l3,l4;
	public static PaymentOption po;
	public static DeleteBooking dbo;
	public Booking(){
		super("Bookings");
		po=new PaymentOption();
		dbo=new DeleteBooking();
		l=new JLabel("Booking Id");
		l2=new JLabel("Customer Id");
		l3=new JLabel("Package Id");
		l4=new JLabel("Ticket Id");
		mpButton=new JButton("Make Payment");
		dbButton=new JButton("Delete Booking");
		exitButton=new JButton("Exit");
		ta=new TextArea();
		ta.setEditable(false);
		add(ta);add(dbButton);add(l);
		add(mpButton);add(exitButton);
		add(l2);add(l3);add(l4);
		exitButton.addActionListener(this);
		mpButton.addActionListener(this);
		dbButton.addActionListener(this);
		addWindowListener(this);
		setLayout(null);
		setSize(800,300);
		setLocation(300,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		ta.setBounds(50,70,700,100);
		l.setBounds(50,30,100,30);
		l2.setBounds(150,30,100,30);
		l3.setBounds(250,30,100,30);
		l4.setBounds(350,30,100,30);
		mpButton.setBounds(100,200,200,30);
		dbButton.setBounds(320,200,200,30);
		exitButton.setBounds(540,200,100,30);
	}
	public void loadData(){
		String input= JOptionPane.showInputDialog("Enter Your Password");
			String sql="select * from booking where booking.c_id=(select c_id from customer where password = '"+input+"')";
			try{
				DataAccess da=new DataAccess();
				ResultSet rs=da.getData(sql);
				String data="";
				while(rs.next()){
					data=data+rs.getString("booking_id")+"       ";
					data=data+rs.getString("c_id")+"       ";
					data=data+rs.getString("package_id")+"       ";
					data=data+rs.getString("ticket_id")+"\n";
				}
				ta.setText(data);
			}
			catch(Exception ex){
				System.out.println("Error!");
			}
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){
		String sig=e.getActionCommand();
		if(sig.equals("Make Payment")){
			this.setVisible(false);
			po.setVisible(true);
			po.setParent(this);
		}
		else if(sig.equals("Delete Booking")){
			this.setVisible(false);
			dbo.setVisible(true);
			dbo.setParent(this);
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