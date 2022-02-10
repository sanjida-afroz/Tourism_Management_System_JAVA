import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ATickets extends Frame implements ActionListener, WindowListener{
	private JButton b,b2,b3,b4,b5,b6,b10;
	public static AddRoute ar;
	public static DeleteRoute dr;
	public static DeleteTicket dt;
	public static AddTicket at;
	public static AllTickets allTicket;
	public static Route route;
	private Frame parent;
	public ATickets(){
		super("Tickets");
		ar=new AddRoute();
		dr=new DeleteRoute();
		at=new AddTicket();
		dt=new DeleteTicket();
		allTicket=new AllTickets();
		route=new Route();
		b=new JButton("All Tickets");
		b2=new JButton("Add new Ticket Info");
		b3=new JButton("Delete Ticket Info");
		b4=new JButton("Routes");
		b5=new JButton("Add new Route");
		b6=new JButton("Delete Route");
		b10=new JButton("Go back");
		addWindowListener(this);
		add(b);add(b2);add(b3);add(b4);add(b5);
		add(b6);add(b10);
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b10.addActionListener(this);
		setLayout(null);
		setSize(450,500);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		b.setBounds(50,50,150,30);
		b2.setBounds(50,110,200,30);
		b3.setBounds(270,110,150,30);
		b4.setBounds(50,170,150,30);
		b5.setBounds(50,230,200,30);
		b6.setBounds(270,230,150,30);	
		b10.setBounds(170,420,100,30);
		
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Add new Ticket Info")){
			at.setVisible(true);
			at.setParent(this);
		}
		else if(sig.equals("All Tickets")){
			allTicket.loadData();
			allTicket.setVisible(true);
			allTicket.setParent(this);
		}
		else if(sig.equals("Delete Ticket Info")){
			dt.setVisible(true);
			dt.setParent(this);
		}
		else if(sig.equals("Add new Route")){
			ar.setVisible(true);
			ar.setParent(this);
		}
		else if(sig.equals("Delete Route")){
			dr.setVisible(true);
			dr.setParent(this);
		}
		else if(sig.equals("Routes")){
			route.loadData();
			route.setVisible(true);
			route.setParent(this);
		}
		else if(sig.equals("Go back")){
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