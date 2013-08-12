package co.com.carp.petcity.view;

import java.awt.Font;

import javax.swing.JPanel;

/**
 * This interfaces is attempt to control those panels that allows fill information, and 
 * this is done because information can be changed in any time. When the information
 * for screen requires an update, controller notifies that, and panel will decide what is
 * the next step to be executed. 
 * 
 * @author Carlos Rodriguez
 *
 */
public interface InformationPanelFillable {
	
	/**
	 * It creates information panel with all fields required.
	 * 
	 * @param verdanaBold Verdana font in bold.
	 * @param verdanaPlain Verdana font plain.
	 * 
	 * @return {@link JPanel} with all fields instantiated.
	 */
	JPanel createInfoPanel(Font verdanaBold, Font verdanaPlain);
	
	/**
	 * It sets default value to all fields on screen.
	 */
	void cleanAllFields();
	
	/**
	 * When screen doesn't have information to be displayed, all fields become disabled. 
	 */
	void initializeDisableAllComponents();
	
	/**
	 * It does enable all fields. 
	 */
	void doEnableAllComponents();
	
	/**
	 * It fills fields with information.
	 */
	void fillFields();
	
	/**
	 * It tries to update information being displayed.
	 * 
	 * @param object {@link Object} with new information to be displayed.
	 * @return True if information can be updated, false otherwise.
	 */
	boolean updateInformation(Object object);

}
