package co.com.carp.petcity.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import co.com.carp.petcity.controller.PetAndOwnerInfoTabController;
import co.com.carp.petcity.entity.Owner;

public class JFPetAndOwnerInfoTab extends JFrame implements ActionListener, Observer {

	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;
	
	private PetAndOwnerInfoTabController controller;
	
	/**
	 * Create the frame.
	 */
	public JFPetAndOwnerInfoTab() {
		super();
		//Initialize controller
		this.controller = new PetAndOwnerInfoTabController();
		//Get data to display in screen
		Set<Owner> ownerSet = this.controller.queryOwnerInfo("");
		//Create screen components
		this.setTitle("Pet city soft- Propietarios");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(JFPetAndOwnerInfoTab.class.getResource("/co/com/carp/petcity/image/dog1.png")));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, (int)screenSize.getWidth(), (int)screenSize.getHeight() - 40);
		//Tool bar menu
		this.add(new JTPetCityTools(JTPetCityTools.TOOLBAR_PET_OWNER_INFO), BorderLayout.NORTH);
		//Owner list to do searches
		JPSearchAndList searchAndList = new JPSearchAndList();
		searchAndList.addObserver(this);
		this.add(searchAndList.createSearchAndListSection(ownerSet, (int) screenSize.getHeight()), BorderLayout.WEST);		
		//Owner info
		JPanel jpnCentral = new JPanel();
		jpnCentral.setSize((int)screenSize.getWidth() - 260, (int) screenSize.getHeight() - 80);
		jpnCentral.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		jpnCentral.setBackground(Color.WHITE);
		Owner owner = ownerSet.size() > 0 ? (Owner) ownerSet.toArray()[0] : null;
		JPOwnerInfo jpnOwnerInfo = new JPOwnerInfo(owner);
		jpnOwnerInfo.setPreferredSize(new Dimension((int)screenSize.getWidth() - 260, (int) screenSize.getHeight() - 80));
		jpnOwnerInfo.setBackground(Color.WHITE);
		jpnCentral.add(jpnOwnerInfo);
		this.controller.keepCopyFromOwnerInfoPanel(jpnOwnerInfo);
		this.add(jpnCentral, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void update(Observable observable, Object arg) {
		this.controller.changeOwnerInOwnerInfoPanel((Owner)arg);
	}

}
