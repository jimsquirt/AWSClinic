package view;


import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel {
	private JLabel label1;
	private JLabel bg = new JLabel(new ImageIcon("images/pet.png"));
	private Menu menu;
	private Add add;
	private NewOwner newOwner;
	private NewType newType;
	private Find find;
	private Visit visit;
	private Edit edit;
	
	
	public MainPanel() {
		setAttributes();
		setComponents();
		setEverything();
	}

	private void setEverything() {
		label1 = new JLabel("AWS");
		label1.setFont(new Font("Segoe UI Light",Font.PLAIN, 100));
		
	}

	private void setAttributes() 
	{
		setBounds(0,0,1024,600);
		setLayout(null);
	}

	private void setComponents() {
		menu = Menu.getInstance();
		add(menu);
		
		add = Add.getInstance();
		add(add);
		add.setVisible(false);
		
		newOwner = NewOwner.getInstance();
		add(newOwner);
		newOwner.setVisible(false);
		
		newType = NewType.getInstance();
		add(newType);
		newType.setVisible(false);
		
		find = Find.getInstance();
		add(find);
		find.setVisible(false);
		
		edit  = Edit.getInstance();
		add(edit);
		edit.setVisible(false);
		
		visit = Visit.getInstance();
		add(visit);
		visit.setVisible(false);
		
		bg.setBounds(0,0,1024,600);
		bg.setLayout(null);
		add(bg);
	}
	public Menu getMenu() {
		return menu;
	}
	
	public Add getAdd() {
		return add;
	}
	
	public NewOwner getOwner() {
		return newOwner;
	}
	
	public NewType getType() {
		return newType;
	}
	
	public Find getFind(){
		return find;
	}
	
	public Visit getVisit(){
		return visit;
	}
	
	public Edit getEdit(){
		return edit;
	}
}

