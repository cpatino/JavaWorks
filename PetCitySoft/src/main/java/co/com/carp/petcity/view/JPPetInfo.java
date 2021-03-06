package co.com.carp.petcity.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;
import co.com.carp.petcity.entity.Pet;
import co.com.carp.petcity.entity.PetBreed;
import co.com.carp.petcity.entity.PetType;
import static co.com.carp.petcity.util.Configuration.SELECT_ONE_MSG;
import static co.com.carp.petcity.entity.Pet.*;

/**
 * This class is attempt to manage information from pets, those information can be inserted, updated.
 * 
 * @author Carlos Rodriguez
 *
 */
public class JPPetInfo extends Observable implements ActionListener, InformationPanelFillable, Serializable {

	/**
	 * Auto-generated serial version
	 */
	private static final long serialVersionUID = -1250251333816555407L;	

	/**
	 * {@link Pet} actually been displayed on screen.
	 */
	private Pet pet;
	
	/**
	 * {@link Set} of {@link PetType}s that will be displayed on {@link JComboBox}, it also contains information
	 * about {@link PetBreed}s that will be displayed according {@link PetType} selected.
	 */
	private Set<PetType> typeSet; 

	/**
	 * {@link JTextField} that stores pet's name
	 */
	private JTextField jtfName;

	/**
	 * {@link JComboBox} with {@link PetType}(s).
	 */
	private JComboBox<String> jcbPetType;

	/**
	 * {@link JComboBox} with pet's sex.
	 */
	private JComboBox<String> jcbSex;

	/**
	 * {@link JComboBox} with breeds that dependents from 
	 * selection done on {@link PetType}(s) {@link JComboBox}.
	 */
	private JComboBox<String> jcbBreed;
	
	/**
	 * {@link JComboBox} with reproduction status from {@link Pet}.
	 */
	private JComboBox<String> jcbReproductionStatus;

	/**
	 * {@link JTextField} that stores pet's color.
	 */
	private JTextField jtfColor;

	/**
	 * {@link JDatePanelImpl} that allows store pet's born date.
	 */
	private JDatePickerImpl jdcBornDate;

	/**
	 * {@link JTextField} that allows store place where pet was obtained.
	 */
	private JTextField jtfSource;
	
	/**
	 * It controls if some change was done in a field component was notified.
	 */
	private boolean changeNotified;

	/**
	 * Constructor
	 * 
	 * @param pet {@link Pet} to displayed in screen.
	 * @param typeSet {@link Set} of {@link PetType}s that will be displayed.
	 */
	public JPPetInfo(Pet pet, Set<PetType> typeSet) {
		super();
		this.pet = pet;
		this.typeSet = typeSet;
		this.changeNotified = false;
	}
	
	/**
	 * @return the changeNotified
	 */
	public boolean isChangeNotified() {
		return changeNotified;
	}

	/**
	 * Creates a new pet information panel (Main panel).
	 * 
	 * @return {@link JPanel} to display all information.
	 */
	public JPanel createPetInfoPanel() {
		JPanel jpanel = new JPanel(null);
		Font verdanaBold = new Font("Verdana", Font.BOLD, 12);
		Font verdanaPlain = new Font("Verdana", Font.PLAIN, 12);

		JPanel jpnTitle = new JPanel(null);
		jpnTitle.setBounds(10, 0, 730, 40);
		jpnTitle.setBackground(new Color(34, 139, 34));
		jpnTitle.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel jlTitle = new JLabel("DATOS MASCOTA");
		jlTitle.setFont(verdanaBold);
		jlTitle.setBounds(250, 10, 300, 20);
		jlTitle.setForeground(Color.WHITE);
		jpnTitle.add(jlTitle);

		jpanel.add(jpnTitle);
		jpanel.add(this.createInfoPanel(verdanaBold, verdanaPlain));
		jpanel.add(this.createPetImagePanel());
		jpanel.add(this.createImageActionPanel(verdanaBold, verdanaPlain));

		this.fillFields();
		return jpanel;
	}

	/**
	 * It creates a panel with an image from pet. When the pet doesn't have an
	 * image associated, a default image is loaded.
	 * 
	 * @return {@link JPanel} with image to be displayed.
	 */
	private JPanel createPetImagePanel() {
		JPanel jpnPetImage = new JPanel(new BorderLayout());
		jpnPetImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jpnPetImage.setBounds(540, 45, 200, 200);
		jpnPetImage.setBackground(new Color(250, 245, 245));

		JLabel jlbPhoto = new JLabel(
				new ImageIcon(
						JPPetInfo.class
								.getResource("/co/com/carp/petcity/image/background-white.png")));
		JScrollPane scrollPane = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().add(jlbPhoto);
		jpnPetImage.add(scrollPane, BorderLayout.CENTER);
		return jpnPetImage;
	}

