/**
 * 
 */
package co.com.carp.petcity.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * This class is attempt to be a model to build all {@link JPanel}(s) that 
 * will display information in a tabular way.
 * 
 * @author Carlos Rodriguez
 */
public abstract class TableStructure extends Observable implements ActionListener {
	
	/**
	 * The set of objects to be displayed;
	 */
	private Set<?> objectSet;
	
	/**
	 * The columns name from table.
	 */
	private String columnNames[];
	
	/**
	 * {@link JPanel} with all components to be displayed.
	 */
	private JPanel jpTabPanel;
	
	/**
	 * Constructor
	 * <p>
	 * It will create main panel that will contains a tab to display information
	 * and a button to add a new element. <br><p>
	 * 
	 * Builds a new {@link JPanel} with two sections: <br>
	 * 1- Section to fill data and allowing add new info to database.<br>
	 * 2- Section with a tab with already filled information.
	 * 
	 * @param objectSet {@link Set} of objects that will be used to display information
	 * in the table section.
	 */
	public TableStructure(Set<?> objectSet) {
		super();
		this.objectSet = objectSet;
		this.jpTabPanel = new JPanel(new BorderLayout());
		jpTabPanel.add(this.createScrollPanel(), BorderLayout.CENTER);
	}
	
	/**
	 * @return the objectSet
	 */
	public Set<?> getObjectSet() {
		return objectSet;
	}

	/**
	 * @param objectSet the objectSet to set
	 */
	public void setObjectSet(Set<?> objectSet) {
		this.objectSet = objectSet;
	}

	/**
	 * @return the columnNames
	 */
	public String[] getColumnNames() {
		return columnNames;
	}
	
	/**
	 * @param columnNames the columnNames to set
	 */
	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}	
	
	/**
	 * It will return main panel that will contains a tab to display information
	 * and a button to add a new element.
	 * 
	 * @return {@link JPanel} with two sections: <br>
	 * 1- Section to fill data and allowing add new info to database.<br>
	 * 2- Section with a tab with already filled information.
	 */
	public JPanel getTabPanel() {		
		return jpTabPanel;
	}
	
	/**
	 * Creates a scroll pane that will contains the table.
	 * 
	 * @return {@link JScrollPane} to be displayed.
	 */
	private JScrollPane createScrollPanel() {
		TableModel model = this.createTableModel();
	    JTable table = new JTable(model); 

	    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
	    table.setRowSorter(sorter);

	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setPreferredSize(new Dimension(400, 400));
	    return scrollPane;
	}
	
	/**
	 * Creates table model that will be used to display information 
	 * correctly.
	 * 
	 * @return {@link TableModel} that will be used to display table.
	 */
	protected abstract TableModel createTableModel();

}
