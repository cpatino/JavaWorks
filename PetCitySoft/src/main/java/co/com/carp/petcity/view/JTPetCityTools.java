package co.com.carp.petcity.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import co.com.carp.petcity.entity.Owner;
import co.com.carp.petcity.entity.Pet;

/**
 * This class is attempt to manage different {@link JToolBar}(s) that can be used 
 * along application.
 * 
 * @author Carlos Rodriguez
 *
 */
public class JTPetCityTools extends Observable implements ActionListener, Serializable {

	/**
	 * Default serial version id.
	 */
	private static final long serialVersionUID = 11231212L;
	
	/**
	 * Identification from tool bar that is been currently used.
	 */
	private int idToolBarUsed;
	
	/**
	 * Button that allows save data when some change occurs.
	 */
	private JButton jbtSave;
	
	/**
	 * Button that allows add a new {@link Owner}.
	 */
	private JButton jbtNewOwner;
	
	/**
	 * Button that allows add a new pet for register {@link Owner}s.
	 */
	private JButton jbtNewPet;
	
	/**
	 * Button that allows add or open clinic history for selected {@link Pet}.
	 */
	private JButton jbtClinicHistory;
	
	/**
	 * Button that allows add a new note for selected {@link Pet}.
	 */
	private JButton jbtNewNote;
	
	/**
	 * Button that allows add a view all notes created on application.
	 */
	private JButton jbtViewNotes;
	
	/**
	 * Tool bar used in {@link JFOwnerAndPetsInfo} screens. 
	 */
	public static final int TOOLBAR_OWNER_PET_INFO = 1;
	
	/**
	 * Action that will be notified to observer when save action is required by user.
	 */
	public static final String TOOLBAR_OWNER_PET_INFO_ACTION_SAVE = "Guardar";
	
	/**
	 * Action that will be notified to observer when new owner action is required by user.
	 */
	public static final String TOOLBAR_OWNER_PET_INFO_ACTION_OWNER = "NewOwner";
	
	/**
	 * Action that will be notified to observer when new pet action is required by user.
	 */
	public static final String TOOLBAR_OWNER_PET_INFO_ACTION_PET = "NewPet";
	
	/**
	 * Action that will be notified to observer when clinic history action is required by user.
	 */
	public static final String TOOLBAR_OWNER_PET_INFO_ACTION_HISTORY = "OpenHistory";
	
	/**
	 * Action that will be notified to observer when new note action is required by user.
	 */
	public static final String TOOLBAR_OWNER_PET_INFO_ACTION_NEW_NOTE = "AddNote";
	
	/**
	 * Action that will be notified to observer when view notes action is required by user.
	 */
	public static final String TOOLBAR_OWNER_PET_INFO_ACTION_VIEW_NOTES = "ViewNote";
	
	
	/**
	 * Constructor
	 * 
	 * @param idToolBar Identification from tool bar that will be created.
	 */
	public JTPetCityTools(int idToolBar) {
		super();
		this.idToolBarUsed = idToolBar;
	}
	
	/**
	 * Creates a {@link JToolBar} using the identification passed to constructor.
	 * 
	 * @return {@link JToolBar} that will be displayed.
	 */
	public JToolBar createJToolBar() {
		JToolBar toolBar = new JToolBar();
		if (TOOLBAR_OWNER_PET_INFO == this.idToolBarUsed) {
			toolBar = this.createPetAndOwnerToolBar();
		}
		return toolBar;
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
	 * It'll make enable/disable actions (Create/Add clinic history, add new pet)
	 * when a new pet has been already added.
	 * 
	 * @param enable True if button must be enabled, false otherwise.
	 */
	public void makeEnableActionsForPet(boolean enable) {
		this.jbtNewPet.setEnabled(enable);
		this.jbtClinicHistory.setEnabled(enable);
	}

	/**
	 * Creates a new pet and owner tool bar, and it enables its buttons to receive the users' interaction. 
	 */
	private JToolBar createPetAndOwnerToolBar() {
		JToolBar toolbar = new JToolBar();
		this.jbtSave = new JButton(new ImageIcon(JTPetCityTools.class.getResource("/co/com/carp/petcity/image/disk_blue.png")));
		this.jbtSave.setToolTipText("Guardar");
		this.jbtSave.setEnabled(false);
		this.jbtSave.addActionListener(this);
		toolbar.add(this.jbtSave);
		toolbar.addSeparator();
		this.jbtNewOwner = new JButton(new ImageIcon(JTPetCityTools.class.getResource("/co/com/carp/petcity/image/businessman_add.png")));
		this.jbtNewOwner.setToolTipText("Nuevo propietario");
		this.jbtNewOwner.addActionListener(this);
		toolbar.add(this.jbtNewOwner);
		toolbar.addSeparator();
		this.jbtNewPet = new JButton(new ImageIcon(JTPetCityTools.class.getResource("/co/com/carp/petcity/image/dog_add.png")));
		this.jbtNewPet.setToolTipText("Agregar mascota");
		this.jbtNewPet.addActionListener(this);
		toolbar.add(this.jbtNewPet);
		toolbar.addSeparator();
		this.jbtClinicHistory = new JButton(new ImageIcon(JTPetCityTools.class.getResource("/co/com/carp/petcity/image/doctor.png")));
		this.jbtClinicHistory.setToolTipText("Ver historia clinica");
		this.jbtClinicHistory.addActionListener(this);
		toolbar.add(this.jbtClinicHistory);
		toolbar.addSeparator();
		this.jbtNewNote = new JButton(new ImageIcon(JTPetCityTools.class.getResource("/co/com/carp/petcity/image/note_add.png")));
		this.jbtNewNote.setToolTipText("Agregar nota");
		this.jbtNewNote.addActionListener(this);
		toolbar.add(this.jbtNewNote);
		toolbar.addSeparator();
		this.jbtViewNotes = new JButton(new ImageIcon(JTPetCityTools.class.getResource("/co/com/carp/petcity/image/note_view.png")));
		this.jbtViewNotes.setToolTipText("Ver notas");
		this.jbtViewNotes.addActionListener(this);
		toolbar.add(this.jbtViewNotes);
		toolbar.addSeparator();
		return toolbar;
	}
	
	/**
	 * Notifies to observer about next action to be executed.
	 * 
	 * @param event Button event that was pressed.
	 */
	private void actionsForOwnerAndPetToolbar(ActionEvent event) {
		setChanged();			
		if (event.getSource().equals(jbtSave)) {
			notifyObservers(TOOLBAR_OWNER_PET_INFO_ACTION_SAVE);
		} else if (event.getSource().equals(jbtNewOwner)) {
			notifyObservers(TOOLBAR_OWNER_PET_INFO_ACTION_OWNER);
		} else if (event.getSource().equals(jbtNewPet)) {
			notifyObservers(TOOLBAR_OWNER_PET_INFO_ACTION_PET);
		} else if (event.getSource().equals(jbtClinicHistory)) {
			notifyObservers(TOOLBAR_OWNER_PET_INFO_ACTION_HISTORY);
		} else if (event.getSource().equals(jbtNewNote)) {
			notifyObservers(TOOLBAR_OWNER_PET_INFO_ACTION_NEW_NOTE);
		} else if (event.getSource().equals(jbtViewNotes)) {
			notifyObservers(TOOLBAR_OWNER_PET_INFO_ACTION_VIEW_NOTES);
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (TOOLBAR_OWNER_PET_INFO == this.idToolBarUsed) {
			this.actionsForOwnerAndPetToolbar(event);
		}
	}

}
