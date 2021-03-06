package co.com.carp.petcity.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import co.com.carp.petcity.controller.ClinicHistorySummaryController;
import co.com.carp.petcity.entity.Pet;

/**
 * This class is attempt to be a summary from pet's clinic history,
 * it will contains information about drenching, food, vaccines, weight control
 * and so on.
 * 
 * @author Carlos Rodriguez
 *
 */
public class JDClinicHistorySummary extends JDialog {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = -5830527480419989055L;
	
	/**
	 * Constructor
	 * 
	 * @param pet {@link Pet} used to display clinic history information.
	 */
	public JDClinicHistorySummary(Pet pet) {
		super();
		ClinicHistorySummaryController controller = new ClinicHistorySummaryController();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight() - 40);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(JFOwnerAndPetsInfo.class.getResource("/co/com/carp/petcity/image/dog1.png")));
		this.setLayout(new BorderLayout());
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setTitle("Pet city soft- Resumen historia clinica");
		
		JPConsulationCardList jpConsultCardList = new JPConsulationCardList();
		jpConsultCardList.addObserver(controller);
		this.add(jpConsultCardList.createSearchAndListSection(null, (int) screenSize.getHeight() - 80), BorderLayout.WEST);
		this.add(createSummaryFrame(pet, controller), BorderLayout.CENTER);
	}
	
	/**
	 * It will create a new {@link JFrame} with all summary information about 
	 * pet's clinic history, it will be placed on center position of screen.  
	 * 
	 * @param pet {@link Pet} used to display clinic history information.
	 * @param controller {@link ClinicHistorySummaryController} that will be observing for changes
	 * on {@link JPanel}(s) that will help to display information.
	 * 
	 * @return {@link JPanel} with all data to be displayed on the center of screen.
	 */
	private JPanel createSummaryFrame(Pet pet, ClinicHistorySummaryController controller) {
		JPanel jpnCentral = new JPanel(new GridLayout(2, 2, 15, 15));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		jpnCentral.setSize((int)screenSize.getWidth() - 260, (int) screenSize.getHeight() - 80);
		jpnCentral.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		jpnCentral.setBackground(Color.WHITE);
		//Creates resume for pet weight section
		JPTablePetWeight jpPetWeight = new JPTablePetWeight(null);
		jpnCentral.add(createTablePanelWithTitle("Resum�n de condici�n de la mascota", jpPetWeight.getTabPanel()));
		//Creates resume for pet food section
		JPTablePetFood jpPetFood = new JPTablePetFood(null);
		jpnCentral.add(createTablePanelWithTitle("Resum�n de comidas de la mascota", jpPetFood.getTabPanel()));
		//Creates resume for pet vaccine section
		JPTablePetVaccine jpPetVaccine = new JPTablePetVaccine(null);
		jpnCentral.add(createTablePanelWithTitle("Resum�n de vacunas de la mascota", jpPetVaccine.getTabPanel()));
		//Create resume for pet drenching section
		JPTablePetDrenching jpPetDrenching = new JPTablePetDrenching(null);
		jpnCentral.add(createTablePanelWithTitle("Resum�n de desparasitaciones de la mascota", jpPetDrenching.getTabPanel()));
		return jpnCentral;
	}
	
	/**
	 * It creates a new {@link JPanel} that have a title to describe the information
	 * from the table being displayed.
	 * 
	 * @param title {@link String} that will be displayed as title.
	 * @param tabPanel {@link JPanel} that will display data as table.
	 * @return {@link JPanel} with a title.
	 */
	private JPanel createTablePanelWithTitle(String title, JPanel tabPanel) {
		JPanel jpnTitle = new JPanel(new GridLayout(1,1));
		jpnTitle.setSize(200, 40);
		jpnTitle.setBackground(new Color(34, 139, 34));
		jpnTitle.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel jlTitle = new JLabel(title);
		jlTitle.setFont(new Font("Verdana", Font.BOLD, 12));
		jlTitle.setForeground(Color.WHITE);
		jpnTitle.add(jlTitle);
		JPanel jpToAdd = new JPanel(new BorderLayout());
		jpToAdd.add(jpnTitle, BorderLayout.NORTH);
		jpToAdd.add(tabPanel, BorderLayout.CENTER);
		return jpToAdd;
	}

}
