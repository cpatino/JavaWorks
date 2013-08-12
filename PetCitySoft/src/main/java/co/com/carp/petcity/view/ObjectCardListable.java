package co.com.carp.petcity.view;

import java.util.Set;

import javax.swing.JPanel;

/**
 * This interface is attempt to control those panels that are card list, 
 * it will help to build the list of cards and provides an easy way to 
 * manage update on information been displayed.
 * 
 * @author Carlos Rodriguez
 *
 */
public interface ObjectCardListable {
	
	/**
	 * It creates a panel that contains object card list.
	 * 
	 * @param objectSet {@link Object} {@link Set} that will be used to create object cards.
	 * @param allowedDimension allowedDimension that must have the panels that will be created.
	 * @return {@link JPanel} Panel with a list all object cards.
	 */
	JPanel createSearchAndListSection(Set<?> objectSet, int allowedDimension);
	
	/**
	 * It allows update card list
	 * 
	 * @param objectSet New {@link Set} to be displayed as card list.
	 */
	void updateCards(Set<?> objectSet);
	
	/**
	 * It builds a panel that is used as view port to display card list.
	 * 
	 * @return {@link JPanel} A panel that have all cards.
	 */
	JPanel buildViewPort();
	
	/**
	 * It creates each one of cards displayed on screen.
	 * 
	 * @param object {@link Object} that will provided information to be used to create card.
	 * @return {@link JPanel} A panel (Card) with all information related to object
	 * 			that will be displayed.
	 */
	JPanel createCard(Object object);
	
	/**
	 * It removes and adds all cards when selected data has been changed.
	 */
	void refreshCardList();

}
