import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DeleteCustomer extends Frame implements ActionListener, WindowListener{
	private TextField id;
	private JButton delButton,cancelButton;
	private JLabel l;
	public Frame parent;
	public DeleteCustomer(){
		super("Delete Customer");
		l=new JLabel("Customer Id:");
		id=new TextField();
		delButton=new JButton("Delete");
		cancelButton=new JButton("Cancel");
		add(l);add(id);
		add(delButton);add(cancelButton);
		l.setBounds(20,100,100,30);
		id.setBounds(145,100,207,30);
		delButton.setBounds(145,180,100,30);
		cancelButton.setBounds(250,180,100,30);
		delButton.addActionListener(this);
		cancelButton.addActionListener(this);
		setLayout(null);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		setSize(400,400);
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
			if(isEmpty(id)){
				JOptionPane.showMessageDialog(this,"Please Enter id");
			}
			else{
				DataAccess da=new DataAccess();
				try{
					String sql="DELETE FROM customer WHERE customer.c_id = '"+id.getText()+"'";
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