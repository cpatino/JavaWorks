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
	 * Tool bar used in {@link JFOwnerAndPetsInfo} screens. 
	 */
	public static final int TOOLBAR_PET_OWNER_INFO = 1;
	
	public JTPetCityTools(int idToolBar) {
		if (TOOLBAR_PET_OWNER_INFO == idToolBar) {
			this.setIdToolBarUsed(idToolBar);
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
	 * @param idToolBarUsed the idToolBarUsed to set
	 */
	public void setIdToolBarUsed(int idToolBarUsed) {
		this.idToolBarUsed = idToolBarUsed;
	}

	/**
	 * Creates a new pet and owner tool bar, and it enables its buttons to receive the users' interaction. 
	 */
	public void createPetAndOwnerToolBar() {
		JButton jbtNew = new JButton(new ImageIcon(JTPetCityTools.class.getResource("/co/com/carp/petcity/image/add_tb_button.png")));
		jbtNew.addActionListener(this);
		this.add(jbtNew);
		this.addSeparator();
		JButton jbtSave = new JButton(new ImageIcon(JTPetCityTools.class.getResource("/co/com/carp/petcity/image/disk_blue_tb_button.png")));
		jbtSave.addActionListener(this);
		this.add(jbtSave);
		this.addSeparator();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
