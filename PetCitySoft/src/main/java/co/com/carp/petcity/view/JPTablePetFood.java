/**
 * 
 */
package co.com.carp.petcity.view;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import co.com.carp.petcity.entity.MedicalConsultation;
import co.com.carp.petcity.entity.PetFood;

/**
 * This class is attempt to show what was eating the pet along 
 * the time.
 * 
 * This information is queried from visits (All medical consultation) 
 * where owner gave information from this topic.
 * 
 * @author Carlos Rodriguez
 *
 */
public class JPTablePetFood extends TableStructure {

	/**
	 * @param objectSet
	 */
	public JPTablePetFood(Set<?> objectSet) {
		super(objectSet);
		this.setColumnNames(new String[] { "Marca", "Nombre", "Fecha consulta" });
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see co.com.carp.petcity.view.TableStructure#createTableModel()
	 */
	@Override
	protected TableModel createTableModel() {
		Object[][] dataToModel = null;
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		if (this.getObjectSet() != null && this.getObjectSet().size() > 0) {
			dataToModel = new Object[this.getObjectSet().size()][3];
			int rows = 0;
			for(Object object : this.getObjectSet()) {
				MedicalConsultation consultation = (MedicalConsultation)object;
				PetFood food = consultation.getVisitAdditionalInfo().getFood();
				if (food != null) {
					dataToModel[rows][0] = food.getFoodBrandMap().get(food.getFoodBrandSelected());
					dataToModel[rows][1] = food.getName();
					dataToModel[rows][3] = format.format(consultation.getConsultationDate());
					rows++;
				}
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
