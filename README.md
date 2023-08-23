<h3 align="center"><img src="https://github.com/RydelMorgan/SpringBoot2/assets/16851853/977b33a3-d832-4769-ba01-b0f3500187a4" width=300 height=300></h3>

<h1 align="center">DevDojo MockInterview</h1>

<p align="center">
  <a href="#about">About</a> •
  <a href="#requirements">Requirements</a> •
  <a href="#installation">Installation</a> •
  <a href="#test">Test</a> •
  <a href="#exam">About the exam</a>
</p>

## About

This is a project to participate of the fictional interviwe from DevDojo.

The idea its implement the endpoint that returns the bank transactions of the registered user. 

## Requirements

- [x] The project must be made with Java 17
- [x] The project must be made with Spring Boot 3.1.2
- [x] The project must be made with Maven
- [x] Only authenticated users can access the endpoint
- [x] Each user should have an `accountId`
- [x] If one user tries to access transactions from another user, return `403 status`
- [x] Returns a list of bank transactions with its `json` mapped to the fields described in the table <a href="#exam">DevDojo</a>
- [x] The request should be made to `/transactions/{accountId}`

## Installation

This is a project [Spring](https://spring.io/projects/spring-boot) made with:
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org)
- [Docker](https://www.docker.com)

First, install the dependecies:

```bash
./mvnw install
```

Then, run the database container with Docker:

```bash
docker-compose up
```

And finally, run the following to start the application:

```bash
./mvnw spring-boot:run
```

> **Note**
> When the application starts, it will automatically create the database and tables.
> It will also create some users and transactions based on the [transactions.json](/src/main/resources/transactions.json)

## Functionality

You can use the follow command to test in your terminal if the application is working:
```bash
curl -u user1:password1 --location --request GET 'http://localhost:8080/transactions/8a8587b371776b9e01717d217e6e1492'
```

Use the following table for reference.

|             accontId             | username |  password |
|:--------------------------------:|:--------:|:---------:|
| 8a8587b371776b9e01717d217e6e1492 |   user1  | password1 |
| 8a85867e6ad9e761016ada958bdf5b0f |   user2  | password2 |
| 8a8587fd6b0487a7016b07a1ecfb0b74 |   user3  | password3 |

## Test

First follow the installation steps. 
Then, in another terminal, run:

```bash
mvn test
```


## Exam

### Rules

1.	You have a 48-hour deadline from when you receive this test. 
1.	Develop something you are proud of. Write your code as if it were going into production. 
1.	Pay attention to the non-functional requirements that should be part of the project, but not been explicitly described in this document.
1.	Put your completed project on GitHub and email the link to  william.suane@devdojo.academy when you're done. When we clone it, the rest of the commits will be ignored.

### Mission

Develop an endpoint that returns a list of bank transactions with its json mapped to the fields described in the table below (**DevDojo Mapping** column).

The request should be made to `/transactions/{accountId}` and the endpoint should return the content of the transactions.json file mapped to the fields.

### Notes

-	Only authenticated users can access this endpoint. 
-	Each user should have 1 `accountId`, and it should be unique per user. For example, William has account **123**, David has account **890**. User William should not be able to see the transactions from account 890, and user David should not be able to see the transactions from account 123. If they try, they should get a 403 status. 
-	It's okay to return the same transactions for both accounts, available in the [transactions.json](/src/main/resources/transactions.json) file.


### Requirements
	
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

> “Those who think they **can** and those who think they **can't are both usually right**.” – Confucius.
