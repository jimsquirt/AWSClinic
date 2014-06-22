package model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Button extends JButton implements MouseListener
{
	ImageIcon icon, iconH;
	
	public Button(ImageIcon a, ImageIcon b)
	{
		icon =a;
		iconH =b;
		setProperties();
		this.addMouseListener(this);
	}


	private void setProperties() {
		setBorder(null);
		setFocusable(false);
		setContentAreaFilled(false);
		setSize(166,166);
		setVisible(true);
		setIcon(icon);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==this)
			setIcon(iconH);
	}


	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==this)
			setIcon(icon);
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
