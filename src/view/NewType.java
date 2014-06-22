package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")

public class NewType extends JLabel{
	private static NewType newTypeLabel;
	private static final Font segoe = new Font("Segoe UI Light", Font.PLAIN, 40);
	private JButton add, newTypeBack;
	private JLabel label1, label2, label3;
	private JTextField typeName;
	
	private NewType()
	{
		setAttributes();
		setComponents();
	}
	
	public static NewType getInstance(){
		if(newTypeLabel == null){
			newTypeLabel = new NewType();
		}
		return newTypeLabel;
	}
	
	private void setAttributes() 
	{
		setBounds(0,0,1024,600);
		setLayout(null);
		setBackground(null);
	}
	private void setComponents() {
		typeName= new JTextField();
		typeName.setBounds(350,220,300,80);
		typeName.setOpaque(false);
		typeName.setFont(segoe);
		typeName.setForeground(Color.white);
		typeName.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE),"NEW PET TYPE", 0,0,new Font("Segoe UI Light", Font.PLAIN, 15),Color.WHITE));
		add(typeName);
		
		newTypeBack = new JButton(new ImageIcon("images/back.png"));
		newTypeBack.setBorder(null);
		newTypeBack.setFocusable(false);
		newTypeBack.setContentAreaFilled(false);
		newTypeBack.setSize(75,75);
		newTypeBack.setLocation(20,20);
		add(newTypeBack);
		
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
		
		label2 = new JLabel("Add new type");
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
	
	public JButton getNewTypeBack(){
		return newTypeBack;
	}
	
	public JButton getAddType(){
		return add;
	}
	
	public JTextField getTypeNameField(){
		return typeName;
	}
	
}
