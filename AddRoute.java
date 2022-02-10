import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddRoute extends Frame implements ActionListener, WindowListener{
	private JButton b,b2;
	private TextField t,t2;
	private JLabel l,l2;
	private Frame parent;
	public AddRoute(){
		super("Add Tour Package");
		l=new JLabel("Route Id");
		l2=new JLabel("Type");
		t=new TextField();
		t2=new TextField();
		b=new JButton("Add");
		b2=new JButton("Cancel");
		add(b);add(b2);
		add(l);add(l2);
		add(t);add(t2);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);
		setSize(400,300);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(20,50,100,30);
		l2.setBounds(20,100,100,30);
		t.setBounds(140,50,200,30);
		t2.setBounds(140,100,200,30);
		b.setBounds(140,160,70,30);
		b2.setBounds(215,160,120,30);
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
		System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Add")){
			if(isEmpty(t) || isEmpty(t2)){
				JOptionPane.showMessageDialog(this,"All fields are mandatory");
			}
			else{
				DataAccess da=new DataAccess();
				try{
					String sql="insert into route(route_id,type) values('"+t.getText()+"','"+t2.getText()+"')";
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