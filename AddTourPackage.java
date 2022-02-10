import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddTourPackage extends Frame implements ActionListener, WindowListener{
	private JButton b,b2;
	private TextField t,t2,t3,t4,t5;
	private JLabel l,l2,l3,l4,l5;
	private Frame parent;
	public AddTourPackage(){
		super("Add Tour Package");
		l=new JLabel("Package Id");
		l2=new JLabel("Package Des");
		l3=new JLabel("Cost");
		t=new TextField();
		t2=new TextField();
		t3=new TextField();
		b=new JButton("Add");
		b2=new JButton("Cancel");
		add(b);add(b2);
		add(l);add(l2);add(l3);
		add(t);add(t2);add(t3);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);
		setSize(400,400);
		addWindowListener(this);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(20,50,100,30);
		l2.setBounds(20,100,100,30);
		l3.setBounds(20,200,100,30);
		t.setBounds(140,50,210,30);
		t2.setBounds(140,100,210,80);
		t3.setBounds(140,200,210,30);
		b.setBounds(140,240,100,30);
		b2.setBounds(250,240,100,30);
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
			if(isEmpty(t) || isEmpty(t2) || isEmpty(t3)){
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else{
				DataAccess da=new DataAccess();
				try{
					String sql="insert into tour_package(package_id,package_des,cost) values('"+t.getText()+"','"+t2.getText()+"','"+t3.getText()+"')";
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