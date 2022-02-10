import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CTickets extends Frame implements ActionListener, WindowListener{
	private JButton b,b3;
	public static TextField r,r2,r3;
	private JLabel l,l2,l3;
	public static ShowTickets sht;
	private Frame parent;
	public CTickets(){
		super("Ticket");
		sht=new ShowTickets();
		l=new JLabel("Select Route");
		r=new TextField();
		l2=new JLabel("From");
		r2=new TextField();
		l3=new JLabel("To");
		r3=new TextField();
		b=new JButton("Show Tickets");
		b3=new JButton("Cancel");
		add(b);add(b3);
		add(l);add(r);
		add(l2);add(r2);
		add(l3);add(r3);
		b.addActionListener(this);
		b3.addActionListener(this);
		setLayout(null);
		setSize(400,400);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(20,50,100,30);
		r.setBounds(150,50,200,30);
		l2.setBounds(20,100,100,30);
		r2.setBounds(150,100,200,30);
		l3.setBounds(20,150,100,30);
		r3.setBounds(150,150,200,30);
		b.setBounds(170,210,160,30);
		b3.setBounds(200,260,100,30);
		addWindowListener(this);
	}
	public void setParent(Frame f){
		parent=f;
	}
	
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Show Tickets")){
			this.setVisible(false);
			sht.loadData();
			sht.setVisible(true);
			sht.setParent(this);
		}
		else if(sig.equals("Cancel")){
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