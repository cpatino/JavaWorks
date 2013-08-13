package co.com.carp.petcity.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import co.com.carp.petcity.controller.OwnerAndPetsInfoController;
import co.com.carp.petcity.entity.Owner;
import co.com.carp.petcity.entity.Pet;

/**
 * This class is attempt to be central frame from application, there you can find
 * owner and pet info, you can start a new consultation by pet and so on.
 * 
 * @author Carlos Rodriguez
 *
 */
public class JFOwnerAndPetsInfo extends JFrame {

	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Screen controller that enables communication between different panels
	 * that compose screen.
	 */
	private OwnerAndPetsInfoController controller;
	
	/**
	 * Constructor.
	 */
	public JFOwnerAndPetsInfo() {
		super();
		this.setTitle("Pet city soft- Propietarios");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(JFOwnerAndPetsInfo.class.getResource("/co/com/carp/petcity/image/dog1.png")));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		//Initialize controller
		this.controller = new OwnerAndPetsInfoController();
		//Get data to display in screen
		Set<Owner> ownerSet = this.controller.queryOwnerInfo("");
		//Create screen components		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight() - 40);
		//Owner list to do searches
		JPOwnerCardList jpOwnerCardList = new JPOwnerCardList();
		jpOwnerCardList.addObserver(this.controller);
		//Central Panel (Owner and Pet info)
		JPanel jpnCentral = new JPanel(new BorderLayout());
		jpnCentral.setSize((int)screenSize.getWidth() - 260, (int) screenSize.getHeight() - 80);
		jpnCentral.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		jpnCentral.setBackground(Color.WHITE);
		//Owner info		
		Owner owner = ownerSet.size() > 0 ? (Owner) ownerSet.toArray()[0] : null;
		JPOwnerInfo jpnOwnerInfo = new JPOwnerInfo(owner);
		jpnOwnerInfo.addObserver(this.controller);
		jpnCentral.add(jpnOwnerInfo.createOwnerInfoPanel(
				new Dimension((int)screenSize.getWidth() - 260, (int) screenSize.getHeight() - 580)), 
				BorderLayout.NORTH);
		//Pet info
		Pet pet = (Pet) owner.getPetSet().toArray()[0];
		JPPetInfo jpPetInfo = new JPPetInfo(pet);
		jpPetInfo.setPreferredSize(new Dimension((int)screenSize.getWidth() - 260, (int) screenSize.getHeight() - 600));
		jpPetInfo.setBackground(Color.WHITE);
		jpnCentral.add(jpPetInfo, BorderLayout.CENTER);
		this.controller.keepCopyFromPetInfoPanel(jpPetInfo);
		//Pet card list
		JPPetCardList jpPetCardList = new JPPetCardList();
		jpPetCardList.addObserver(this.controller);
		jpnCentral.add(jpPetCardList.createSearchAndListSection(owner.getPetSet(), (int)screenSize.getWidth() - 260), BorderLayout.SOUTH);
		this.controller.keepCopyFromPetCardPanel(jpPetCardList);
		//Add objects to frame
		JTPetCityTools jtPetCityTools = new JTPetCityTools(JTPetCityTools.TOOLBAR_PET_OWNER_INFO);
		this.controller.keepCopyFromPetCityTools(jtPetCityTools);
		this.add(jtPetCityTools, BorderLayout.NORTH);
		this.add(jpnCentral, BorderLayout.CENTER);
		this.add(jpOwnerCardList.createSearchAndListSection(ownerSet, (int) screenSize.getHeight() - 80), BorderLayout.WEST);
		this.controller.keepCopyFromOwnerInfoPanel(jpnOwnerInfo);		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
					new JDLogin().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}
