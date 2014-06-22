package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Controller;
import database.Connector;
import view.Add;
import view.NewOwner;
import view.NewType;

public class AddListener implements ActionListener{
	private Connector connector = Connector.getInstance();
	private Controller controller;
	private Add add = Add.getInstance();
	private NewOwner owner = NewOwner.getInstance();
	private NewType type = NewType.getInstance();
	
	public AddListener(Controller controller){
		this.controller = controller;
		getOwners();
		getPetTypes();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add.getAdd()){
			if(checkPetInputs()){
				try {
					connector.updateQuery("INSERT INTO pet (Pet_Name, Pet_Type, Pet_Age, Pet_Owner) VALUES('" + add.getNameField().getText() + "' , '" + (add.getTypeList().getSelectedIndex() + 1) + "' , " + Integer.parseInt(add.getAge().getText()) + ", '" + (add.getOwnerList().getSelectedIndex() + 1) + "')");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Pet successfully added!", "Notice!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(e.getSource() == owner.getAddOwner()){
			if(checkOwnerInputs()){
				try {
					connector.updateQuery("INSERT INTO owner (First_Name, Last_Name, Contact_Number, Address) VALUES('" + owner.getFNameField().getText() + "' , '" + owner.getLNameField().getText() + "' , '" + owner.getContactNumber().getText() + "' , '" + owner.getAddress().getText() + "')");
					getOwners();
					controller.showPanel(0);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Owner successfully added!", "Notice!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(e.getSource() == type.getAddType()){
			if(!type.getTypeNameField().getText().trim().equals("")){
				try {
					connector.updateQuery("INSERT INTO pet_type (Type_Name) VALUES('" + type.getTypeNameField().getText() + "')");
					getPetTypes();
					controller.showPanel(0);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Type successfully added!", "Notice!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	private void getOwners(){
		try {
			add.getOwnerList().removeAllItems();
			connector.selectQuery("SELECT First_Name, Last_Name FROM owner");
			while(connector.getResultSet().next()){
				add.getOwnerList().addItem(connector.getResultSet().getObject(1).toString() + " " + connector.getResultSet().getObject(2).toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void getPetTypes(){
		try {
			add.getTypeList().removeAllItems();
			connector.selectQuery("SELECT Type_Name FROM pet_type");
			while(connector.getResultSet().next()){
				add.getTypeList().addItem(connector.getResultSet().getObject(1).toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private boolean checkPetInputs(){
		if(add.getNameField().getText().trim().equals("") || add.getAge().getText().trim().equals("") || Integer.parseInt(add.getAge().getText().trim()) < 0){
			JOptionPane.showMessageDialog(null, "Please check your input!", "Notice!", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
	
	private boolean checkOwnerInputs(){
		if(owner.getFNameField().getText().trim().equals("") || owner.getLNameField().getText().trim().equals("") || owner.getContactNumber().getText().trim().equals("") || owner.getAddress().getText().trim().equals("")){
			JOptionPane.showMessageDialog(null, "Please check your input!", "Notice!", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}
}
