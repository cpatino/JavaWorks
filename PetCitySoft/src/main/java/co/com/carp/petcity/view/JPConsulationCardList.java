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
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.border.BevelBorder;

import co.com.carp.petcity.entity.MedicalConsultation;

/**
 * This class is attempt to manage all consultation information being displayed on card list.
 * 
 * @author Carlos Rodriguez
 *
 */
public class JPConsulationCardList extends Observable implements ActionListener, ObjectCardListable {
	
	/**
	 * {@link JTextField} that will be parameter to be search when client wants to change information
	 * displayed on the list.
	 */
	private JTextField jtfSearch;
	
	/**
	 * {@link MedicalConsultation} {@link Set} that will be displayed on screen.
	 */
	private Set<MedicalConsultation> consultationSet;
	
	/**
	 * {@link JPanel} with all components to be displayed.
	 */
	private JPanel jpSearchAndList;
	
	@SuppressWarnings("unchecked")
	@Override
	public JPanel createSearchAndListSection(Set<?> consulationSet, int height) {
		this.consultationSet = (Set<MedicalConsultation>) consulationSet;
		this.jpSearchAndList = new JPanel();
		this.jpSearchAndList.setLayout(new BorderLayout());
		this.jpSearchAndList.setSize(new Dimension(250, height));		
		
		JPanel jpnSubPanelSearch = new JPanel(null);
		jpnSubPanelSearch.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.GRAY));
		jpnSubPanelSearch.setPreferredSize(new Dimension(240, 65));
		jpnSubPanelSearch.setBackground(new Color(34, 139, 34));
		
		jtfSearch = new JTextField();
		jtfSearch.setBounds(5, 10, 230, 20);
		jpnSubPanelSearch.add(jtfSearch);
		JButton jbtSearch = new JButton("BUSCAR");
		jbtSearch.setForeground(new Color(255, 255, 255));
		jbtSearch.setBounds(145, 35, 89, 23);
		jbtSearch.setBackground(new Color(30, 144, 255));
		jbtSearch.setFont(new Font("Verdana", Font.BOLD, 12));
		jbtSearch.addActionListener(this);
		jpnSubPanelSearch.add(jbtSearch);				
				
		JScrollPane jspScroll = new JScrollPane(this.buildViewPort()
				, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jspScroll.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		jspScroll.setAutoscrolls(true);	
		
		this.jpSearchAndList.add(jpnSubPanelSearch, BorderLayout.NORTH);
		this.jpSearchAndList.add(jspScroll, BorderLayout.CENTER);
		return this.jpSearchAndList;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getActionCommand().equals("Ver")) {
			int id = Integer.parseInt(((JButton)evt.getSource()).getName());
			for (MedicalConsultation consultation : consultationSet) {
				if (consultation.getIdentification() == id) {
					setChanged();
					notifyObservers(consultation);
					break;
				}
			}			
		} else if (evt.getActionCommand().equals("BUSCAR")) {
			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void updateCards(Set<?> objectSet) {
		this.consultationSet = (Set<MedicalConsultation>) objectSet;
		this.refreshCardList();
	}

	@Override
	public JPanel buildViewPort() {
		JPanel jpViewPort = new JPanel(null);
		jpViewPort.setBackground(Color.WHITE);
		int height = consultationSet != null ? 80 * consultationSet.size() : 80;
		jpViewPort.setPreferredSize(new Dimension(230, height));
		jpViewPort.setBackground(Color.WHITE);
		
		int yForNextSubPanel = 0;
		int cont = 0;
		if (consultationSet != null && consultationSet.size() > 0) {
			for (MedicalConsultation consultation : consultationSet) {
				JPanel subPanel = this.createCard(consultation);
				subPanel.setBounds(0, yForNextSubPanel, 230, 80);
				yForNextSubPanel = yForNextSubPanel + 80;
	
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
		MedicalConsultation consultation = (MedicalConsultation) object;
		JPanel jpOwnerCard = new JPanel();
		jpOwnerCard.setLayout(null);
		Font verdanaBold = new Font("Verdana", Font.BOLD, 12);
		Font verdanaPlain = new Font("Verdana", Font.PLAIN, 12);
		
		JLabel jlbDate = new JLabel(consultation.getConsultationDate().toString());
		jlbDate.setFont(verdanaBold);
		jlbDate.setBounds(10, 10, 90, 20);
		jpOwnerCard.add(jlbDate);
		
		JLabel jlbMotive = new JLabel(consultation.getMotive());
		jlbMotive.setFont(verdanaBold);
		jlbMotive.setBounds(10, 30, 160, 20);
		jpOwnerCard.add(jlbMotive);
		
		JButton jbtViewDetail = new JButton("Ver");
		jbtViewDetail.setName(consultation.getIdentification() + "");
		jbtViewDetail.setFont(verdanaPlain);
		jbtViewDetail.setBounds(170, 50, 40, 20);
		jbtViewDetail.addActionListener(this);
		jbtViewDetail.setBackground(new Color(255, 100, 0));
		jbtViewDetail.setForeground(Color.WHITE);
		jpOwnerCard.add(jbtViewDetail);
		return jpOwnerCard;
	}

	@Override
	public void refreshCardList() {
		JScrollPane jspScroll = (JScrollPane)this.jpSearchAndList.getComponent(1);
		JViewport jvpViewPort = jspScroll.getViewport();
		jvpViewPort.removeAll();
		jvpViewPort.add(this.buildViewPort());		
		this.jpSearchAndList.add(jspScroll, BorderLayout.CENTER, 0);
		this.jpSearchAndList.updateUI();
	}
}
