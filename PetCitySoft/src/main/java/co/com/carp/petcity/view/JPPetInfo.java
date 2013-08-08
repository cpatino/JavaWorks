package co.com.carp.petcity.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import co.com.carp.petcity.entity.Pet;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;

public class JPPetInfo extends JPanel implements ActionListener {	
	
	/**
	 * Auto-generated serial version
	 */
	private static final long serialVersionUID = -1250251333816555407L;
	
	private Pet pet;

	private JTextField jtfName;
	
	private JComboBox<String> jcbKind;
	
	private JComboBox<String> jcbSex;
	
	private JComboBox<String> jcbBreed;
	
	private JTextField jtfColor;
	
	private JDatePickerImpl jdcBornDate;
	
	private JTextField jtfSource;
	
	private JTextField jtfWeight;
	
	private JTextField jtfDiet;
	
	private JTextField jtfCorporalCondition;
	
	private JTextField jtfDewormingProduct;
	
	private JDatePickerImpl jdcDewormingDate;
	
	private JComboBox<String> jcbReproduction;
	
	private JButton jbtLoadImage;
	
	public JPPetInfo(Pet pet) {
		super();
		this.pet = pet;
		this.setLayout(null);
		Font verdanaBold = new Font("Verdana", Font.BOLD, 12);
		Font verdanaPlain = new Font("Verdana", Font.PLAIN, 12);
		
		JPanel jpnTitle = new JPanel(null);
		jpnTitle.setBounds(10, 10, 730, 40);
		jpnTitle.setBackground(new Color(34, 139, 34));
		jpnTitle.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel jlTitle = new JLabel("DATOS MASCOTA");
		jlTitle.setFont(verdanaBold);
		jlTitle.setBounds(250, 10, 300, 20);
		jlTitle.setForeground(Color.WHITE);
		jpnTitle.add(jlTitle);
		
		this.add(jpnTitle);
		this.add(this.drawnGeneralDataPanel(verdanaBold, verdanaPlain));
		this.add(this.drawnFeedTypeDataPanel(verdanaBold, verdanaPlain));
		this.add(this.drawnOthersDataPanel(verdanaBold, verdanaPlain));
		this.add(this.drawnPetImagePanel());
		this.add(this.drawnImageActionPanel(verdanaBold, verdanaPlain));
		
		//Inicializar deshabilitados todos los componentes para no permitir editarlos.
		this.initializeDisableAllComponents();
		this.fillFields();
	}
	
