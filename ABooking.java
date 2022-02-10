import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ABooking extends Frame implements ActionListener, WindowListener{
	private JButton exitButton,dbButton;
	private TextArea ta;
	private JLabel l,l2,l3,l4;
	private Frame parent;
	public static PaymentOption po;
	public static DeleteBooking dbo;
	public ABooking(){
		super("Bookings");
		po=new PaymentOption();
		dbo=new DeleteBooking();
		l=new JLabel("Booking Id");
		l2=new JLabel("Customer Id");
		l3=new JLabel("Package Id");
		l4=new JLabel("Ticket Id");
		dbButton=new JButton("Delete Booking");
		exitButton=new JButton("Exit");
		ta=new TextArea(3,100);
		ta.setEditable(false);
		add(ta);add(dbButton);add(exitButton);
		add(l);add(l2);add(l3);add(l4);
		exitButton.addActionListener(this);
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
		dbButton.setBounds(320,200,200,30);
		exitButton.setBounds(540,200,100,30);
	}
	public void loadData(){
			String sql="select * from booking";
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
				JOptionPane.showMessageDialog(this,"Exception in Show Booking");
			}
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){
		String sig=e.getActionCommand();
		if(sig.equals("Delete Booking")){
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