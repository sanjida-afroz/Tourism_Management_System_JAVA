import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Customer extends Frame implements ActionListener, WindowListener{
	private JButton b,b2,b3,b4,b5,b6;
	public static CTPackages ctp;
	public static CTickets cTickets;
	public static Profile profile;
	public static ShowPay shp;
	public static Booking bok;
	private Frame parent;
	public Customer(){
		super("Customer");
		ctp=new CTPackages();
		bok=new Booking();
		cTickets=new CTickets();
		profile=new Profile();
		shp=new ShowPay();
		b=new JButton("Tour");
		b2=new JButton("Tickets");
		b3=new JButton("Log out");
		b4=new JButton("Profile");
		b5=new JButton("Pay Stat");
		b6=new JButton("Bookings");
		addWindowListener(this);
		add(b);add(b2);add(b6);
		add(b3);add(b4);add(b5);
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		setLayout(null);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		setSize(400,500);
		b.setBounds(112,95,175,30);
		b2.setBounds(112,145,175,30);
		b5.setBounds(112,195,175,30);
		b6.setBounds(112,245,175,30);
		b3.setBounds(149,320,100,30);
		b4.setBounds(149,50,100,30);
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Tour")){
			this.setVisible(false);
			ctp.loadData();
			ctp.setVisible(true);
			ctp.setParent(this);
		}
		else if(sig.equals("Tickets")){
			this.setVisible(false);
			cTickets.setVisible(true);
			cTickets.setParent(this);
		}
		else if(sig.equals("Profile")){
			profile.loadData();
			this.setVisible(false);
			profile.setVisible(true);
			profile.setParent(this);
		}
		else if(sig.equals("Pay Stat")){
			shp.loadData();
			this.setVisible(false);
			shp.setVisible(true);
			shp.setParent(this);
		}
		else if(sig.equals("Bookings")){
			bok.loadData();
			this.setVisible(false);			
			bok.setVisible(true);
			bok.setParent(this);
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