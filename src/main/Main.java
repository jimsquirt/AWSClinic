package main;

import javax.swing.SwingUtilities;

import controller.Controller;

public class Main {
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{	
				new Controller();
			}
		});
	}
}
