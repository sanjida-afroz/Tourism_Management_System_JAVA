import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddTicket extends Frame implements ActionListener, WindowListener{
	private JButton b,b2;
	private TextField t,t2,t3,t4,t5,t6;
	private JLabel l,l2,l3,l4,l5,l6;
	private Frame parent;
	public AddTicket(){
		super("Add Ticket Info");
		l=new JLabel("Ticket Id");
		l2=new JLabel("From");
		l3=new JLabel("Destination");
		l4=new JLabel("Fare");
		l5=new JLabel("Time");
		l6=new JLabel("Route Id");
		t=new TextField();
		t2=new TextField();
		t3=new TextField();
		t4=new TextField();
		t5=new TextField();
		t6=new TextField();
		b=new JButton("Add");
		b2=new JButton("Cancel");
		add(b);add(b2);
		add(l);add(l2);add(l3);add(l4);add(l5);add(l6);
		add(t);add(t2);add(t3);add(t4);add(t5);add(t6);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);
		setSize(400,400);
		setLocation(500,175);
		addWindowListener(this);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(20,50,100,30);
		l2.setBounds(20,100,100,30);
		l3.setBounds(20,150,100,30);
		l4.setBounds(20,200,100,30);
		l5.setBounds(20,250,100,30);
		l6.setBounds(20,300,100,30);
		t.setBounds(140,50,200,30);
		t2.setBounds(140,100,200,30);
		t3.setBounds(140,150,200,30);
		t4.setBounds(140,200,200,30);
		t5.setBounds(140,250,200,30);
		t6.setBounds(140,300,200,30);
		b.setBounds(140,360,70,30);
		b2.setBounds(215,360,120,30);
	}
	public void setParent(Frame f){
		parent=f;
	}
	private boolean isEmpty(TextField s){
		boolean flag=false;
		if(s.getText().length()==0)flag=true;
		return flag;
	}
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Add")){
			if(isEmpty(t) || isEmpty(t2) || isEmpty(t3) || isEmpty(t4)|| isEmpty(t5) || isEmpty(t6)){
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else{
				DataAccess da=new DataAccess();
				try{
					String sql="insert into ticket(ticket_id,departure_from,destination,fare,departure_time,route_id) values('"+t.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"')";
						if(da.updateDB(sql) > 0){
							JOptionPane.showMessageDialog(this,"Added!");
						}
						else{
							JOptionPane.showMessageDialog(this,"Error!");
						}
					System.out.println(sql);
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(this,"Error!");
				}
			}
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