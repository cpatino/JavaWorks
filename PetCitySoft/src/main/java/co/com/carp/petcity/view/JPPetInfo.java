package co.com.carp.petcity.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;
import co.com.carp.petcity.entity.Pet;
import co.com.carp.petcity.entity.PetType;

/**
 * This class is attempt to manage information from pets, those information can be inserted, updated.
 * 
 * @author Carlos Rodriguez
 *
 */
public class JPPetInfo extends JPanel implements ActionListener, InformationPanelFillable {

	/**
	 * Auto-generated serial version
	 */
	private static final long serialVersionUID = -1250251333816555407L;

	/**
	 * {@link Pet} actually been displayed on screen.
	 */
	private Pet pet;

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
	 * {@link JComboBox} with ; values displayed dependents from 
	 * selection done on {@link PetType}(s) {@link JComboBox}.
	 */
	private JComboBox<String> jcbBreed;

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
	 * Constructor
	 * 
	 * @param pet {@link Pet} to displayed in screen.
	 */
	public JPPetInfo(Pet pet) {
		super();
		this.pet = pet;
		this.setLayout(null);
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

		this.add(jpnTitle);
		this.add(this.createInfoPanel(verdanaBold, verdanaPlain));
		this.add(this.createPetImagePanel());
		this.add(this.createImageActionPanel(verdanaBold, verdanaPlain));

		this.fillFields();
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
		jpnPetImageActions.setBounds(540, 250, 200, 40);
		jpnPetImageActions.setBackground(new Color(250, 245, 245));

		JButton jbtLoadImage = new JButton("Cargar imagen");
		jbtLoadImage.setForeground(new Color(255, 255, 255));
		jbtLoadImage.setBackground(new Color(30, 144, 255));
		jbtLoadImage.setFont(new Font("Verdana", Font.BOLD, 12));
		jbtLoadImage.setBounds(70, 10, 120, 20);
		jbtLoadImage.addActionListener(this);
		jpnPetImageActions.add(jbtLoadImage);

		return jpnPetImageActions;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

	}

	@Override
	public JPanel createInfoPanel(Font verdanaBold, Font verdanaPlain) {
		JPanel jpnGeneralDetail = new JPanel(null);
		jpnGeneralDetail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jpnGeneralDetail.setBounds(10, 45, 525, 245);
		jpnGeneralDetail.setBackground(new Color(250, 245, 245));

		JLabel jlbPetName = new JLabel("Nombre:");
		jlbPetName.setBounds(10, 10, 145, 20);
		jlbPetName.setFont(verdanaBold);
		jlbPetName.setHorizontalAlignment(SwingConstants.RIGHT);
		jtfName = new JTextField();
		jtfName.setBounds(160, 10, 250, 20);
		jtfName.setFont(verdanaPlain);
		jpnGeneralDetail.add(jlbPetName);
		jpnGeneralDetail.add(jtfName);

		JLabel jlbPetKind = new JLabel("Especie:");
		jlbPetKind.setBounds(10, 40, 145, 20);
		jlbPetKind.setFont(verdanaBold);
		jlbPetKind.setHorizontalAlignment(SwingConstants.RIGHT);
		jcbPetType = new JComboBox<String>(new String[] { "Seleccione uno..." });
		jcbPetType.setBounds(160, 40, 200, 20);
		jcbPetType.setFont(verdanaPlain);
		jcbPetType.addActionListener(this);
		jpnGeneralDetail.add(jlbPetKind);
		jpnGeneralDetail.add(jcbPetType);

		JLabel jlbPetBreed = new JLabel("Raza:");
		jlbPetBreed.setBounds(10, 70, 145, 20);
		jlbPetBreed.setFont(verdanaBold);
		jlbPetBreed.setHorizontalAlignment(SwingConstants.RIGHT);
		jcbBreed = new JComboBox<String>(new String[] { "Seleccione uno..." });
		jcbBreed.setBounds(160, 70, 200, 20);
		jcbBreed.setFont(verdanaPlain);
		jpnGeneralDetail.add(jlbPetBreed);
		jpnGeneralDetail.add(jcbBreed);

		JLabel jlbPetSex = new JLabel("Sexo:");
		jlbPetSex.setBounds(10, 100, 145, 20);
		jlbPetSex.setFont(verdanaBold);
		jlbPetSex.setHorizontalAlignment(SwingConstants.RIGHT);
		jcbSex = new JComboBox<String>(new String[] { "Seleccione uno...",
				"Macho", "Hembra" });
		jcbSex.setBounds(160, 100, 130, 20);
		jcbSex.setFont(verdanaPlain);
		jpnGeneralDetail.add(jlbPetSex);
		jpnGeneralDetail.add(jcbSex);

		JLabel jlbPetColor = new JLabel("Color:");
		jlbPetColor.setBounds(10, 130, 145, 20);
		jlbPetColor.setFont(verdanaBold);
		jlbPetColor.setHorizontalAlignment(SwingConstants.RIGHT);
		jtfColor = new JTextField();
		jtfColor.setBounds(160, 130, 250, 20);
		jtfColor.setFont(verdanaPlain);
		jpnGeneralDetail.add(jlbPetColor);
		jpnGeneralDetail.add(jtfColor);

		JLabel jlbPetSource = new JLabel("Procedencia:");
		jlbPetSource.setBounds(10, 160, 145, 20);
		jlbPetSource.setFont(verdanaBold);
		jlbPetSource.setHorizontalAlignment(SwingConstants.RIGHT);
		jtfSource = new JTextField();
		jtfSource.setBounds(160, 160, 250, 20);
		jtfSource.setFont(verdanaPlain);
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
		((Component) jdcBornDate).setBounds(160, 190, 100, 25);
		jpnGeneralDetail.add(jlbPetBornDate);
		jpnGeneralDetail.add((Component) jdcBornDate);

		return jpnGeneralDetail;
	}

	@Override
	public void cleanAllFields() {
		this.jtfName.setText("");
	}

	@Override
	public void initializeDisableAllComponents() {
		if (this.pet == null) {
			this.jtfName.setEnabled(false);
		}
	}

	@Override
	public void doEnableAllComponents() {
		if (this.pet != null) {
			this.jtfName.setEnabled(true);
		}
	}

	@Override
	public void fillFields() {
		this.jtfName.setText(pet.getName());
	}

	@Override
	public boolean updateInformation(Object pet) {
		boolean canReplace = false;
		if (!this.pet.equals((Pet)pet)) {
			this.pet = (Pet)pet;
			if (pet == null) {
				this.initializeDisableAllComponents();
			} else {
				this.doEnableAllComponents();
				this.fillFields();
			}
			canReplace = true;
		}
		return canReplace;
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
		// TODO Auto-generated method stub		
	}

	@Override
	public Object getObjectDisplayed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObjectOriginal() {
		// TODO Auto-generated method stub
		return null;
	}
}
