package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Visit extends JLabel{
	private static Visit addLabel;
	private static final Font segoe = new Font("Segoe UI Light", Font.PLAIN, 40);
	private JButton add, newType, newProcedure, back;
	private JLabel label1, label2, label3;
	private JTextField name, age;
	private JComboBox<String> typeList, ownerList;
	
	private Visit()
	{
		setAttributes();
		setComponents();
	}
	
	public static Visit getInstance(){
		if(addLabel == null){
			addLabel = new Visit();
		}
		return addLabel;
	}
	
	private void setAttributes() 
	{
		setBounds(0,0,1024,600);
		setLayout(null);
		setBackground(null);
	}
	private void setComponents() {
		label1 = new JLabel("Visit");
		label1.setFont(new Font("Segoe UI Light",Font.PLAIN, 100));
		label1.setBounds(100,300,300,90);
		label1.setForeground(Color.WHITE);
		add(label1);
		
		label2 = new JLabel("Add Visitation");
		label2.setFont(new Font("Segoe UI Light",Font.PLAIN, 20));
		label2.setBounds(155,300,300,200);
		label2.setForeground(Color.WHITE);
		add(label2);
		
		label3 = new JLabel("AWS Internal Use Only");
		label3.setFont(new Font("Segoe UI Light",Font.PLAIN, 10));
		label3.setBounds(170,320,300,200);
		label3.setForeground(Color.WHITE);
		add(label3);
		
		name= new JTextField();
		name.setBounds(350,220,300,80);
		name.setOpaque(false);
		name.setFont(segoe);
		name.setForeground(Color.white);
		name.setEnabled(false);
		name.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE)," PET NAME", 0,0,new Font("Segoe UI Light", Font.PLAIN, 15),Color.WHITE));
		add(name);
				
		ownerList = new JComboBox<>();
		ownerList.setToolTipText("Select Pet Type");
		ownerList.setOpaque(false);
		ownerList.setBounds(350, 320, 200, 60);
		ownerList.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE),"PROCEDURE", 0,0,new Font("Segoe UI Light", Font.PLAIN, 15),Color.WHITE));
		add(ownerList);
		
		
		add = new JButton(new ImageIcon("images/sub.png"));
		add.setBorder(null);
		add.setContentAreaFilled(false);
		add.setSize(166,166);
		add.setLocation(800,320);
		add(add);
		
		back = new JButton(new ImageIcon("images/back.png"));
		back.setBorder(null);
		back.setFocusable(false);
		back.setContentAreaFilled(false);
		back.setSize(75,75);
		back.setLocation(20,20);
		add(back);
		
		newProcedure = new JButton(new ImageIcon("images/new.png"));
		newProcedure.setBorder(null);
		newProcedure.setFocusable(false);
		newProcedure.setContentAreaFilled(false);
		newProcedure.setSize(50,50);
		newProcedure.setLocation(570,335);
		newProcedure.setToolTipText("ADD NEW PROCEDURE");
		add(newProcedure);
		
		
	}
	
	public JTextField getNameField(){
		return name;
	}
	
	public JTextField getAge(){
		return age;
	}
	
	public JComboBox<String> getOwnerList(){
		return ownerList;
	}
	
	public JComboBox<String> getTypeList(){
		return typeList;
	}
	
	public JButton getAdd(){
		return add;
	}
	
	public JButton getBack(){
		return back;
	}
	
	public JButton getNewOwner(){
		return newProcedure;
	}
	
	public JButton getNewType(){
		return newType;
	}
}
