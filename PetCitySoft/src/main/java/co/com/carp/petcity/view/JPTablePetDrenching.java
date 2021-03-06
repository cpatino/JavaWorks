/**
 * 
 */
package co.com.carp.petcity.view;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import co.com.carp.petcity.entity.PetDrenching;

/**
 * This class is attempt to display information about pet's deworming
 * using the {@link TableDataStructure} way.
 * 
 * @author Carlos Rodriguez
 *
 */
public class JPTablePetDrenching extends TableDataStructure {
	
	/**
	 * Constructor
	 * 
	 * @param objectSet {@link Set} of objects that will be used to display information
	 * in the table section.
	 */
	public JPTablePetDrenching(Set<?> objectSet) {
		super(objectSet);
		this.setJlbDescriptionText("Desparasitante:");
		this.setColumnNames(new String[] { "Desparasitante", "Fecha aplicación" });
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see co.com.carp.petcity.view.TableDataStructure#createTableModel()
	 */
	@Override
	protected TableModel createTableModel() {
		Object[][] dataToModel = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		if (this.getObjectSet() != null && this.getObjectSet().size() > 0) {
			dataToModel = new Object[this.getObjectSet().size()][5];
			int rows = 0;
			for(Object object : this.getObjectSet()) {
				PetDrenching drenchingUsed = (PetDrenching)object;
				dataToModel[rows][0] = drenchingUsed.getProductName();
				dataToModel[rows][1] = format.format(drenchingUsed.getDrenchingDate());
				rows++;
			}			
		}
		return new DefaultTableModel(dataToModel, this.getColumnNames()) {

			private static final long serialVersionUID = 15451565641561561L;

			public Class<?> getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};
	}

}
