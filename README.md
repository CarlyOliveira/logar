# logar
Projeto logar consiste em uma API do processo de criacao de usuarios, autenticacao com login e recuperacao de dados de usuario autenticado.

# Rotas 

/signup  {POST} - Cadastra um usuario novo e retorna um token JWT autenticado recebendo:
{
	"firstName":"Hello",
	"lastName":	"teste",
	"email":	"hello1@world.com",
	"password":	"1234",
	"phones":
		[{	"number":988887888,
			"area_code":81,
			"country_code":"+55"
			}
		]
}

/signin {POST} - Efetua o login de um usuario cadastrado e retorna um token JWT autenticado recebendo:
{
	"email":	"hello1@world.com",
	"password":	"1234"
}

/me {GET} - Recupera as informacoes de um usuario autenticado recebendo um token JWT valido no Header.
{ Authorization : "TokenJWT"}



# Tecnologias 

REST
Spring boot
Spring boot starter web - Spring mvc, tomcat, RESTFull
Spring data jpa starter - hibernate 
spring-boot-starter-security
spring-boot-starter-test
Maven
Git
Java 8
JWT
Banco em memoria - H2

# Adcional

Implementada criptografia para senhas de usuario
Tests unitarios
API armazenada na cloud utilizando Heroku
Integracao entre GitHub e Heroku para deploy na nuvem
Build e Tests unitarios automatizados via Maven.
Rotas disponiveis:
https://logar-api.herokuapp.com/signup
https://logar-api.herokuapp.com/signin
https://logar-api.herokuapp.com/me
