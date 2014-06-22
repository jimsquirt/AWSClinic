package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Button;

@SuppressWarnings("serial")
public class Menu extends JLabel{
	private static Menu menu;
	private Button add, find, exit;
	private JLabel label1, label2, label3;
	
	private Menu()
	{
		setAttributes();
		setComponents();
	}
	
	public static Menu getInstance(){
		if(menu == null){
			menu = new Menu();
		}
		return menu;
	}
	
	private void setAttributes() 
	{
		setBounds(0,0,1024,600);
		setLayout(null);
		setBackground(null);
	}
	private void setComponents() {
		label1 = new JLabel("AWS");
		label1.setFont(new Font("Segoe UI Light",Font.PLAIN, 100));
		label1.setBounds(100,300,300,90);
		label1.setForeground(Color.WHITE);
		add(label1);
		
		label2 = new JLabel("Advanced Wildlife Systems");
		label2.setFont(new Font("Segoe UI Light",Font.PLAIN, 20));
		label2.setBounds(75,300,300,200);
		label2.setForeground(Color.WHITE);
		add(label2);
		
		label3 = new JLabel("AWS Internal Use Only");
		label3.setFont(new Font("Segoe UI Light",Font.PLAIN, 10));
		label3.setBounds(200,320,300,200);
		label3.setForeground(Color.WHITE);
		add(label3);
		
		add = new Button(new ImageIcon("images/add.png"), new ImageIcon("images/addH.png"));
		add.setLocation(340,270);
		add(add);
		
		find = new Button(new ImageIcon("images/find.png"), new ImageIcon("images/findH.png"));
		find.setLocation(519,270);
		add(find);
		
		exit = new Button(new ImageIcon("images/exit.png"), new ImageIcon("images/exitH.png"));
		exit.setLocation(698,270);
		add(exit);
	}
	
	public Button getAdd(){
		return add;
	}
	public Button getFind(){
		return find;
	}
	public Button getExit(){
		return exit;
	}
	
}
