package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")

public class NewOwner extends JLabel{
	private static NewOwner newOwnerLabel;
	private static final Font segoe = new Font("Segoe UI Light", Font.PLAIN, 40);
	private JButton add, newOwnerBack;
	private JLabel label1, label2, label3;
	private JTextField fname, lname, contactNumber, address;
	
	private NewOwner()
	{
		setAttributes();
		setComponents();
	}
	
	public static NewOwner getInstance(){
		if(newOwnerLabel == null){
			newOwnerLabel = new NewOwner();
		}
		return newOwnerLabel;
	}
	
	private void setAttributes() 
	{
		setBounds(0,0,1024,600);
		setLayout(null);
		setBackground(null);
	}
	private void setComponents() {
		fname= new JTextField();
		fname.setBounds(350,220,300,80);
		fname.setOpaque(false);
		fname.setFont(segoe);
		fname.setForeground(Color.white);
		fname.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE),"FIRST NAME", 0,0,new Font("Segoe UI Light", Font.PLAIN, 15),Color.WHITE));
		add(fname);
		
		lname = new JTextField();
		lname.setBounds(670,220,300,80);
		lname.setOpaque(false);
		lname.setFont(segoe);
		lname.setForeground(Color.white);
		lname.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE),"LAST NAME", 0,0,new Font("Segoe UI Light", Font.PLAIN, 15),Color.WHITE));
		add(lname);
		
		contactNumber = new JTextField();
		contactNumber.setBounds(350,330,300,80);
		contactNumber.setOpaque(false);
		contactNumber.setFont(segoe);
		contactNumber.setForeground(Color.white);
		contactNumber.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE),"CONTACT NUMBER", 0,0,new Font("Segoe UI Light", Font.PLAIN, 15),Color.WHITE));
		add(contactNumber);

		address= new JTextField();
		address.setBounds(350,440,300,80);
		address.setOpaque(false);
		address.setFont(segoe);
		address.setForeground(Color.white);
		address.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE),"ADDRESS", 0,0,new Font("Segoe UI Light", Font.PLAIN, 15),Color.WHITE));
		add(address);
		
		newOwnerBack = new JButton(new ImageIcon("images/back.png"));
		newOwnerBack.setBorder(null);
		newOwnerBack.setFocusable(false);
		newOwnerBack.setContentAreaFilled(false);
		newOwnerBack.setSize(75,75);
		newOwnerBack.setLocation(20,20);
		add(newOwnerBack);
		
		add = new JButton(new ImageIcon("images/sub.png"));
		add.setBorder(null);
		add.setContentAreaFilled(false);
		add.setSize(166,166);
		add.setLocation(800,320);
		add(add);
		
		label1 = new JLabel("Add");
		label1.setFont(new Font("Segoe UI Light",Font.PLAIN, 100));
		label1.setBounds(100,300,300,90);
		label1.setForeground(Color.WHITE);
		add(label1);
		
		label2 = new JLabel("Add new owner");
		label2.setFont(new Font("Segoe UI Light",Font.PLAIN, 20));
		label2.setBounds(140,300,300,200);
		label2.setForeground(Color.WHITE);
		add(label2);
		
		label3 = new JLabel("AWS Internal Use Only");
		label3.setFont(new Font("Segoe UI Light",Font.PLAIN, 10));
		label3.setBounds(170,320,300,200);
		label3.setForeground(Color.WHITE);
		add(label3);

	}
	
	public JButton getNewOwnerBack(){
		return newOwnerBack;
	}
	
	public JButton getAddOwner(){
		return add;
	}
	
	public JTextField getFNameField(){
		return fname;
	}
	
	public JTextField getLNameField(){
		return lname;
	}
	
	public JTextField getContactNumber(){
		return contactNumber;
	}
	
	public JTextField getAddress(){
		return address;
	}
	
}
