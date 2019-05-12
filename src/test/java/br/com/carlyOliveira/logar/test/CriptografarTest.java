package br.com.carlyOliveira.logar.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.carlyOliveira.logar.security.LogarSecurityService;

public class CriptografarTest {

	@Test
	public void test() {
		String senha1 = "1234";
		String senha2 = "12345";
		String senhaCrypted1 = LogarSecurityService.criptografar(senha1);
		String senhaCrypted2 = LogarSecurityService.criptografar(senha2);

		Assert.assertFalse(senhaCrypted1.equals(senhaCrypted2));

		Assert.assertTrue(senhaCrypted1.contentEquals(senhaCrypted1));
	}

}
