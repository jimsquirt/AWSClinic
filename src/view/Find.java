package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.Button;

@SuppressWarnings("serial")
public class Find extends JLabel{
	private static Find addLabel;
	private static final Font segoe = new Font("Segoe UI Light", Font.PLAIN, 20);
	private Button back, search, del, edit, visit;
	private JLabel label1, label2, label3;
	private JTextField searchT, age;
	private JComboBox<String> typeList;
	private DefaultTableCellRenderer centerRenderer;

	private JPanel tablePanel;
	private JTable table;
	private DefaultTableModel tableModel;
	
	private Object[][] data = new Object[0][0];
	private String columnNames[] = {"Pet ID", "Pet Name", "Pet Type", "Pet Age", "Pet Owner"};
	
	private ArrayList<ArrayList<Object>> input = new ArrayList<>();;
	private ArrayList<Object> entry;

	private JScrollPane pane;
	
	private Find()
	{
		setAttributes();
		setComponents();
		addTable();
	}

	private void addTable() {
		tablePanel = new JPanel(null);
		tablePanel.setBounds(310, 140, 680, 360);

		tableModel = new DefaultTableModel(data, columnNames);

		table = new JTable(tableModel);

		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for(int i=0 ; i<5 ; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		}
		
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pane.setBounds(0, 0, 1000, 350);

		for(int i=0; i<table.getColumnCount(); i++)
			table.getColumnModel().getColumn(i).setPreferredWidth(135);

		tablePanel.add(pane, BorderLayout.CENTER);
		add(tablePanel);
	}
	
	
	public static Find getInstance(){
		if(addLabel == null){
			addLabel = new Find();
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
		label1 = new JLabel("Find");
		label1.setFont(new Font("Segoe UI Light",Font.PLAIN, 100));
		label1.setBounds(100,300,300,90);
		label1.setForeground(Color.WHITE);
		add(label1);
		
		label2 = new JLabel("Find/Delete/Update pet profiles");
		label2.setFont(new Font("Segoe UI Light",Font.PLAIN, 20));
		label2.setBounds(10,300,300,200);
		label2.setForeground(Color.WHITE);
		add(label2);
		
		label3 = new JLabel("AWS Internal Use Only");
		label3.setFont(new Font("Segoe UI Light",Font.PLAIN, 10));
		label3.setBounds(170,320,300,200);
		label3.setForeground(Color.WHITE);
		add(label3);
		
		searchT= new JTextField();
		searchT.setBounds(450,40,300,60);
		searchT.setOpaque(false);
		searchT.setFont(segoe);
		searchT.setForeground(Color.white);
		searchT.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE),"FIND", 0,0,new Font("Segoe UI Light", Font.PLAIN, 15),Color.WHITE));
		add(searchT);
		
		search = new Button(new ImageIcon("images/search.png"),new ImageIcon("images/searchH.png"));
		search.setBorder(null);
		search.setFocusable(false);
		search.setContentAreaFilled(false);
		search.setBounds(910,40,75,75);
		add(search);
			
		visit = new Button(new ImageIcon("images/visit.png"),new ImageIcon("images/visitH.png"));
		visit.setBorder(null);
		visit.setFocusable(false);
		visit.setContentAreaFilled(false);
		visit.setBounds(40,440,75,75);
		add(visit);
		
		edit = new Button(new ImageIcon("images/edit.png"),new ImageIcon("images/editH.png"));
		edit.setBorder(null);
		edit.setFocusable(false);
		edit.setContentAreaFilled(false);
		edit.setBounds(120,440,75,75);
		add(edit);
		
		del = new Button(new ImageIcon("images/del.png"),new ImageIcon("images/delH.png"));
		del.setBorder(null);
		del.setFocusable(false);
		del.setContentAreaFilled(false);
		del.setBounds(200,440,75,75);
		add(del);
		
		back = new Button(new ImageIcon("images/back.png"),new ImageIcon("images/backH.png"));
		back.setBorder(null);
		back.setFocusable(false);
		back.setContentAreaFilled(false);
		back.setBounds(20,20,75,75);
		add(back);
		
		
	}
	
	public void arrayListToArray() {
		data = new Object[input.size()][columnNames.length];
		for(int i = 0; i < input.size(); i++) {
			for(int j = 0; j < (columnNames.length); j++) {
				data[i][j] = (input.get(i)).get(j);
			}
		}
	}
	
	public void redrawTable() {
		tableModel.setDataVector(data, columnNames);
		tableModel.fireTableDataChanged();
		
		for(int i=0; i<table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(135);
			table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		}
	}
	
	public void setEntry() {
		entry = new ArrayList<>();
	}
	
	public JTextField getNameField(){
		return searchT;
	}
	
	public JTextField getAge(){
		return age;
	}
	
	public JComboBox<String> getTypeList(){
		return typeList;
	}
	public Button getSearchButton(){
		return search;
	}
	
	public Button getBack(){
		return back;
	}
	public Button getVisit(){
		return visit;
	}
	public Button getEdit(){
		return edit;
	}
	public Button getDelete(){
		return del;
	}
	public String[] getColumnNames() {
		return columnNames;
	}
	public ArrayList<ArrayList<Object>> getInput() {
		return input;
	}
	
	public ArrayList<Object> getEntry() {
		return entry;
	}
	public DefaultTableModel getModel() {
		return tableModel;
	}
	public JTable getTable() {
		return table;
	}
	
	
	
}
