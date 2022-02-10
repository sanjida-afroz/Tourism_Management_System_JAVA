import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TPackages extends Frame implements ActionListener, WindowListener{
	private JButton exitButton,upButton;
	private TextArea ta;
	private JLabel l,l2,l3;
	public static UpdatePackage up;
	private Frame parent;
	public TPackages(){
		super("Tour Packages");
		up=new UpdatePackage();
		l=new JLabel("Package Id");
		l2=new JLabel("Package Des");
		l3=new JLabel("Cost");
		exitButton=new JButton("Exit");
		upButton=new JButton("Update");
		ta=new TextArea(10,100);
		ta.setEditable(false);
		add(ta);add(exitButton);add(upButton);
		add(l);add(l2);add(l3);
		exitButton.addActionListener(this);
		upButton.addActionListener(this);
		addWindowListener(this);
		setLayout(null);
		setSize(800,650);
		setLocation(300,55);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(50,50,100,30);
		l2.setBounds(150,50,100,30);
		l3.setBounds(250,50,100,30);
		ta.setBounds(50,100,700,300);
		upButton.setBounds(300,450,200,30);
		exitButton.setBounds(350,520,100,30);
	}
	public void loadData(){
		String sql="select * from tour_package";
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			String data="";
			while(rs.next()){
				data=data+rs.getString("package_id")+"       ";
				data=data+rs.getString("package_des")+"       ";
				data=data+rs.getString("cost")+"\n";
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
		if(sig.equals("Update")){
			up.setParent(this);
			up.setVisible(true);
		}
		else if(sig.equals("Exit")){
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