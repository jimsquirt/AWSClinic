package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Frame extends JFrame 
{
	private JPanel contentPane; 
	private MainPanel mainPanel;
	public Frame()
	{
		setAttributes();
		setFrame();
	}

	private void setAttributes()
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1024,600);
		setLocationRelativeTo(null);
		setTitle("Advanced Wildlife Systems");
//		setProgramIconAndTitle();
	}
	private void setFrame()
	{
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mainPanel= new MainPanel();
		contentPane.add(mainPanel);
		
		setVisible(true);
	}
	
	public MainPanel getMainPanel()
	{
		return mainPanel;
	}
//	private void setProgramIconAndTitle() {
//		String gameIcon = "images/gui/icon.png";
//		setIconImage(Toolkit.getDefaultToolkit().getImage(gameIcon));
//		setTitle("AGASTitch");
//	}
	
}
