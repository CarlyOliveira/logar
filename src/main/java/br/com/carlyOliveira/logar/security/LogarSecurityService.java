package br.com.carlyOliveira.logar.security;

import java.math.BigInteger;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class LogarSecurityService {

	// EXPIRATION_TIME = 1 minutos
	static final long EXPIRATION_TIME = 60000;
	static final String SECRET = "carlyOliveira";
	static final String HEADER_STRING = "Authorization";

	public static String createAuthentication(String usuario) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		String tokenJWT = Jwts.builder().setSubject(usuario)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(signatureAlgorithm, signingKey).compact();

		return tokenJWT;

	}

	public static String criptografar(String password) {
		String passwordCrypted = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
			passwordCrypted = hash.toString(16);
		} catch (NoSuchAlgorithmException e) {

		}
		return passwordCrypted;
	}
}
