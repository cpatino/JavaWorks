package co.com.carp.petcity.controller;

import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import co.com.carp.petcity.util.Security;


public class LoginController {
	
	public boolean doCancelAction() {
		return true;
	}
	
	public boolean doAcceptAction(String user, char[] password) {
		String strPassword = String.valueOf(password);
		try {
			String pwdEnc = Security.encrypt(strPassword);
			System.out.println(pwdEnc);
			System.out.println(Security.decrypt(pwdEnc));
		} catch (NoSuchAlgorithmException ex) {
			JOptionPane.showMessageDialog(null, "No se encuentra el algoritmo de encriptación.");
			Logger.getLogger(this.getClass()).error(ex.getMessage());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Un error ha ocurrido al intentar encriptar la contraseña.");
			Logger.getLogger(this.getClass()).error(ex.getMessage());
		}
		return true;
	}

}