	/**
	 * It helps to create all buttons that allows actions in pet information
	 * panel
	 * 
	 * @param verdanaBold
	 *            Verdana font bold.
	 * @param verdanaPlain
	 *            Verdana font plain.
	 * @return {@link JPanel} with all action buttons.
	 */
	private JPanel createImageActionPanel(Font verdanaBold, Font verdanaPlain) {
		JPanel jpnPetImageActions = new JPanel(null);
		jpnPetImageActions.setBorder(BorderFactory
				.createLineBorder(Color.BLACK));
		jpnPetImageActions.setBounds(540, 250, 200, 45);
		jpnPetImageActions.setBackground(new Color(250, 245, 245));

		JButton jbtLoadImage = new JButton("Cargar imagen");
		jbtLoadImage.setForeground(new Color(255, 255, 255));
		jbtLoadImage.setBackground(new Color(30, 144, 255));
		jbtLoadImage.setFont(new Font("Verdana", Font.BOLD, 12));
		jbtLoadImage.setBounds(70, 10, 120, 25);
		jbtLoadImage.addActionListener(this);
		jpnPetImageActions.add(jbtLoadImage);

		return jpnPetImageActions;
	}
	
	/**
	 * Builds a {@link String} array that will be used on {@link PetType}'s 
	 * {@link JComboBox}  to display data.
	 * 
	 * @return {@link String} array with data to be displayed.
	 */
	private String[] buildPetTypeStringArray() {
		String[] typeArray = new String[this.typeSet.size() + 1];
		typeArray[0] = SELECT_ONE_MSG;
		int arrayPos = 1;
		for(PetType type : typeSet) {
			typeArray[arrayPos] = type.getName();
			arrayPos++;
		}
		return typeArray;
	}
	
	/**
	 * Builds a {@link String} array that will be used on {@link PetBreed}'s 
	 * {@link JComboBox}  to display data.
	 * 
	 * @return {@link String} array with data to be displayed.
	 */
	private String[] buildPetBreedStringArray() {
		String[] breedArray = null;
		if (jcbPetType.getSelectedIndex() == 0) {
			breedArray = new String[] { SELECT_ONE_MSG };
		} else {
			for (PetType type : typeSet) {
				if (type.getName().equalsIgnoreCase(jcbPetType.getSelectedItem().toString())) {
					if (type.getBreedSet() != null) {
						breedArray = new String[type.getBreedSet().size() + 1];
						breedArray[0] = SELECT_ONE_MSG;
						int arrayPos = 1;
						for (PetBreed breed : type.getBreedSet()) {
							breedArray[arrayPos] = breed.getName();
							arrayPos++;
						}
					} else {
						breedArray = new String[] { SELECT_ONE_MSG };
					}
				}
			}
		}
		return breedArray;
	}
	
