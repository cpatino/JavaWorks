/**
 * 
 */
package co.com.carp.petcity.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;

/**
 * This class is attempt to be a model to build all {@link JPanel}(s) that 
 * will display information in a tabular way.
 * 
 * @author Carlos Rodriguez
 */
public abstract class TableDataStructure extends TableStructure {
	
	/**
	 * It will be used as a label when a {@link JDatePicker} is being displayed.
	 */
	private static String SELECT_DATE_TEXT = "Fecha de aplicación:";
	
	
	/**
	 * Label that will describe the information that is required to be filled.
	 */
	private JLabel jlbDescription;
	
	/**
	 * Text field with description or name about the action that will be stored on 
	 * database.
	 */
	private JTextField jtfDescription;
	
	/**
	 * Date picker to select date from application.
	 */
	private JDatePickerImpl jdcApplicationDate;
	
	/**
	 * Button to add new information to database.
	 */
	private JButton jbtAdd;
	
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
	public TableDataStructure(Set<?> objectSet) {
		super(objectSet);
		this.getTabPanel().add(this.createFillInfoPanel(), BorderLayout.NORTH);
	}

	/**
	 * Sets text to description label.
	 * 
	 * @param description the description to be set on {@link JLabel}.
	 */
	public void setJlbDescriptionText(String description) {
		this.jlbDescription.setText(description);
	}
	
	/**
	 * Creates a panel with components to add new information
	 * 
	 * @return {@link JPanel} to be displayed.
	 */
	private JPanel createFillInfoPanel() {
		JPanel jpnFillInfo = new JPanel(null);
		jpnFillInfo.setPreferredSize(new Dimension(400, 100));
		Font verdanaBold = new Font("Verdana", Font.BOLD, 12);
		
		this.jlbDescription = new JLabel();
		jlbDescription.setBounds(10, 10, 130, 20);
		jlbDescription.setFont(verdanaBold);		
		this.jtfDescription = new JTextField();
		this.jtfDescription.setBounds(130, 10, 180, 20);
		this.jtfDescription.setFont(new Font("Verdana", Font.PLAIN, 12));
		
		JLabel jlbProgramatedDate = new JLabel(SELECT_DATE_TEXT);
		jlbProgramatedDate.setBounds(10, 35, 150, 20);
		jlbProgramatedDate.setFont(verdanaBold);
		jdcApplicationDate = new JDatePickerImpl(new JDatePanelImpl(new UtilCalendarModel()));
		jdcApplicationDate.getModel().setDate(Calendar.getInstance().get(Calendar.YEAR), 
				Calendar.getInstance().get(Calendar.MONTH), 
				Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/co/com/carp/petcity/image/calendar.png")); 
		((JButton)jdcApplicationDate.getComponent(1)).setIcon(icon);
		((JButton)jdcApplicationDate.getComponent(1)).setText("");
		((Component) jdcApplicationDate).setBounds(210, 35, 100, 25);
		
		
		icon = new ImageIcon(this.getClass().getResource("/co/com/carp/petcity/image/disk_blue.png"));
		this.jbtAdd = new JButton(icon);
		this.jbtAdd.setBounds(315, 10, 60, 40);
		this.jbtAdd.addActionListener(this);
		
		jpnFillInfo.add(jlbDescription);
		jpnFillInfo.add(jtfDescription);
		jpnFillInfo.add(jlbProgramatedDate);
		jpnFillInfo.add((Component) jdcApplicationDate);
		jpnFillInfo.add(jbtAdd);
		
		return jpnFillInfo;
	}

}
