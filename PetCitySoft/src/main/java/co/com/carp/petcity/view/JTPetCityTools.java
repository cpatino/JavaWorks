package co.com.carp.petcity.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 * This class is attempt to manage different {@link JToolBar}(s) that can be used 
 * along application.
 * 
 * @author Carlos Rodriguez
 *
 */
public class JTPetCityTools extends JToolBar implements ActionListener {

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Identification from tool bar that is been currently used.
	 */
	private int idToolBarUsed;
	
	/**
	 * Button that allows save data when some change occurs.
	 */
	private JButton jbtSave;
	
	/**
	 * Tool bar used in {@link JFOwnerAndPetsInfo} screens. 
	 */
	public static final int TOOLBAR_PET_OWNER_INFO = 1;
	
	public JTPetCityTools(int idToolBar) {
		if (TOOLBAR_PET_OWNER_INFO == idToolBar) {
			this.idToolBarUsed = idToolBar;
			this.createPetAndOwnerToolBar();
		}
	}	

	/**
	 * @return the idToolBarUsed
	 */
	public int getIdToolBarUsed() {
		return idToolBarUsed;
	}
	
	/**
	 * It'll make enable/disable save action when it needs.
	 * 
	 * @param enable True if button must be enabled, false otherwise.
	 */
	public void makeEnableSaveAction(boolean enable) {
		this.jbtSave.setEnabled(enable);
	}

	/**
	 * Creates a new pet and owner tool bar, and it enables its buttons to receive the users' interaction. 
	 */
	private void createPetAndOwnerToolBar() {
		this.jbtSave = new JButton(new ImageIcon(JTPetCityTools.class.getResource("/co/com/carp/petcity/image/disk_blue.png")));
		this.jbtSave.setToolTipText("Guardar");
		this.jbtSave.setEnabled(false);
		this.jbtSave.addActionListener(this);
		this.add(this.jbtSave);
		this.addSeparator();
		JButton jbtNewOwner = new JButton(new ImageIcon(JTPetCityTools.class.getResource("/co/com/carp/petcity/image/businessman_add.png")));
		jbtNewOwner.setToolTipText("Nuevo propietario");
		jbtNewOwner.addActionListener(this);
		this.add(jbtNewOwner);
		this.addSeparator();
		JButton jbtNewPet = new JButton(new ImageIcon(JTPetCityTools.class.getResource("/co/com/carp/petcity/image/dog_add.png")));
		jbtNewPet.setToolTipText("Agregar mascota");
		jbtNewPet.addActionListener(this);
		this.add(jbtNewPet);
		this.addSeparator();
		JButton jbtClinicHistory = new JButton(new ImageIcon(JTPetCityTools.class.getResource("/co/com/carp/petcity/image/doctor.png")));
		jbtClinicHistory.setToolTipText("Ver historia clinica");
		jbtClinicHistory.addActionListener(this);
		this.add(jbtClinicHistory);
		this.addSeparator();
		JButton jbtNewNote = new JButton(new ImageIcon(JTPetCityTools.class.getResource("/co/com/carp/petcity/image/note_add.png")));
		jbtNewNote.setToolTipText("Agregar nota");
		jbtNewNote.addActionListener(this);
		this.add(jbtNewNote);
		this.addSeparator();
		JButton jbtViewNotes = new JButton(new ImageIcon(JTPetCityTools.class.getResource("/co/com/carp/petcity/image/note_view.png")));
		jbtViewNotes.setToolTipText("Ver notas");
		jbtViewNotes.addActionListener(this);
		this.add(jbtViewNotes);
		this.addSeparator();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
