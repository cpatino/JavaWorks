package co.com.carp.petcity.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.border.BevelBorder;

import co.com.carp.petcity.entity.Pet;
import co.com.carp.petcity.entity.PetBreed;

/**
 * This class is attempt to manage all pet information being displayed on card list.
 * 
 * @author Carlos Rodriguez
 *
 */
public class JPPetCardList extends Observable implements ActionListener, ObjectCardListable {
	
	/**
	 * {@link Pet} {@link Set} that will be displayed on screen.
	 */
	private Set<Pet> petSet;
	
	/**
	 * {@link JPanel} with all components to be displayed.
	 */
	private JPanel jpSearchAndList;
	
	@SuppressWarnings("unchecked")
	@Override
	public JPanel createSearchAndListSection(Set<?> petSet, int width) {
		this.petSet = (Set<Pet>) petSet;
		this.jpSearchAndList = new JPanel();
		this.jpSearchAndList.setLayout(new BorderLayout());
		this.jpSearchAndList.setSize(new Dimension(width, 80));
		JScrollPane jspScroll = new JScrollPane(this.buildViewPort()
				, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jspScroll.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		jspScroll.setAutoscrolls(true);
		this.jpSearchAndList.add(jspScroll, BorderLayout.CENTER);
		return jpSearchAndList;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		int id = Integer.parseInt(((JButton)event.getSource()).getName());
		for (Pet pet : petSet) {
			if (pet.getIdentification() == id) {
				setChanged();
				notifyObservers(pet);
				break;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateCards(Set<?> objectSet) {
		this.petSet = (Set<Pet>) objectSet;
		this.refreshCardList();	
	}

	@Override
	public JPanel buildViewPort() {
		JPanel jpViewPort = new JPanel(null);
		jpViewPort.setBackground(Color.WHITE);
		int cardWidth = petSet != null ? 160 * petSet.size() : 80;
		jpViewPort.setPreferredSize(new Dimension(cardWidth, 80));
		jpViewPort.setBackground(Color.WHITE);
		
		int xForNextSubPanel = 0;
		int cont = 0;
		if (petSet != null && petSet.size() > 0) {
			for (Pet pet : petSet) {
				JPanel subPanel = this.createCard(pet);
				subPanel.setBounds(xForNextSubPanel, 0, 160, 80);
				xForNextSubPanel += 160;
	
				jpViewPort.add(subPanel);
				if (cont % 2 == 1) {
					subPanel.setBackground(new Color(220, 220, 200));
				}
				cont++;
			}
		}			
		return jpViewPort;
	}

	@Override
	public JPanel createCard(Object object) {
		Pet pet = (Pet)object;
		JPanel jpPetCard = new JPanel();
		jpPetCard.setLayout(null);
		Font verdanaBold = new Font("Verdana", Font.BOLD, 12);
		Font verdanaPlain = new Font("Verdana", Font.PLAIN, 12);
		
		JLabel jlbPetName = new JLabel("" + pet.getName());
		jlbPetName.setFont(verdanaBold);
		jlbPetName.setBounds(10, 10, 90, 20);
		jpPetCard.add(jlbPetName);
		PetBreed breed = pet.getType().getBreedMap().get(pet.getType().getBreedSelected());
		JLabel jlbPetBreed = new JLabel(breed.getName());
		jlbPetBreed.setFont(verdanaBold);
		jlbPetBreed.setBounds(10, 30, 160, 20);
		jpPetCard.add(jlbPetBreed);
		
		JButton jbtViewDetail = new JButton("Ver");
		jbtViewDetail.setName(pet.getIdentification() + "");
		jbtViewDetail.setFont(verdanaPlain);
		jbtViewDetail.setBounds(10, 50, 40, 20);
		jbtViewDetail.addActionListener(this);
		jbtViewDetail.setBackground(new Color(255, 100, 0));
		jbtViewDetail.setForeground(Color.WHITE);
		jpPetCard.add(jbtViewDetail);
		return jpPetCard;
	}

	@Override
	public void refreshCardList() {
		JScrollPane jspScroll = (JScrollPane)this.jpSearchAndList.getComponent(0);
		JViewport jvpViewPort = jspScroll.getViewport();
		jvpViewPort.removeAll();
		jvpViewPort.add(this.buildViewPort());		
		this.jpSearchAndList.add(jspScroll, BorderLayout.CENTER, 0);
		this.jpSearchAndList.updateUI();
	}

}
