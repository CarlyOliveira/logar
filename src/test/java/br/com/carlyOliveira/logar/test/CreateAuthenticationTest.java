package br.com.carlyOliveira.logar.test;

import javax.xml.bind.DatatypeConverter;

import org.junit.Assert;
import org.junit.Test;

import br.com.carlyOliveira.logar.security.LogarSecurityService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class CreateAuthenticationTest {

	@Test
	public void test() {

		String jsonUsuarioFalse = "{\r\n" + "	\"firstName\":\"HelloFalse\",\r\n" + "	\"lastName\":	\"teste\",\r\n"
				+ "	\"email\":	\"hello1@world.com\",\r\n" + "	\"password\":	\"1234\",\r\n" + "	\"phones\":\r\n"
				+ "		[{	\"number\":988887888,\r\n" + "			\"area_code\":81,\r\n"
				+ "			\"country_code\":\"+55\"\r\n" + "			}\r\n" + "		]\r\n" + "}";

		String jsonUsuario = "{\r\n" + "	\"firstName\":\"Hello\",\r\n" + "	\"lastName\":	\"teste\",\r\n"
				+ "	\"email\":	\"hello1@world.com\",\r\n" + "	\"password\":	\"1234\",\r\n" + "	\"phones\":\r\n"
				+ "		[{	\"number\":988887888,\r\n" + "			\"area_code\":81,\r\n"
				+ "			\"country_code\":\"+55\"\r\n" + "			}\r\n" + "		]\r\n" + "}";

		String tokenJWT = LogarSecurityService.createAuthentication(jsonUsuario);

		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("carlyOliveira"))
				.parseClaimsJws(tokenJWT).getBody();

		String usuarioClaims = claims.getSubject().toString();

		Assert.assertTrue(jsonUsuario.equals(usuarioClaims));

		Assert.assertFalse(jsonUsuarioFalse.equals(usuarioClaims));

	}

}
