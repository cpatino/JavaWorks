package co.com.carp.petcity.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import co.com.carp.petcity.entity.Owner;

public class JPOwnerInfo extends JPanel {

	/**
	 * Auto-generated serial version
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField jtfOwnerName;
	
	private JTextField jtfOwnerId;
	
	private JTextField jtfOwnerAddress;
	
	private JTextField jtfOwnerPhone;
	
	private JTextField jtfOwnerCellphone;
	
	private JTextField jtfOwnerEmail;
	
	private Owner owner;
	
	/**
	 * Constructor that receives the owner to displayed on screen. 
	 * 
	 * @param owner The owner that will be displayed.
	 */
	public JPOwnerInfo(Owner owner) {
		super();
		this.owner = owner;
		this.setLayout(null);
		Font verdanaBold = new Font("Verdana", Font.BOLD, 12);
		Font verdanaPlain = new Font("Verdana", Font.PLAIN, 12);
		
		JPanel jpnTitle = new JPanel(null);
		jpnTitle.setBounds(10, 0, 730, 40);
		jpnTitle.setBackground(new Color(34, 139, 34));
		jpnTitle.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel jlTitle = new JLabel("DATOS PROPIETARIO");
		jlTitle.setFont(verdanaBold);
		jlTitle.setBounds(250, 10, 300, 20);
		jlTitle.setForeground(Color.WHITE);
		jpnTitle.add(jlTitle);
		
		this.add(jpnTitle);
		this.add(this.createOwnerInfoPanel(verdanaBold, verdanaPlain));
		if (owner == null) {
			this.initializeDisableAllComponents();
		} else {
			this.doEnableAllComponents();
			this.fillFields();
		}
	}
	
	/**
	 * It creates the owner information panel.
	 * 
	 * @param verdanaBold Verdana font in bold.
	 * @param verdanaPlain Verdana font plain.
	 * @return
	 */
	private JPanel createOwnerInfoPanel(Font verdanaBold, Font verdanaPlain) {
		JPanel jpnOwnerDetail = new JPanel(null);
		jpnOwnerDetail.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jpnOwnerDetail.setBounds(10, 70, 730, 180);
		jpnOwnerDetail.setBackground(new Color(250, 245, 245));
		
		JLabel jlbOwnerId = new JLabel("Cedula:");
		jlbOwnerId.setBounds(10, 20, 100, 20);
		jlbOwnerId.setFont(verdanaBold);
		jtfOwnerId = new JTextField();
		jtfOwnerId.setBounds(100, 20, 250, 20);
		jtfOwnerId.setFont(verdanaPlain);
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
	
	/**
	 * It sets default value to all text fields on screen.
	 */
	private void cleanAllFields() {
		this.jtfOwnerName.setText("");
		this.jtfOwnerAddress.setText("");
		this.jtfOwnerPhone.setText("0");
		this.jtfOwnerCellphone.setText("0");
		this.jtfOwnerEmail.setText("");
		this.jtfOwnerId.setText("");
	}
	
	/**
	 * When screen doesn't have an owner to be displayed, all text field becomes disabled. 
	 */
	private void initializeDisableAllComponents() {
		if (owner == null) {
			this.jtfOwnerName.setEditable(false);
			this.jtfOwnerAddress.setEditable(false);
			this.jtfOwnerPhone.setEditable(false);
			this.jtfOwnerCellphone.setEditable(false);
			this.jtfOwnerEmail.setEditable(false);
			this.jtfOwnerId.setEditable(false);
			this.cleanAllFields();
		}
	}
	
	/**
	 * It make able all text fields. 
	 */
	private void doEnableAllComponents() {
		if (owner != null) {
			this.jtfOwnerName.setEditable(true);
			this.jtfOwnerAddress.setEditable(true);
			this.jtfOwnerPhone.setEditable(true);
			this.jtfOwnerCellphone.setEditable(true);
			this.jtfOwnerEmail.setEditable(true);
			this.jtfOwnerId.setEditable(true);			
		}
	}
	
	/**
	 * It fills text fields with the owner information.
	 */
	private void fillFields() {
		this.jtfOwnerName.setText(this.owner.getName());
		this.jtfOwnerAddress.setText(this.owner.getAddress());
		this.jtfOwnerPhone.setText(this.owner.getPhone() + "");
		this.jtfOwnerCellphone.setText(this.owner.getCellphone() + "");
		this.jtfOwnerEmail.setText(this.owner.getEmail());
		this.jtfOwnerId.setText(this.owner.getDocumentId() + "");
	}
	
	public boolean replaceOwnerInformation(Owner owner) {
		boolean canReplace = false;
		if (!this.owner.equals(owner)) {
			this.owner = owner;
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
}
