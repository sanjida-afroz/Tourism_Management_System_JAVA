import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateCost extends Frame implements ActionListener, WindowListener{
	private JButton b,b2;
	private TextField t,t2;
	private JLabel l,l2;
	private Frame parent;
	public UpdateCost(){
		super("Update Cost");
		l=new JLabel("Package Id");
		t=new TextField();
		l2=new JLabel("Cost");
		t2=new TextField();
		b=new JButton("Update");
		b2=new JButton("Cancel");
		add(b);add(b2);
		add(l);add(t);
		add(l2);add(t2);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);
		setSize(450,300);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(20,50,100,30);
		t.setBounds(140,50,200,30);
		l2.setBounds(20,110,100,30);
		t2.setBounds(140,110,200,30);
		b.setBounds(140,170,90,30);
		b2.setBounds(250,170,90,30);
		addWindowListener(this);
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
		String sig=e.getActionCommand();
		if(sig.equals("Update")){
			if(isEmpty(t)){
				JOptionPane.showMessageDialog(this,"Fillup the field");
			}
			else{
				DataAccess da=new DataAccess();
				try{
					String sql="UPDATE tour_package SET cost = '"+t2.getText()+"' WHERE package_id = '"+t.getText()+"'";
						if(da.updateDB(sql) > 0){
							JOptionPane.showMessageDialog(this,"Updated!");
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