	/**
	 * Gets {@link PetBreed} selected on {@link JComboBox} component.
	 * 
	 * @return {@link PetBreed} selected on {@link JComboBox}, or null if
	 * no one was selected yet.
	 */
	private PetBreed getBreedSelected() {
		if (this.jcbPetType.getSelectedIndex() > 0) {
			for (PetType type : this.typeSet) {
				if (this.jcbPetType.getSelectedItem().equals(type.getName())) {
					if (this.jcbBreed.getSelectedIndex() > 0) {
						for (PetBreed breed : type.getBreedSet()) {
							if (this.jcbBreed.getSelectedItem().equals(breed.getName())) {
								return breed;
							}
						}
						break;
					} else {
						break;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Notifies to observer that some data was changed.
	 */
	private void notifyDataChanged() {
		if (!this.changeNotified) {
			this.changeNotified = true;
			setChanged();
			notifyObservers();
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.notifyDataChanged();
		if (event.getSource().equals(jcbPetType)) {
			this.jcbBreed.removeAllItems();
			String[] breedArray = this.buildPetBreedStringArray();
			for (String strBreed : breedArray) {
				this.jcbBreed.addItem(strBreed);
			}
		}
	}

	@Override
	public JPanel createInfoPanel(Font verdanaBold, Font verdanaPlain) {
		JPanel jpnGeneralDetail = new JPanel(null);
		jpnGeneralDetail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jpnGeneralDetail.setBounds(10, 45, 525, 250);
		jpnGeneralDetail.setBackground(new Color(250, 245, 245));

		JLabel jlbPetName = new JLabel("Nombre:");
		jlbPetName.setBounds(10, 10, 145, 20);
		jlbPetName.setFont(verdanaBold);
		jlbPetName.setHorizontalAlignment(SwingConstants.RIGHT);
		jtfName = new JTextField();
		jtfName.setBounds(160, 10, 250, 20);
		jtfName.setFont(verdanaPlain);
		jtfName.addKeyListener(this);
		jpnGeneralDetail.add(jlbPetName);
		jpnGeneralDetail.add(jtfName);

		JLabel jlbPetKind = new JLabel("Especie:");
		jlbPetKind.setBounds(10, 40, 145, 20);
		jlbPetKind.setFont(verdanaBold);
		jlbPetKind.setHorizontalAlignment(SwingConstants.RIGHT);
		jcbPetType = new JComboBox<String>(this.buildPetTypeStringArray());
		jcbPetType.setBounds(160, 40, 200, 20);
		jcbPetType.setFont(verdanaPlain);
		jcbPetType.addActionListener(this);
		jpnGeneralDetail.add(jlbPetKind);
		jpnGeneralDetail.add(jcbPetType);

		JLabel jlbPetBreed = new JLabel("Raza:");
		jlbPetBreed.setBounds(10, 70, 145, 20);
		jlbPetBreed.setFont(verdanaBold);
		jlbPetBreed.setHorizontalAlignment(SwingConstants.RIGHT);
		jcbBreed = new JComboBox<String>(this.buildPetBreedStringArray());
		jcbBreed.setBounds(160, 70, 200, 20);
		jcbBreed.setFont(verdanaPlain);
		jcbBreed.addActionListener(this);
		jpnGeneralDetail.add(jlbPetBreed);
		jpnGeneralDetail.add(jcbBreed);

		JLabel jlbPetSex = new JLabel("Sexo:");
		jlbPetSex.setBounds(10, 100, 145, 20);
		jlbPetSex.setFont(verdanaBold);
		jlbPetSex.setHorizontalAlignment(SwingConstants.RIGHT);
		jcbSex = new JComboBox<String>(new String[] { SELECT_ONE_MSG,
				Pet.PET_SEX_FEMALE, Pet.PET_SEX_MALE });
		jcbSex.setBounds(160, 100, 130, 20);
		jcbSex.setFont(verdanaPlain);
		jcbSex.addActionListener(this);
		jpnGeneralDetail.add(jlbPetSex);
		jpnGeneralDetail.add(jcbSex);

		JLabel jlbPetColor = new JLabel("Color:");
		jlbPetColor.setBounds(10, 130, 145, 20);
		jlbPetColor.setFont(verdanaBold);
		jlbPetColor.setHorizontalAlignment(SwingConstants.RIGHT);
		jtfColor = new JTextField();
		jtfColor.setBounds(160, 130, 250, 20);
		jtfColor.setFont(verdanaPlain);
		jtfColor.addKeyListener(this);
		jpnGeneralDetail.add(jlbPetColor);
		jpnGeneralDetail.add(jtfColor);

		JLabel jlbPetSource = new JLabel("Procedencia:");
		jlbPetSource.setBounds(10, 160, 145, 20);
		jlbPetSource.setFont(verdanaBold);
		jlbPetSource.setHorizontalAlignment(SwingConstants.RIGHT);
		jtfSource = new JTextField();
		jtfSource.setBounds(160, 160, 250, 20);
		jtfSource.setFont(verdanaPlain);
		jtfSource.addKeyListener(this);
		jpnGeneralDetail.add(jlbPetSource);
		jpnGeneralDetail.add(jtfSource);

		JLabel jlbPetBornDate = new JLabel("Fecha de nacimiento:");
		jlbPetBornDate.setBounds(10, 190, 145, 20);
		jlbPetBornDate.setFont(verdanaBold);
		jlbPetBornDate.setHorizontalAlignment(SwingConstants.RIGHT);
		jdcBornDate = new JDatePickerImpl(new JDatePanelImpl(
				new UtilCalendarModel()));
		jdcBornDate.getModel().setDate(
				Calendar.getInstance().get(Calendar.YEAR),
				Calendar.getInstance().get(Calendar.MONTH),
				Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		((JButton) jdcBornDate.getComponent(1))
				.setIcon(new ImageIcon(JPPetInfo.class
						.getResource("/co/com/carp/petcity/image/calendar.png")));
		((JButton) jdcBornDate.getComponent(1)).setText("");
		((JButton) jdcBornDate.getComponent(1)).addActionListener(this);
		((Component) jdcBornDate).setBounds(160, 190, 100, 25);
		jpnGeneralDetail.add(jlbPetBornDate);
		jpnGeneralDetail.add((Component) jdcBornDate);
		
		JLabel jlbPetRepStatus = new JLabel("Reproducci�n:");
		jlbPetRepStatus.setBounds(10, 220, 145, 20);
		jlbPetRepStatus.setFont(verdanaBold);
		jlbPetRepStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		jcbReproductionStatus = new JComboBox<String>(new String[] { SELECT_ONE_MSG, 
				REPRODUCTION_ENTIRE, REPRODUCTION_STERILIZED, REPRODUCTION_ONE_TWO,
				REPRODUCTION_THREE_FOUR, REPRODUCTION_FIVE_MORE});
		jcbReproductionStatus.setBounds(160, 220, 200, 20);
		jcbReproductionStatus.setFont(verdanaPlain);
		jcbReproductionStatus.addActionListener(this);
		jpnGeneralDetail.add(jlbPetRepStatus);
		jpnGeneralDetail.add(jcbReproductionStatus);

		return jpnGeneralDetail;
	}

	@Override
	public void cleanAllFields() {
		this.jtfName.setText("");
		this.jcbPetType.setSelectedIndex(0);
		this.jcbBreed.setSelectedIndex(0);
		this.jcbSex.setSelectedIndex(0);
		this.jtfColor.setText("");
		this.jtfSource.setText("");
		this.jdcBornDate.getModel().setValue(null);
		this.jcbReproductionStatus.setSelectedIndex(0);
		this.changeNotified = false;
	}

	@Override
	public void initializeDisableAllComponents() {
		this.jtfName.setEnabled(false);
		this.jcbPetType.setEnabled(false);
		this.jcbBreed.setEnabled(false);
		this.jcbSex.setEnabled(false);
		this.jtfColor.setEnabled(false);
		this.jtfSource.setEnabled(false);
		this.jdcBornDate.setEnabled(false);
		((JButton)jdcBornDate.getComponent(1)).setEnabled(false);
		this.jcbReproductionStatus.setEnabled(false);
		this.cleanAllFields();
	}

	@Override
	public void doEnableAllComponents() {
		if (this.pet != null) {
			this.jtfName.setEnabled(true);
			this.jcbPetType.setEnabled(true);
			this.jcbBreed.setEnabled(true);
			this.jcbSex.setEnabled(true);
			this.jtfColor.setEnabled(true);
			this.jtfSource.setEnabled(true);
			this.jdcBornDate.setEnabled(true);
			((JButton)jdcBornDate.getComponent(1)).setEnabled(true);
			this.jcbReproductionStatus.setEnabled(true);
			this.fillFields();
		}
		this.changeNotified = false;
	}

	@Override
	public void fillFields() {
		this.jtfName.setText(pet.getName());
		this.jcbPetType.setSelectedItem(pet.getBreed().getPetType().getName());
		this.jcbBreed.setSelectedItem(pet.getBreed().getName());
		this.jcbSex.setSelectedItem(pet.getSex());
		this.jtfColor.setText(pet.getColor());
		this.jtfSource.setText(pet.getBornPlace());
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(pet.getBornDate());
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		this.jdcBornDate.getModel().setDate(year, month, day);
		this.jdcBornDate.getModel().setSelected(true);
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			((JFormattedTextField)this.jdcBornDate.getComponent(0)).setText(format.format(pet.getBornDate()));
		} catch (Exception ex) {
			Logger.getLogger(this.getClass()).error(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Fecha de nacimiento no est� en el formato correcto", 
					"Error de conversi�n", JOptionPane.ERROR_MESSAGE);
		}
		this.jcbReproductionStatus.setSelectedItem(pet.getReproduction());
		this.changeNotified = false;
	}

	@Override
	public void updateInformation(Object pet) {
		if (pet != null) {
			this.pet = (Pet)pet;
			this.doEnableAllComponents();
		} else {
			this.pet = null;
			this.cleanAllFields();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		this.notifyDataChanged();	
	}

	@Override
	public Object getObjectDisplayed() {
		Pet petCopied = new Pet();
		if (pet != null) {
			petCopied.setIdentification(pet.getIdentification());
		}
		petCopied.setName(this.jtfName.getText());
		petCopied.setBreed(getBreedSelected());
		String petSex = this.jcbSex.getSelectedIndex() > 0 ? this.jcbSex.getSelectedItem().toString() : null;
		petCopied.setSex(petSex);
		petCopied.setColor(this.jtfColor.getText());
		petCopied.setBornPlace(this.jtfSource.getText());
		String bornDate = ((JFormattedTextField)this.jdcBornDate.getComponent(0)).getText();
		if (bornDate != null && !bornDate.equals("")) {
			try {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				petCopied.setBornDate(format.parse(bornDate));
			} catch (Exception ex) {
				Logger.getLogger(this.getClass()).error(ex.getMessage());
				JOptionPane.showMessageDialog(null, "Fecha de nacimiento no est� en el formato correcto", 
						"Error de conversi�n", JOptionPane.ERROR_MESSAGE);
			}
		}
		String reproduction = this.jcbReproductionStatus.getSelectedIndex() > 0 ? 
				this.jcbReproductionStatus.getSelectedItem().toString() : null;
		petCopied.setReproduction(reproduction);
		return petCopied;
	}

	@Override
	public Object getObjectOriginal() {
		return this.pet;
	}
}
