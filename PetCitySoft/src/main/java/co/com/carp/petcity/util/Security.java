package co.com.carp.petcity.util;

import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;

import java.io.InputStream;

import java.io.OutputStream;

import java.security.NoSuchAlgorithmException;

import java.security.SecureRandom;

import javax.crypto.Cipher;

import javax.crypto.spec.SecretKeySpec;

import javax.mail.internet.MimeUtility;

/**
 * This class is attempt to manage cryptography process.
 * 
 * @author Carlos Rodriguez
 *
 */
public class Security {
	
	/**
	 * Cryptography key to generate new data encrypted.
	 */
	private final static String keyBuffer = "53ba43c1";

	/**
	 * It will encode data that is passed as parameter.
	 * 
	 * @param b byte array to be encoded
	 * @return byte array encoded
	 * @throws Exception Any exception that can throw the process.
	 */
	private static byte[] encode(byte[] b) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		OutputStream b64os = MimeUtility.encode(baos, "base64");
		b64os.write(b);
		b64os.close();
		return baos.toByteArray();
	}

	/**
	 * It will decode data that is passed as parameter.
	 * 
	 * @param b byte array to be decode
	 * @return byte array decode
	 * @throws Exception Any exception that can throw the process.
	 */
	private static byte[] decode(byte[] b) throws Exception {
		ByteArrayInputStream bais = new ByteArrayInputStream(b);
		InputStream b64is = MimeUtility.decode(bais, "base64");
		byte[] tmp = new byte[b.length];
		int n = b64is.read(tmp);
		byte[] res = new byte[n];
		System.arraycopy(tmp, 0, res, 0, n);
		return res;
	}

	/**
	 * It creates secret key to be used on cryptography process.
	 * 
	 * @return {@link SecretKeySpec} to be used.
	 */
	private static SecretKeySpec getKey() {
		SecretKeySpec key = new SecretKeySpec(keyBuffer.getBytes(), "DES");
		return key;
	}

	/**
	 * It decrypts the {@link String} that is passed as parameter.
	 * 
	 * @param s {@link String} to be decrypted.
	 * @return {@link String} decrypted.
	 * @throws NoSuchAlgorithmException The algorithm specified can not be found.
	 * @throws Exception Any exception that can throw the process.
	 */
	public static String decrypt(String s) throws NoSuchAlgorithmException, Exception {
		String s1 = null;
		if (s.indexOf("{ENC}") != -1) {
			String s2 = s.substring("{ENC}".length());
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(2, getKey());
			byte abyte0[] = cipher.doFinal(decode(s2.getBytes()));
			s1 = new String(abyte0);
		} else {
			s1 = s;
		}
		return s1;
	}

	/**
	* It encrypts the {@link String} that is passed as parameter.
	 * 
	 * @param s {@link String} to be encrypted.
	 * @return {@link String} encrypted.
	 * @throws NoSuchAlgorithmException The algorithm specified can not be found.
	 * @throws Exception Any exception that can throw the process.
	 */
	public static String encrypt(String s) throws NoSuchAlgorithmException, Exception {
		byte abyte0[];
		SecureRandom securerandom = new SecureRandom();
		securerandom.nextBytes(keyBuffer.getBytes());
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(1, getKey());
		abyte0 = encode(cipher.doFinal(s.getBytes()));
		return "{ENC}" + new String(abyte0);
	}
}