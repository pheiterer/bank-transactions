<h3 align="center"><img src="https://github.com/RydelMorgan/SpringBoot2/assets/16851853/977b33a3-d832-4769-ba01-b0f3500187a4" width=300 height=300></h3>

<h1 align="center">DevDojo MockInterview</h1>

<p align="center">
  <a href="#sobre">Sobre</a> •
  <a href="#requisitos">Requisitos</a> •
  <a href="#instalação">Instalação</a> •
  <a href="#funcionamento">Funcionamento</a> •
  <a href="#testes">Testes</a> •
  <a href="#exam">Sobre  o exame</a>
</p>

## Sobre

Este é um projeto para participar da entrevista ficticia do DevDojo.

A ideia é implementar um *endpoint* que retorna as transações bancárias do usuário cadastrado. 

## Requisitos

- [x] O projeto deve ser feito usando Java 17
- [x] O projeto deve ser feito usando Spring Boot 3.1.2
- [x] O projeto deve ser feito usando Maven
- [x] Apenas usuários autenticados podem acessar o *endpoint*
- [x] Cada usuário deve ter um unico `accountId`
- [x] Caso o usuário tente acessar as transições de outro usuário retornar `403 status`
- [x] O retorno deve ser um `json` mapeado para os campos da tabela <a href="#exam">DevDojo</a>
- [x] O pedido deve ser feito por `/transactions/{accountId}`

## Instalação

Este é um projeto [Spring](https://spring.io/projects/spring-boot) feito com:
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org)
- [Docker](https://www.docker.com)
- [Postman](https://www.postman.com)

Primeiro, instale as dependências:

```bash
mvn verify
```

Depois, rode o banco de dados:

```bash
docker-compose up
```

Abra http://localhost:8080/transactions/`{accountId}` com o Postman para ver o resultado.

|             accontId             | username |  password |
|:--------------------------------:|:--------:|:---------:|
| 8a8587b371776b9e01717d217e6e1492 |   user1  | password1 |
| 8a85867e6ad9e761016ada958bdf5b0f |   user2  | password2 |
| 8a8587fd6b0487a7016b07a1ecfb0b74 |   user3  | password3 |


## Funcionamento

![Alt text](intera%C3%A7%C3%A3o.gif)

## Testes

Primeiro siga os passos da instação. 
Então, em outro terminal rode o comando:

```bash
mvn test
```


## Exam

Rules

1.	You have a 48-hour deadline from when you receive this test. 
1.	Develop something you are proud of. Write your code as if it were going into production. 
1.	Pay attention to the non-functional requirements that should be part of the project, but not been explicitly described in this document.
1.	Put your completed project on GitHub and email the link to  william.suane@devdojo.academy when you're done. When we clone it, the rest of the commits will be ignored.

Mission

Develop an endpoint that returns a list of bank transactions with its json mapped to the fields described in the table below (**DevDojo Mapping** column).

The request should be made to `/transactions/{accountId}` and the endpoint should return the content of the transactions.json file mapped to the fields.

Notes

-	Only authenticated users can access this endpoint. 
-	Each user should have 1 `accountId`, and it should be unique per user. For example, William has account **123**, David has account **890**. User William should not be able to see the transactions from account 890, and user David should not be able to see the transactions from account 123. If they try, they should get a 403 status. 
-	It's okay to return the same transactions for both accounts, available in the [transactions.json](/src/main/resources/transactions.json) file.


Requirements
	
1.	Java 17
1.	Spring Boot 3.1.2
1.	Maven



|          Original fields        |                    DevDojo Mapping                  |
|:-----------------------------------:|:-------------------------------------------------------:|
|              encodedKey             |                            id                           |
|           parentAccountKey          |                       arrangementId                     |
|             creationDate            |                        bookingDate                      |
|                 type                |                           type                          |
|               valueDate             |                         valueDate                       |
|                amount               |                          amount                         |
|             currencyCode            |                       currencyCode                      |
|             currencyCode            |                         currency                        |
|                amount               |     creditDebitIndicator  (DEBIT   < 0, CREDIT >= 0)    |
|     accountBalances.totalBalance    |                      runningBalance                     |
|                  id                 |                 counterPartyAccountNumber               |
|           parentAccountKey          |                         reference                       |
|                 type                |                         typeGroup                       |
|                amount               |                     instructedAmount                    |



Good Luck!

“Those who think they **can** and those who think they **can't are both usually right**.” – Confucius.
