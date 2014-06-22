package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Controller;
import database.Connector;
import view.Edit;
import view.Find;
import view.Visit;

public class SearchListener implements ActionListener{
	private Connector connector = Connector.getInstance();
	private Controller controller;
	private Find find = Find.getInstance();
	private Visit visit = Visit.getInstance();
	private Edit edit = Edit.getInstance();

	public SearchListener(Controller controller){
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == find.getSearchButton()){
			getPets();
		}
		else if(e.getSource() == find.getVisit()){
			if(find.getTable().getSelectedRow()>=0){
				getProcedures();
				int selected = find.getTable().getSelectedRow();
				try{
					connector.selectQuery("SELECT Pet_Name FROM pet WHERE Pet_Id = " + find.getModel().getValueAt(selected, 0) + "");
					connector.getResultSet();
					if(connector.getResultSet().next()){
						visit.getNameField().setText(""+connector.getResultSet().getObject(1));
					}
				}catch (Exception e2){
					e2.printStackTrace();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "No item selected!", "Notice!", JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource() == find.getEdit()){
			if(find.getTable().getSelectedRow()>=0){
				int selected = find.getTable().getSelectedRow();
				try{
					connector.selectQuery("SELECT Pet_Id, Pet_Name, Type_Name, Pet_Age, First_Name, Last_Name FROM pet, owner, pet_type WHERE Pet_Id =" + find.getModel().getValueAt(selected, 0) + " AND Pet_Type = Type_Id AND Pet_Owner = Owner_Id");
					connector.getResultSet();
					if(connector.getResultSet().next()){
						System.out.println("a");
						edit.getNameField().setText(""+connector.getResultSet().getObject(2));
						edit.getAge().setText(""+connector.getResultSet().getObject(4));
						edit.getOwnerList().addItem((String) connector.getResultSet().getObject(5) + " " + connector.getResultSet().getObject(6));
						edit.getTypeList().addItem("" + connector.getResultSet().getObject(3));
					}
				}catch (Exception e2){
					e2.printStackTrace();
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "No item selected!", "Notice!", JOptionPane.WARNING_MESSAGE);
			}

		}
		if(e.getSource() == find.getDelete()){
			int selected = find.getTable().getSelectedRow();
			try {
				connector.updateQuery("Delete FROM pet WHERE Pet_Id = " + find.getModel().getValueAt(selected, 0) + "");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Pet successfully deleted!", "Notice!", JOptionPane.INFORMATION_MESSAGE);
		}	
	}

	private void getProcedures(){
		try {
			visit.getOwnerList().removeAllItems();
			connector.selectQuery("SELECT Procedure_Name FROM procedure_table");
			while(connector.getResultSet().next()){
				visit.getOwnerList().addItem(connector.getResultSet().getObject(1).toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void getPets(){
		try {
			connector.selectQuery("SELECT Pet_Id, Pet_Name, Type_Name, Pet_Age, First_Name, Last_Name FROM pet, owner, pet_type WHERE Pet_Name LIKE '%" + find.getNameField().getText() + "%' AND Pet_Type = Type_Id AND Pet_Owner = Owner_Id");
			connector.getResultSet();
			find.getInput().clear();
			while(connector.getResultSet().next()){
				find.setEntry();
				for(int i = 1; i<=5 ; i++){
					if(i==5)
						find.getEntry().add((String)connector.getResultSet().getObject(i) + " " + connector.getResultSet().getObject(i + 1));
					else
						find.getEntry().add(connector.getResultSet().getObject(i));
				}
				find.getInput().add(find.getEntry());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		find.arrayListToArray();
		find.redrawTable();
	}
}
