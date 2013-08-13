package co.com.carp.petcity.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import co.com.carp.petcity.entity.Owner;

/**
 * This class is attempt to manage information from owners, those information can be inserted, updated.
 * 
 * @author Carlos Rodriguez
 *
 */
public class JPOwnerInfo extends Observable implements InformationPanelFillable {
	
	/**
	 * {@link JTextField} that stores owner's name
	 */
	private JTextField jtfOwnerName;
	
	/**
	 * {@link JTextField} that stores owner's document identification number.
	 */
	private JTextField jtfOwnerId;
	
	/**
	 * {@link JTextField} that stores owner's address.
	 */
	private JTextField jtfOwnerAddress;
	
	/**
	 * {@link JTextField} that stores owner's phone number.
	 */
	private JTextField jtfOwnerPhone;
	
	/**
	 * {@link JTextField} that stores owner's cellphone number.
	 */
	private JTextField jtfOwnerCellphone;
	
	/**
	 * {@link JTextField} that stores owner's email.
	 */
	private JTextField jtfOwnerEmail;
	
	/**
	 * {@link Owner} that is being displayed on screen.
	 */
	private Owner owner;
	
	/**
	 * It controls if some change done in a field component was notified.
	 */
	private boolean changeNotified;
	
	/**
	 * {@link JPanel} with owner information.
	 */
	private JPanel jpOwnerInfo;
	
	/**
	 * Constructor that receives the owner to displayed on screen. 
	 * 
	 * @param owner The owner that will be displayed.
	 */
	public JPOwnerInfo(Owner owner) {
		super();
		this.owner = owner;
		this.changeNotified = false;		
	}
	
	public JPanel createOwnerInfoPanel(Dimension dimension) {		
		Font verdanaBold = new Font("Verdana", Font.BOLD, 12);
		Font verdanaPlain = new Font("Verdana", Font.PLAIN, 12);
		
		this.jpOwnerInfo = new JPanel(null);
		this.jpOwnerInfo.setPreferredSize(dimension);
		this.jpOwnerInfo.setBackground(Color.WHITE);
		JPanel jpnTitle = new JPanel(null);
		jpnTitle.setBounds(10, 0, 730, 40);
		jpnTitle.setBackground(new Color(34, 139, 34));
		jpnTitle.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel jlTitle = new JLabel("DATOS PROPIETARIO");
		jlTitle.setFont(verdanaBold);
		jlTitle.setBounds(250, 10, 300, 20);
		jlTitle.setForeground(Color.WHITE);
		jpnTitle.add(jlTitle);
		
		this.jpOwnerInfo.add(jpnTitle);
		this.jpOwnerInfo.add(this.createInfoPanel(verdanaBold, verdanaPlain));
		if (owner == null) {
			this.initializeDisableAllComponents();
		} else {
			this.doEnableAllComponents();
			this.fillFields();
		}
		return this.jpOwnerInfo;
	}
	
	@Override
	public JPanel createInfoPanel(Font verdanaBold, Font verdanaPlain) {
		JPanel jpnOwnerDetail = new JPanel(null);
		jpnOwnerDetail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jpnOwnerDetail.setBounds(10, 45, 730, 140);
		jpnOwnerDetail.setBackground(new Color(250, 245, 245));
		
		JLabel jlbOwnerId = new JLabel("Cedula:");
		jlbOwnerId.setBounds(10, 20, 100, 20);
		jlbOwnerId.setFont(verdanaBold);
		jtfOwnerId = new JTextField();
		jtfOwnerId.setBounds(100, 20, 250, 20);
		jtfOwnerId.setFont(verdanaPlain);
		jtfOwnerId.addKeyListener(this);
		jpnOwnerDetail.add(jlbOwnerId);
		jpnOwnerDetail.add(jtfOwnerId);
		
		JLabel jlbOwnerName = new JLabel("Nombre:");
		jlbOwnerName.setBounds(10, 50, 100, 20);
		jlbOwnerName.setFont(verdanaBold);
		jtfOwnerName = new JTextField();
		jtfOwnerName.setBounds(100, 50, 250, 20);
		jtfOwnerName.setFont(verdanaPlain);
		jpnOwnerDetail.add(jlbOwnerName);
		jpnOwnerDetail.add(jtfOwnerName);		
		
		JLabel jlbOwnerAddress = new JLabel("Dirección:");
		jlbOwnerAddress.setBounds(10, 80, 100, 20);
		jlbOwnerAddress.setFont(verdanaBold);
		jtfOwnerAddress = new JTextField();
		jtfOwnerAddress.setBounds(100, 80, 250, 20);
		jtfOwnerAddress.setFont(verdanaPlain);
		JLabel jlbOwnerAddressIcon = new JLabel(new ImageIcon(JPOwnerInfo.class.getResource("/co/com/carp/petcity/image/home.png")));
		jlbOwnerAddressIcon.setBounds(360, 80, 24, 24);
		jpnOwnerDetail.add(jlbOwnerAddress);
		jpnOwnerDetail.add(jtfOwnerAddress);
		jpnOwnerDetail.add(jlbOwnerAddressIcon);
		
		JLabel jlbOwnerPhone = new JLabel("Teléfono:");
		jlbOwnerPhone.setBounds(380, 20, 100, 20);
		jlbOwnerPhone.setFont(verdanaBold);
		jtfOwnerPhone = new JTextField();
		jtfOwnerPhone.setBounds(450, 20, 150, 20);
		jtfOwnerPhone.setFont(verdanaPlain);
		JLabel jlbOwnerPhoneIcon = new JLabel(new ImageIcon(JPOwnerInfo.class.getResource("/co/com/carp/petcity/image/telephone.png")));
		jlbOwnerPhoneIcon.setBounds(610, 20, 24, 24);
		jpnOwnerDetail.add(jlbOwnerPhone);
		jpnOwnerDetail.add(jtfOwnerPhone);
		jpnOwnerDetail.add(jlbOwnerPhoneIcon);
		
		
		JLabel jlbOwnerCellphone = new JLabel("Celular:");
		jlbOwnerCellphone.setBounds(380, 50, 100, 20);
		jlbOwnerCellphone.setFont(verdanaBold);
		jtfOwnerCellphone = new JTextField();
		jtfOwnerCellphone.setBounds(450, 50, 150, 20);
		jtfOwnerCellphone.setFont(verdanaPlain);
		JLabel jlbOwnerCellphoneIcon = new JLabel(new ImageIcon(JPOwnerInfo.class.getResource("/co/com/carp/petcity/image/cellphone.png")));
		jlbOwnerCellphoneIcon.setBounds(610, 50, 24, 24);
		jpnOwnerDetail.add(jlbOwnerCellphone);
		jpnOwnerDetail.add(jtfOwnerCellphone);
		jpnOwnerDetail.add(jlbOwnerCellphoneIcon);
		
		JLabel jlbOwnerEmail = new JLabel("Email:");
		jlbOwnerEmail.setBounds(10, 110, 100, 20);
		jlbOwnerEmail.setFont(verdanaBold);
		jtfOwnerEmail = new JTextField();
		jtfOwnerEmail.setBounds(100, 110, 300, 20);
		jtfOwnerEmail.setFont(verdanaPlain);
		JLabel jlbOwnerEmailIcon = new JLabel(new ImageIcon(JPOwnerInfo.class.getResource("/co/com/carp/petcity/image/at.png")));
		jlbOwnerEmailIcon.setBounds(410, 110, 24, 24);
		jpnOwnerDetail.add(jlbOwnerEmail);
		jpnOwnerDetail.add(jtfOwnerEmail);
		jpnOwnerDetail.add(jlbOwnerEmailIcon);
		
		return jpnOwnerDetail;
	}
	
