package co.com.carp.petcity.view;

import java.util.Set;

import javax.swing.JPanel;

public interface ObjectCardListable {
	
	/**
	 * It allows update card list
	 * 
	 * @param objectSet New set to be displayed as card list.
	 */
	void updateCards(Set<?> objectSet);
	
	/**
	 * It builds a panel that is used as view port to display card list.
	 * 
	 * @return JPanel A panel that have all cards.
	 */
	JPanel buildViewPort();
	
	/**
	 * It creates each one of cards displayed on screen.
	 * 
	 * @param object Object that will provided information to be used to create card.
	 * @return JPanel A panel (Card) with all information related to object
	 * 			that will be displayed.
	 */
	JPanel createCard(Object object);
	
	/**
	 * It removes and adds all cards when selected data has been changed.
	 */
	void refreshCardList();

}
