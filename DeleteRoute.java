import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DeleteRoute extends Frame implements ActionListener, WindowListener{
	private JButton b,b2;
	private TextField t;
	private JLabel l;
	private Frame parent;
	public DeleteRoute(){
		super("Delete Route");
		l=new JLabel("Route Id");
		t=new TextField();
		b=new JButton("Delete");
		b2=new JButton("Cancel");
		add(b);add(b2);
		add(l);add(t);
		b.addActionListener(this);
		b2.addActionListener(this);
		setLayout(null);
		setSize(400,250);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		l.setBounds(20,50,100,30);
		t.setBounds(140,50,200,30);
		b.setBounds(140,110,70,30);
		b2.setBounds(215,110,120,30);
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
		if(sig.equals("Delete")){
			if(isEmpty(t)){
				JOptionPane.showMessageDialog(this,"Please Enter id");
			}
			else{
				DataAccess da=new DataAccess();
				try{
					String sql="DELETE FROM route WHERE route.route_id = '"+t.getText()+"'";
						if(da.updateDB(sql) > 0){
							JOptionPane.showMessageDialog(this,"Deleted!");
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