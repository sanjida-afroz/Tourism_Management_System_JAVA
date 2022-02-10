import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CTPackages extends Frame implements ActionListener, WindowListener{
	private JButton exitButton,selButton;
	private TextArea ta;
	private JLabel l,l2,l3;
	public static SelPackage sp;
	private Frame parent;
	public CTPackages(){
		super("Tour Packages");
		sp=new SelPackage();
		l=new JLabel("Package Id");
		l2=new JLabel("Package Des");
		l3=new JLabel("Cost");
		exitButton=new JButton("Exit");
		selButton=new JButton("Select Package");
		ta=new TextArea(10,100);
		ta.setEditable(false);
		add(ta);add(exitButton);add(selButton);
		add(l);add(l2);add(l3);
		exitButton.addActionListener(this);
		selButton.addActionListener(this);
		addWindowListener(this);
		setLayout(null);
		setSize(800,650);
		setLocation(300,55);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(50,50,100,30);
		l2.setBounds(150,50,290,30);
		l3.setBounds(540,50,100,30);
		ta.setBounds(50,100,700,300);
		selButton.setBounds(300,450,200,30);
		exitButton.setBounds(350,520,100,30);
	}
	public void loadData(){
		String sql="select * from tour_package";
		try{
			DataAccess da=new DataAccess();
			ResultSet rs=da.getData(sql);
			String data="";
			while(rs.next()){
				data=data+rs.getString("package_id")+"     		  ";
				data=data+rs.getString("package_des")+"   					        		 ";
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
		if(sig.equals("Select Package")){
			sp.setParent(this);
			sp.setVisible(true);
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