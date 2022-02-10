import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Admin extends Frame implements ActionListener, WindowListener{
	private JButton b,b2,b3,b4,b5,b6;
	public static ATour aTour;
	public static ATickets aTickets;
	public static CustomerList customerList;
	public static ShowPay shp;
	public static ABooking bk;
	private Frame parent;
	public Admin(){
		super("Admin");
		aTour=new ATour();
		customerList=new CustomerList();
		aTickets=new ATickets();
		bk=new ABooking();
		shp=new ShowPay();
		b=new JButton("Tour");
		b2=new JButton("Tickets");
		b3=new JButton("Customer List");
		b4=new JButton("Log out");
		b5=new JButton("Pay Stat");
		b6=new JButton("Bookings");
		add(b);add(b2);add(b5);
		add(b3);add(b4);add(b6);
		addWindowListener(this);
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		setLayout(null);
		setSize(300,400);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		b.setBounds(75,50,150,30);
		b2.setBounds(75,100,150,30);
		b3.setBounds(75,150,150,30);
		b5.setBounds(75,200,150,30);
		b6.setBounds(75,250,150,30);
		b4.setBounds(100,310,100,30);
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Tour")){
			this.setVisible(false);
			aTour.setVisible(true);
			aTour.setParent(this);
		}
		else if(sig.equals("Customer List")){
			this.setVisible(false);
			customerList.loadData();
			customerList.setVisible(true);
			customerList.setParent(this);
		}
		else if(sig.equals("Tickets")){
			this.setVisible(false);
			aTickets.setVisible(true);
			aTickets.setParent(this);
		}
		else if(sig.equals("Pay Stat")){
			this.setVisible(false);
			shp.aloadData();
			shp.setVisible(true);
			shp.setParent(this);
		}
		else if(sig.equals("Bookings")){
			this.setVisible(false);
			bk.loadData();
			bk.setVisible(true);
			bk.setParent(this);
		}
		else if(sig.equals("Log out")){
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