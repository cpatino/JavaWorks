package co.com.carp.petcity.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import co.com.carp.petcity.dao.UserDao;
import co.com.carp.petcity.entity.User;
import co.com.carp.petcity.util.Security;
import co.com.carp.petcity.view.JDLogin;

/**
 * This class is attempt to control all request done by {@link JDLogin} screen.
 * 
 * @author Carlos Rodriguez
 * 
 */
public class LoginController {

	/**
	 * It will execute steps when login's button cancel is pressed.
	 * 
	 * @return True if all actions were executed, false otherwise.
	 */
	public boolean doCancelAction() {
		return true;
	}

	/**
	 * It will execute steps when login's button accept is pressed.
	 * 
	 * @param user
	 *            {@link String} that was filled by user on user's
	 *            {@link JTextField}.
	 * @param password
	 *            Char array with password filled by user on pasword's
	 *            {@link JPasswordField}
	 * @return True if all actions were executed and user and password are
	 *         correct, false otherwise.
	 */
	public boolean doAcceptAction(String user, char[] password) {
		String strPassword = String.valueOf(password);
		try {
			String pwdEnc = Security.encrypt(strPassword);
			pwdEnc = pwdEnc.replace("\n", "").replace("\r", "");
			System.out.println(pwdEnc);
			UserDao dao = new UserDao();
		    List<User> userList = dao.selectUsingLogin(user, pwdEnc);
			return (userList != null && userList.size() > 0);
		} catch (NoSuchAlgorithmException ex) {
			JOptionPane.showMessageDialog(null,
					"No se encuentra el algoritmo de encriptación.");
			Logger.getLogger(this.getClass()).error(ex.getMessage());
		} catch (Exception ex) {
			JOptionPane
					.showMessageDialog(null,
							"Un error ha ocurrido al intentar encriptar la contraseña.");
			Logger.getLogger(this.getClass()).error(ex.getMessage());
		}
		return false;
	}

}
