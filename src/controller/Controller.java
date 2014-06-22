package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import listeners.AddListener;
import listeners.SearchListener;
import model.Button;
import view.Add;
import view.Edit;
import view.Find;
import view.Frame;
import view.Menu;
import view.NewOwner;
import view.NewType;
import view.Visit;

public class Controller implements ActionListener
{
	private Button add, find,exit;
	private JButton findBack, editBack, visitBack, back, addPet, addOwner, addType, newOwner, newOwnerBack, newType, newTypeBack, findSearch, visit, edit, delete;
	private Menu menuPanel;
	private Add addPanel;
	private NewOwner ownerPanel;
	private NewType typePanel;
	private Find findPanel;
	private Edit editPanel;
	private Visit visitPanel;
	private Frame frame;
	private AddListener addListener;
	private SearchListener searchListener;
	
	public Controller()
	{
		setFrame(new Frame());
		initializeComponents();
		initializeEventListeners();
	}
	private void initializeComponents()
	{	
		menuPanel = frame.getMainPanel().getMenu();
		addPanel = frame.getMainPanel().getAdd();
		ownerPanel = frame.getMainPanel().getOwner();
		typePanel = frame.getMainPanel().getType();
		findPanel = frame.getMainPanel().getFind();
		editPanel = frame.getMainPanel().getEdit();
		visitPanel = frame.getMainPanel().getVisit();
		
		add  =   frame.getMainPanel().getMenu().getAdd();
		find =  frame.getMainPanel().getMenu().getFind();
		exit =  frame.getMainPanel().getMenu().getExit();
		back =  frame.getMainPanel().getAdd().getBack();
		findBack = frame.getMainPanel().getFind().getBack();
		editBack = frame.getMainPanel().getEdit().getBack();
		visitBack = frame.getMainPanel().getVisit().getBack();
		visit = findPanel.getVisit();
		edit = findPanel.getEdit();
		delete = findPanel.getDelete();
		
		addPet = Add.getInstance().getAdd();
		newOwner = Add.getInstance().getNewOwner();
		newType = Add.getInstance().getNewType();
		
		addOwner = ownerPanel.getAddOwner();
		newOwnerBack = ownerPanel.getNewOwnerBack();
		
		addType = typePanel.getAddType();
		newTypeBack = typePanel.getNewTypeBack();
		
		findSearch = findPanel.getSearchButton();
		
		addListener = new AddListener(this);
		searchListener = new SearchListener(this);
		
	}
	private void initializeEventListeners()
	{								
		add.addActionListener(this);
		find.addActionListener(this);
		exit.addActionListener(this);
		back.addActionListener(this);
		newOwner.addActionListener(this);
		newOwnerBack.addActionListener(this);
		newType.addActionListener(this);
		newTypeBack.addActionListener(this);
		editBack.addActionListener(this);
		visitBack.addActionListener(this);
		findBack.addActionListener(this);
		visit.addActionListener(this);
		edit.addActionListener(this);
		addPet.addActionListener(addListener);
		addOwner.addActionListener(addListener);
		addType.addActionListener(addListener);
		findSearch.addActionListener(searchListener);
		visit.addActionListener(searchListener);
		edit.addActionListener(searchListener);
		delete.addActionListener(searchListener);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add){
			showPanel(0);
		}
		else if(e.getSource()==back){
			showPanel(1);
		}
		else if (e.getSource()==newOwner){
			showPanel(2);
		}
		else if (e.getSource()==newOwnerBack){
			showPanel(3);
		}
		else if (e.getSource()==newType){
			showPanel(4);
		}
		else if (e.getSource()==newTypeBack){
			showPanel(5);
		}
		else if(e.getSource()==find){
			showPanel(6);
		}
		else if(e.getSource()==findBack){
			showPanel(7);
		}
		else if(e.getSource()==visit){
			showPanel(8);
		}
		else if(e.getSource()==visitBack){
			showPanel(9);
		}
		else if(e.getSource()==edit){
			showPanel(10);
		}
		else if(e.getSource()==editBack){
			showPanel(11);
		}
		else if (e.getSource()==exit){
			System.exit(0);
		}
	}
	
	public void showPanel(int status){
		menuPanel.setVisible(false);
		addPanel.setVisible(false);
		ownerPanel.setVisible(false);
		typePanel.setVisible(false);
		findPanel.setVisible(false);
		editPanel.setVisible(false);
		visitPanel.setVisible(false);
		if(status == 0){
			addPanel.setVisible(true);
		}
		else if(status == 1){
			menuPanel.setVisible(true);
		}
		else if(status == 2){
			ownerPanel.setVisible(true);
		}
		else if(status == 3){
			addPanel.setVisible(true);
		}
		else if(status == 4){
			typePanel.setVisible(true);
		}
		else if(status == 5){
			addPanel.setVisible(true);
		}
		else if(status == 6){
			findPanel.setVisible(true);
		}
		else if(status == 7){
			menuPanel.setVisible(true);
		}
		else if(status == 8){
			visitPanel.setVisible(true);
		}
		else if(status == 9){
			findPanel.setVisible(true);
		}
		else if(status == 10){
			editPanel.setVisible(true);
		}
		else if(status == 11){
			findPanel.setVisible(true);
		}
	}
	
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}

}
