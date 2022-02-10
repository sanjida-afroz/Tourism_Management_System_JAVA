import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ATour extends Frame implements ActionListener, WindowListener{
	private JButton b,b2,b3,b10;
	public static TPackages tps;
	public static AddTourPackage atp;
	public static DeleteTourPackage dtp;
	private Frame parent;
	public ATour(){
		super("Tour");
		atp=new AddTourPackage();
		dtp=new DeleteTourPackage();
		tps=new TPackages();
		b=new JButton("Tour packages");
		b2=new JButton("Add new packages");
		b3=new JButton("Delete package");
		b10=new JButton("Go back");
		add(b);add(b2);add(b3);add(b10);
		b.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b10.addActionListener(this);
		setLayout(null);
		setSize(450,500);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);
		b.setBounds(75,90,300,30);
		b2.setBounds(75,160,300,30);
		b3.setBounds(75,230,300,30);
		b10.setBounds(125,350,200,30);
		addWindowListener(this);
	}
	public void setParent(Frame f){
		parent=f;
	}
	public void actionPerformed(ActionEvent e){
		System.out.println(e.getActionCommand());
		String sig=e.getActionCommand();
		if(sig.equals("Add new packages")){
			atp.setVisible(true);
			atp.setParent(this);
		}
		else if(sig.equals("Delete package")){
			dtp.setVisible(true);
			dtp.setParent(this);
		}
		else if(sig.equals("Tour packages")){
			tps.loadData();
			tps.setVisible(true);
			tps.setParent(this);
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