package co.com.carp.petcity.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import co.com.carp.petcity.controller.LoginController;

/**
 * This class is attempt to manage the application login screen.
 * 
 * @author Carlos Rodriguez
 *
 */
public class JDLogin extends JDialog implements ActionListener {

	/**
	 * Default serial version.
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel jpPrincipal;
	private JTextField jtfUser;
	private JPasswordField jpfPassword;
	private JButton jbtLogin;
	private JButton jbtCancel;

	/**
	 * Create the login frame.
	 */
	public JDLogin() {
		this.setJMenuBar(this.createMenuBar());
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(JDLogin.class.getResource("/co/com/carp/petcity/image/dog1.png")));
		this.setBackground(new Color(0, 100, 0));
		this.setResizable(false);
		this.setTitle("Pet city soft- Login");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds((int) (screenSize.getWidth() / 2 - 340), (int) (screenSize.getHeight() / 2 - 150), 694, 330);
		jpPrincipal = new JPanel();
		jpPrincipal.setBackground(new Color(34, 139, 34));
		jpPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		jpPrincipal.setLayout(null);
		this.setContentPane(jpPrincipal);
		
		
		JLabel jlbUser = new JLabel("Usuario:");
		jlbUser.setHorizontalAlignment(SwingConstants.RIGHT);
		jlbUser.setForeground(new Color(255, 255, 255));
		jlbUser.setFont(new Font("Verdana", Font.BOLD, 12));
		jlbUser.setBounds(402, 81, 73, 20);
		jpPrincipal.add(jlbUser);
		
		jtfUser = new JTextField();
		jtfUser.setToolTipText("nombre de usuario");
		jlbUser.setLabelFor(jtfUser);
		jtfUser.setFont(new Font("Verdana", Font.PLAIN, 12));
		jtfUser.setColumns(10);
		jtfUser.setBounds(475, 81, 186, 20);
		jpPrincipal.add(jtfUser);
		
		JLabel jlbPassword = new JLabel("Contraseña:");
		jlbPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		jlbPassword.setForeground(new Color(255, 255, 255));
		jlbPassword.setFont(new Font("Verdana", Font.BOLD, 12));
		jlbPassword.setBounds(392, 112, 83, 20);
		jpPrincipal.add(jlbPassword);
		
		jbtLogin = new JButton("Entrar");
		jbtLogin.setMnemonic(KeyEvent.VK_E);
		jbtLogin.setForeground(new Color(255, 255, 255));
		jbtLogin.setBackground(new Color(30, 144, 255));
		jbtLogin.setFont(new Font("Verdana", Font.BOLD, 12));
		jbtLogin.setBounds(572, 155, 89, 23);
		jbtLogin.addActionListener(this);
		jpPrincipal.add(jbtLogin);
		
		jbtCancel = new JButton("Cancelar");
		jbtCancel.setMnemonic(KeyEvent.VK_C);
		jbtCancel.setForeground(new Color(255, 255, 255));
		jbtCancel.setBackground(new Color(30, 144, 255));
		jbtCancel.setFont(new Font("Verdana", Font.BOLD, 12));
		jbtCancel.setBounds(475, 155, 89, 23);
		jbtCancel.addActionListener(this);
		jpPrincipal.add(jbtCancel);
		
		JLabel jlbPetCityImage = new JLabel("");
		jlbPetCityImage.setIcon(new ImageIcon(JDLogin.class.getResource("/co/com/carp/petcity/image/dog-city-logo.png")));
		jlbPetCityImage.setBounds(0, 0, 382, 300);
		jpPrincipal.add(jlbPetCityImage);
		
		jpfPassword = new JPasswordField();
		jpfPassword.setToolTipText("contrase\u00F1a");
		jlbPassword.setLabelFor(jpfPassword);
		jpfPassword.setFont(new Font("Verdana", Font.PLAIN, 12));
		jpfPassword.setBounds(475, 112, 186, 20);
		jpPrincipal.add(jpfPassword);
	}
	
	/**
	 * It creates a new menu bar that will be associated with the JFrame. 
	 * 
	 * @return {@link JMenuBar} new menu to be associated with the JFrame.
	 */
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Opciones");
		menu.setMnemonic(KeyEvent.VK_O);
		
		JMenuItem menuItem;
		
		menuItem = new JMenuItem("Cambiar contraseña", KeyEvent.VK_H);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Recuperar contraseña", KeyEvent.VK_R);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuBar.add(menu);		
		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		LoginController loginCtrl = new LoginController();
		if (evt.getSource().equals(jbtLogin)) {
			if (this.jtfUser.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this, "Por favor llene la casilla del usuario", "Login", JOptionPane.INFORMATION_MESSAGE);
			} else if (this.jpfPassword.getPassword().length == 0) {
				JOptionPane.showMessageDialog(this, "Por favor llene la casilla de la contraseña", "Login", JOptionPane.INFORMATION_MESSAGE);
			} else { 
				if(loginCtrl.doAcceptAction(this.jtfUser.getText(), this.jpfPassword.getPassword())) {
					this.setVisible(false);
					new JFOwnerAndPetsInfo().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "Usuario o clave invalida", "Login invalido", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		} else if (evt.getSource().equals(jbtCancel)) {
			if (loginCtrl.doCancelAction()) {
				System.exit(EXIT_ON_CLOSE);
			}
		} else if (evt.getActionCommand().equals("Cambiar contraseña")) {
			
		}  else if (evt.getActionCommand().equals("Recuperar contraseña")) {
			
		}
		
	}
}