	@Override
	public void cleanAllFields() {
		this.jtfOwnerName.setText("");
		this.jtfOwnerAddress.setText("");
		this.jtfOwnerPhone.setText("0");
		this.jtfOwnerCellphone.setText("0");
		this.jtfOwnerEmail.setText("");
		this.jtfOwnerId.setText("");
	}
	
	@Override
	public void initializeDisableAllComponents() {
		if (owner == null) {
			this.changeNotified = false;
			this.jtfOwnerName.setEditable(false);
			this.jtfOwnerAddress.setEditable(false);
			this.jtfOwnerPhone.setEditable(false);
			this.jtfOwnerCellphone.setEditable(false);
			this.jtfOwnerEmail.setEditable(false);
			this.jtfOwnerId.setEditable(false);
			this.cleanAllFields();
		}
	}
	
	@Override
	public void doEnableAllComponents() {
		if (owner != null) {
			this.changeNotified = false;
			this.jtfOwnerName.setEditable(true);
			this.jtfOwnerAddress.setEditable(true);
			this.jtfOwnerPhone.setEditable(true);
			this.jtfOwnerCellphone.setEditable(true);
			this.jtfOwnerEmail.setEditable(true);
			this.jtfOwnerId.setEditable(true);			
		}
	}
	
	@Override
	public void fillFields() {
		this.changeNotified = false;
		this.jtfOwnerName.setText(this.owner.getName());
		this.jtfOwnerAddress.setText(this.owner.getAddress());
		this.jtfOwnerPhone.setText(this.owner.getPhone() + "");
		this.jtfOwnerCellphone.setText(this.owner.getCellphone() + "");
		this.jtfOwnerEmail.setText(this.owner.getEmail());
		this.jtfOwnerId.setText(this.owner.getDocumentId() + "");
	}
	
	@Override
	public boolean updateInformation(Object owner) {
		boolean canReplace = false;		
		if (!this.owner.equals((Owner)owner)) {
			this.owner = (Owner)owner;
			if (owner == null) {
				this.initializeDisableAllComponents();
			} else {
				this.doEnableAllComponents();
				this.fillFields();
			}
			canReplace = true;
		}
		return canReplace;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		if (!this.changeNotified) {
			this.changeNotified = true;
			setChanged();
			notifyObservers();
		}
	}

	@Override
	public Object getObjectDisplayed() {
		Owner ownerCopied = new Owner();
		ownerCopied.setIdentification(this.owner.getIdentification());
		ownerCopied.setDocumentId(Integer.parseInt(this.jtfOwnerId.getText()));
		ownerCopied.setName(this.jtfOwnerName.getText());
		ownerCopied.setAddress(this.jtfOwnerAddress.getText());
		ownerCopied.setPhone(Integer.parseInt(this.jtfOwnerPhone.getText()));
		ownerCopied.setCellphone(new BigInteger(this.jtfOwnerCellphone.getText()));
		ownerCopied.setEmail(this.jtfOwnerEmail.getText());
		return ownerCopied;
	}

	@Override
	public Object getObjectOriginal() {
		return this.owner;
	}
}