	private JPanel drawnGeneralDataPanel(Font verdanaBold, Font verdanaPlain) {
		JPanel jpnGeneralDetail = new JPanel(null);
		jpnGeneralDetail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jpnGeneralDetail.setBounds(10, 70, 360, 230);
		jpnGeneralDetail.setBackground(new Color(250, 245, 245));
		
		JLabel jlbPetName = new JLabel("Nombre:");
		jlbPetName.setBounds(10, 10, 100, 20);
		jlbPetName.setFont(verdanaBold);
		jtfName = new JTextField();
		jtfName.setBounds(150, 10, 200, 20);
		jtfName.setFont(verdanaPlain);
		jpnGeneralDetail.add(jlbPetName);
		jpnGeneralDetail.add(jtfName);
		
		JLabel jlbPetKind = new JLabel("Especie:");
		jlbPetKind.setBounds(10, 40, 100, 20);
		jlbPetKind.setFont(verdanaBold);
		jcbKind = new JComboBox<String>(new String[]{"Seleccione uno"});
		jcbKind.setBounds(150, 40, 200, 20);
		jcbKind.setFont(verdanaPlain);
		jcbKind.addActionListener(this);
		jpnGeneralDetail.add(jlbPetKind);
		jpnGeneralDetail.add(jcbKind);
		
		JLabel jlbPetBreed = new JLabel("Raza:");
		jlbPetBreed.setBounds(10, 70, 100, 20);
		jlbPetBreed.setFont(verdanaBold);
		jcbBreed = new JComboBox<String>(new String[]{"Seleccione uno"});
		jcbBreed.setBounds(150, 70, 200, 20);
		jcbBreed.setFont(verdanaPlain);
		jpnGeneralDetail.add(jlbPetBreed);
		jpnGeneralDetail.add(jcbBreed);
		
		JLabel jlbPetSex = new JLabel("Sexo:");
		jlbPetSex.setBounds(10, 100, 100, 20);
		jlbPetSex.setFont(verdanaBold);
		jcbSex = new JComboBox<String>(new String[]{"Seleccione uno", "Macho", "Hembra"});
		jcbSex.setBounds(150, 100, 200, 20);
		jcbSex.setFont(verdanaPlain);
		jpnGeneralDetail.add(jlbPetSex);
		jpnGeneralDetail.add(jcbSex);
		
		JLabel jlbPetColor = new JLabel("Color:");
		jlbPetColor.setBounds(10, 130, 100, 20);
		jlbPetColor.setFont(verdanaBold);
		jtfColor = new JTextField();
		jtfColor.setBounds(150, 130, 200, 20);
		jtfColor.setFont(verdanaPlain);
		jpnGeneralDetail.add(jlbPetColor);
		jpnGeneralDetail.add(jtfColor);
		
		JLabel jlbPetBornDate = new JLabel("Fecha de nacimiento:");
		jlbPetBornDate.setBounds(10, 160, 150, 20);
		jlbPetBornDate.setFont(verdanaBold);
		jdcBornDate = new JDatePickerImpl(new JDatePanelImpl(new UtilCalendarModel()));
		jdcBornDate.getModel().setDate(Calendar.getInstance().get(Calendar.YEAR), 
				Calendar.getInstance().get(Calendar.MONTH), 
				Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		((JButton)jdcBornDate.getComponent(1)).setIcon(new ImageIcon(JPPetInfo.class.getResource("/co/com/carp/petcity/image/calendar.png")));
		((JButton)jdcBornDate.getComponent(1)).setText("");
		((Component) jdcBornDate).setBounds(150, 160, 170, 25);
		jpnGeneralDetail.add(jlbPetBornDate);
		jpnGeneralDetail.add((Component) jdcBornDate);
		
		JLabel jlbPetSource = new JLabel("Procedencia:");
		jlbPetSource.setBounds(10, 190, 150, 20);
		jlbPetSource.setFont(verdanaBold);
		jtfSource = new JTextField();
		jtfSource.setBounds(150, 190, 200, 20);
		jtfSource.setFont(verdanaPlain);
		jpnGeneralDetail.add(jlbPetSource);
		jpnGeneralDetail.add(jtfSource);
		
		return jpnGeneralDetail;
	}
	
	private JPanel drawnFeedTypeDataPanel(Font verdanaBold, Font verdanaPlain) {
		JPanel jpnFeedType = new JPanel(null);
		jpnFeedType.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jpnFeedType.setBounds(10, 305, 360, 80);
		jpnFeedType.setBackground(new Color(250, 245, 245));
		
		JLabel jlbPetWeight = new JLabel("Peso:");
		jlbPetWeight.setBounds(10, 10, 100, 20);
		jlbPetWeight.setFont(verdanaBold);
		jtfWeight = new JTextField();
		jtfWeight.setBounds(110, 10, 60, 20);
		jtfWeight.setFont(verdanaPlain);
		JLabel jlbPetWeightComp = new JLabel("Kg");
		jlbPetWeightComp.setBounds(175, 10, 20, 20);
		jlbPetWeightComp.setFont(verdanaBold);
		jpnFeedType.add(jlbPetWeight);
		jpnFeedType.add(jtfWeight);
		jpnFeedType.add(jlbPetWeightComp);
		
		JLabel jlbPetDiet = new JLabel("Alimentación:");
		jlbPetDiet.setBounds(10, 40, 100, 20);
		jlbPetDiet.setFont(verdanaBold);
		jtfDiet = new JTextField();
		jtfDiet.setBounds(110, 40, 240, 20);
		jtfDiet.setFont(verdanaPlain);
		jpnFeedType.add(jlbPetDiet);
		jpnFeedType.add(jtfDiet);
		
		return jpnFeedType;
	}
	
	private JPanel drawnOthersDataPanel(Font verdanaBold, Font verdanaPlain) {
		JPanel jpnOthersData = new JPanel(null);
		jpnOthersData.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jpnOthersData.setBounds(10, 390, 360, 130);
		jpnOthersData.setBackground(new Color(250, 245, 245));
		
		JLabel jlbPetCorporalCondition = new JLabel("Condición corporal:");
		jlbPetCorporalCondition.setBounds(10, 10, 150, 20);
		jlbPetCorporalCondition.setFont(verdanaBold);
		jtfCorporalCondition = new JTextField();
		jtfCorporalCondition.setBounds(170, 10, 60, 20);
		jtfCorporalCondition.setFont(verdanaPlain);
		jpnOthersData.add(jlbPetCorporalCondition);
		jpnOthersData.add(jtfCorporalCondition);
		
		JLabel jlbPetlastDeworming = new JLabel("Desparasitado con:");
		jlbPetlastDeworming.setBounds(10, 40, 170, 20);
		jlbPetlastDeworming.setFont(verdanaBold);
		jtfDewormingProduct = new JTextField();
		jtfDewormingProduct.setBounds(170, 40, 180, 20);
		jtfDewormingProduct.setFont(verdanaPlain);
		jpnOthersData.add(jlbPetlastDeworming);
		jpnOthersData.add(jtfDewormingProduct);
		
		JLabel jlbDewormingDate = new JLabel("Fecha desparasitación:");
		jlbDewormingDate.setBounds(10, 70, 170, 20);
		jlbDewormingDate.setFont(verdanaBold);
		jdcDewormingDate = new JDatePickerImpl(new JDatePanelImpl(new UtilCalendarModel()));
		jdcDewormingDate.getModel().setDate(Calendar.getInstance().get(Calendar.YEAR), 
				Calendar.getInstance().get(Calendar.MONTH), 
				Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		((JButton)jdcDewormingDate.getComponent(1)).setIcon(new ImageIcon(JPPetInfo.class.getResource("/co/com/carp/petcity/image/calendar.png")));
		((JButton)jdcDewormingDate.getComponent(1)).setText("");
		((Component) jdcDewormingDate).setBounds(170, 70, 170, 25);
		jpnOthersData.add(jlbDewormingDate);
		jpnOthersData.add((Component) jdcDewormingDate);
		
		JLabel jlbPetReproduction = new JLabel("Reproducción:");
		jlbPetReproduction.setBounds(10, 100, 150, 20);
		jlbPetReproduction.setFont(verdanaBold);
		jcbReproduction = new JComboBox<String>(new String[]{"Seleccione uno", "Entero", "Esterilizado", "1 a 2 partos", "3 a 4 partos", "5 a 6 partos"});
		jcbReproduction.setBounds(170, 100, 180, 20);
		jcbReproduction.setFont(verdanaPlain);
		jpnOthersData.add(jlbPetReproduction);
		jpnOthersData.add(jcbReproduction);
		
		return jpnOthersData;
	}
	
	private JPanel drawnPetImagePanel() {
		JPanel jpnPetImage = new JPanel(new BorderLayout());
		jpnPetImage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jpnPetImage.setBounds(380, 70, 360, 390);
		jpnPetImage.setBackground(new Color(250, 245, 245));
		
		JLabel jlbPhoto = new JLabel(new ImageIcon(JPPetInfo.class.getResource("/co/com/carp/petcity/image/background-white.png")));
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().add(jlbPhoto);
		jpnPetImage.add(scrollPane, BorderLayout.CENTER);
		return jpnPetImage;
	}
	
	private JPanel drawnImageActionPanel(Font verdanaBold, Font verdanaPlain) {
		JPanel jpnPetImageActions = new JPanel(null);
		jpnPetImageActions.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jpnPetImageActions.setBounds(380, 470, 360, 50);
		jpnPetImageActions.setBackground(new Color(250, 245, 245));
		
		jbtLoadImage = new JButton("Cargar imagen");
		jbtLoadImage.setBounds(240, 10, 100, 30);
		jbtLoadImage.addActionListener(this);
		jpnPetImageActions.add(jbtLoadImage);
		
		return jpnPetImageActions;
	}
	
	private void initializeDisableAllComponents() {
		this.jtfName.setEditable(false);
		this.jcbKind.setEnabled(false);
		this.jcbSex.setEnabled(false);
		this.jcbBreed.setEnabled(false);
		this.jtfColor.setEditable(false);
		this.jdcBornDate.setEnabled(false);
		((JButton)jdcBornDate.getComponent(1)).setEnabled(false);
		this.jtfSource.setEditable(false);
		this.jtfWeight.setEditable(false);
		this.jtfDiet.setEditable(false);
		this.jtfCorporalCondition.setEditable(false);
		this.jtfDewormingProduct.setEditable(false);
		jdcDewormingDate.setEnabled(false);
		((JButton)jdcDewormingDate.getComponent(1)).setEnabled(false);
		this.jcbReproduction.setEnabled(false);
		this.jbtLoadImage.setEnabled(false);
	}
	
	/**
	 * It fills text fields with the pet information.
	 */
	private void fillFields() {
		this.jtfName.setText(pet.getName());
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
	}
}

