import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdatePackage extends Frame implements ActionListener, WindowListener{
	private JButton b,b2,b10;
	public static UpdateDes ud;
	public static UpdateCost uc;
	private Frame parent;
	public UpdatePackage(){
		super("Update Package");
		ud=new UpdateDes();
		uc=new UpdateCost();
		b=new JButton("Update Description");
		b2=new JButton("Update Cost");
		b10=new JButton("Go back");
		add(b);add(b2);add(b10);
		setLocation(500,175);
		b.addActionListener(this);
		b2.addActionListener(this);
		b10.addActionListener(this);
		setLayout(null);
		setSize(450,500);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		b.setBounds(75,90,300,30);
		b2.setBounds(75,160,300,30);
		b10.setBounds(125,250,200,30);
		addWindowListener(this);
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Update Description")){
			ud.setVisible(true);
			ud.setParent(this);
		}
		else if(sig.equals("Update Cost")){
			uc.setVisible(true);
			uc.setParent(this);
		}
		else if(sig.equals("Go back")){
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