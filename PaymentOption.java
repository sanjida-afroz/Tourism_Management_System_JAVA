import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaymentOption extends Frame implements ActionListener, WindowListener{
	private JButton b2,b3,b10;
	public static Card card;
	public static BankTransfer btf;
	private Frame parent;
	public PaymentOption(){
		super("Payment Option");
		btf=new BankTransfer();
		card=new Card();
		b2=new JButton("Card");
		b3=new JButton("Bank Transfer");
		b10=new JButton("Go back");
		add(b2);add(b3);add(b10);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b10.addActionListener(this);
		setLayout(null);
		setSize(450,500);
		setLocation(500,175);
		Color cl= new Color(51,204,255);
		setBackground(cl);		
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
		if(sig.equals("Card")){
			this.setVisible(false);
			card.setVisible(true);
			card.setParent(this);
		}
		else if(sig.equals("Bank Transfer")){
			this.setVisible(false);
			btf.setVisible(true);
			btf.setParent(this);
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