import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Route extends Frame implements ActionListener, WindowListener{
	private JButton exitButton;
	private TextArea ta;
	private JLabel l,l2;
	private Frame parent;
	public Route(){
		super("Routes");
		l=new JLabel("Route Id");
		l2=new JLabel("Type");
		exitButton=new JButton("Exit");
		ta=new TextArea();
		ta.setEditable(false);
		add(ta);add(exitButton);add(l);add(l2);
		exitButton.addActionListener(this);
		addWindowListener(this);
		setLayout(null);
		setSize(800,300);
		setLocation(300,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		ta.setBounds(50,70,700,100);
		l.setBounds(50,30,100,30);
		l2.setBounds(170,30,100,30);
		exitButton.setBounds(310,200,100,30);
	}
	public void loadData(){
		String sql="select * from route";
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			String data="";
			while(rs.next()){
				data=data+rs.getString("route_id")+"  		     ";
				data=data+rs.getString("type")+"\n";
			}
			ta.setText(data);
		}
		catch(Exception ex){
			System.out.println("Exception Tour Package:");
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